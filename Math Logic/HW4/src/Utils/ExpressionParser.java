package Utils;

import Utils.Tree.*;

import java.util.ArrayList;

public class ExpressionParser {
    private enum Token {
        IMPLICATION, OR, AND, NOT, LBRACKET, RBRACKET, VAR, END, COMMA, FORALL,
        EXIST, PREDICATE, EQUAL, ADD, MULTIPLY, ZERO, INC
    }

    private ExpressionLexer lexer;

    private Expression parseNameLower() {
        Token cur = parseToken(lexer.getToken());
        if (cur == Token.VAR) {
            Expression res = new Variable(lexer.getToken());
            lexer.nextToken();
            return res;
        } else {
            throw new AssertionError(cur.toString());
        }
    }

    private Expression parseMultiplier() {
        Token cur = parseToken(lexer.getToken());
        Expression res;
        switch (cur) {
            case VAR:
                String name = lexer.getToken();
                lexer.nextToken();
                cur = parseToken(lexer.getToken());
                ArrayList<Expression> a = new ArrayList<>();
                if (cur == Token.LBRACKET) {
                    lexer.nextToken();
                    while (true) {
                        a.add(parseTerm());
                        cur = parseToken(lexer.getToken());
                        if (cur == Token.COMMA) {
                            lexer.nextToken();
                        } else {
                            if (cur != Token.RBRACKET) {
                                throw new AssertionError();
                            }
                            lexer.nextToken();
                            break;
                        }
                    }
                    Expression ch[] = new Expression[a.size()];
                    ch = a.toArray(ch);
                    res = new Predicate(name, ch);
                } else {
                    res = new Variable(name);
                }
                break;
            case LBRACKET:
                lexer.nextToken();
                res = parseTerm();
                if (parseToken(lexer.getToken()) != Token.RBRACKET) {
                    throw new AssertionError();
                }
                lexer.nextToken();
                break;
            case ZERO:
                lexer.nextToken();
                res = new Zero();
                break;
            default:
                throw new AssertionError();
        }
        while (true) {
            cur = parseToken(lexer.getToken());
            if (cur == Token.INC) {
                res = new Inc(res);
                lexer.nextToken();
            } else break;
        }
        return res;
    }

    private Expression parseSummand() {
        Expression res = parseMultiplier();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur == Token.MULTIPLY) {
                lexer.nextToken();
                res = new Multiply(res, parseMultiplier());
                continue;
            }
            break;
        }
        return res;
    }

    private Expression parseTerm() {
        Expression res = parseSummand();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur == Token.ADD) {
                lexer.nextToken();
                res = new Add(res, parseSummand());
                continue;
            }
            break;
        }
        return res;
    }

    private Expression parsePredicate() {
        Token cur = parseToken(lexer.getToken());
        switch (cur) {
            case PREDICATE:
                String predicate = lexer.getToken();
                lexer.nextToken();
                cur = parseToken(lexer.getToken());
                ArrayList<Expression> a = new ArrayList<>();
                if (cur == Token.LBRACKET) {
                    lexer.nextToken();
                    while (true) {
                        a.add(parseTerm());
                        cur = parseToken(lexer.getToken());
                        if (cur == Token.COMMA) {
                            lexer.nextToken();
                        } else {
                            if (cur != Token.RBRACKET) {
                                throw new AssertionError();
                            }
                            lexer.nextToken();
                            break;
                        }
                    }
                    Expression ch[] = new Expression[a.size()];
                    ch = a.toArray(ch);
                    return new Predicate(predicate, ch);
                } else {
                    return new Variable(predicate);
                }

            default:
                Expression left = parseTerm();
                cur = parseToken(lexer.getToken());
                if (cur != Token.EQUAL) {
                    throw new AssertionError();
                }
                lexer.nextToken();
                Expression right = parseTerm();
                return new Equal(left, right);
        }
    }

    private Expression parseUnary() {
        Token cur = parseToken(lexer.getToken());
        Expression res;
        switch (cur) {
            case NOT:
                lexer.nextToken();
                return new Not(parseUnary());
            case LBRACKET:
                char c = lexer.getAfterBracketToken();
                if (c == '=' || c == '+' || c == '*' || c == '\'') {
                    return parsePredicate();
                }
                lexer.nextToken();
                res = parseExpression();
                if (parseToken(lexer.getToken()) != Token.RBRACKET) {
                    throw new AssertionError();
                }
                lexer.nextToken();
                return res;
            case FORALL:
            case EXIST:
                lexer.nextToken();
                Expression var = parseNameLower();
                Expression ch = parseUnary();
                if (cur == Token.FORALL) {
                    return new Forall(var, ch);
                } else if (cur == Token.EXIST) {
                    return new Exist(var, ch);
                } else {
                    throw new AssertionError();
                }
            default:
                return parsePredicate();
        }
    }

    private Expression parseConjunction() {
        Expression res = parseUnary();
        while (true) {
            Token cur = parseToken(lexer.getToken());
            if (cur == Token.AND) {
                lexer.nextToken();
                res = new And(res, parseUnary());
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
            case ",":
                return Token.COMMA;
            case "@":
                return Token.FORALL;
            case "?":
                return Token.EXIST;
            case "=":
                return Token.EQUAL;
            case "+":
                return Token.ADD;
            case "*":
                return Token.MULTIPLY;
            case "0":
                return Token.ZERO;
            case "'":
                return Token.INC;
            default:
                char cur = s.charAt(0);
                if (cur >= 'a' && cur <= 'z') {
                    for (int i = 1; i < s.length(); i++) {
                        if (s.charAt(i) < '0' || s.charAt(i) > '9')
                            throw new AssertionError("Unexpected token:" + s);
                    }
                    return Token.VAR;

                } else if (cur >= 'A' && cur <= 'Z') {
                    for (int i = 1; i < s.length(); i++) {
                        if (s.charAt(i) < '0' || s.charAt(i) > '9')
                            throw new AssertionError("Unexpected token:" + s);
                    }
                    return Token.PREDICATE;

                } else {

                    throw new AssertionError("Unexpected token:" + s);
                }
        }
    }
}
