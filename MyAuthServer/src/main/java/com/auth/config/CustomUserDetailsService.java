package com.auth.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.dao.MyJpaRepositories;
import com.auth.entity.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	MyJpaRepositories myJpaRepositories;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = myJpaRepositories.findUserByUsername(username);
		return user.map(MyUserDetails::new).get();
	}

}
