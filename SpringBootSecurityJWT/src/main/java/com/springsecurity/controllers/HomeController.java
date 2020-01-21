package com.springsecurity.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.UsernamePasswordAuthentication;
import com.springsecurity.services.MyUserDetailsService;
import com.springsecurity.util.JwtUtil;

@RestController
public class HomeController {

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

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

	@SuppressWarnings("unchecked")
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody UsernamePasswordAuthentication usernamePasswordAuthentication) {
		String username = usernamePasswordAuthentication.getUsername();
		String password = usernamePasswordAuthentication.getPassword();
		String jwtToken = null;
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			try {
				Authentication auth = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				//SecurityContextHolder.getContext().setAuthentication(auth);
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				jwtToken = jwtUtil.genrateJwtToken(userDetails);
			} catch (Exception ex) {
				return (ResponseEntity<HttpStatus>)ResponseEntity.status(HttpStatus.UNAUTHORIZED);
			}
		}
		return (ResponseEntity<String>) ResponseEntity.ok(jwtToken);

	}

}
