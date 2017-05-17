package Utils;
public class Lexer {
    private final String input;
    private int pos;
    private String curToken;

    Lexer(String input) {
        this.input = input.replace(" ", "");
        this.pos = 0;
        nextToken();
    }

    String getToken() {
        return curToken;
    }

    void nextToken() {
        curToken = next();
    }

    private String next() {
        if (pos == input.length()) {
            pos++;
            return "";
        }
        if (pos > input.length()) {
            throw new AssertionError();
        }
        switch (input.charAt(pos)) {
            case '=':
            case '+':
            case '-':
            case '*':
            case '^':
            case 'w':
            case '(':
            case ')':
                return String.valueOf(input.charAt(pos++));
            default:
                if (!Character.isDigit(input.charAt(pos))) {
                    throw new AssertionError();
                }
                StringBuilder sb = new StringBuilder();
                for (;pos < input.length(); pos++) {
                    char c = input.charAt(pos);
                    if (!Character.isDigit(c)){
                        break;
                    }
                    sb.append(c);
                }
                return sb.toString();
        }
    }
}
