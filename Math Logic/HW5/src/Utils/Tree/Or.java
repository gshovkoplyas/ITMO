package Utils.Tree;

import Utils.Model;

public class Or extends BinaryExpression {
    public Or(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected boolean op(boolean a, boolean b) {
        return a || b;
    }

    @Override
    public String type() {
        return "|";
    }

    @Override
    public boolean check(Model model) {
        return getLeft().check(model) || getRight().check(model);
    }
}
