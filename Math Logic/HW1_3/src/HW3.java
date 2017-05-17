import Tools.Checker;
import Tools.Deductor;
import Tools.Prover;
import Utils.CheckerOutput;
import Utils.Proof;

import java.io.*;

public class HW3 {
    public static void main(String[] args) throws IOException {
        File folder = new File("tests/3");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            String name = entry.getName();
            if (name.endsWith("in")) {
                System.out.println("Testing: " + name);
                long startTime = System.nanoTime();
                BufferedReader in = new BufferedReader(new FileReader(entry));
                PrintWriter out = new PrintWriter(new File(entry.toString().replace(".in", ".out")));
                String expression = in.readLine();
                Proof output = new Prover().prove(expression);
                if (output.list.get(0).startsWith("Высказывание ложно при")) {
                    System.out.println("Verdict: OK");

                } else {
                    CheckerOutput check = new Checker().check(output);
                    System.out.println("Verdict: " + (check.ok ? "OK" : "Incorrect"));
                }
                out.println(output.toString());
                out.close();
                long finishTime = System.nanoTime();
                System.out.println("Time: " + ((double) (finishTime - startTime) / 1e9) + "sec");
                System.out.println();
            }
        }
    }
}
