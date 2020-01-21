package com.springsecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Users;

@Repository
public interface MyJpaRepositories extends JpaRepository<Users, String>{
		public Optional<Users> findUserByUsername(String username);
}
