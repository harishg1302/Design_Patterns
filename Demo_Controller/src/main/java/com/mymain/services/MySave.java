package com.mymain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymain.dao.MySaver;
import com.mymain.mapper.MyMapper;
import com.mymain.model.Employee;
import com.mymain.model.EmployeeDao;

@Service
public class MySave {
	
	@Autowired
	private MySaver ms;
	@Autowired
	private MyMapper mm;
	
	public int saving(EmployeeDao e)
	{
		Employee emp=mm.toEntity(e);
		emp=ms.save(emp);
		if(emp==null)
			return 0;
		else
		return 1;
	}
	public Employee finding(int id)
	{
		return ms.findByEid(id);
	}
	
	public int deleting(int id)
	{
		try{
			ms.delete(id);
			return 1;
		}
		catch(IllegalArgumentException exp)
		{
			return 0;
		}
			
	}
	
	public boolean existing(int id)
	{
		return ms.exists(id);
	}
	
	public List<Employee> allFinding()
	{
		return ms.findAll();
	}
}
