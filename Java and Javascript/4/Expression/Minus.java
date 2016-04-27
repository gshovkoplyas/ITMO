public class Minus implements Expression3 {
	private Expression3 once;

	public Minus(Expression3 once) {
		this.once = once;
	}

	public double evaluate(double x, double y, double z) {
		return -once.evaluate(x, y, z);
	}

}
