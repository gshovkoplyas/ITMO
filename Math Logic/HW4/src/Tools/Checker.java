package Tools;

import Utils.CheckerOutput;
import Utils.Pair;
import Utils.ExpressionParser;
import Utils.Proof;
import Utils.Tree.*;

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
    private static final ArrayList<Expression> logicAxioms = new ArrayList<>();
    private static final ArrayList<Expression> algebraAxioms = new ArrayList<>();

    public Checker() {
        if (!logicAxioms.isEmpty()) {
            return;
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("axioms.txt")));
            String cur = in.readLine();
            while (!cur.equals("---")) {
                logicAxioms.add(new ExpressionParser().parseTree(cur));
                cur = in.readLine();
            }
            cur = in.readLine();
            while (cur != null && !cur.equals("---")) {
                algebraAxioms.add(new ExpressionParser().parseTree(cur));
                cur = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isMatch(Expression a, Expression b) {
        if (a instanceof Function) {
            return a.type().equals(b.type()) && a.toString().equals(b.toString());
        }
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

    private final HashSet<Expression> matched2 = new HashSet<>();
    private final HashSet<String> willBound = new HashSet<>();

    private Pair<Boolean, Boolean> match(Expression a, Expression b, String x) {
        if (a instanceof Function) {
            return new Pair<>(a.type().equals(b.type()) && a.toString().equals(b.toString()), false);
        }
        if (a instanceof Variable) {
            if (a.toString().equals(x)) {
                matched2.add(b);
                return new Pair<>(true, true);
            } else {
                return new Pair<>(a.equals(b), false);
            }
        }

        if (!a.type().equals(b.type()) || a.children.length != b.children.length) {
            return new Pair<>(false, false);
        }
        boolean was = false;
        boolean ok = true;
        for (int i = 0; i < a.children.length; i++) {
            Pair<Boolean, Boolean> p;
            if (a instanceof QuantorExpression && a.children[0].toString().equals(x)) {
                p = match(a.children[i], b.children[i], "");
            } else {
                p = match(a.children[i], b.children[i], x);
            }
            ok &= p.getFirst();
            was |= p.getSecond();
        }
        if (a instanceof QuantorExpression && was) {
            willBound.add(a.children[0].toString());
        }
        return new Pair<>(ok, was);
    }

    private final HashMap<String, Integer> bound = new HashMap<>();
    private HashSet<String> free = new HashSet<>();

    private void findFree(Expression v) {
        if (v instanceof Variable) {
            String name = v.toString();
            if ((!bound.containsKey(name) || bound.get(name) == 0)
                    && !name.isEmpty() && Character.isLowerCase(name.charAt(0))) {
                free.add(name);
            }
        } else if (v instanceof QuantorExpression) {
            String x = v.children[0].toString();
            if (!bound.containsKey(x)) {
                bound.put(x, 0);
            }
            bound.put(v.children[0].toString(), bound.get(x) + 1);
            for (int i = 0; i < v.children.length; i++) {
                findFree(v.children[i]);
            }
            if (!bound.containsKey(x)) {
                bound.put(x, 0);
            }
            bound.put(x, bound.get(x) - 1);
        } else {
            for (int i = 0; i < v.children.length; i++) {
                findFree(v.children[i]);
            }
        }

    }

    private void addProven(Expression expression, int id) {
        this.id.put(expression, id);
        if (expression instanceof Implication) {
            Expression left = expression.children[0];
            Expression right = expression.children[1];
            if (this.id.containsKey(left)) {
                proven.put(right,
                        String.format("M.P. %d, %d", this.id.get(left), this.id.get(right)));
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

    private boolean isFree(Expression x, String s) {
        if (x instanceof Variable) {
            return s.equals(x.toString()) && (!s.isEmpty() && Character.isLowerCase(s.charAt(0)));
        }
        if (x instanceof QuantorExpression) {
            return !x.children[0].toString().equals(s) && isFree(x.children[1], s);
        }
        for (int i = 0; i < x.children.length; i++) {
            if (isFree(x.children[i], s)) {
                return true;
            }
        }
        return false;
    }

    public CheckerOutput check(Proof proof, boolean needCheckFree) {
        CheckerOutput res = new CheckerOutput();

        free.clear();
        HashSet<String> freeAssumption = new HashSet<>();
        if (proof.header != null) {
            assumptions.addAll(proof.header.assumptions.stream().map(p -> new ExpressionParser().parseTree(p)).collect(Collectors.toList()));
            if (!proof.header.assumptions.isEmpty() && needCheckFree) {
                findFree(Expression.getTree(proof.header.assumptions.get(proof.header.assumptions.size() - 1)));
            }
            freeAssumption = free;
        }

        for (int i = 0; i < proof.list.size(); i++) {
            Expression expression;
            try {
                expression = new ExpressionParser().parseTree(proof.list.get(i));
            } catch (AssertionError e) {
                res.ok = false;
                res.list.add(String.format("(%d) %s (Не доказано)", i + 1, proof.list.get(i)));
                continue;
            }
            if (assumptions.contains(expression)) {
                res.list.add(String.format("(%d) %s (Предположение)", i + 1, proof.list.get(i)));
                addProven(expression, i + 1);
                continue;
            }
            if (proven.containsKey(expression)) {
                res.list.add(String.format("(%d) %s (%s)", i + 1, proof.list.get(i), proven.get(expression)));
                addProven(expression, i + 1);
                continue;
            }
            boolean proved = false;
            for (Expression axiom : logicAxioms) {
                matched = new HashMap<>();
                boolean ok = isMatch(axiom, expression);
                for (ArrayList<Expression> list : matched.values()) {
                    for (int j = 1; j < list.size(); j++) {
                        ok &= list.get(0).equals(list.get(j));
                    }
                }
                if (ok) {
                    proved = true;
                    res.list.add(String.format("(%d) %s (Сх. акс. %d)",
                            i + 1, proof.list.get(i), logicAxioms.indexOf(axiom) + 1));
                    break;
                }
            }
            if (proved) {
                addProven(expression, i + 1);
                continue;
            }
            for (Expression axiom : algebraAxioms) {
                if (axiom.equals(expression)) {
                    proved = true;
                    res.list.add(String.format("(%d) %s (Сх. акс. A%d)",
                            i + 1, proof.list.get(i), algebraAxioms.indexOf(axiom) + 1));
                    addProven(expression, i + 1);
                }
            }
            if (proved) {
                continue;
            }
            // check (f -> g) |- (f -> @x g) where x is not free in f
            if (expression instanceof Implication
                    && expression.children[1] instanceof Forall
                    && !freeAssumption.contains(expression.children[1].children[0].toString())
                    && !isFree(expression.children[0], expression.children[1].children[0].toString())) {
                Expression e = new Implication(expression.children[0], expression.children[1].children[1]);
                if (id.containsKey(e)) {
                    res.list.add(String.format("(%d) %s (Правило Forall %d)", i + 1, proof.list.get(i), id.get(e)));
                    addProven(expression, i + 1);
                    continue;
                }
            }
            // check (f -> g) |- (?x f -> g) where x is not free in g
            if (expression instanceof Implication
                    && expression.children[0] instanceof Exist
                    && !freeAssumption.contains(expression.children[0].children[0].toString())
                    && !isFree(expression.children[1], expression.children[0].children[0].toString())) {
                Expression e = new Implication(expression.children[0].children[1], expression.children[1]);
                if (id.containsKey(e)) {
                    res.list.add(String.format("(%d) %s (Правило Exist %d)", i + 1, proof.list.get(i), id.get(e)));
                    addProven(expression, i + 1);
                    continue;
                }
            }
            // check axiom @x f -> f(x := t)
            matched2.clear();
            willBound.clear();
            if (expression instanceof Implication
                    && expression.children[0] instanceof Forall
                    && match(expression.children[0].children[1], expression.children[1], expression.children[0].children[0].toString()).getFirst()
                    && matched2.size() <= 1) {
                free = new HashSet<>();
                if (!matched2.isEmpty()) {
                    findFree(matched2.iterator().next());
                }
                boolean flag = true;
                for (String x : willBound) {
                    flag &= !free.contains(x);
                }
                if (flag) {
                    res.list.add(String.format("(%d) %s (Сх. акс. 11)", i + 1, proof.list.get(i)));
                    addProven(expression, i + 1);
                    continue;
                }
            }

            matched2.clear();
            willBound.clear();
            if (expression instanceof Implication
                    && expression.children[1] instanceof Exist
                    && match(expression.children[1].children[1], expression.children[0], expression.children[1].children[0].toString()).getFirst()
                    && matched2.size() <= 1) {
                free = new HashSet<>();
                if (!matched2.isEmpty()) {
                    findFree(matched2.iterator().next());
                }
                boolean flag = true;
                for (String x : willBound) {
                    flag &= !free.contains(x);
                }
                if (flag) {
                    res.list.add(String.format("(%d) %s (Сх. акс. 12)", i + 1, proof.list.get(i)));
                    addProven(expression, i + 1);
                    continue;
                }
            }
            // check axiom (f[x := 0]) & @x (f -> f[x := x']) -> f
            if (expression instanceof Implication
                    && expression.children[0] instanceof And
                    && expression.children[0].children[1] instanceof Forall
                    && expression.children[0].children[1].children[1] instanceof Implication) {
                Expression first = expression.children[0].children[1].children[1].children[0];
                Expression second = expression.children[1];
                if (first.equals(second)) {
                    res.list.add(String.format("(%d) %s (Сх. акс. A9)", i + 1, proof.list.get(i)));
                    addProven(expression, i + 1);
                    continue;
                }
            }
            res.list.add(String.format("(%d) %s (Не доказано)", i + 1, proof.list.get(i)));
            res.ok = false;
        }
        return res;
    }
}
