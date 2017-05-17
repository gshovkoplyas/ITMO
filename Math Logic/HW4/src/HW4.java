import Tools.Checker;
import Tools.Deductor;
import Utils.CheckerOutput;
import Utils.Proof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HW4 {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("tests");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            String name = entry.getName();
            if (name.endsWith("in")) {
                System.out.println("Testing: " + name);
                long startTime = System.nanoTime();
                Proof proof = new Proof(entry);
                CheckerOutput check = new Checker().check(proof, true);
                System.out.println("Verdict: " + (check.ok ? "OK" : "Incorrect"));
                PrintWriter out = new PrintWriter(new File(entry.toString().replace(".in", ".out")));
                if (check.ok) {
                    out.println(new Deductor().deduce(proof).toString());
                }   else {
                    out.println(check.findError());
                }
                out.close();
                long finishTime = System.nanoTime();
                System.out.println("Time: " + ((double) (finishTime - startTime) / 1e9) + "sec");
                System.out.println();
            }
        }
    }
}
