import Exceptions.ParseException;

public class ExpressionParser {
	private static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '!' || c == '#');
	}

	private static boolean isIdent(char c) {
		return (c >= '0' && c <= '9') || (c >= 'x' && c <= 'z');
	}

	private static boolean isDigit(char c) {
		return (c >= '0' && c <= '9');
	}

	private static boolean opLeftAssoc(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}

	private static int opArgumentCount(char c) {
		if (c == '!' || c == '#') {
			return 1;
		}
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return 2;
		}
		return 0;

	}

	private static int opPreced(char c) {
		if (c == '!' || c == '#') {
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

	private static ArrayDeque shuntingYard(String input) throws ParseException {
		ArrayDeque output = new ArrayDeque();
		ArrayDeque stack = new ArrayDeque();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (isIdent(c)) {
				if (isDigit(c)) {
					long cur = c - '0';
					i++;
					while (i < input.length() && isDigit(input.charAt(i))) {
						cur = cur * 10 + (input.charAt(i) - '0');
						i++;
					}
					i--;
					output.addLast(String.valueOf(cur));
				} else {
					output.addLast(String.valueOf(c));
				}
			} else if (isOperator(c)) {
				while (!stack.isEmpty()) {
					char sc = (char) stack.peekLast();
					if (isOperator(sc)
							&& (opLeftAssoc(c) && (opPreced(c) <= opPreced(sc)))
							|| (!opLeftAssoc(c) && (opPreced(c) < opPreced(sc)))) {
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
					throw new ParseException("'(' not found, but ')' exists");
				}
				stack.removeLast();
			} else {
				throw new ParseException("unknown token '" + c + "'");
			}
		}
		while (!stack.isEmpty()) {
			char sc = (char) stack.removeLast();
			if (sc == '(' || sc == ')') {
				throw new ParseException("bad brackets balance");
			}
			output.addLast(String.valueOf(sc));
		}
		return output;
	}

	private static Expression3 execute(ArrayDeque input) throws ParseException {
		ArrayDeque stack = new ArrayDeque();
		while (!input.isEmpty()) {
			String str = (String) input.removeFirst();
			char c = str.charAt(0);
			if (isIdent(c)) {
				if (c == 'x' || c == 'y' || c == 'z') {
					stack.addLast(new Variable(String.valueOf(c)));
				} else {
					stack.addLast(new Const((int) Long.parseLong(str)));
				}
			} else if (isOperator(c)) {
				int nargs = opArgumentCount(c);
				if (stack.size() < nargs) {
					throw new ParseException("not enough arguments for '" + c
							+ "'");
				}
				if (c == '#') {
					Expression3 once = (Expression3) stack.removeLast();
					stack.addLast(new Log(once));
				} else if (c == '!') {
					Expression3 once = (Expression3) stack.removeLast();
					stack.addLast(new Minus(once));
				} else if (c == '+') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					stack.addLast(new Add(first, second));
				} else if (c == '-') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					stack.addLast(new Subtract(first, second));
				} else if (c == '*') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					stack.addLast(new Multiply(first, second));
				} else if (c == '/') {
					Expression3 second = (Expression3) stack.removeLast();
					Expression3 first = (Expression3) stack.removeLast();
					stack.addLast(new Divide(first, second));
				}

			}
		}
		assert (stack.size() == 1);
		return (Expression3) stack.removeLast();
	}

	private static String doGood(String expression) {
		char[] arrexpr = expression.toCharArray();
		int whitespaces = 0;
		int loges = 0;
		for (int i = 0; i < arrexpr.length; i++) {
			if (Character.isWhitespace(arrexpr[i])) {
				whitespaces++;
			}
			if (arrexpr[i] == 'l') {
				loges++;
			}
		}
		char[] newexpr = new char[arrexpr.length - whitespaces - 2 * loges];
		int j = 0;
		for (int i = 0; i < arrexpr.length; i++) {
			if (!Character.isWhitespace(arrexpr[i])) {
				if (arrexpr[i] != 'l') {
					newexpr[j++] = arrexpr[i];
				} else {
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
					&& (isOperator(newexpr[i - 1]) || newexpr[i - 1] == '(')) {
				newexpr[i] = '!';
			}
		}
		return String.valueOf(newexpr);
	}

	public static Expression3 parse(String expression) throws ParseException {
		return execute(shuntingYard(doGood(expression)));
	}

}
