package Utils.Tree;

import Utils.Hasher;
import Utils.ExpressionParser;
import Utils.Model;
import Utils.World;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Expression {
    public Expression children[];

    public abstract String type();

    public abstract boolean execute(boolean... v);

    public abstract boolean check(Model model);

    protected boolean checkNot(Model model) {
        if (check(model)) {
            return true;
        }
        for (Model child : model.children) {
            if (child.isActive() && checkNot(child)) {
                return true;
            }
        }
        return false;
    }


    public HashSet<Expression> getVariables() {
        HashSet<Expression> res = new HashSet<>();
        for (int i = 0; i < children.length; i++) {
            res.addAll(children[i].getVariables());
        }
        return res;
    }

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
