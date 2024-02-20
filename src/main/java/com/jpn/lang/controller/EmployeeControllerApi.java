package com.jpn.lang.controller;

import com.jpn.lang.model.request.EmployeePostRequest;
import com.jpn.lang.model.request.EmployeePutRequest;
import com.jpn.lang.model.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public interface EmployeeControllerApi {
    @PostMapping
    EmployeeResponse addEmployee(@RequestBody EmployeePostRequest employeePostRequest);

    @GetMapping
    ArrayList<EmployeeResponse> getEmployees(@RequestParam(value = "id", required = false) Long id);

    @DeleteMapping
    ResponseEntity<?> deleteEmployee(@RequestParam(value = "id") Long id );

   @PutMapping
   public EmployeeResponse put(@RequestBody EmployeePutRequest putEmployee, @RequestParam(value="id") Long id);

}
