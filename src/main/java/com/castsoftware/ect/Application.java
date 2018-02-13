package com.castsoftware.ect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(10); // reload messages every 10 seconds
		return messageSource;
	}

	@Bean
	public CommandLineRunner run() throws Exception {

		CommandLineRunner status = args -> {

			// String url =
			// String.format("%sdomains/%s/applications?expand=domain",
			// hlRestConfig.getBaseURL(), hlRestConfig.getDefaultDomain());
			// log.info(url);
			// HighlightApplication[] highlightApplication =
			// hlRestConfig.getRestTemplate().getForObject(url,
			// HighlightApplication[].class);
			// for (HighlightApplication s : highlightApplication) {
			// log.info(s.toString());
			// }

			//
			// AADApplication []apps = AADApplication.getInstance(restTemplate);
			// log.info(apps.toString());

		};
		return status;
	}

}