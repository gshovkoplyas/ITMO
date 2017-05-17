package Utils.Tree;

public class Or extends BinaryExpression {
    public Or(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String type() {
        return "|";
    }
}
