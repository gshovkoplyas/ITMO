import org.StructureGraphic.v1.DSutils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

/**
 * Created by shovkoplyas on 26.04.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        InputStream inputStream = test("var a: integer; b: c12har21;");
        //OutputStream outputStream = System.out;
        try {
            Tree t = (new Parser()).parse(inputStream);
            t.print(new PrintStream("output.txt"));
            DSutils.show(t, 25, 15);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("Position " + e.getErrorOffset());
        }
    }

    private InputStream test(String s) {
        return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    }
}
