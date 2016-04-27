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

	public String toString() {
		return str;
	}

	public int priority() {
		return 3;
	}
	
	public Expression3 simplify() {
		return new Variable(str);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
