package Utils.Tree;

public class Predicate extends Expression {
    public Predicate(String s, Expression... other) {
        children = new Expression[other.length + 1];
        children[0] = new Function(s);
        for (int i = 0; i < other.length; i++) {
            children[i + 1] = other[i];
        }
        calculateHash();
    }

    @Override
    public String type() {
        return "Predicate";
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(children[0]);
        if (children.length > 1) {
            res.append("(");
            for (int i = 1; i < children.length; i++) {
                res.append(children[i].toString());
                res.append(",");

            }
            res.deleteCharAt(res.length() - 1);
            res.append(")");
        }
        return res.toString();
    }
}
