package Utils;

import java.util.ArrayList;

class ExpressionLexer {
    private final String inputString;
    private int pos;
    private final ArrayList<Character> list = new ArrayList<>();
    private String curToken;

    ExpressionLexer(String inputString) {
        this.inputString = inputString.replace(" ", "");
        pos = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            list.add((char) (0));
            if (inputString.charAt(i) == '(') {
                stack.add(i);
            }
            if (inputString.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    throw new AssertionError();
                }
                int j = i + 1;
                if (j < inputString.length()) {
                    list.set(stack.get(stack.size() - 1), inputString.charAt(j));
                }
                stack.remove(stack.size() - 1);
            }
        }
        nextToken();
    }

    private String next() {
        if (pos == inputString.length()) {
            pos++;
            return "";
        }
        if (pos > inputString.length()) {
            throw new AssertionError("Tokens have ended");
        }
        switch (inputString.charAt(pos)) {
            case '-':
                if (inputString.charAt(pos + 1) != '>') {
                    throw new AssertionError("Unexpected token");
                }
                pos += 2;
                return "->";
            case '|':
                if (pos + 1 < inputString.length() && inputString.charAt(pos + 1) == '-') {
                    pos += 2;
                    return "|-";
                }
                pos++;
                return "|";
            case '&':
                pos++;
                return "&";
            case '!':
                pos++;
                return "!";
            case ',':
                pos++;
                return ",";
            case '(':
                pos++;
                return "(";
            case ')':
                pos++;
                return ")";
            case '@':
                pos++;
                return "@";
            case '?':
                pos++;
                return "?";
            case '=':
                pos++;
                return "=";
            case '+':
                pos++;
                return "+";
            case '*':
                pos++;
                return "*";
            case '0':
                pos++;
                return "0";
            case '\'':
                pos++;
                return "'";
            default:
                if (isLetter(inputString.charAt(pos))) {
                    String res = "";
                    res += inputString.charAt(pos++);
                    while (pos < inputString.length() && Character.isDigit(inputString.charAt(pos))) {
                        res += inputString.charAt(pos++);
                    }
                    return res;
                }
                throw new AssertionError("Unexpected token");
        }
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }


    String getToken() {
        return curToken;
    }

    void nextToken() {
        curToken = next();
    }

    char getAfterBracketToken() {
        return list.get(pos - 1);
    }


}
