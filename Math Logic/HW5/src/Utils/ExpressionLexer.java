package Utils;

public class ExpressionLexer {
    private final String inputString;
    private int pos;
    private String curToken;

    ExpressionLexer(String inputString) {
        this.inputString = inputString.replace(" ", "");
        this.pos = 0;
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
        return c >= 'A' && c <= 'Z';
    }

    String getToken() {
        return curToken;
    }

    void nextToken() {
        curToken = next();
    }

}
