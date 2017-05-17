import Tools.KripkeChecker;
import Utils.Model;

import java.io.*;

public class HW5 {
    public static void main(String[] args) throws IOException {
        File folder = new File("tests");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            String name = entry.getName();
            if (name.endsWith("in")) {
                System.out.println("Testing: " + name);
                long startTime = System.nanoTime();
                BufferedReader in = new BufferedReader(new FileReader(entry));
                PrintWriter out = new PrintWriter(new File(entry.toString().replace(".in", ".out")));
                String expression = in.readLine();
                Model ans = new KripkeChecker().contraModel(expression);
                System.out.println("Verdict: " + ((ans == null) ? "Формула общезначима" : "Есть контрмодель"));
                out.println((ans == null) ? "Формула общезначима" : ans.toString());
                out.close();
                long finishTime = System.nanoTime();
                System.out.println("Time: " + ((double) (finishTime - startTime) / 1e9) + "sec");
                System.out.println();
            }
        }
    }
}
