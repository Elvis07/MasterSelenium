package com.cs.exception;

@SuppressWarnings("serial")
public class TestFailException extends Exception {


	public TestFailException(String msg,Throwable cause) {
		super(msg,cause);
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
