package com.mymain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.mymain.services.AuditorAwareImpl;

@EnableJpaAuditing
@SpringBootApplication 
public class SpringBootDemo {
	    public static void main(String[] args) {  
	        SpringApplication.run(SpringBootDemo.class, args);  
	    }  
	    
	    @Bean
	    public AuditorAware<String> auditorAware() {
	        return new AuditorAwareImpl();
	    }
	} 

