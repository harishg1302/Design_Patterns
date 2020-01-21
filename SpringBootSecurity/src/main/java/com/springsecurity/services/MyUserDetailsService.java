package com.springsecurity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springsecurity.config.MyUserDetails;
import com.springsecurity.entity.Users;
import com.springsecurity.repositories.MyJpaRepositories;

@EnableWebSecurity
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	MyJpaRepositories myJpaRepositories;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = myJpaRepositories.findUserByUsername(username);
		return user.map(MyUserDetails::new).get();
	}

}
