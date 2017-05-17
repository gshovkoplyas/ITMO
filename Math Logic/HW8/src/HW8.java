import Tools.Calculator;

import java.io.*;

public class HW8 {
    public static void main(String[] args) throws IOException {
        File folder = new File("tests");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            String name = entry.getName();
            if (name.endsWith("in")) {
                System.out.println("Testing: " + name);
                long startTime = System.nanoTime();
                BufferedReader in = new BufferedReader(new FileReader(entry));
                String input = in.readLine();
                String output = new Calculator().calculate(input);
                System.out.println("Verdict: " + output);
                PrintWriter out = new PrintWriter(new File(entry.toString().replace(".in", ".out")));
                out.println(output);
                out.close();
                long finishTime = System.nanoTime();
                System.out.println("Time: " + ((double) (finishTime - startTime) / 1e9) + "sec");
                System.out.println();
            }
        }
    }
}
