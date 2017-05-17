package Utils.Tree;

public class And extends BinaryExpression {
    public And(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String type() {
        return "&";
    }
}
