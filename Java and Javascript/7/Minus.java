import Exceptions.EvaluateException;
import Exceptions.OverflowException;

public class Minus extends UnaryExpression {
	public Minus(Expression3 once) {
		super(once);
	}

	public int evaluate(int x, int y, int z) throws EvaluateException {
		int operand;
		operand = once.evaluate(x, y, z);
		if (-((long) operand) > Integer.MAX_VALUE
				|| -((long) operand) < Integer.MIN_VALUE) {
			throw new OverflowException(String.valueOf((long) operand));
		}
		return -operand;
	}

}
