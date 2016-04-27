import Exceptions.DBZException;
import Exceptions.EvaluateException;
import Exceptions.OverflowException;

public class Divide extends BinaryOperation {
	public Divide(Expression3 first, Expression3 second) {
		super(first, second);
	}

	public int evaluate(int x, int y, int z) throws EvaluateException {
		int operand1, operand2;
		operand1 = first.evaluate(x, y, z);
		operand2 = second.evaluate(x, y, z);
		if (operand2 == 0) {
			throw new DBZException();
		}
		if ((long) operand1 / operand2 > Integer.MAX_VALUE
				|| (long) operand1 / operand2 < Integer.MIN_VALUE) {
			throw new OverflowException(String.valueOf((long) operand1
					/ operand2));
		}
		return operand1 / operand2;
	}
}
