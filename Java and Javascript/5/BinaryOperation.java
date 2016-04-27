public abstract class BinaryOperation implements Expression3 {
	protected Expression3 first, second;

	public BinaryOperation(Expression3 first, Expression3 second) {
		this.first = first;
		this.second = second;
	}

	public abstract int evaluate(int x, int y, int z);

}
