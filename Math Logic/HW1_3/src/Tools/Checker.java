package Tools;

import Utils.Proof;
import Utils.CheckerOutput;
import Utils.Pair;
import Utils.ExpressionParser;
import Utils.Tree.Expression;
import Utils.Tree.Implication;
import Utils.Tree.Variable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Checker {
    private HashMap<String, ArrayList<Expression>> matched = new HashMap<>();
    private final HashSet<Expression> assumptions = new HashSet<>();
    private final HashMap<Expression, String> proven = new HashMap<>();
    private final HashMap<Expression, Integer> id = new HashMap<>();
    private final HashMap<Expression, ArrayList<Pair<Expression, Integer>>> lazyProve = new HashMap<>();
    private static final ArrayList<Expression> axioms = new ArrayList<>();

    public Checker() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("axioms.txt")));
            String cur = in.readLine();
            while (cur != null) {
                axioms.add(new ExpressionParser().parseTree(cur));
                cur = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isMatch(Expression a, Expression b) {
        if (a instanceof Variable) {
            String s = a.toString();
            if (!matched.containsKey(s)) {
                matched.put(s, new ArrayList<>());
            }
            matched.get(s).add(b);
            return true;
        }
        if (!a.type().equals(b.type()) || a.children.length != b.children.length) {
            return false;
        }
        for (int i = 0; i < a.children.length; i++) {
            if (!isMatch(a.children[i], b.children[i])) {
                return false;
            }
        }
        return true;
    }

    private void addProven(Expression expression, int id) {
        this.id.put(expression, id);
        if (expression instanceof Implication) {
            Expression left = expression.children[0];
            Expression right = expression.children[1];
            if (this.id.containsKey(left)) {
                int first = this.id.get(left);
                int second = this.id.get(expression);
                proven.put(right, String.format("M.P. %d, %d", first, second));
            }
            if (!proven.containsKey(left)) {
                if (!lazyProve.containsKey(left)) {
                    lazyProve.put(left, new ArrayList<>());
                }
                lazyProve.get(left).add(new Pair<>(right, id));
            }
        }
        if (lazyProve.containsKey(expression)) {
            for (Pair<Expression, Integer> p : lazyProve.get(expression)) {
                proven.put(p.getFirst(), String.format("M.P. %d, %d", id, p.getSecond()));
            }
            lazyProve.remove(expression);
        }
    }

    public CheckerOutput check(Proof proof) {
        CheckerOutput output = new CheckerOutput();

        if (proof.header != null) {
            assumptions.addAll(proof.header.assumptions.stream().filter(p -> !p.isEmpty()).map(p -> new ExpressionParser().parseTree(p)).collect(Collectors.toList()));
        }

        for (int i = 0; i < proof.list.size(); i++) {
            String cur = proof.list.get(i);
            Expression expression = new ExpressionParser().parseTree(cur);

            if (assumptions.contains(expression)) {
                output.list.add(String.format("(%d) %s (Предположение)", i + 1, cur));
                addProven(expression, i + 1);
            } else if (proven.containsKey(expression)) {
                output.list.add(String.format("(%d) %s (%s)", i + 1, cur, proven.get(expression)));
                addProven(expression, i + 1);
            } else {
                boolean proved = false;
                for (Expression axiom : axioms) {
                    matched = new HashMap<>();
                    boolean ok = isMatch(axiom, expression);
                    for (ArrayList<Expression> list : matched.values()) {
                        for (int j = 1; j < list.size(); j++) {
                            ok &= list.get(0).equals(list.get(j));
                        }
                    }
                    if (ok) {
                        proved = true;
                        output.list.add(String.format("(%d) %s (Сх. акс. %d)",
                                i + 1, proof.list.get(i), axioms.indexOf(axiom) + 1));
                        addProven(expression, i + 1);
                        break;
                    }
                }
                if (!proved) {
                    output.list.add(String.format("(%d) %s (Не доказано)", i + 1, proof.list.get(i)));
                    output.ok = false;
                }
            }
        }

        return output;
    }
}
