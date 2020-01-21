package com.springsecurity.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	String secret = "secret";

	public String extractUsername(String token) {
		Claims claim = extractAll(token);
		return claim.getSubject();
	}

	public Date extractExpiration(String token) {
		Claims claim = extractAll(token);
		return claim.getExpiration();
	}

	public Claims extractAll(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public String genrateJwtToken(UserDetails userDetails) {
		Map<String, Object> clam = new HashMap<>();
		return createJwtToken(clam, userDetails.getUsername());
	}

	private String createJwtToken(Map<String, Object> clam, String username) {
		return Jwts.builder().setClaims(clam).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();

	}
	
	public boolean validateToken(String token) {
		return !extractExpiration(token).before(new Date());
		//return true;
	}

}
