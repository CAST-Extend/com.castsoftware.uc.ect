package com.castsoftware.ect.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADAnnotation {
	private String version;
	private int number;
	private String href;
	private AADDate date;
	private AADPlaceHolder sizingMeasures;
	private AADPlaceHolder qualityIndicators;
	private AADPlaceHolder backgroundFacts;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public AADDate getDate() {
		return date;
	}
	public void setDate(AADDate date) {
		this.date = date;
	}
	public AADPlaceHolder getSizingMeasures() {
		return sizingMeasures;
	}
	public void setSizingMeasures(AADPlaceHolder sizingMeasures) {
		this.sizingMeasures = sizingMeasures;
	}
	public AADPlaceHolder getQualityIndicators() {
		return qualityIndicators;
	}
	public void setQualityIndicators(AADPlaceHolder qualityIndicators) {
		this.qualityIndicators = qualityIndicators;
	}
	public AADPlaceHolder getBackgroundFacts() {
		return backgroundFacts;
	}
	public void setBackgroundFacts(AADPlaceHolder backgroundFacts) {
		this.backgroundFacts = backgroundFacts;
	}

	
}
