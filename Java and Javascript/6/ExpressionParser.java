public class ExpressionParser {
	private static boolean is_operator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '!'
				|| c == '#' || c == '~');
	}

	private static boolean is_ident(char c) {
		return (c >= '0' && c <= '9') || (c >= 'x' && c <= 'z');
	}

	private static boolean is_digit(char c) {
		return (c >= '0' && c <= '9');
	}

	private static boolean op_left_assoc(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}

	private static int op_argument_count(char c) {
		if (c == '!' || c == '#' || c == '~') {
			return 1;
		}
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return 2;
		}
		return 0;

	}

	private static int op_preced(char c) {
		if (c == '!' || c == '#' || c == '~') {
			return 3;
		}
		if (c == '*' || c == '/') {
			return 2;
		}
		if (c == '+' || c == '-') {
			return 1;
		}
		return 0;
	}

	private static ArrayDeque shunting_yard(String input) {
		ArrayDeque output = new ArrayDeque();
		ArrayDeque stack = new ArrayDeque();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// if (!Character.isWhitespace(c)) {
			// System.out.println(i);
			if (is_ident(c)) {
				if (is_digit(c)) {
					long cur = c - '0';
					i++;
					while (i < input.length() && is_digit(input.charAt(i))) {
						cur = cur * 10 + (input.charAt(i) - '0');
						i++;
					}
					i--;
					output.addLast(String.valueOf(cur));
				} else {
					output.addLast(String.valueOf(c));
				}
			} else if (is_operator(c)) {
				while (!stack.isEmpty()) {
					char sc = (char) stack.peekLast();
					if (is_operator(sc)
							&& (op_left_assoc(c) && (op_preced(c) <= op_preced(sc)))
							|| (!op_left_assoc(c) && (op_preced(c) < op_preced(sc)))) {
						output.addLast(String.valueOf(sc));
						stack.removeLast();
					} else {
						break;
					}
				}
				stack.addLast(c);
			} else if (c == '(') {
				stack.addLast(c);
			} else if (c == ')') {
				boolean pe = true;
				while (!stack.isEmpty()) {
					char sc = (char) stack.peekLast();
					if (sc == '(') {
						pe = false;
						break;
					} else {
						output.addLast(String.valueOf(sc));
						stack.removeLast();
					}
				}
				if (pe) {
					System.out.println("PE: '(' not found");
					assert (false);
				}
				stack.removeLast();
			} else {
				System.out.println("PE: unknown token");
				assert (false);
			}
			// }
		}
		while (!stack.isEmpty()) {
			char sc = (char) stack.removeLast();
			if (sc == '(' || sc == ')') {
				System.out.println("PE: bad brackets");
				assert (false);
			}
			output.addLast(String.valueOf(sc));
		}
		return output;
	}

	private static Expression3 execute(ArrayDeque input) {
		ArrayDeque stack = new ArrayDeque();
		while (!input.isEmpty()) {
			String str = (String) input.removeFirst();
			// System.out.println(str);
			char c = str.charAt(0);
			if (is_ident(c)) {
				if (c == 'x' || c == 'y' || c == 'z') {
					stack.addLast(new Variable(String.valueOf(c)));
				} else {
					stack.addLast(new Const((int) Long.parseLong(str)));
				}
			} else if (is_operator(c)) {
				int nargs = op_argument_count(c);
				if (stack.size() < nargs) {
					System.out.println("Error: not enough arguments");
					assert (false);
				}
				/*if (c == '#') {
					Expression3 once = (Expression3) stack.removeLast();
					// System.out.println("once = " + once.evaluate(1, 1, 1));
					stack.addLast(new Abs(once));
				} else if (c == '~') {
					Expression3 once = (Expression3) stack.removeLast();
					// System.out.println("once = " + once.evaluate(1, 1, 1));
					stack.addLast(new Not(once));
				} else if (c == '!') {
					Expression3 once = (Expression3) stack.removeLast();
					// System.out.println("once = " + once.evaluate(1, 1, 1));
					stack.addLast(new Minus(once));
				} else */
				if (c == '+') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					// System.out.print("first = " + first.evaluate(1, 1, 1));
					// System.out.println(" second = " + second.evaluate(1, 1,
					// 1));
					stack.addLast(new Add(first, second));
				} else if (c == '-') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					// System.out.print("first = " + first.evaluate(1, 1, 1));
					// System.out.println(" second = " + second.evaluate(1, 1,
					// 1));
					stack.addLast(new Subtract(first, second));
				} else if (c == '*') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					// System.out.print("first = " + first.evaluate(1, 1, 1));
					// System.out.println(" second = " + second.evaluate(1, 1,
					// 1));
					stack.addLast(new Multiply(first, second));
				} else if (c == '/') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					// System.out.print("first = " + first.evaluate(3, 1, 1));
					// System.out.println(" second = " + second.evaluate(3, 1,
					// 1));
					stack.addLast(new Divide(first, second));
				}

			}
		}
		// System.out.println("Stack.size == " + stack.size());
		assert (stack.size() == 1);
		return (Expression3) stack.removeLast();
	}

	private static String do_good(String expression) {
		char[] arrexpr = expression.toCharArray();
		int whitespaces = 0;
		int abses = 0;
		for (int i = 0; i < arrexpr.length; i++) {
			if (Character.isWhitespace(arrexpr[i])) {
				whitespaces++;
			}
			if (arrexpr[i] == 'a') {
				abses++;
			}
		}
		char[] newexpr = new char[arrexpr.length - whitespaces - 2 * abses];
		int j = 0;
		for (int i = 0; i < arrexpr.length; i++) {
			if (!Character.isWhitespace(arrexpr[i])) {
				if (arrexpr[i] != 'a') {
					newexpr[j++] = arrexpr[i];
				}else{
					newexpr[j++] = '#';
					i += 2;
				}
			}
		}
		if (newexpr[0] == '-') {
			newexpr[0] = '!';
		}
		for (int i = 1; i < newexpr.length; i++) {
			if (newexpr[i] == '-'
					&& (is_operator(newexpr[i - 1]) || newexpr[i - 1] == '(')) {
				newexpr[i] = '!';
			}
		}
		return String.valueOf(newexpr);
	}

	public static Expression3 parse(String expression) {

		/*
		 * ArrayDeque a = shunting_yard(do_good(expression));
		 * System.out.println("Deque size == " + a.size());
		 * 
		 * for (int i = 0; i < a.size(); i++) { String q =
		 * String.valueOf(a.removeFirst()); System.out.println(q); a.addLast(q);
		 * }
		 */

		//System.out.println(do_good(expression));
		return execute(shunting_yard(do_good(expression)));
	}

	/*public static void main(String[] args) { //
		System.out.println("ANSWER = " + parse("abs(~y)").evaluate(0, 0, 0));
	}*/

}
