package com.mvc.nagesh.cntrl;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondController {
	
	@RequestMapping("/{username}")
	public ModelAndView Add(@PathVariable("username") String name) {
		ModelAndView model = new ModelAndView("response");
		model.addObject("msg", "Name :" + name);
        return  model;
        
	}

}
