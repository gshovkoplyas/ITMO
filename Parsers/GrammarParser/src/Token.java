import org.omg.CORBA.portable.OutputStream;

import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * Created by shovkoplyas on 18.04.2016.
 */
public enum Token {
    VAR, CHARACTER, DIGIT, COMMA, SEMICOLON, COLON, END, VARTYPE;
    //var, [a-z|A-Z], [0-9], ',', ';', ':'

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void print(PrintStream out) {
        switch (this) {
            case VAR:
                out.println("VAR");
                break;
            case CHARACTER:
            case DIGIT:
            case VARTYPE:
                out.println(getValue());
                break;
            case COMMA:
                out.println(",");
                break;
            case SEMICOLON:
                out.println(";");
                break;
            case COLON:
                out.println(":");
                break;
            case END:
                out.println("-1");
                break;
        }
    }

}
