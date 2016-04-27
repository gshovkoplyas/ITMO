import Exceptions.EvaluateException;

public abstract class UnaryExpression implements Expression3 {
	protected Expression3 once;

	public UnaryExpression(Expression3 once) {
		this.once = once;
	}

	public abstract int evaluate(int x, int y, int z) throws EvaluateException;
}
