package com.mvc.nagesh.exception;

public class InvalidPersonExcpetion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3332292346834265371L;
	
	public InvalidPersonExcpetion(String name)
	{
		super("Person name starting with X --unknown origin : " + name);
	}
	
	

}
