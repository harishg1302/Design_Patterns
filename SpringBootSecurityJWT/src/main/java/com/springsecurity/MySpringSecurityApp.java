package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.springsecurity.repositories.MyJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=MyJpaRepositories.class)
public class MySpringSecurityApp {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSecurityApp.class, args);
	}

}
