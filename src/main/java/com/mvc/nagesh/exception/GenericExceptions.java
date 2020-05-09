package com.mvc.nagesh.exception;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class GenericExceptions extends SimpleMappingExceptionResolver {

    @Override
	public String buildLogMessage(Exception ex, HttpServletRequest req)
	 {
		System.out.println("Message from Generic excp :" + ex.getLocalizedMessage()); 
    	return "Generic error occured" + ex.getLocalizedMessage();
	 }
}
