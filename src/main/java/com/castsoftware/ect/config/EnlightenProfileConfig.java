package com.castsoftware.ect.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "enlighten")
public class EnlightenProfileConfig {
	private static final Logger LOG = LoggerFactory.getLogger(EnlightenProfileConfig.class);

	
  	private String server;
  	private String port;
  	private String user;
  	private String password;
  	private String version;
  	private String profileBaseFolder;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProfileBaseFolder() {
		return profileBaseFolder;
	}
	public void setProfileBaseFolder(String profileBaseFolder) {
		this.profileBaseFolder = profileBaseFolder;
	}

}
