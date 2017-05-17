package Utils.Tree;

public class Not extends UnaryExpression {
    public Not(Expression once) {
        super(once);
    }

    @Override
    public String type() {
        return "!";
    }
}
