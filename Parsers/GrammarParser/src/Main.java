import org.StructureGraphic.v1.DSutils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shovkoplyas on 26.04.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintStream log = new PrintStream(new File("log.txt"));
        int cnt = 0;
        while (in.hasNextLine()) {
            log.print((++cnt) + ": ");
            String request = in.nextLine();
            log.println("\"" + request + "\"");
            InputStream inputStream = test(request);
            // test("var a: integer; b: c12har21;");
            //OutputStream outputStream = System.out;
            try {
                Tree t = (new Parser()).parse(inputStream);
                t.print(new PrintStream("output.txt"));
                DSutils.show(t, 25, 15);
                log.println("Succesful");
            } catch (ParseException e) {
                //e.printStackTrace();
                //System.err.println("Position " + e.getErrorOffset());
                log.println("Exception: " + e.getMessage() + " " + (e.getErrorOffset() - 1));
            }
        }
    }

    private InputStream test(String s) {
        return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    }

    private void lexicalAnalyzerPrint(InputStream inputStream) throws ParseException {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(inputStream);
        lexicalAnalyzer.nextToken();
        while (lexicalAnalyzer.curToken() != Token.END) {
            lexicalAnalyzer.curToken().print(System.out);
            lexicalAnalyzer.nextToken();
        }
    }
}
