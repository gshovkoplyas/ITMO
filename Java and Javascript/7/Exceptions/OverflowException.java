package Exceptions;

public class OverflowException extends EvaluateException {
	public OverflowException(String message) {
		super("overflow: " + message);
	}
}