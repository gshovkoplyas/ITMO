package Utils;

import java.util.ArrayList;

public class Header {
    public ArrayList<String> assumptions;
    public String expression;

    public Header() {
        this.assumptions = new ArrayList<>();
        this.expression = "";
    }

    public Header(Header header) {
        this.assumptions = new ArrayList<>(header.assumptions);
        this.expression = header.expression;
    }

    public Header(String s) {
        this();
        String[] tmp = s.replace("\\s", "").split("\\|-");
        String[] tmp1 = tmp[0].split(",");
        int balance = 0;
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < tmp1.length; i++) {
            cur.append(tmp1[i]);
            for (int j = 0; j < tmp1[i].length(); j++) {
                char c = tmp1[i].charAt(j);
                if (c == '(') {
                    balance++;
                }
                if (c == ')') {
                    balance--;
                }
            }
            if (balance == 0) {
                if (!cur.toString().isEmpty()) {
                    assumptions.add(cur.toString());
                }
                cur = new StringBuilder();
            } else {
                cur.append(",");
            }
        }
        expression = tmp[1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String assumption : assumptions) {
            sb.append(assumption);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("|-");
        sb.append(expression);
        return sb.toString();
    }
}
