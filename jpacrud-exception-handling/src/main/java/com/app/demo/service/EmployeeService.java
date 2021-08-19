package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.custom.exception.BusinessException;
import com.app.demo.custom.exception.EmptyInputException;
import com.app.demo.entity.Employee;
import com.app.demo.repos.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {

		if ((employee.getName()).isEmpty() || (employee.getName()).length() == 0) {
			throw new EmptyInputException("601", "Input Fields are Empty");
		}
		Employee savedEmployee = crudRepo.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = crudRepo.findAll();
		if (empList.isEmpty())
			throw new BusinessException("604", "Hey list is completely empty");
		return empList;
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}
