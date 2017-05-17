package Utils.Tree;

public abstract class QuantorExpression extends Expression {
    QuantorExpression(Expression var, Expression exp) {
        children = new Expression[]{var, exp};
        calculateHash();
    }

    @Override
    public String toString() {
        return String.format("%s%s(%s)", type(), children[0].toString(), children[1].toString());
    }
}
