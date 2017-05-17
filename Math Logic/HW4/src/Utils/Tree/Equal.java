package Utils.Tree;

public class Equal extends BinaryExpression {
    public Equal(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String type() {
        return "=";
    }

    @Override
    public String toString() {
        return String.format("%s=%s", children[0].toString(), children[1].toString());
    }
}
