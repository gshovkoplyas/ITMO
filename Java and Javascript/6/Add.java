public class Add extends BinaryOperation {
	public Add(Expression3 first, Expression3 second) {
		super(first, second);
	}

	public int evaluate(int x, int y, int z) {
		return first.evaluate(x, y, z) + second.evaluate(x, y, z);
	}

	public String toString() {
		return first.toString() + " + " + second.toString();
	}

	public int priority() {
		return 1;
	}

	public Expression3 simplify() {
		Expression3 first, second;
		first = this.first.simplify();
		second = this.second.simplify();
		String firstString = first.toString();
		String secondString = second.toString();
		if (firstString.equals(new Const(0).toString())) {
			super.prior = second.priority();
			return second;
		}
		if (secondString.equals(new Const(0).toString())) {
			super.prior = first.priority();
			return first;
		}
		if (first.priority() == 4 && second.priority() == 4) {
			super.prior = 4;
			return new Const(first.getValue() + second.getValue());
		}
		super.prior = 2;
		return new Add(first, second);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
