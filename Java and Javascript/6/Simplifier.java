public class Simplifier {
	public static void main(String[] args) {
		System.out.println(ExpressionParser.parse(args[0]).simplify().toString());
	}
}
