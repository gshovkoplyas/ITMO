import javafx.util.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by shovkoplyas on 18.04.2016.
 */
public class NewLexicalAnalyzer {
    private InputStream in;
    private int curChar;
    private int curPos;
    private Deque<Pair<Token, Integer>> tokenQueue;
    private Token curToken;

    public NewLexicalAnalyzer(InputStream in) throws ParseException {
        this.in = in;
        curPos = 0;
        tokenQueue = new ArrayDeque<Pair<Token, Integer>>();
        nextChar();
    }

    private boolean isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private boolean isAlpha(int c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isDigit(int c) {
        return c >= '0' && c <= '9';
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = in.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        /*if (!tokenQueue.isEmpty()) {
            Pair<Token, Integer> cur = tokenQueue.poll();
            curToken = cur.getKey();
            curToken.setValue(cur.getValue());
            return;
        }*/

        while (isBlank(curChar)) {
            nextChar();
        }

        switch (curChar) {
            case ',':
                nextChar();
                curToken = Token.COMMA;
                break;
            case ':':
                nextChar();
                curToken = Token.COLON;
                break;
            case ';':
                nextChar();
                curToken = Token.SEMICOLON;
                break;
            case -1:
                curToken = Token.END;
                break;
            default:
                if (!isAlpha(curChar)) {
                    throw new ParseException("Character expected at position", curPos());
                } else {
                    String s = String.valueOf((char) curChar);
                    nextChar();
                    while (isAlpha(curChar) || isDigit(curChar)) {
                        s += String.valueOf((char) curChar);
                        nextChar();
                    }
                    if (s.toLowerCase().equals("var")) {
                        curToken = Token.VAR;
                    } else {
                        curToken = Token.VARTYPE;
                        curToken.setValue(s);
                    }
                }


        }
    }

    public Token curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }
}
