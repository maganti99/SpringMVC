package com.mvc.nagesh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipValidator implements ConstraintValidator<Zipcode, String> {

	public void initialize(Zipcode zip) {
		// TODO Auto-generated method stub		
	}

	public boolean isValid(String zip, ConstraintValidatorContext ctx) {
		// Validate Zipcode using regex
		
		if (zip.matches("^[0-9]{5}(?:-[0-9]{4})?$"))
			return true;
		else
			return false;
	}

}
