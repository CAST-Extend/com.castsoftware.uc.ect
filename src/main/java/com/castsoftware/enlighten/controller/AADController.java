package com.castsoftware.enlighten.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.castsoftware.enlighten.config.AADRestConfig;
import com.castsoftware.enlighten.model.AADApplication;
import com.castsoftware.enlighten.model.AADPortal;
import com.castsoftware.enlighten.model.AADSnapshot;
import com.castsoftware.enlighten.model.AADSystem;

@Controller
public class AADController {
	private static final Logger log = LoggerFactory.getLogger(AADController.class);

	@Autowired
	AADRestConfig restConfig;
	
	public List<AADPortal> getPortals()
	{
		String url = String.format("%s", restConfig.getBaseURL());
		log.debug(url);

		ResponseEntity<List<AADPortal>> applResponse = restConfig.getRestTemplate().exchange(url,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<AADPortal>>() {
				});
		
		return applResponse.getBody();
	}

	public AADSystem getSystem(String portal)
	{
		String url = String.format("%s%s", restConfig.getBaseURL(), portal);
		log.debug(url);

		ResponseEntity<AADSystem> applResponse = restConfig.getRestTemplate().exchange(url,
				HttpMethod.GET, null, new ParameterizedTypeReference<AADSystem>() {
				});
		
		return applResponse.getBody();
	}

	public List<AADSnapshot> getSnapshots(String portal)
	{
		String url = String.format("%s%s/configuration/snapshots", restConfig.getBaseURL(), portal);
		log.debug(url);

		ResponseEntity<List<AADSnapshot>> applResponse = restConfig.getRestTemplate().exchange(url,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<AADSnapshot>>() {
				});
		
		return applResponse.getBody();
	}
	
	public List<AADApplication> getApplications(String portal)
	{
		String url = String.format("%s%s/applications", restConfig.getBaseURL(), portal);
		log.debug(url);

		ResponseEntity<List<AADApplication>> applResponse = restConfig.getRestTemplate().exchange(url,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<AADApplication>>() {
				});
		
		return applResponse.getBody();
	}
}
