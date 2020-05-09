package com.mvc.nagesh.exception;

public class ExceptionJSON {
	
	String URL;
	String message;
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExceptionJSON(String uRL, String message) {
		super();
		URL = uRL;
		this.message = message;
	}
	
	

}
