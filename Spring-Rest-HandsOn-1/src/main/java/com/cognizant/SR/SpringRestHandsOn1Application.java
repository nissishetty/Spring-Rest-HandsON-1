package com.cognizant.SR;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringRestHandsOn1Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestHandsOn1Application.class);

	public static void displayDate() throws ParseException {
		String str = "31/12/2018";
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
//		System.out.println(format.parse(str));
		LOGGER.info("Start");
		LOGGER.debug(str, format.parse(str));
		LOGGER.info("End");

	}

	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		LOGGER.debug(country.toString());
	}

	public static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countrylist = new ArrayList<>();
		countrylist = (List<Country>) context.getBean("countryList", ArrayList.class);
		LOGGER.info("Start Display Country");

		LOGGER.debug("Countrylist : {}", countrylist);
		LOGGER.info("End Display Country");

	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringRestHandsOn1Application.class, args);
//		try{
//			displayDate();
//			}catch (Exception e) {
//				LOGGER.error("errorrr",e);			}
		displayDate();
		displayCountry();
		displayCountries();

	}

}
