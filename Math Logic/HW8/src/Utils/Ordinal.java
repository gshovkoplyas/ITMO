package Utils;

public class Ordinal {
    private final long value;
    private final Ordinal left;
    private final Ordinal right;

    public Ordinal(long value) {
        this.value = value;
        left = null;
        right = null;
    }

    public Ordinal(Ordinal left, Ordinal right) {
        this.left = left;
        this.right = right;
        this.value = -1;
    }

    public Ordinal(String s) {
        this(new Parser().parseOrdinal(s).execute());
    }

    public Ordinal(Ordinal o) {
        this.value = o.value;
        this.left = o.left;
        this.right = o.right;
    }

    public static boolean isEquals(Ordinal a, Ordinal b) {
        return cmpo(a, b) == 0;
    }

    public long getValue() {
        return value;
    }

    public static boolean isAtom(Ordinal o) {
        return o == null || o.value != -1;
    }


    public final static Ordinal ZERO = new Ordinal(0);
    public final static Ordinal ONE = new Ordinal(1);

    public boolean isZero() {
        return cmpo(this, ZERO) == 0;
    }

    public boolean isOne() {
        return cmpo(this, ONE) == 0;
    }

    @Override
    public String toString() {
        return toString(this);
    }

    private static String toString(Ordinal a) {
        if (isAtom(a)) {
            return Long.toString(a.value);
        }
        StringBuilder res = new StringBuilder();
        res.append("w^(").append(toString(a.left.left)).append(")*").append(a.left.right.toString());
        if (a.right != null) {
            res.append("+").append(toString(a.right));
        }
        return res.toString();
    }

    public static Ordinal first(Ordinal a) {
        return a.left;
    }

    public static Ordinal rest(Ordinal a) {
        return a.right;
    }

    public static Ordinal firstn(Ordinal a, long n) {
        if (n == 0) {
            return null;
        }
        return new Ordinal(first(a), firstn(rest(a), n - 1));
    }

    public static Ordinal restn(Ordinal a, long n) {
        if (n == 0) {
            return a;
        }
        return restn(rest(a), n - 1);
    }


    public static Ordinal fe(Ordinal a) {
        if (isAtom(a)) {
            return new Ordinal(0);
        }
        return first(first(a));
    }

    public static Ordinal fc(Ordinal a) {
        if (isAtom(a)) {
            return a;
        }
        return rest(first(a));
    }

    public static long length(Ordinal a) {
        if (isAtom(a)) {
            return 0;
        }
        return 1 + length(rest(a));
    }

    public Ordinal append(Ordinal o) {
        if (isAtom(this)) {
            return o;
        }
        Ordinal r = rest(this);
        if (r == null) {
            return new Ordinal(first(this), o);
        }
        return new Ordinal(first(this), r.append(o));
    }

    private static int cmpw(Ordinal a, Ordinal b) {
        return Long.compare(a.value, b.value);
    }

    public static int cmpo(Ordinal a, Ordinal b) {
        if (isAtom(a) && isAtom(b)) {
            return cmpw(a, b);
        }
        if (isAtom(a)) {
            return -1;
        }
        if (isAtom(b)) {
            return 1;
        }
        int cmp = cmpo(fe(a), fe(b));
        if (cmp != 0) {
            return cmp;
        }
        int cmp2 = cmpw(fc(a), fc(b));
        if (cmp2 != 0) {
            return cmp2;
        }
        return cmpo(rest(a), rest(b));
    }
}
