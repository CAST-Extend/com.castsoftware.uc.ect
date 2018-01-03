package com.castsoftware.enlighten.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADDate {
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
