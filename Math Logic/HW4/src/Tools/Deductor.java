package Tools;

import Utils.*;
import Utils.Tree.Expression;
import Utils.Tree.Implication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;

import static Utils.CheckerOutput.getAnnotation;
import static Utils.CheckerOutput.getExpression;


public class Deductor {
    private static final HashMap<String, ArrayList<String>> proofs = new HashMap<>();

    public Deductor() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("proofs.txt")));
            ArrayList<String> lines = new ArrayList<>();
            String cur = in.readLine();
            while (cur != null) {
                lines.add(cur);
                cur = in.readLine();
            }
            for (int i = 0; i < lines.size(); i++) {
                String name = lines.get(i++);
                proofs.put(name, new ArrayList<>());
                while (i < lines.size()) {
                    if (lines.get(i).equals("---")) {
                        break;
                    }
                    proofs.get(name).add(lines.get(i++));
                }
                Proof proof = new Proof();
                if (name.contains("|-")) {
                    proof.header = new Header(name);
                }
                proof.list = proofs.get(name);
                if (!new Checker().check(proof, true).ok) {
                    throw new AssertionError();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Consumer<String> makeConsumer(HashSet<Expression> was, Proof proof) {
        return s -> {
            if (proof.list.isEmpty() || !proof.header.expression.equals(proof.list.get(proof.list.size() - 1))) {
                Expression tree = Expression.getTree(s);
                if (!was.contains(tree)) {
                    was.add(tree);
                }
                proof.list.add(s);
            }
        };
    }

    public Proof deduce(Proof proof) {
        CheckerOutput proved = new Checker().check(proof, true);
        if (!proved.ok) {
            Proof res = new Proof();
            res.list.add(proved.list.get(0));
            return res;
        }
        if (proof.header.assumptions.isEmpty()) {
            return proof;
        }
        Proof res = new Proof();
        res.header = new Header(proof.header);
        Expression a = new ExpressionParser().parseTree(res.header.assumptions.get(res.header.assumptions.size() - 1));
        res.header.assumptions.remove(res.header.assumptions.size() - 1);
        res.header.expression = new Implication(a, Expression.getTree(res.header.expression)).toString();
        HashSet<Expression> was = new HashSet<>();
        Consumer<String> consumer = makeConsumer(was, res);
        for (int i = 0; i < proved.list.size(); i++) {
            Expression expr = Expression.getTree(getExpression(proved.list.get(i)));
            String annotation = getAnnotation(proved.list.get(i));
            if (expr.equals(a)) {
                consumer.accept(Substitutor.substitute("A->A->A", a));
                consumer.accept(Substitutor.substitute("(A->A->A)->(A->(A->A)->A)->(A->A)", a));
                consumer.accept(Substitutor.substitute("(A->(A->A)->A)->(A->A)", a));
                consumer.accept(Substitutor.substitute("(A->(A->A)->A)", a));
                consumer.accept(Substitutor.substitute("A->A", a));
            } else if (annotation.startsWith("Предположение")
                    || annotation.startsWith("Сх. акс.")) {
                consumer.accept(Substitutor.substitute("A", expr));
                consumer.accept(Substitutor.substitute("A->B->A", expr, a));
                consumer.accept(Substitutor.substitute("A->B", a, expr));
            } else if (annotation.startsWith("M.P.")) {
                int ind = Integer.parseInt(annotation.substring(5, annotation.indexOf(',')));
                Expression b = Expression.getTree(getExpression(proved.list.get(ind - 1)));
                consumer.accept(Substitutor.substitute("(A->B)->(A->B->C)->(A->C)", a, b, expr));
                consumer.accept(Substitutor.substitute("(A->B->C)->(A->C)", a, b, expr));
                consumer.accept(Substitutor.substitute("A->B", a, expr));
            } else if (annotation.startsWith("Правило Forall")) {
                Expression t = Expression.getTree(proof.list.get(i));
                String f = t.children[0].toString();
                String x = t.children[1].children[0].toString();
                String g = t.children[1].children[1].toString();
                getProof("|-(A&B->C)->(A->B->C)", a.toString(), f, String.format("@%s(%s)", x, g)).forEach(consumer);
                getProof("|-(A->B->C)->(A&B->C)", a.toString(), f, g).forEach(consumer);
                consumer.accept(String.format("(%s)&(%s)->(%s)", a, f, g));
                consumer.accept(String.format("(%s)&(%s)->@%s(%s)", a, f, x, g));
                consumer.accept(String.format("(%s)->(%s)->@%s(%s)", a, f, x, g));
            } else if (annotation.startsWith("Правило Exist")) {
                Expression t = Expression.getTree(proof.list.get(i));
                String f = t.children[1].toString();
                String x = t.children[0].children[0].toString();
                String g = t.children[0].children[1].toString();
                getProof("|-(A->B->C)->(B->A->C)", a.toString(), g, f).forEach(consumer);
                getProof("|-(A->B->C)->(B->A->C)", String.format("?%s(%s)", x, g), a.toString(), f).forEach(consumer);
                consumer.accept(String.format("(%s)->(%s)->(%s)", g, a, f));
                consumer.accept(String.format("?%s(%s)->(%s)->(%s)", x, g, a, f));
                consumer.accept(String.format("(%s)->?%s(%s)->(%s)", a, x, g, f));
            } else {
                throw new AssertionError();
            }
        }

        return res;
    }

    private static ArrayList<String> getProof(String theorem, String... formulas) {
        ArrayList<String> res = new ArrayList<>();
        if (!proofs.containsKey(theorem)) {
            throw new AssertionError();
        }
        for (String s : proofs.get(theorem)) {
            String cur = Substitutor.substitute(s, formulas);
            res.add(cur);
        }
        return res;
    }
}
