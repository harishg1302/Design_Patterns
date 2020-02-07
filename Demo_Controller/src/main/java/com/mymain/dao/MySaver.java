package com.mymain.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mymain.model.Employee;

@Repository
public interface MySaver extends CrudRepository<Employee, Integer>{

	public Employee save(Employee e);
	public Employee findByEid(int id);
	public void delete(int id);
	public boolean exists(int id);
	public List<Employee> findAll();
	
}
