package com.jpn.lang.service;

import com.jpn.lang.entity.Employee;
import com.jpn.lang.model.request.EmployeePostRequest;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(EmployeePostRequest employeePostRequest);

    List<Employee> getEmployee(Long employeeId);

    void deleteEmployee(Long id);
}
