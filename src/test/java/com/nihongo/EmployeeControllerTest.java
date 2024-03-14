package com.nihongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.entity.Employee;
import com.nihongo.model.request.EmployeePostRequest;
import com.nihongo.model.request.EmployeePutRequest;
import com.nihongo.model.response.EmployeeResponse;
import com.nihongo.repository.EmployeeRepository;
import com.nihongo.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addEmployeeTest() throws Exception {

        EmployeePostRequest employeePostRequest = new EmployeePostRequest();
        employeePostRequest.setUsername("test-employee");
        employeePostRequest.setEmail("test-email");
        employeePostRequest.setDob("0 month");
        employeePostRequest.setAddress("test-add");

        Employee employee = new Employee();
        employee.setEmployeeId(Long.parseLong("1"));
        employee.setUsername("test-employee");
        employee.setMail("test-email");
        employee.setDob("0 month");
        employee.setAddress("test-add");

        when(employeeService.saveEmployee(any())).thenReturn(employee);

        MockHttpServletResponse response = mockMvc.perform(post("/employees")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeePostRequest))
                .accept("application/json")).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());

        Map map = objectMapper.readValue(response.getContentAsString(), Map.class);
        Assertions.assertEquals(1,map.get("id"));
//        Employee employee1 = objectMapper.readValue(response.getContentAsString(), Employee.class);
//        Assertions.assertEquals(1, employee1.getEmployeeId());
    }

    @Test
    void putTest() throws Exception {
        EmployeePutRequest employeePutRequest = new EmployeePutRequest();
        employeePutRequest.setUsername("Sidd");
        employeePutRequest.setMail("mohd.shoaib@gmail.com");
        employeePutRequest.setDob("20-06-1990");
        employeePutRequest.setAddress("Bareilly");

        Employee employee = new Employee();
        employee.setEmployeeId(Long.parseLong("1"));
        employee.setUsername("Sidd");
        employee.setMail("mohd.shoaib@gmail.com");
        employee.setDob("20-06-1990");
        employee.setAddress("Bareilly");

        when(employeeService.updateEmployee(any(), any())).thenReturn(employee);

        MockHttpServletResponse response = mockMvc.perform(put("/employees?id=1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeePutRequest))
                .accept("application/json")).andReturn().getResponse();


        Assertions.assertEquals(200, response.getStatus());
        Map map = objectMapper.readValue(response.getContentAsString(), Map.class);
        Assertions.assertEquals(1,map.get("id"));
    }

    @Test
    void deleteEmployeeTest() throws Exception {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(Long.parseLong("1"));
        employeeResponse.setUsername("Sidd");
        employeeResponse.setMail("mohd.shoaib@gmail.com");
        employeeResponse.setDob("20-06-1990");
        employeeResponse.setAddress("Bareilly");

        Employee employee = new Employee();
        employee.setEmployeeId(Long.parseLong("1"));
        employee.setUsername("Sidd");
        employee.setMail("mohd.shoaib@gmail.com");
        employee.setDob("20-06-1990");
        employee.setAddress("Bareilly");

        doNothing().when(employeeService).deleteEmployee(any());

        MockHttpServletResponse response = mockMvc.perform(delete("/employees?id=1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeResponse))
                .accept("application/json")).andReturn().getResponse();

        Assertions.assertEquals(200, response.getStatus());

        String id = response.getContentAsString();
        Assertions.assertEquals("1",id);
        //Map map = objectMapper.readValue(response.getContentAsString(), Map.class);
    }

    //-===================================================================================================================================

    @Test
    void getEmployeeTest() throws Exception {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(Long.parseLong("1"));
        employeeResponse.setUsername("sidd");
        employeeResponse.setMail("mail");
        employeeResponse.setDob("0-month");
        employeeResponse.setAddress("add");

        Employee employee = new Employee();
        employee.setEmployeeId(Long.parseLong("1"));
        employee.setUsername("sidd");
        employee.setMail("mail");
        employee.setDob("0-month");
        employee.setAddress("add");
    }

    //convert objects to json string
    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}