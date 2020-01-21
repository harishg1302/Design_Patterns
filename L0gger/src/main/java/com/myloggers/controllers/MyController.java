package com.myloggers.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myloggers.model.Employee;
import com.myloggers.service.MyService;

@RestController
public class MyController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MyService service;

	@Value("${server.port}")
	private int id;
	
	@PostMapping("/save")
	public String reg(@RequestBody Employee emp)
	{
		emp.setId(id);
		logger.info("Save request received as Employee Id:{} & name:{}",emp.getId(), emp.getName());
		return service.save(emp);
			
	}
}
