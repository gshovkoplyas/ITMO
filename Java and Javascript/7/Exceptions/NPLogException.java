package Exceptions;

public class NPLogException extends EvaluateException {
	public NPLogException() {
		super("non positive log");
	}
}