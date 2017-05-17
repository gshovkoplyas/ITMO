package Utils.Tree;

public class Inc extends UnaryExpression {
    public Inc(Expression once) {
        super(once);
    }

    @Override
    public String type() {
        return "'";
    }

    @Override
    public String toString() {
        return String.format("(%s)'", children[0].toString());
    }
}
