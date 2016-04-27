public class Minus implements Expression3 {
	private Expression3 once;

	public Minus(Expression3 once) {
		this.once = once;
	}

	public int evaluate(int x, int y, int z) {
		return -once.evaluate(x, y, z);
	}

}
