package com.cognizant.SR.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.SR.Country;
import com.cognizant.SR.SpringRestHandsOn1Application;

@Controller
public class CountryControlle {
	
	@RequestMapping("/country")
	public @ResponseBody String getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		return country.toString();
		
	}
	
	@GetMapping("/countries")
	public @ResponseBody  List<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countrylist = new ArrayList<>();
		countrylist = (List<Country>) context.getBean("countryList", ArrayList.class);
		return countrylist;
		
	}

}
