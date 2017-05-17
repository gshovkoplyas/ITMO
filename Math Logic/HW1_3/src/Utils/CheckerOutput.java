package Utils;

import java.util.ArrayList;

public class CheckerOutput {
    public final ArrayList<String> list = new ArrayList<>();
    public boolean ok = true;


    public static String getAnnotation(String s) {
        int i = s.lastIndexOf("(");
        return s.substring(i + 1, s.length() - 1);
    }

    public static String getIndex(String s) {
        int i = s.indexOf(")");
        return s.substring(1, i);
    }

    public static String getExpression(String s) {
        int l = s.indexOf(")");
        int r = s.lastIndexOf("(");
        return s.substring(l + 2, r - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
