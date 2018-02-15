package com.castsoftware.ect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Main class for the Enlighten Configuration Tool application
 * 
 * @author NKA
 * @since 2018-02-15
 */
@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	
	/**
	 * application entry point
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * bean to handle messaging text
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(10); // reload messages every 10 seconds
		return messageSource;
	}

}