package com.castsoftware.ect.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADSnapshot {
	private static final Logger LOG = LoggerFactory.getLogger(AADSnapshot.class);

	private String name;
	private int number;
	private String href;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

	

}
