package com.mymain.mapper;

import com.mymain.model.Employee;
import com.mymain.model.EmployeeDao;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-07T14:38:47+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class MyMapperImpl extends MyMapper {

    @Override
    public Employee toEntity(EmployeeDao empdao) {
        if ( empdao == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setEid( empdao.getEid() );
        employee.setCreatedAt( empdao.getCreatedAt() );
        employee.setCreatedBy( empdao.getCreatedBy() );
        employee.setLastModifiedAt( empdao.getLastModifiedAt() );
        employee.setLastModifiedBy( empdao.getLastModifiedBy() );
        employee.setEname( empdao.getEname() );
        employee.setElocation( empdao.getElocation() );

        return employee;
    }

    @Override
    public EmployeeDao toDao(Employee emp) {
        if ( emp == null ) {
            return null;
        }

        EmployeeDao employeeDao = new EmployeeDao();

        employeeDao.setCreatedAt( emp.getCreatedAt() );
        employeeDao.setCreatedBy( emp.getCreatedBy() );
        employeeDao.setLastModifiedAt( emp.getLastModifiedAt() );
        employeeDao.setLastModifiedBy( emp.getLastModifiedBy() );
        employeeDao.setEid( emp.getEid() );
        employeeDao.setEname( emp.getEname() );
        employeeDao.setElocation( emp.getElocation() );

        return employeeDao;
    }
}
