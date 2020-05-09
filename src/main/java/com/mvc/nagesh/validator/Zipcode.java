package com.mvc.nagesh.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = ZipValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Zipcode {
	
	 String message() default "Invalid Zip";
     
	    Class<?>[] groups() default {};
	     
	    Class<? extends Payload>[] payload() default {};

}
