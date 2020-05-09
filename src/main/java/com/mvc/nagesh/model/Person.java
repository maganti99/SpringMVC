package com.mvc.nagesh.model;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.mvc.nagesh.validator.Zipcode;;

public class Person {
	
	@NotEmpty(message="${error.FirstName}")
	private String FirstName;
	@Size(min=2,max=5)
	@NotEmpty
	private String	LastName;
	@NotEmpty
	@Email
	private String  Email;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull
	private Date   DOB;
	@NotNull(message= "{error.skills}")
	private List<String> pesonskills;
	
	@Zipcode
	private String zipcode;
	
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public List<String> getPesonskills() {
		return pesonskills;
	}
	public void setPesonskills(List<String> pesonskills) {
		this.pesonskills = pesonskills;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

	@Override
	public String toString() {
		return "Person [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", DOB=" + DOB
				+ ", pesonskills=" + pesonskills + "]";
	}
	
}
