package com.nihongo.service;

import com.nihongo.entity.Employee;
import com.nihongo.model.request.EmployeePostRequest;
import com.nihongo.model.request.EmployeePutRequest;
import com.nihongo.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getEmployeeTest() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setUsername("Mohd Shoaib");
        employee.setMail("mohd.shoaib@gmail.com");
        employee.setDob("20-03-1999");
        employee.setAddress("Bly");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        List<Employee> employeeResponse =  employeeService.getEmployee(1L);

        // Perform assertions
        assertNotNull(employeeResponse);
        assertEquals(1L, employeeResponse.get(0).getEmployeeId()); // Assuming you're comparing with a long value
        assertEquals("Mohd Shoaib", employeeResponse.get(0).getUsername());
        assertEquals("mohd.shoaib@gmail.com", employeeResponse.get(0).getMail());
        assertEquals("20-03-1999", employeeResponse.get(0).getDob());
        assertEquals("Bly", employeeResponse.get(0).getAddress());
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setUsername("Mohd Shoaib");
        employee.setMail("mohd.shoaib@gmail.com");
        employee.setDob("20-03-1999");
        employee.setAddress("Bly");

        employeeService.deleteEmployee(employee.getEmployeeId());

        assertNotNull(employeeService);

        // Verify that the deleteById method of the repository was called with the correct argument
        verify(employeeRepository).deleteById(1L);
    }

    @Test
    void saveEmployeeTest() {
        EmployeePostRequest employeePostRequest = new EmployeePostRequest();
        employeePostRequest.setUsername("Mohd Shoaib");
        employeePostRequest.setEmail("mohd.shoaib@gmail.com");
        employeePostRequest.setDob("20-03-1999");
        employeePostRequest.setAddress("Bly");

        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setUsername("Mohd Shoaib");
        employee.setMail("mohd.shoaib@gmail.com");
        employee.setDob("20-03-1999");
        employee.setAddress("Bly");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee employeeResponse = employeeService.saveEmployee(employeePostRequest);

        assertNotNull(employeeResponse);
        assertEquals(1L, employeeResponse.getEmployeeId()); // Assuming you're comparing with a long value
        assertEquals("Mohd Shoaib", employeeResponse.getUsername());
        assertEquals("mohd.shoaib@gmail.com", employeeResponse.getMail());
        assertEquals("20-03-1999", employeeResponse.getDob());
        assertEquals("Bly", employeeResponse.getAddress());
     }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setUsername("Mohd Shoaib");
        employee.setMail("mohd.shoaib@gmail.com");
        employee.setDob("20-03-1999");
        employee.setAddress("Bly");

        when(employeeRepository.findById(any())).thenReturn(Optional.of(employee));

        EmployeePutRequest employeePutRequest = new EmployeePutRequest();
        employeePutRequest.setUsername("Sidd_Updated");
        employeePutRequest.setMail("mohd.shoaib_Updated@gmail.com");
        employeePutRequest.setDob("20-06-1990");
        employeePutRequest.setAddress("Updated_Bareilly");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee employeePutResponse = employeeService.updateEmployee(employeePutRequest, 1L);

        verify(employeeRepository, times(1)).save(any(Employee.class));

        assertNotNull(employeePutResponse);
        assertEquals(1L, employeePutResponse.getEmployeeId()); // Assuming you're comparing with a long value
        assertEquals("Sidd_Updated", employeePutResponse.getUsername());
        assertEquals("mohd.shoaib_Updated@gmail.com", employeePutResponse.getMail());
        assertEquals("20-06-1990", employeePutResponse.getDob());
        assertEquals("Updated_Bareilly", employeePutResponse.getAddress());
    }
}