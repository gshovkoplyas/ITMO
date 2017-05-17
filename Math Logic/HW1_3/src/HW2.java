import Tools.Checker;
import Tools.Deductor;
import Utils.CheckerOutput;
import Utils.Proof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HW2 {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("tests/2");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            String name = entry.getName();
            if (name.endsWith("in")) {
                System.out.println("Testing: " + name);
                long startTime = System.nanoTime();
                Proof proof = new Proof(entry);
                Proof output = new Deductor().deduce(proof);
                CheckerOutput check = new Checker().check(output);
                System.out.println("Verdict: " + (check.ok ? "OK" : "Incorrect"));
                PrintWriter out = new PrintWriter(new File(entry.toString().replace(".in", ".out")));
                out.println(output.toString());
                out.close();
                long finishTime = System.nanoTime();
                System.out.println("Time: " + ((double) (finishTime - startTime) / 1e9) + "sec");
                System.out.println();
            }
        }
    }
}
