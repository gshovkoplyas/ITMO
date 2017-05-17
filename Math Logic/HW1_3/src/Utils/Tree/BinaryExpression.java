package Utils.Tree;

public abstract class BinaryExpression extends Expression {
    BinaryExpression(Expression left, Expression right) {
        children = new Expression[]{left, right};
        calculateHash();
    }

    @Override
    public String toString() {
        return String.format("(%s)%s(%s)", children[0].toString(), type(), children[1].toString());
    }

    protected abstract boolean op(boolean a, boolean b);

    public boolean execute(boolean... v) {
        return op(v[0], v[1]);
    }
}
