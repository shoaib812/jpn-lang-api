package com.jpn.lang.service;

import com.jpn.lang.entity.Employee;
import com.jpn.lang.model.request.EmployeePostRequest;
import com.jpn.lang.model.response.EmployeeResponse;
import com.jpn.lang.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployee(Long id) {

        ArrayList<Employee> arrayList = new ArrayList<>();
        if(id != null) {
            Optional<Employee> optional = employeeRepository.findById(id);
            if(optional.isPresent()){
                Employee employee = optional.get();
                arrayList.add(employee);
            }
            return arrayList;
        }
        else {
            return employeeRepository.findAll();
        }
    }

    @Override
    public Employee saveEmployee(EmployeePostRequest employeePostRequest) {

        Employee employee = new Employee();
        employee.setUsername(employeePostRequest.getUsername());
        employee.setMail(employeePostRequest.getEmail());
        employee.setDob(employeePostRequest.getDob());
        employee.setAddress(employeePostRequest.getAddress());
        return employeeRepository.save(employee);
    }
}
