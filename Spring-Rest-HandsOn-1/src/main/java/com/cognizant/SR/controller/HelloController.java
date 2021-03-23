package com.cognizant.SR.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SR.Country;
import com.cognizant.SR.exception.CountryNotFoundException;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public  String sayHello() {
		return "Hello World!!";
		
	}
	
	@GetMapping("/country/{id}")
	public  Country getCountrybyId(@PathVariable String id)throws CountryNotFoundException {

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countrylist=context.getBean("countryList", ArrayList.class);
		Country country=new Country();
		Iterator<Country> itr = countrylist.iterator();
		while(itr.hasNext()) {
			
			 country = (Country)itr.next();
			
			if(country.getCode().equals(id)) {
				
				break;
			}
		
			country = null;
		
		}
		
		if (country == null) {
			
			throw new CountryNotFoundException(id);
		}
		return country;
		

	}
	
}
