package Utils.Tree;

public class Variable extends Expression {
    private final String name;

    public Variable(String s) {
        this.name = s;
        children = new Expression[0];
        calculateHash();
    }

    @Override
    public String type() {
        return "Variable";
    }

    @Override
    protected Integer hash() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
