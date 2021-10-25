package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Employee;
import com.kindsonthegenius.fleetapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	public Optional<Employee> findById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}


}
