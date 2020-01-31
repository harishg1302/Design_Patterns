package com.client.controller;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.config.ValueFromYML;
import com.client.entity.User;
import com.client.service.SaveUserService;

@RestController
public class MyController {
	
	@Autowired
	private SaveUserService saveUserService;
	
	@Autowired
	private ValueFromYML value;
	
	private String accessTokenUri="http://localhost:8082/logmein/oauth/token";
	
	@PostMapping("/login")
	public String getToken(@RequestBody LoginInfo logininfo) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = createHeaders();
		String str = "grant_type=password&username=" + logininfo.getUserName() + "&password=" + logininfo.getPassword();
		HttpEntity<String> request = new HttpEntity<>(str, header);
		String token = restTemplate.postForObject(accessTokenUri, request, String.class);
		return token;
	}
	
	@PostMapping("/signup")
	public void signup(@RequestBody User user) {
		saveUserService.save(user);
	}
	
	private HttpHeaders createHeaders() {
		
			String clientid = value.getClientId(); // client id of ouath2
			String clientSecret = value.getClientSecret(); // clientsecret of oauth2
			String auth = clientid + ":" + clientSecret;
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + encodedAuth;
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", authHeader);
			headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);
			return headers;
	}
}
