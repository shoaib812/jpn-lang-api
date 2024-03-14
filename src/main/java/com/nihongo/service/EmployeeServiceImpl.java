package com.nihongo.service;

import com.nihongo.entity.Employee;
import com.nihongo.repository.EmployeeRepository;
import com.nihongo.model.request.EmployeePostRequest;
import com.nihongo.model.request.EmployeePutRequest;
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

    public void deleteEmployee(Long id) {
        if(getEmployee(id) != null) {
            employeeRepository.deleteById(id);
        }
    }

    public Employee updateEmployee(EmployeePutRequest putRequest, Long id) {
        List<Employee>  employeeList  = getEmployee(id);
        Employee currentEmployee = null;
        if(employeeList.size()==1){
            currentEmployee =  employeeList.get(0);
            if (putRequest.getUsername() != null) {
                currentEmployee.setUsername(putRequest.getUsername());
            }
            if (putRequest.getMail() != null) {
                currentEmployee.setMail(putRequest.getMail());
            }
            if (putRequest.getMail() != null) {
                currentEmployee.setDob(putRequest.getDob());
            }
            if (putRequest.getAddress() != null) {
                currentEmployee.setAddress(putRequest.getAddress());
            }
            currentEmployee = employeeRepository.save(currentEmployee);
        }
        return currentEmployee;
    }

}