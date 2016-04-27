//Binary search
public class BinarySearch {
	// Pre: x <- args[0], a = args[1..args.length]
	// Post: print answer
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int[] a = new int[args.length - 1];
		for (int i = 0; i < args.length - 1; i++) {
			a[i] = Integer.parseInt(args[i + 1]);
		}
		// a[] is sorted, a[-1] <- -INF, a[a.length] <- +INF
		int indx, indy;
		indx = iterative(a, x);
		// y <- x + 1, indx = min{i | a[i] >= x}
		if (x == Integer.MAX_VALUE) {
			// a[] is sorted, a[-1] <- -INF, a[a.length] <- +INF
			indy = a.length;
			// indy = min{i | a[i] > x}
		} else {
			// a[] is sorted, a[-1] <- -INF, a[a.length] <- +INF
			indy = recursive(a, x + 1);
			// indy = min{i | a[i] > x}
		}
		// indy = min{i | a[i] > x}
		// => for all i: indx <= x < indy
		// a[i] == x
		System.out.println(indx + " " + (indy - indx));
	}

	// Pre: a[] is sorted, a[-1] <- -INF, a[a.length] <- +INF
	// Post: result = min{i | a[i] >= x}, result in [0; a.length]
	public static int iterative(int[] a, int x) {
		int l = -1, r = a.length;
		// a[l] < x < a[r]
		// invariant: result in (l; r]
		while (r > l + 1) {
			int m = (l + r) / 2;
			if (x <= a[m]) {
				// for all i: i >= m
				// a[i] >= x
				// => result in (l; m]
				r = m;
			} else {
				// for all i: i < m
				// a[i] < x
				// => result in (m; r]
				l = m;
			}
			// result in (l; r]
		}
		// result in (r - 1; r]
		// => a[r - 1] < x <= a[r]
		// => r = min{i | a[i] >= x}, r in [0; a.length]
		// => r = result
		return r;
	}

	// Pre: a[] is sorted, a[-1] <- -INF, a[a.length] <- +INF
	// Post: result = min{i | a[i] >= x}, result in [0; a.length]
	public static int recursive(int a[], int x) {
		// a[l] < x < a[r]
		// invariant: result in (l; r]
		return recursive(a, x, -1, a.length);
	}

	// Pre: a[] is sorted, result in (l; r] (-1 <= l < r <= a.length)
	// Post: result = min{i | a[i] >= x}, result in [0; a.length]
	public static int recursive(int a[], int x, int l, int r) {
		if (r == l + 1) {
			// result in (r - 1; r]
			// => a[r - 1] < x <= a[r]
			// => r = min{i | a[i] >= x}, r in [0; a.length]
			// => r = result
			return r;
		}
		int m = (l + r) / 2;
		if (x <= a[m]) {
			// for all i: i >= m
			// a[i] >= x
			// => result in (l; m]
			return recursive(a, x, l, m);
		} else {
			// for all i: i < m
			// a[i] < x
			// => result in (m; r]
			return recursive(a, x, m, r);
		}
	}

}
