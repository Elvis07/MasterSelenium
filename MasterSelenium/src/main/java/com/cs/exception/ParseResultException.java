package com.cs.exception;

@SuppressWarnings("serial")
public class ParseResultException extends Exception {

	// public ParseResultException() {
	// super(ExceptionMessages.UNABLE_PARSE_CONTENT.getMessage());
	// }

	public ParseResultException(Throwable cause) {
		super("Form data are wrong", cause);

	}


	// public ParseResultException(ExceptionMessages msg) {
	// super(msg.getMessage());
	// }
	//
	// public ParseResultException(ExceptionMessages msg, Throwable cause) {
	// super(msg.getMessage(), cause);
	// }

	// public ParseResultException(Throwable cause) {
	// super(ExceptionMessages.UNABLE_PARSE_CONTENT.getMessage(), cause);
	// }

}
