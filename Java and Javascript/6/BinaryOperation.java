public abstract class BinaryOperation implements Expression3 {
	protected Expression3 first, second;
	protected int prior;

	public BinaryOperation(Expression3 first, Expression3 second) {
		this.first = first;
		this.second = second;
	}

	public abstract int evaluate(int x, int y, int z);
	public abstract String toString();
	public abstract int priority();
	public abstract Expression3 simplify();
}
