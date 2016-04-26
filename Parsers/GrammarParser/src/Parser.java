import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by shovkoplyas on 25.04.2016.
 */
public class Parser {
    LexicalAnalyzer lexicalAnalyzer;

    private Tree S() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case VAR:
                Tree beg = V();
                lexicalAnalyzer.nextToken();
                if (lexicalAnalyzer.curToken() != Token.CHARACTER) {
                    throw new ParseException("alpha expected on position", lexicalAnalyzer.curPos());
                }
                Tree cont = T();
                return new Tree("S", beg, cont);
            default:
                throw new AssertionError();
        }
    }

    private Tree V() {
        if (lexicalAnalyzer.curToken() != Token.VAR) {
            throw new AssertionError();
        }
        return new Tree("VAR");
    }

    private Tree NDoublePrime() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case CHARACTER:
            case DIGIT:
                String value = String.valueOf((char) lexicalAnalyzer.curToken().getValue());
                lexicalAnalyzer.nextToken();
                Tree cont = NDoublePrime();
                return new Tree("N''", new Tree(value), cont);
            case SEMICOLON:
            case COLON:
            case COMMA:
                return new Tree("N''");
            default:
                throw new AssertionError();
        }
    }

    private Tree NPrime() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case CHARACTER:
            case DIGIT:
                String value = String.valueOf((char) lexicalAnalyzer.curToken().getValue());
                lexicalAnalyzer.nextToken();
                Tree cont = NDoublePrime();
                return new Tree("N'", new Tree(value), cont);
            default:
                throw new AssertionError();
        }
    }

    private Tree N() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case CHARACTER:
                String value = String.valueOf((char) lexicalAnalyzer.curToken().getValue());
                lexicalAnalyzer.nextToken();
                Tree cont = NDoublePrime();
                return new Tree("N", new Tree(value), cont);
            default:
                throw new AssertionError();
        }
    }

    private Tree L() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case CHARACTER:
                Tree beg = N();
                //lexicalAnalyzer.nextToken();
                Tree cont;
                switch (lexicalAnalyzer.curToken()) {
                    case COMMA:
                        lexicalAnalyzer.nextToken();
                        cont = L();
                        return new Tree("L", beg, new Tree(","), cont);
                    case COLON:
                        return new Tree("L", beg);
                    default:
                        throw new ParseException("':' or ',' expected at position", lexicalAnalyzer.curPos());
                }
            default:
                throw new AssertionError();
        }
    }


    private Tree T() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case CHARACTER:
                Tree beg = L();
                //lexicalAnalyzer.nextToken();
                if (lexicalAnalyzer.curToken() != Token.COLON) {
                    throw new ParseException("':' expected at position", lexicalAnalyzer.curPos());
                }
                lexicalAnalyzer.nextToken();
                Tree sub = N();
                if (lexicalAnalyzer.curToken() != Token.SEMICOLON) {
                    throw new ParseException("';' expected at position", lexicalAnalyzer.curPos());
                }
                lexicalAnalyzer.nextToken();
                if (lexicalAnalyzer.curToken() == Token.END) {
                    return new Tree("T", beg, new Tree(":"), sub, new Tree(";"));
                }
                //lexicalAnalyzer.nextToken();
                Tree cont = T();
                return new Tree("T", beg, new Tree(":"), sub, new Tree(";"), cont);
            default:
                throw new AssertionError();
        }
    }
    public Tree parse(InputStream inputStream) throws ParseException {
        lexicalAnalyzer = new LexicalAnalyzer(inputStream);
        lexicalAnalyzer.nextToken();
        /*while (lexicalAnalyzer.curToken() != Token.END) {
            lexicalAnalyzer.curToken().print(System.out);
            lexicalAnalyzer.nextToken();
        }*/
        return S();
    }


}