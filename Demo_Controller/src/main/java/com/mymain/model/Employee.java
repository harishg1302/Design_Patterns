package com.mymain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Employee extends EntityBase{

	@Id
	private int eid;
	@ApiModelProperty(name = "Employee Name", required = true,value = "Employee Name Value", notes = "Employee Name description")
	private String ename;
	private String elocation;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getElocation() {
		return elocation;
	}
	public void setElocation(String elocation) {
		this.elocation = elocation;
	}
	
	
}
