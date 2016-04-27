public class Add extends BynaryOperation {
	public Add(Expression3 expr1, Expression3 expr2) {
		super(expr1, expr2);
	}
	public double evaluate(double x, double y, double z){
		return first.evaluate(x, y, z) + second.evaluate(x, y, z);
	}
}
