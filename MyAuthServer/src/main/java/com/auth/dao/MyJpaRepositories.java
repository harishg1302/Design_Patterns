package com.auth.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.Users;

@Repository
public interface MyJpaRepositories extends JpaRepository<Users, String>{
		public Optional<Users> findUserByUsername(String username);
}
