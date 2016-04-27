public class Divide extends BinaryOperation {
	public Divide(Expression3 first, Expression3 second) {
		super(first, second);
	}

	public int evaluate(int x, int y, int z) {
		// assert(second.evaluate(x, y, z) == 0);
		return first.evaluate(x, y, z) / second.evaluate(x, y, z);
	}

	public String toString() {
		String firstString = first.toString();
		String secondString = second.toString();
		if (first.priority() <= 1) {
			firstString = "(" + firstString + ")";
		}
		if (second.priority() <= 2) {
			secondString = "(" + secondString + ")";
		}
		return firstString + " / " + secondString;
	}

	public int priority() {
		return super.prior;
	}

	public Expression3 simplify() {
		Expression3 first, second;
		first = this.first.simplify();
		second = this.second.simplify();
		String firstString = first.toString();
		String secondString = second.toString();
		if (firstString.equals(secondString)) {
			super.prior = 4;
			return new Const(1);
		}
		if (firstString.equals(new Const(0).toString())) {
			super.prior = 4;
			return new Const(0);
		}
		if (secondString.equals(new Const(1).toString())) {
			super.prior = first.priority();
			return first;
		}
		if (first.priority() == 4 && second.priority() == 4) {
			super.prior = 4;
			return new Const(first.getValue() / second.getValue());
		}
		super.prior = 2;
		return new Divide(first, second);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
}
