import javafx.util.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by shovkoplyas on 18.04.2016.
 */
public class LexicalAnalyzer {
    private InputStream in;
    private int curChar;
    private int curPos;
    private Deque<Pair<Token, String>> tokenQueue;
    private Token curToken;

    public LexicalAnalyzer(InputStream in) throws ParseException {
        this.in = in;
        curPos = 0;
        tokenQueue = new ArrayDeque<Pair<Token, String>>();
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
        if (!tokenQueue.isEmpty()) {
            Pair<Token, String> cur = tokenQueue.poll();
            curToken = cur.getKey();
            curToken.setValue(cur.getValue());
            return;
        }

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
                if (curChar == 'v' || curChar == 'V') {
                    boolean isVar = false;
                    tokenQueue.add(new Pair<Token, String>(Token.CHARACTER, String.valueOf((char)curChar)));
                    nextChar();
                    if (curChar == 'a' || curChar == 'A') {
                        tokenQueue.add(new Pair<Token, String>(Token.CHARACTER, String.valueOf((char)curChar)));
                        nextChar();
                        if (curChar == 'r' || curChar == 'R') {
                            tokenQueue.add(new Pair<Token, String>(Token.CHARACTER, String.valueOf((char)curChar)));
                            nextChar();
                            if (isBlank(curChar)) {
                                curToken = Token.VAR;
                                for (int i = 0; i < 2; i++) {
                                    tokenQueue.removeLast();
                                }
                                isVar = true;
                            }
                        }
                    }
                    if (!isVar) {
                        Pair<Token, String> cur = tokenQueue.poll();
                        curToken = cur.getKey();
                        curToken.setValue(cur.getValue());
                    }
                } else if (isAlpha(curChar)) {
                    curToken = Token.CHARACTER;
                    curToken.setValue(String.valueOf((char)curChar));
                    nextChar();
                    //break;
                } else if (isDigit(curChar)) {
                    curToken = Token.DIGIT;
                    curToken.setValue(String.valueOf((char)curChar));
                    nextChar();
                    //break;
                } else {
                    throw new ParseException("Illegal character" + (char) curChar, curPos);
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
