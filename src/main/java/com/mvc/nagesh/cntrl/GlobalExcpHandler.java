package com.mvc.nagesh.cntrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
//import com.mvc.nagesh.exception.InvalidPersonExcpetion;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExcpHandler {
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLExcpetion(HttpServletRequest re, Exception ex)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("except", ex);
		modelAndView.addObject("url", re.getRequestURL());
		modelAndView.addObject("message", "SQL Exception occured");
		modelAndView.setViewName("error");
		return modelAndView;
		
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="I/O Exception occured")
	public void handleIOExcpetion(HttpServletRequest re, Exception ex)
	{
		System.out.println("I/O Excpetion handler executed");
		
	}
	

}
