public class Not implements Expression3 {
	private Expression3 once;

	public Not(Expression3 once) {
		this.once = once;
	}

	public int evaluate(int x, int y, int z) {
		return ~once.evaluate(x, y, z);
	}

}
