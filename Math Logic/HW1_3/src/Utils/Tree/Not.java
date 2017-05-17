package Utils.Tree;

public class Not extends Expression {
    public Not(Expression once) {
        children = new Expression[]{once};
        calculateHash();
    }

    @Override
    public String toString() {
        return String.format("!(%s)", children[0].toString());
    }

    public boolean execute(boolean... v) {
        return !v[0];
    }

    @Override
    public String type() {
        return "!";
    }
}
