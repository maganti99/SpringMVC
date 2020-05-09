package com.mvc.nagesh.cntrl;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.nagesh.cnfg.Config;
import com.mvc.nagesh.model.Person;
import com.mvc.nagesh.exception.ExceptionJSON;
import com.mvc.nagesh.exception.InvalidPersonExcpetion;;

@Controller
public class HomeController {
	
	private Validator validator;
	
	public HomeController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	
	@ModelAttribute("skills")
	public List<String> getSkills()
	{
		List<String> skillset = new ArrayList<String>();
		skillset.add("Music");
		skillset.add("Tennis");
		skillset.add("Hiking");
		skillset.add("Bowling");
		return skillset;
	}
	
	/*@InitBinder
	public void initBnd(WebDataBinder webBinder)
	{
		System.out.println("InitBinder");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		webBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true, 10));
	}
*/	
	
	//Test
	//@RequestMapping("/")
	public String Test(Model model) {
		
		System.out.println("--- Model before data ---");
		Map modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}
		
		System.out.println("In test method");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name2", "Tennis");
		map.put("name3", "Soccer");
		
		model.addAttribute("name", "Nagesh");
	    model.mergeAttributes(map);
	    
	    System.out.println("--- Model after data ---");
		Map modelMap1 = model.asMap();
		for (Object modelKey : modelMap1.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}
        return "Test";
	} 
	 
	//End Test
	
	@RequestMapping("/")
	public String Add(Model model) {
		System.out.println("Request from servlet");
		
		
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		List<String> skills = (ArrayList<String>)context.getBean("myskills");*/
		
		Person person1 = new Person();
		person1.setFirstName("Nagesh");
		model.addAttribute("person3", person1);
		
        return "home";
	}
	
	/*@RequestMapping(value="/put", method=RequestMethod.POST)
	public ModelAndView response(@RequestParam("name") String studentName, @RequestParam("Hobby") String studentHobby) {
		System.out.println("Request from servlet1");
		ModelAndView model = new ModelAndView("response");
		model.addObject("msg", "Name :" + studentName + "Hobby :" + studentHobby );
        return  model;
	}*/
	
	@RequestMapping(value="/persondetails", method=RequestMethod.POST)
	public String response(@Valid @ModelAttribute("person3")Person person3, BindingResult binres, Model model) throws Exception{
	//public String response(Model model) {
		
		System.out.println("--- Model before data ---");
		Map modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -**- " + modelValue);
		}
		
		System.out.println("Request from servlet2");
		System.out.println("Person :" + person3.getFirstName());
		//model.addAttribute("person3", person);
		
		
		/*Set<ConstraintViolation<Person>> violations =  validator.validate(person);
		
		for(ConstraintViolation<Person> violation : violations)
		{
			String propertypath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			System.out.println(propertypath + " " + message);
			binres.addError(new FieldError("person", propertypath, "Invalid "+ propertypath + "(" + message + ")"));
		}*/
		
		//Forced exception
		//int j = 12/0;
		
		if (person3.getLastName().startsWith("X"))
		{
			throw new InvalidPersonExcpetion(person3.getLastName());
		}
		else if (person3.getLastName().startsWith("$"))
				{
			         throw new SQLException(person3.getLastName());
				}
		else if (person3.getLastName().startsWith("&"))
		{
	         throw new IOException(person3.getLastName());
		}
		else if (person3.getLastName().startsWith("#"))
		{
			
			throw new Exception("Unkown error");
		}
		
		
		if (binres.hasErrors())
		{
			System.out.println("hasErrors");
			return "home";
			
			//return new ModelAndView("home");
		}
		else
			return "response";
		
		
		/*ModelAndView model1 = new ModelAndView("response");
		model1.addObject("msg", " Name :" + person1.getFirstName() + " Email :" + person1.getEmail() );
        return  model1;*/
		//return "response";
	}
	
	
	/*@ExceptionHandler(InvalidPersonExcpetion.class)
	public ModelAndView handleEmployeeNameExcpetion(HttpServletRequest re, Exception ex)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("except", ex);
		modelAndView.addObject("url", re.getRequestURL());
		modelAndView.addObject("message", "Invalid person name Exception occured");
		modelAndView.setViewName("error");
		return modelAndView;
		
	}*/
	
	@ExceptionHandler(InvalidPersonExcpetion.class)
	public @ResponseBody ExceptionJSON handleEmployeeNameExcpetion(HttpServletRequest re, Exception ex)
	{
		ExceptionJSON exceptionJson = new ExceptionJSON(re.getRequestURI(), ex.getMessage());
		
		return exceptionJson;
		
	}
	
	
	

}
