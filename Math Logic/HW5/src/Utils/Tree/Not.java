package Utils.Tree;

import Utils.Model;

public class Not extends Expression {
    public Not(Expression once) {
        children = new Expression[]{once};
        calculateHash();
    }

    public Expression getOnce() {
        return children[0];
    }

    @Override
    public String toString() {
        return String.format("!(%s)", children[0].toString());
    }

    public boolean execute(boolean... v) {
        return !v[0];
    }

    @Override
    public boolean check(Model model) {
        if (getOnce().check(model)) {
            return false;
        }
        for (Model child : model.children) {
            if (child.isActive() && getOnce().checkNot(child)){//child.deepCheck(getOnce())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String type() {
        return "!";
    }
}
