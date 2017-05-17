package Utils.Tree;

public class Function extends Expression {
    private final String name;

    public Function(String s) {
        this.name = s;
        children = new Expression[0];
        calculateHash();
    }

    @Override
    public String type() {
        return "Function";
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