package Utils.Tree;

import Utils.Model;
import Utils.World;

import java.util.HashSet;

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
    public boolean check(Model model) {
        return model.world.isForced(this);
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

    @Override
    public HashSet<Expression> getVariables() {
        HashSet<Expression> res = new HashSet<>();
        res.add(this);
        return res;
    }
}
