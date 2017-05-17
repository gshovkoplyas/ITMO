package Utils.Tree;

import Utils.Ordinal;

import static Utils.Ordinal.*;
import static Utils.Tree.Add.add;

public class Mul extends BinaryExpression {
    public Mul(Expression left, Expression right) {
        super(left, right);
    }

    private Mul() {
    }

    @Override
    protected Ordinal execute(Ordinal a, Ordinal b) {
        return pmult(a, b, 0);
    }

    @Override
    public String op() {
        return "*";
    }

    public static Ordinal multiply(Ordinal a, Ordinal b) {
        return new Mul().execute(a, b);
    }

    private static long c(Ordinal a, Ordinal b) {
        if (cmpo(fe(b), fe(a)) < 0) {
            return 1 + c(rest(a), b);
        }
        return 0;
    }

    private static long count(Ordinal a, Ordinal b, long n) {
        return n + c(restn(a, n), b);
    }

    public static Ordinal padd(Ordinal a, Ordinal b, long n) {
        Ordinal first = firstn(a, n);
        if (first == null) {
            return add(restn(a, n), b);
        }
        return first.append(add(restn(a, n), b));
    }

    private static Ordinal pmult(Ordinal a, Ordinal b, long n) {
        if (a.getValue() == 0 || b.getValue() == 0) {
            return ZERO;
        }
        if (isAtom(a) && isAtom(b)) {
            return new Ordinal(a.getValue() * b.getValue());
        }
        if (isAtom(b)) {
            return new Ordinal(new Ordinal(fe(a), new Ordinal(fc(a).getValue() * b.getValue())), rest(a));
        }
        long m = count(fe(a), fe(b), n);
        return new Ordinal(new Ordinal(padd(fe(a), fe(b), m), fc(b)), pmult(a, rest(b), m));
    }
}
