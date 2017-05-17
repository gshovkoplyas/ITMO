package Utils;

import Utils.Tree.*;

public class ExpressionParser {
    enum Token {
        IMPLICATION, OR, AND, NOT, LBRACKET, RBRACKET, VAR, END
    }

    private ExpressionLexer lexer;

    private Expression parseNegate() {
        Token cur = parseToken(lexer.getToken());
        Expression res;
        switch (cur) {
            case VAR:
                res = new Variable(lexer.getToken());
                lexer.nextToken();
                return res;
            case NOT:
                lexer.nextToken();
                return new Not(parseNegate());
            case LBRACKET:
                lexer.nextToken();
                res = parseExpression();
                if (parseToken(lexer.getToken()) != Token.RBRACKET) {
                    throw new AssertionError();
                }
                lexer.nextToken();
                return res;
            default:
                throw new AssertionError();
        }
    }

    private Expression parseConjunction() {
        Expression res = parseNegate();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur == Token.AND) {
                lexer.nextToken();
                res = new And(res, parseNegate());
                continue;
            }
            break;
        }
        return res;
    }

    private Expression parseDisjunction() {
        Expression res = parseConjunction();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur == Token.OR) {
                lexer.nextToken();
                res = new Or(res, parseConjunction());
                continue;
            }
            break;
        }
        return res;
    }

    private Expression parseExpression() {
        Expression res = parseDisjunction();
        Token cur = parseToken(lexer.getToken());
        if (cur == Token.IMPLICATION) {
            lexer.nextToken();
            return new Implication(res, parseExpression());
        }
        return res;
    }

    public Expression parseTree(String s) {
        lexer = new ExpressionLexer(s);
        return parseExpression();
    }

    public static Token parseToken(String s) {
        switch (s) {
            case "->":
                return Token.IMPLICATION;
            case "|":
                return Token.OR;
            case "&":
                return Token.AND;
            case "!":
                return Token.NOT;
            case "(":
                return Token.LBRACKET;
            case ")":
                return Token.RBRACKET;
            case "":
                return Token.END;
            default:
                return Token.VAR;
        }
    }
}
