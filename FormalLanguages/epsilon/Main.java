import java.util.*;
import java.io.*;

public class Main {
    private static final int ALPHABET_SIZE = 26;
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int s = in.next().charAt(0) - 'A';
        ArrayList<String> next[] = new ArrayList[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
                next[i] = new ArrayList<>();
        }

        // Reading graph
        for (int i = 0; i < n; i++) {
            int from = in.next().charAt(0) - 'A';
            in.next();
            String to = in.endOfLine() ? "" : in.next();
            //System.out.println(from + "->" + to);
            next[from].add(to);
        }

        boolean isEps[] = new boolean[ALPHABET_SIZE];
        Arrays.fill(isEps, false);
        boolean finish = false;
        while (!finish) {
            finish = true;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (next[i].size() == 0 || isEps[i]) {
                    continue;
                }
                for (String to: next[i]) {
                    boolean epsilon = true;
                    for (int j = 0; j < to.length() && epsilon; j++) {
                        if (Character.isLowerCase(to.charAt(j)) || !isEps[to.charAt(j) - 'A']) {
                            epsilon = false;
                        }
                    }
                    if (epsilon) {
                        isEps[i] = true;
                        finish = false;
                    }
                }
            }
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (isEps[i]) {
                out.print(String.format("%c ", i + 'A'));
            }
        }
        out.println();
    }

    public void run() {
        try {
            in = new FastScanner(new File("epsilon.in"));
            out = new PrintWriter(new File("epsilon.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        boolean endOfLine() {
            return !st.hasMoreTokens();
        }



        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new Main().run();
    }
}