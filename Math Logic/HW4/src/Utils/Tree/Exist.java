package Utils.Tree;

public class Exist extends QuantorExpression {
    public Exist(Expression var, Expression exp) {
        super(var, exp);
    }

    @Override
    public String type() {
        return "?";
    }
}
