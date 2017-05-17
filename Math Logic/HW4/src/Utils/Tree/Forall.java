package Utils.Tree;

public class Forall extends QuantorExpression {
    public Forall(Expression var, Expression exp) {
        super(var, exp);
    }

    @Override
    public String type() {
        return "@";
    }
}
