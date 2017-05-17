package Utils.Tree;

import Utils.Ordinal;

import static Utils.Ordinal.*;

public class Sub extends BinaryExpression {
    public Sub(Expression left, Expression right) {
        super(left, right);
    }

    private Sub() {

    }

    @Override
    protected Ordinal execute(Ordinal a, Ordinal b) {
        if (a.getValue() <= b.getValue()) {
            return ZERO;
        }
        if (isAtom(a) && isAtom(b)) {
            return new Ordinal(a.getValue() - b.getValue());
        }
        int cmp = cmpo(fe(a), fe(b));
        if (cmp < 0) {
            return ZERO;
        }
        if (cmp > 0) {
            return a;
        }
        int cmp2 = cmpo(fc(a), fc(b));
        if (cmp2 < 0) {
            return ZERO;
        }
        if (cmp2 > 0) {
            return new Ordinal(new Ordinal(fe(a), subtract(fc(a), fc(b))), rest(a));
        }
        return subtract(rest(a), rest(b));
    }

    public static Ordinal subtract(Ordinal a, Ordinal b) {
        return new Sub().execute(a, b);
    }

    @Override
    public String op() {
        return "-";
    }
}
