package com.castsoftware.ect.model;

import java.util.ArrayList;

public class ApplForm {
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
