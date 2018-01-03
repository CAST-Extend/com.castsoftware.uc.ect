package com.castsoftware.ect.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment env;

	@Value("${ldap.domain}")
	private String DOMAIN;

	@Value("${ldap.url}")
	private String URL;
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(
				"/webjars/**",
                "/lib/bootstrap/**",
                "/css/**",
                "/img/**",
                "/js/**").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
//        http.requiresChannel().anyRequest().requiresSecure();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.authenticationProvider(activeDirectoryLdapAuthenticationProvider())
				.userDetailsService(userDetailsService());
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
	}

	@Bean
	public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(DOMAIN, URL);
		provider.setConvertSubErrorCodesToExceptions(true);
		provider.setUseAuthenticationRequestCredentials(true);
//		provider.setSearchFilter("(&(objectCategory=person)(objectClass=user))");
		
//		provider.setSearchFilter("sAMAccountName={0}");

		return provider;
	}

	@PostConstruct
	private void configureSSL() {
	    //set to TLSv1.1 or TLSv1.2
	    System.setProperty("https.protocols", "TLSv1.1");

	    //load the 'javax.net.ssl.trustStore' and 'javax.net.ssl.trustStorePassword' from application.properties
	    System.setProperty("javax.net.ssl.trustStore", env.getProperty("server.ssl.trust-store"));
	    System.setProperty("javax.net.ssl.trustStorePassword",env.getProperty("server.ssl.trust-store-password"));
	}	
	
//	@Bean
//	EmbeddedServletContainerCustomizer containerCustomizer (
//
//	     @Value("${https.port}") final int port, 
//	     @Value("${server.ssl.trust-store}") Resource keystoreFile,
//	     @Value("${keystore.alias}") final String alias, 
//	     @Value("${keystore.password}") final String keystorePass,
//	     @Value("${keystore.type}") final String keystoreType) throws Exception {
//	          final String absoluteKeystoreFile = keystoreFile.getFile().getAbsolutePath();
//	          return new EmbeddedServletContainerCustomizer() {
//	               public void customize(ConfigurableEmbeddedServletContainer container) {
//	                    TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//	                    tomcat.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//	                         public void customize(Connector connector) {
//	                              connector.setPort(port);
//	                              connector.setSecure(true);
//	                              connector.setScheme("https");
//	                              Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
//	                              proto.setSSLEnabled(true);
//	                              proto.setKeystoreFile(absoluteKeystoreFile);
//	                              proto.setKeyAlias(alias);
//	                              proto.setKeystorePass(keystorePass);
//	                              proto.setKeystoreType(keystoreType);
//	                        }
//	               });
//	           }
//
//	     };
//	 }
}