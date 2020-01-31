package com.auth.config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security.oauth2.client")
public class ClientDetails extends BaseClientDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		Set<String> redirect = new HashSet<>();
		redirect.add("https://localhost:8081");
		super.setRegisteredRedirectUri(redirect);
	}

}
