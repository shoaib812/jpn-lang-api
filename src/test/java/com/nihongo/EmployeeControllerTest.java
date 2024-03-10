package com.nihongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.entity.Employee;
import com.nihongo.model.request.EmployeePostRequest;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;
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

        when(employeeService.saveEmployee(Mockito.any())).thenReturn(employee);


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
    void getEmployeeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .accept("application/json")
                        .contentType("application/json"))

                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.*").exists());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value("1"));
    }


//    @Test
//    void deleteEmployeeTest() throws Exception {
//        Mockito.when(employeeControllerApi.deleteEmployee(2L)).thenReturn(1L);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/employees", 2L))
//                .andExpect(status().isOk());
//    }


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