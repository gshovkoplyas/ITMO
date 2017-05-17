package Utils.Tree;

import Utils.Ordinal;

import static Utils.Ordinal.*;

public class Add extends BinaryExpression {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    private Add() {

    }

    @Override
    protected Ordinal execute(Ordinal a, Ordinal b) {
        if (isAtom(a) && isAtom(b)) {
            return new Ordinal(a.getValue() + b.getValue());
        }
        int cmp = cmpo(fe(a), fe(b));
        if (cmp < 0) {
            return b;
        }
        if (cmp == 0) {
            return new Ordinal(new Ordinal(fe(a), add(fc(a), fc(b))), rest(b));
        }
        return new Ordinal(new Ordinal(fe(a), fc(a)), add(rest(a), b));

    }

    public static Ordinal add(Ordinal a, Ordinal b) {
        return new Add().execute(a, b);
    }

    @Override
    public String op() {
        return "+";
    }
}
