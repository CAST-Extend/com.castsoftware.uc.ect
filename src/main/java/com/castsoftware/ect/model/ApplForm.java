package com.castsoftware.ect.model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.castsoftware.ect.HttpComponentsClientHttpRequestFactoryBasicAuth;

public class ApplForm {
	private static final Logger LOG = LoggerFactory.getLogger(HttpComponentsClientHttpRequestFactoryBasicAuth.class);
	
	private ArrayList<AADApplication> applList;
	private String[] configList;

	public ArrayList<AADApplication> getApplList() {
		return applList;
	}
	public void setApplList(ArrayList<AADApplication> applList) {
		this.applList = applList;
	}
	public String[] getConfigList() {
		return configList;
	}
	public void setConfigList(String[] configList) {
		this.configList = configList;
	}

}
