package com.myloggers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myloggers.service.MyService;

@SpringBootApplication
public class MySpringApplication implements ApplicationRunner{

	@Autowired
	private MyService service;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MySpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Helooooooooooooooooooooooooooooooooo");
		service.show();
	}

}
