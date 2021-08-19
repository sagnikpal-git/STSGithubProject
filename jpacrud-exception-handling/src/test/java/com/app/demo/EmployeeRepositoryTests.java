package com.app.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.demo.entity.Employee;
import com.app.demo.repos.EmployeeCrudRepo;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeCrudRepo employeeCrudRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

    	Employee employee = Employee.builder()
                .name("Sagnik")                
                .emailId("sagnikpalme11@gmail.com")
                .tech("Java")
                .designation("SSE")
                .age(28)
                .address("Bangalore")
                .mobileNumber("9434885076")
                .build();

        employeeCrudRepo.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmployeeTest(){

        Employee employee = employeeCrudRepo.findById(1L).get();

        Assertions.assertThat(employee.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfEmployeesTest(){

        List<Employee> employees = employeeCrudRepo.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Employee employee = employeeCrudRepo.findById(1L).get();

        employee.setEmailId("abhishek.p@gmail.com");

        Employee employeeUpdated =  employeeCrudRepo.save(employee);

        Assertions.assertThat(employeeUpdated.getEmailId()).isEqualTo("abhishek.p@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee = employeeCrudRepo.findById(1L).get();

        employeeCrudRepo.delete(employee);

        Employee employee1 = null;

        Optional<Employee> optionalEmployee = employeeCrudRepo.findByEmail("abhishek.p@gmail.com");

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();
    }

}
