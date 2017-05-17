package Tools;

import Utils.*;
import Utils.Tree.Expression;
import Utils.Tree.Implication;

import java.util.HashSet;
import java.util.function.Consumer;

import static Utils.CheckerOutput.getAnnotation;
import static Utils.CheckerOutput.getExpression;
import static Utils.Simplificator.simplify;

public class Deductor {
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
        CheckerOutput proved = new Checker().check(proof);

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
            } else {
                System.err.println(annotation);
                throw new AssertionError("Unexpected annotation");
            }
        }

        return simplify(res);
    }
}
