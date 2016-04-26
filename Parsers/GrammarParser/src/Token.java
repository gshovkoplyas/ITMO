import org.omg.CORBA.portable.OutputStream;

import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * Created by shovkoplyas on 18.04.2016.
 */
public enum Token {
    VAR, CHARACTER, DIGIT, COMMA, SEMICOLON, COLON, END;
    //var, [a-z|A-Z], [0-9], ',', ';', ':'

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void print(PrintStream out) {
        switch (this) {
            case VAR:
                out.println("VAR");
                break;
            case CHARACTER:
                out.println(String.valueOf((char)getValue()));
                break;
            case DIGIT:
                out.println(String.valueOf((char)getValue()));
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
