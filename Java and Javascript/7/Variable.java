public class Variable implements Expression3 {
	private String str;

	public Variable(String str) {
		this.str = str;
	}

	public int evaluate(int x, int y, int z) {
		assert (str.equals("x") || str.equals("y") || str.equals("z"));
		if (str.equals("x")) {
			return x;
		}
		if (str.equals("y")) {
			return y;
		}
		return z;

	}
}
