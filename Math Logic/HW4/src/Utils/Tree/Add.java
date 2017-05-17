package Utils.Tree;

public class Add extends BinaryExpression {
    public Add(Expression res, Expression expression) {
        super(res, expression);
    }

    @Override
    public String type() {
        return "+";
    }
}
