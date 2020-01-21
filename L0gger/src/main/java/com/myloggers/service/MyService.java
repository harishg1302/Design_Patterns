package com.myloggers.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myloggers.config.MyConfig;
import com.myloggers.model.Employee;

@Service
public class MyService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private List<Employee> al = new ArrayList<>();

	@Autowired
	private MyConfig config;

	public String save(Employee emp) {
		al.add(emp);
		logger.info("Data Saved to List, List Data:{}", al);
		System.out.print(config.getEnvironment());
		System.out.print(config.getHosts());
		return "Data Saved";
	}

	public void show() {
		System.out.print("Runnig Application Runner");
	}

}
