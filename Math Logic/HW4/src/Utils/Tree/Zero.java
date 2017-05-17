package Utils.Tree;

public class Zero extends Expression {
    public Zero() {
        children = new Expression[0];
        calculateHash();
    }

    @Override
    public String type() {
        return "0";
    }

    @Override
    public String toString() {
        return "0";
    }
}
