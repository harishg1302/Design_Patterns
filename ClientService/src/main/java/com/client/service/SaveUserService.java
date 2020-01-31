package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.client.entity.User;

@Service
public class SaveUserService {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private MyJpaRepositories myJpaRepositories;
	
	public void save(User user) {
		String password = user.getPassword();
		user.setPassword(encoder.encode(password));
		myJpaRepositories.save(user);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
