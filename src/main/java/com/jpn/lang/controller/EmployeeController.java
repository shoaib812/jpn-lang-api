package com.jpn.lang.controller;


import com.jpn.lang.entity.Employee;
import com.jpn.lang.model.request.EmployeePostRequest;
import com.jpn.lang.model.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jpn.lang.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController implements EmployeeControllerApi {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Override
    public ArrayList<EmployeeResponse> getEmployees(Long id) {
        List<Employee> employeeList = employeeService.getEmployee(id);
        ArrayList<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for(Employee employee : employeeList) {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setUsername(employee.getUsername());
            employeeResponse.setMail(employee.getMail());
            employeeResponse.setDob(employee.getDob());
            employeeResponse.setAddress(employee.getAddress());

            employeeResponseList.add(employeeResponse);
        }

        return employeeResponseList;
    }

    @Override
    public EmployeeResponse addEmployee(@RequestBody EmployeePostRequest employeePostRequest) {



        Employee employee = employeeService.saveEmployee(employeePostRequest);

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setUsername(employee.getUsername());
        employeeResponse.setMail(employee.getMail());
        employeeResponse.setDob(employee.getDob());
        employeeResponse.setAddress(employee.getAddress());

        return employeeResponse;
    }


}