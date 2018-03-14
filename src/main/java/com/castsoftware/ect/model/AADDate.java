package com.castsoftware.ect.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADDate {
	private static final Logger LOG = LoggerFactory.getLogger(AADDate.class);

	private int time;
	private String isoDate;
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getIsoDate() {
		return isoDate;
	}
	public void setIsoDate(String isoDate) {
		this.isoDate = isoDate;
	}
}
