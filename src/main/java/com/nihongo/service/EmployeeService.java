package com.nihongo.service;

import com.nihongo.entity.Employee;
import com.nihongo.model.request.EmployeePostRequest;
import com.nihongo.model.request.EmployeePutRequest;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(EmployeePostRequest employeePostRequest);

    List<Employee> getEmployee(Long employeeId);

    void deleteEmployee(Long id);

    Employee updateEmployee(EmployeePutRequest employee, Long id);
}
