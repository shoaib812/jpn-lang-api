package com.jpn.lang.controller;

import com.jpn.lang.model.request.EmployeePostRequest;
import com.jpn.lang.model.request.EmployeePutRequest;
import com.jpn.lang.model.response.EmployeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

public interface EmployeeControllerApi {

    @Operation(
            tags = "ADD Employees",
            description = "Add Employees",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Data Not Found",
                            responseCode = "404"
                    )
            }
    )
    @PostMapping(value = "/employees", consumes = "application/json", produces = "application/json")
    EmployeeResponse addEmployee(@RequestBody EmployeePostRequest employeePostRequest);


    @Operation(
            tags = "GET Employees",
            description = "Get Employees",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Data Not Found",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping
    ArrayList<EmployeeResponse> getEmployees(@RequestParam(value = "id", required = false) Long id);

    @DeleteMapping
    Long deleteEmployee(@RequestParam(value = "id") Long id );

   @PutMapping
   public EmployeeResponse put(@RequestBody EmployeePutRequest putEmployee, @RequestParam(value="id") Long id);
}
