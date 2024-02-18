package com.jpn.lang.service;

import com.jpn.lang.entity.Employee;
import com.jpn.lang.model.request.EmployeePostRequest;
import com.jpn.lang.model.response.EmployeeResponse;

import java.util.List;


public interface EmployeeService {

    Employee saveEmployee(EmployeePostRequest employeePostRequest);

    List<Employee> getEmployee(Long employeeId);

}
