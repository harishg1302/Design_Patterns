package com.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
        prefix = "security.oauth2.client"
)
public class MyClientDetailsService extends BaseClientDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
