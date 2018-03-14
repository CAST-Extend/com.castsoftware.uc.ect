package com.castsoftware.ect.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AADRestConfig {
	private static final Logger LOG = LoggerFactory.getLogger(AADRestConfig.class);

	@Autowired private AADConfig config;
	
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate aedRestTemplate(RestTemplateBuilder builder) {
		restTemplate = builder.build();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(config.getUserName(), config.getPassword()));
		return restTemplate;
	}
	public RestTemplate getRestTemplate()
	{
		return restTemplate;
	}
	public String getBaseURL()
	{
		return config.getUrl();
	}
}
