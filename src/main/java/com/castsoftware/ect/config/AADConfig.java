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

import com.castsoftware.ect.Application;

/**
 * Read aad section of the configuration file
 * 
 * @author NKA
 *
 */
@Configuration
@ConfigurationProperties(prefix = "AAD")
public class AADConfig {
	private static final Logger LOG = LoggerFactory.getLogger(AADConfig.class);
	
	private String url;
	private String userName;
	private String password;
	
	/**
	 * URL getter
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * URL setter
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * UserName getter
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * UserName setter
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Password getter
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Password setter
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AEDConfig [url=" + url + ", userName=" + userName + ", password=" + password + "]";
	}

}
