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

        boolean was[] = new boolean[ALPHABET_SIZE];
        Arrays.fill(was, false);
        // Reading graph
        for (int i = 0; i < n; i++) {
            int from = in.next().charAt(0) - 'A';
            was[from] = true;
            in.next();
            String to = in.endOfLine() ? "" : in.next();
            for (int j = 0; j < to.length(); j++) {
                if (Character.isLowerCase(to.charAt(j))) {
                    continue;
                }
                was[to.charAt(j) - 'A'] = true;
            }
            //System.out.println(from + "->" + to);
            next[from].add(to);
        }


        boolean notUseless[] = new boolean[ALPHABET_SIZE];
        Arrays.fill(notUseless, false);
        boolean finish = false;
        while (!finish) {
            finish = true;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (next[i].size() == 0 || notUseless[i]) {
                    continue;
                }
                for (String to: next[i]) {
                    boolean good = true;
                    for (int j = 0; j < to.length() && good; j++) {
                        if (!Character.isLowerCase(to.charAt(j)) && !notUseless[to.charAt(j) - 'A']) {
                            good = false;
                        }
                    }
                    if (good) {
                        notUseless[i] = true;
                        finish = false;
                    }
                }
            }
        }

        boolean used[] = new boolean[ALPHABET_SIZE];
        Arrays.fill(used, false);
        DFS(s, next, notUseless, used);

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if ((!notUseless[i] || !used[i]) && was[i]) {
                out.print(String.format("%c ", i + 'A'));
            }
        }
        out.println();
    }

    private void DFS(int vertex, ArrayList<String>[] next, boolean[] notUseless, boolean[] used) {
        used[vertex] = true;
        for (String to : next[vertex]) {
            boolean go = true;
            for (int i = 0; i < to.length() && go; i++) {
                if (Character.isUpperCase(to.charAt(i)) && !notUseless[to.charAt(i) - 'A']) {
                    go = false;
                }
            }
            if (!go) {
                continue;
            }
            for (int i = 0; i < to.length() && go; i++) {
                if (Character.isUpperCase(to.charAt(i)) && !used[to.charAt(i) - 'A']) {
                    DFS(to.charAt(i) - 'A', next, notUseless, used);
                }
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("useless.in"));
            out = new PrintWriter(new File("useless.out"));

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