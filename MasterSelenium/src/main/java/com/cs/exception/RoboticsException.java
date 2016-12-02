package com.cs.exception;


public class RoboticsException extends RuntimeException
{
	public static final String TYPE_UNKNOWN = "UNKNOWN";
	public static final String TYPE_NO_RESULT = "NO_RESULT";
	public static final String TYPE_PARTIAL = "PARTIAL";
	public static final String TYPE_CRACK_FAILED = "CRACK_FAILED";
	public static final String TYPE_BLOCKED = "BLOCKED";
	public static final String TYPE_MIXED_EMPTY = "MIXED_EMPTY";
	public static final String TYPE_UNEXPECTED_INPUT = "UNEXPECTED_INPUT";
	public static final String TYPE_UNEXPECTED_RESPONSE = "UNEXPECTED_RESPONSE";
	public static final String TYPE_PARSE_FAIL = "PARSE_FAIL";
	public static final String TYPE_NETWORK_EXCEPTION = "NETWORK_EXCEPTION";
	public static final String TYPE_LOGIN_FAIL = "LOGIN_FAIL";
	
	
	public String type;
	
	public RoboticsException(String type, String msg, Throwable cause)
	{
		super(msg, cause);
		this.type = type;
	}
}
