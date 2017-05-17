import Tools.Checker;
import Utils.CheckerOutput;
import Utils.Proof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HW1 {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("tests/1");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            String name = entry.getName();
            if (name.endsWith("in")) {
                System.out.println("Testing: " + name);
                long startTime = System.nanoTime();
                Proof proof = new Proof(entry);
                CheckerOutput output = new Checker().check(proof);
                System.out.println("Verdict: " + (output.ok ? "OK" : "Incorrect"));
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
