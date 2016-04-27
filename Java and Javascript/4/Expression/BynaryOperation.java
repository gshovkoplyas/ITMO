public abstract class BynaryOperation implements Expression3 {
	protected Expression3 first, second;

	public BynaryOperation(Expression3 first, Expression3 second) {
		this.first = first;
		this.second = second;
	}

	public abstract double evaluate(double x, double y, double z);

}
