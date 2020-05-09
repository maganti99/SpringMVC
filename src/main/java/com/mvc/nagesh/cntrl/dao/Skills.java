package com.mvc.nagesh.cntrl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public class Skills {

	@ModelAttribute("skills")
	public List<String> getSkills()
	{
		System.out.println("I am in getSkills() method");
		List<String> skillset = new ArrayList<String>();
		skillset.add("Music");
		skillset.add("Tennis");
		skillset.add("Hiking");
		skillset.add("Bowling");
		skillset.add("Cycling");
		return skillset;
	}
}
