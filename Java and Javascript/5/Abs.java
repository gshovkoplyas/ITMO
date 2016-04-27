public class Abs implements Expression3 {
	private Expression3 once;

	public Abs(Expression3 once) {
		this.once = once;
	}

	private static int abs(int n) {
		if (n < 0) {
			return -n;
		}
		return n;
	}

	public int evaluate(int x, int y, int z) {
		return abs(once.evaluate(x, y, z));
	}

}
