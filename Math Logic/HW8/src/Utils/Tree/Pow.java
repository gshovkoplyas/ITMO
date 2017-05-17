package Utils.Tree;

import Utils.Ordinal;

import static Utils.Ordinal.*;
import static Utils.Tree.Mul.multiply;
import static Utils.Tree.Sub.subtract;
import static Utils.Tree.Mul.padd;

public class Pow extends BinaryExpression {
    public Pow(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected Ordinal execute(Ordinal a, Ordinal b) {
        if (a.isOne() || b.isZero()) {
            return ONE;
        }
        if (a.isZero()) {
            return ZERO;
        }
        if (isAtom(a) && isAtom(b)) {
            return expw(a, b);
        }
        if (isAtom(a)) {
            return exp1(a, b);
        }
        if (isAtom(b)) {
            return exp3(a, b);
        }
        return exp4(a, b);
    }

    @Override
    public String op() {
        return "^";
    }

    private static Ordinal expw(Ordinal a, Ordinal b) {
        return new Ordinal((long) Math.pow(a.getValue(), b.getValue()));
    }

    private static Ordinal exp1(Ordinal p, Ordinal b) {
        if (fe(b).isZero()) {
            return new Ordinal(new Ordinal(fc(b), expw(p, rest(b))), ZERO);
        }
        if (isAtom(rest(b))) {
            return new Ordinal(new Ordinal(new Ordinal(new Ordinal(subtract(fe(b), ONE), fc(b)), ZERO), expw(p, rest(b))), ZERO);
        }
        Ordinal c = exp1(p, rest(b));
        return new Ordinal(new Ordinal(new Ordinal(new Ordinal(subtract(fe(b), ONE), ONE), fe(c)), fc(c)), ZERO);
    }

    private static Ordinal exp2(Ordinal a, Ordinal q) {
        if (q.isOne()) {
            return a;
        }
        return multiply(new Ordinal(new Ordinal(multiply(fe(a), subtract(q, ONE)), ONE), ZERO), a);
    }

    private static Ordinal exp3(Ordinal a, Ordinal q) {
        if (q.isZero()) {
            return ONE;
        }
        if (q.isOne()) {
            return a;
        }
        if (limitp(a)) {
            return exp2(a, q);
        }
        Ordinal c = limitpart(a);
        long n = length(a);
        return padd(firstn(exp2(c, q), n), helper_exp3(c, natpart(a), n, subtract(q, ONE)), n);
    }

    private static Ordinal exp4(Ordinal a, Ordinal b) {
        return multiply(new Ordinal(new Ordinal(multiply(fe(a), limitpart(b)), ONE), ZERO), exp3(a, natpart(b)));
    }

    private static boolean limitp(Ordinal a) {
        if (isAtom(a)) {
            return a.getValue() == 0;
        }
        return limitp(rest(a));
    }

    private static Ordinal limitpart(Ordinal a) {
        if (isAtom(a)) {
            return ZERO;
        }
        return new Ordinal(first(a), limitpart(rest(a)));
    }

    private static Ordinal natpart(Ordinal a) {
        if (isAtom(a)) {
            return a;
        }
        return natpart(rest(a));
    }

    private static Ordinal helper_exp3(Ordinal a, Ordinal p, long n, Ordinal q) {
        if (q.isZero()) {
            return p;
        }
        return padd(multiply(exp2(a, q), p), helper_exp3(a, p, n, subtract(q, ONE)), n);
    }


}
