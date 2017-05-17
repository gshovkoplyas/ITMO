package Utils.Tree;

import Utils.Model;

public class Implication extends BinaryExpression {
    public Implication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected boolean op(boolean a, boolean b) {
        return !a || b;
    }

    @Override
    public String type() {
        return "->";
    }

    @Override
    public boolean check(Model model) {
        if (getLeft().check(model)) {
            if (!getRight().check(model)) {
                return false;
            }
        }
        for (Model child : model.children) {
            if (child.isActive() && !check(child)) {
                return false;
            }
        }
        return true;
    }
}
