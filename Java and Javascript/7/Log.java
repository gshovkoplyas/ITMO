import Exceptions.EvaluateException;
import Exceptions.NPLogException;

public class Log extends UnaryExpression {
	public Log(Expression3 once) {
		super(once);
	}

	public int evaluate(int x, int y, int z) throws EvaluateException {
		int operand;
		operand = once.evaluate(x, y, z);
		if (operand <= 0) {
			throw new NPLogException();
		}
		return Integer.bitCount(Integer.highestOneBit(operand) - 1);
	}

}
