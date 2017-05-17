package Utils;

import Utils.Tree.*;

public class Parser {
    public enum Token {
        EQ, ADD, SUB, MUL, POW, W, NUM, LBRACKET, RBRACKET
    }

    private Lexer lexer;

    private Expression parseExponent() {
        Token cur = parseToken(lexer.getToken());
        if (cur == Token.LBRACKET) {
            lexer.nextToken();
            Expression res = parseExpression();
            if (parseToken(lexer.getToken()) != Token.RBRACKET) {
                throw new AssertionError();
            }
            lexer.nextToken();
            return res;
        }
        if (cur == Token.NUM || cur == Token.W) {
            Expression res = new Const(lexer.getToken());
            lexer.nextToken();
            return res;
        }
        throw new AssertionError();
    }

    private Expression parseMultiplier() {
        Expression res = parseExponent();
        Token cur = parseToken(lexer.getToken());
        if (cur == Token.POW) {
            lexer.nextToken();
            return new Pow(res, parseMultiplier());
        }
        return res;
    }

    private Expression parseSummand() {
        Expression res = parseMultiplier();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur == Token.MUL) {
                lexer.nextToken();
                res = new Mul(res, parseMultiplier());
            } else {
                break;
            }
        }
        return res;
    }

    private Expression parseExpression() {
        Expression res = parseSummand();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur != Token.ADD && cur != Token.SUB) {
                break;
            }
            lexer.nextToken();
            if (cur == Token.ADD) {
                res = new Add(res, parseSummand());
            } else if (cur == Token.SUB) {
                res = new Sub(res, parseSummand());
            }
        }
        return res;
    }

    public Expression parseOrdinal(String s) {
        lexer = new Lexer(s);
        return parseExpression();
    }

    private static Token parseToken(String s) {
        switch (s) {
            case "=":
                return Token.EQ;
            case "+":
                return Token.ADD;
            case "-":
                return Token.SUB;
            case "*":
                return Token.MUL;
            case "^":
                return Token.POW;
            case "w":
                return Token.W;
            case "(":
                return Token.LBRACKET;
            case ")":
                return Token.RBRACKET;
            default:
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        throw new AssertionError("Number expected, found:" + s);
                    }
                }
                return Token.NUM;
        }
    }
}
