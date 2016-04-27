import java.util.*;
import java.io.*;

public class Main {
    private static final int ALPHABET_SIZE = 26;
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int s = in.next().charAt(0) - 'A';
        ArrayList<Integer> next[][] = new ArrayList[ALPHABET_SIZE][ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                next[i][j] = new ArrayList<>();
            }
        }

        // Reading graph
        for (int i = 0; i < n; i++) {
            int from = in.next().charAt(0) - 'A';
            in.next();
            String to = in.next();
            int toC = to.charAt(0) - 'a';
            int toD = (to.length() > 1) ? to.charAt(1) - 'A': -1;
            next[from][toC].add(toD);
        }
        int m = in.nextInt();
        while (m-- > 0) {
            ArrayList<Integer> nextStates = new ArrayList<>();
            ArrayList<Integer> curStates = new ArrayList<>();
            curStates.add(s);
            String request = in.next();
            for (int i = 0; i < request.length(); i++) {
                nextStates = new ArrayList<>();
                for (int from: curStates) {
                    for (int ch: next[from][request.charAt(i) - 'a']) {
                        nextStates.add(ch);
                    }
                }
                curStates = new ArrayList<>();
                for (int state: nextStates) {
                    if (state >= 0) {
                        curStates.add(state);
                    }
                }
            }
            Collections.sort(nextStates);
            if (nextStates.size() > 0 && nextStates.get(0) == -1) {
                out.println("yes");
            } else {
                out.println("no");
            }

        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("automaton.in"));
            out = new PrintWriter(new File("automaton.out"));

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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new Main().run();
    }
}