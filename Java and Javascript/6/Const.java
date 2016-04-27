public class Const implements Expression3 {
	private int value;

	public Const(int value) {
		this.value = value;
	}

	public int evaluate(int x, int y, int z) {
		return value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public int priority() {
		return 4;
	}

	public Expression3 simplify() {
		return new Const(value);
	}
	
	public int getValue() {
		return value;
	}
}
