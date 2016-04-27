import Exceptions.EvaluateException;
import Exceptions.ParseException;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(ExpressionParser.parse(args[0]).evaluate(i, 0, 0));
			} catch (EvaluateException exception) {
				System.out.println(exception.getMessage());
			} catch (ParseException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
