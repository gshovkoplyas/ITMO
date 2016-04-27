import java.io.*;
import java.util.*;

public class VectorStack {
	public static class Vector {
		public static int[] elements = new int[1];
		public static int size = 0;

		private static void ensureCapacity(int capacity) {
			if (size > capacity && capacity > size / 4)
				return;
			int[] e = new int[2 * capacity + 1];
			for (int i = 0; i < size; i++) {
				e[i] = elements[i];
			}
			elements = e;
		}

		public static void push(int x) {
			ensureCapacity(size + 1);
			elements[size++] = x;
		}

		public static int pop() {
			ensureCapacity(size - 1);
			return elements[--size];
		}
	}

	public static void main(String[] args) throws IOException {
		InputStream stream = new FileInputStream("stack1.in");
		Scanner inf = new Scanner(stream);
		PrintWriter ouf = new PrintWriter(new File("stack1.out"));
		int n = inf.nextInt();
		for (int i = 0; i < n; i++) {
			String s = inf.nextToken();
			if (s.equals("+")) {
				int x = inf.nextInt();
				Vector.push(x);
			} else {
				ouf.println(Vector.pop());
			}
		}
		ouf.close();
	}

	// mega scanner from Zakhar Voit
	static public class Scanner {
		BufferedReader in;
		StringTokenizer tok;

		public Scanner(InputStream in) {
			this.in = new BufferedReader(new InputStreamReader(in));
			tok = new StringTokenizer("");
		}

		public String nextToken() {
			while (!tok.hasMoreTokens()) {
				tok = new StringTokenizer(next());
			}

			return tok.nextToken();
		}

		private String tryReadNextLine() {
			try {
				return in.readLine();
			} catch (IOException e) {
				throw new InputMismatchException();
			}
		}

		public String next() {
			String newLine = tryReadNextLine();
			if (newLine == null)
				throw new InputMismatchException();
			return newLine;
		}

		public int nextInt() {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() {
			return Long.parseLong(nextToken());
		}

		public double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		public boolean EOF() {
			while (!tok.hasMoreTokens()) {
				String newLine = tryReadNextLine();
				if (newLine == null)
					return true;
				tok = new StringTokenizer(newLine);
			}
			return false;
		}

	}
}
