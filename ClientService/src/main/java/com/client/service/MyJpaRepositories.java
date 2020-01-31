package com.client.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.User;

@Repository
public interface MyJpaRepositories extends JpaRepository<User, String>{
		@SuppressWarnings("unchecked")
		public User save(User user);
}
