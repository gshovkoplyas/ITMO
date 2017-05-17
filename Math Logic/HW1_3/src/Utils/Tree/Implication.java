package Utils.Tree;

public class Implication extends BinaryExpression {
    public Implication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected boolean op(boolean a, boolean b) {
        return !a || b;
    }

    @Override
    public String type() {
        return "->";
    }
}
