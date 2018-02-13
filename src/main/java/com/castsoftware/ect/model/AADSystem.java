package com.castsoftware.ect.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADSystem {
	private static final Logger LOG = LoggerFactory.getLogger(AADSystem.class);

	private String href;
	private String name;
	private List <String> technologies;
	private AADPlaceHolder applications;
	private AADPlaceHolder results;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}
	public AADPlaceHolder getApplications() {
		return applications;
	}
	public void setApplications(AADPlaceHolder applications) {
		this.applications = applications;
	}
	public AADPlaceHolder getResults() {
		return results;
	}
	public void setResults(AADPlaceHolder results) {
		this.results = results;
	}

}
