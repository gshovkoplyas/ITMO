package Exceptions;

public class ParseException extends Exception {
	final private String message;

	public ParseException(String message) {
		this.message = "wrong expression: " + message;
	}
	
	public String getMessage() {
		return message;
	}
}
