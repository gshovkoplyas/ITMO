package Utils.Tree;

import Utils.Ordinal;

import static Utils.Ordinal.ONE;
import static Utils.Ordinal.ZERO;

public class Const extends Expression {
    private final String value;

    public Const(String s) {
        this.value = s;
    }

    @Override
    public Ordinal execute() {
        if (value.equals("w")) {
            return new Ordinal(new Ordinal(ONE, ONE), ZERO);
        }
        return new Ordinal(Long.parseLong(value));
    }

    @Override
    public String toString() {
        return value;
    }
}
