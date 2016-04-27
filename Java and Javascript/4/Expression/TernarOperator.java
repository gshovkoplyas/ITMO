public class TernarOperator implements Expression3 {
	private Expression3 first, second, third;

	public TernarOperator(Expression3 expr1, Expression3 expr2, Expression3 expr3) {
		first = expr1;
		second = expr2;
		third = expr3;
	}

	public double evaluate(double x, double y, double z) {
		if (first.evaluate(x, y, z) == 0) {
			return second.evaluate(x, y, z);
		}
		return third.evaluate(x, y, z);
	}

}
