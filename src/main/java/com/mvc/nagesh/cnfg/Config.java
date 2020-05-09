package com.mvc.nagesh.cnfg;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//import javax.sql.DataSource;

@Configuration
@ComponentScan(value={"com.mvc.nagesh.cntrl.dao"})
public class Config {
	
	@Bean(name="myskills")
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
