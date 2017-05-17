package Utils.Tree;

public class Implication extends BinaryExpression {
    public Implication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String type() {
        return "->";
    }
}
