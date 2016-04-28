import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by shovkoplyas on 25.04.2016.
 */
public class NewParser {
    NewLexicalAnalyzer lexicalAnalyzer;

    private Tree S() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case VAR:
                Tree beg = V();
                lexicalAnalyzer.nextToken();
                if (lexicalAnalyzer.curToken() != Token.VARTYPE) {
                    throw new ParseException("variable or type expected on position", lexicalAnalyzer.curPos());
                }
                Tree cont = T();
                return new Tree("S", beg, cont);
            default:
                throw new ParseException("VAR expected at position", lexicalAnalyzer.curPos());
        }
    }

    private Tree V() {
        if (lexicalAnalyzer.curToken() != Token.VAR) {
            throw new AssertionError();
        }
        return new Tree("VAR");
    }

    private Tree L() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case VARTYPE:
                String value = lexicalAnalyzer.curToken().getValue();
                lexicalAnalyzer.nextToken();
                Tree cont = LPrime();
                return new Tree("L", new Tree(value), cont);
            default:
                throw new ParseException("variable expected at position", lexicalAnalyzer.curPos());
        }
    }

    private Tree LPrime() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case COMMA:
                lexicalAnalyzer.nextToken();
                Tree cont = L();
                return new Tree("L'", new Tree(","), cont);
            case SEMICOLON:
            case COLON:
                return new Tree("L'");
            case END:
                throw new ParseException("Unexpected end of string", lexicalAnalyzer.curPos());
            default:
                throw new AssertionError();
        }
    }

    private Tree TPrime() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case VARTYPE:
                Tree cont = T();
                return new Tree("T'", cont);
            case SEMICOLON:
            case COLON:
            case COMMA:
            case END:
                return new Tree("T'");
            default:
                throw new AssertionError();
        }
    }


    private Tree T() throws ParseException {
        switch (lexicalAnalyzer.curToken()) {
            case VARTYPE:
                Tree beg = L();
                if (lexicalAnalyzer.curToken() != Token.COLON) {
                    throw new ParseException("':' expected at position", lexicalAnalyzer.curPos());
                }
                lexicalAnalyzer.nextToken();
                if (lexicalAnalyzer.curToken() != Token.VARTYPE) {
                    throw new ParseException("type expected at position", lexicalAnalyzer.curPos());
                }
                Tree sub = new Tree(lexicalAnalyzer.curToken().getValue());
                lexicalAnalyzer.nextToken();
                if (lexicalAnalyzer.curToken() != Token.SEMICOLON) {
                    throw new ParseException("';' expected at position", lexicalAnalyzer.curPos());
                }
                lexicalAnalyzer.nextToken();
                Tree cont = TPrime();
                return new Tree("T", beg, new Tree(":"), sub, new Tree(";"), cont);
            default:
                throw new ParseException("Character expected at position", lexicalAnalyzer.curPos());
        }
    }

    public Tree parse(InputStream inputStream) throws ParseException {
        lexicalAnalyzer = new NewLexicalAnalyzer(inputStream);
        lexicalAnalyzer.nextToken();
        return S();
    }


}