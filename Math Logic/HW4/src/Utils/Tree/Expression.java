package Utils.Tree;

import Utils.Hasher;
import Utils.ExpressionParser;

import java.util.ArrayList;

public abstract class Expression {
    public Expression children[];

    public abstract String type();

    private int hash;

    static public Expression getTree(String s) {
        return new ExpressionParser().parseTree(s);
    }

    @Override
    public int hashCode() {
        return getHash();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Expression) {
            return ((Expression) o).getHash() == getHash();
        }
        return false;
    }

    @Override
    public abstract String toString();

    Integer hash() {
        return type().hashCode();
    }

    void calculateHash() {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(hash());
        for (Expression child : children) {
            res.add(child.getHash());
        }
        hash = Hasher.getHash(res);
    }

    private int getHash() {
        return hash;
    }
}
