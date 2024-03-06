package com.nihongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nihongo.controller.EmployeeController;
import com.nihongo.model.request.EmployeePostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
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
                .email("test-email")
                .dob("0 month")
                .address("test-add")
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/employees")
                        .contentType("application/json")
                        .content(asJsonString(employeePostRequest))
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void getEmployeeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .accept("application/json")
                        .contentType("application/json"))

                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.*").exists());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value("1"));
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