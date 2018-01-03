package com.castsoftware.enlighten.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AADPortal {
	private String href;
	private String name;
	private String dbType;
	private String version;
	private String schema;
	private String dbmsVersion;
	private String localSchema;
	private String mngtSchema;	
	private AADPlaceHolder applications;
	private AADPlaceHolder configurations;
	private AADPlaceHolder results;
	private AADPlaceHolder commonCategories;
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
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getDbmsVersion() {
		return dbmsVersion;
	}
	public void setDbmsVersion(String dbmsVersion) {
		this.dbmsVersion = dbmsVersion;
	}
	public String getLocalSchema() {
		return localSchema;
	}
	public void setLocalSchema(String localSchema) {
		this.localSchema = localSchema;
	}
	public String getMngtSchema() {
		return mngtSchema;
	}
	public void setMngtSchema(String mngtSchema) {
		this.mngtSchema = mngtSchema;
	}
	public AADPlaceHolder getApplications() {
		return applications;
	}
	public void setApplications(AADPlaceHolder applications) {
		this.applications = applications;
	}
	public AADPlaceHolder getConfigurations() {
		return configurations;
	}
	public void setConfigurations(AADPlaceHolder configurations) {
		this.configurations = configurations;
	}
	public AADPlaceHolder getResults() {
		return results;
	}
	public void setResults(AADPlaceHolder results) {
		this.results = results;
	}
	public AADPlaceHolder getCommonCategories() {
		return commonCategories;
	}
	public void setCommonCategories(AADPlaceHolder commonCategories) {
		this.commonCategories = commonCategories;
	}
}
