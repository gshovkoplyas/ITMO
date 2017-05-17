package Utils.Tree;

import Utils.Ordinal;

public abstract class Expression {
    Expression[] children;

    public abstract Ordinal execute();

    @Override
    public abstract String toString();
}
