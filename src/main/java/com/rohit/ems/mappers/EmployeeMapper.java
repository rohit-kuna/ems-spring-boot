package com.rohit.ems.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.rohit.ems.dto.EmployeeResult;
import com.rohit.ems.entities.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee resultToEntity(EmployeeResult employeeResult);

    EmployeeResult entityToResult(Employee employee);

    List<EmployeeResult> mapEntityToResultList(List<Employee> employees);
}
