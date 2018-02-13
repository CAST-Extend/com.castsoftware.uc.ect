package com.castsoftware.ect.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADPlaceHolder {
	private static final Logger LOG = LoggerFactory.getLogger(AADPortal.class);

	private String href;
	private String name;

	public AADPlaceHolder() {
	}

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

	@Override
	public String toString() {
		return "AADModule [href=" + href + ", name=" + name + "]";
	}


}
