package com.nihongo.controller;

import com.nihongo.entity.Employee;
import com.nihongo.model.response.EmployeeResponse;
import com.nihongo.service.EmployeeService;
import com.nihongo.model.request.EmployeePostRequest;
import com.nihongo.model.request.EmployeePutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController implements EmployeeControllerApi {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public EmployeeResponse addEmployee(@RequestBody EmployeePostRequest employeePostRequest) {

        Employee employee = employeeService.saveEmployee(employeePostRequest);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getEmployeeId());
        employeeResponse.setUsername(employee.getUsername());
        employeeResponse.setMail(employee.getMail());
        employeeResponse.setDob(employee.getDob());
        employeeResponse.setAddress(employee.getAddress());

        return employeeResponse;
    }

    @Override
    public ArrayList<EmployeeResponse> getEmployees(Long id) {

        List<Employee> employeeList = employeeService.getEmployee(id);
        ArrayList<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for(Employee employee : employeeList) {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setId(employee.getEmployeeId());
            employeeResponse.setUsername(employee.getUsername());
            employeeResponse.setMail(employee.getMail());
            employeeResponse.setDob(employee.getDob());
            employeeResponse.setAddress(employee.getAddress());

            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }

    @Override
    public Long deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
        System.out.println(" Employee deleted id "+id);
        return id;
    }

    @Override
    public EmployeeResponse put(EmployeePutRequest putEmployee, Long id) {
        Employee employee = employeeService.updateEmployee(putEmployee, id);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getEmployeeId());
        employeeResponse.setUsername(employee.getUsername());
        employeeResponse.setMail(employee.getMail());
        employeeResponse.setDob(employee.getDob());
        employeeResponse.setAddress(employee.getAddress());
        return employeeResponse;
    }

}