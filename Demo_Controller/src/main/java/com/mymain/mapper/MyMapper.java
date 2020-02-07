package com.mymain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.mymain.model.Employee;
import com.mymain.model.EmployeeDao;

@EnableJpaAuditing
@Mapper(componentModel = "spring")
public abstract class  MyMapper /*implements  Mapper1*/{
	
	@Mapping(source = "eid", target = "eid")
//	@Override
	public abstract  Employee toEntity(EmployeeDao empdao);
//	@Override
	public abstract  EmployeeDao toDao(Employee emp);
	
	

}
