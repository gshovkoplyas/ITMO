package Utils;


import Utils.Tree.Expression;

public class Substitutor {
    public static String substitute(String s, Expression... e) {
        String exp[] = new String[e.length];
        for (int i = 0; i < e.length; i++) {
            exp[i] = e[i].toString();
        }
        return substitute(s, exp);
    }

    public static String substitute(String s, String... e) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (isLetter(cur)) {
                res.append("(");
                res.append(e[cur - 'A']);
                res.append(")");
            } else {
                res.append(cur);
            }
        }


        return Expression.getTree(res.toString()).toString();
    }

    private static boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
