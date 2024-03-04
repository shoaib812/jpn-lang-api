package com.nihongo;


import com.nihongo.controller.EmployeeController;
import com.nihongo.entity.Employee;
import com.nihongo.model.request.EmployeePostRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(EmployeeController.class)
                .build();
    }

    @Test
    public void addEmployeeTest() throws Exception {
        EmployeePostRequest employeePostRequest = EmployeePostRequest.builder()
                .username("test-employee")
                .email("sidd@gmail.com")
                .dob("0 month")
                .address("delhi")
                .build();

                mockMvc.perform(MockMvcRequestBuilders
                        .post("/employees")
                        .contentType("application/json")
                        .content(asJsonString(employeePostRequest))
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
    private byte[] asJsonString(EmployeePostRequest employeePostRequest) {
        return new byte[0];
    }

}