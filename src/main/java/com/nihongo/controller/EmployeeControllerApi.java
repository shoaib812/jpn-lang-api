package com.nihongo.controller;

import com.nihongo.model.request.EmployeePostRequest;
import com.nihongo.model.request.EmployeePutRequest;
import com.nihongo.model.response.EmployeeResponse;
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
            tags = "Employee Service",
            description = "Add Employees",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping
    EmployeeResponse addEmployee(@RequestBody EmployeePostRequest employeePostRequest);


    @Operation(
            tags = "Employee Service",
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


    @Operation(
            tags = "Employee Service",
            description = "Delete Employees",
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
    @DeleteMapping
    Long deleteEmployee(@RequestParam(value = "id") Long id );

    @Operation(
            tags = "Employee Service",
            description = "Update Employees",
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
   @PutMapping
   public EmployeeResponse put(@RequestBody EmployeePutRequest putEmployee, @RequestParam(value="id") Long id);
}
