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
    public String toString() {
        return name;
    }

    @Override
    protected Integer hash() {
        return name.hashCode();
    }

    public boolean execute(boolean... v) {
        throw new IllegalStateException();
    }
}
