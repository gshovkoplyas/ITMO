package Utils.Tree;

public abstract class UnaryExpression extends Expression {
    UnaryExpression(Expression once) {
        children = new Expression[]{once};
        calculateHash();
    }

    @Override
    public String toString() {
        return type().toString() + "(" + children[0].toString() + ")";
    }
}
