package com.hcl.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.demo.entity.Employee;

public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {
	
	

}
