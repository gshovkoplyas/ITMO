public class Variable implements Expression3 {
	private String str;

	public Variable(String str) {
		this.str = str;
	}

	public double evaluate(double x, double y, double z) {
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
