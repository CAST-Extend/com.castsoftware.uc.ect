package com.castsoftware.enlighten.model;

import java.util.ArrayList;

public class ApplForm {
	private ArrayList<AADApplication> applList;
	private ArrayList<String> configList;

	public ArrayList<AADApplication> getApplList() {
		return applList;
	}
	public void setApplList(ArrayList<AADApplication> applList) {
		this.applList = applList;
	}
	public ArrayList<String> getConfigList() {
		return configList;
	}
	public void setConfigList(ArrayList<String> configList) {
		this.configList = configList;
	}

}
