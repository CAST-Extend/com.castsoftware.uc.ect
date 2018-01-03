package com.castsoftware.enlighten.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADSnapshot {
	private String name;
	private int number;
	private String href;
	

}
