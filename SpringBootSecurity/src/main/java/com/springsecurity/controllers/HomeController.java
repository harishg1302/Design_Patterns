package com.springsecurity.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/user")
	public String homeUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		String role = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			role = ((UserDetails) principal).getAuthorities().toString();
		}
		return "<h1> Welcome " + username + "</h1>" + "your role is" + role;
	}

	@GetMapping("/admin")
	public String homeAdmin() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		String role = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			role = ((UserDetails) principal).getAuthorities().toString();
		}
		return "<h1> Welcome " + username + "</h1>" + "your role is" + role;
	}

	@GetMapping("/")
	public String home() {
		return "<h1> Welcome </h1>";
	}
	
	
}
