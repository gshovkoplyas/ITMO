package Utils.Tree;

public class Multiply extends BinaryExpression {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String type() {
        return "*";
    }
}
