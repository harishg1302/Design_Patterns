package com.mymain.newcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymain.model.Employee;
import com.mymain.model.EmployeeDao;
import com.mymain.services.MySave;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Product1Controller", tags = "New Employee controller", consumes = "application/xml", produces = "application/xml")
@RestController
public class MyNewController {
		
	@Autowired
	private MySave ms;
	
	@GetMapping("/mynewget/{ID}")
	public Employee display(
			@ApiParam(value = "Employee ID", required = true,example = "99")
			@PathVariable("ID") int id)
	{
		
		return ms.finding(id);
	}
	
	@PostMapping("/newsave")
	public String reg(@RequestBody EmployeeDao emp)
	{
		if(ms.existing(emp.getEid()))
			return "Already exist";
		else
			{
		int x=ms.saving(emp);
		if(x==1)
			return "Successfully Saved";
		else
			return "Not Saved";
			}
			
	}
	
	@ApiOperation("Delete Employee Based on ID")
	@DeleteMapping("/newdel/{ID}")
	public String deletion(@PathVariable("ID") int id)
	{
		if(ms.deleting(id)==1)
		return "Successfully Deleted";
		else
			return "Not Deleted";
	}
	
	/*@PutMapping("/update/{ID}")
	public String Updation(@PathVariable("ID") int id,@RequestBody Employee emp)
	{
		Employee emp1=ms.finding(id);
		emp1.setEname(emp.getEname());
		emp1.setElocation(emp.getElocation());
		int x=ms.saving(emp1);
		if(x==1)
		return "Successfully Updated";
		else
			return "Not updated";
	}*/
	
	@GetMapping("/newgetall")
	public List<Employee> allContent()
	{
		return ms.allFinding();
	}

	}



