public interface Expression3 {
	int evaluate(int x, int y, int z);
	String toString();
	int priority();
	Expression3 simplify();
	int getValue();
}
