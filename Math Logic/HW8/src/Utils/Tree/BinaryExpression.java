package Utils.Tree;

import Utils.Ordinal;

public abstract class BinaryExpression extends Expression {
    BinaryExpression(Expression left, Expression right) {
        children = new Expression[]{left, right};
    }

    protected BinaryExpression() {

    }

    protected abstract String op();

    @Override
    public String toString() {
        return String.format("(%s)%s(%s)", children[0].toString(), op(), children[1].toString());
    }

    protected abstract Ordinal execute(Ordinal a, Ordinal b);

    @Override
    public Ordinal execute() {
        return execute(children[0].execute(), children[1].execute());
    }
}
