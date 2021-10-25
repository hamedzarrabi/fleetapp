package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired private EmployeeTypeRepository employeeTypeRepository;
	
	public List<EmployeeType> getEmployeeType() {
		// TODO Auto-generated method stub
		return employeeTypeRepository.findAll();
	}

	public void save(EmployeeType invoiceStatus) {
		// TODO Auto-generated method stub
		employeeTypeRepository.save(invoiceStatus);
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeTypeRepository.deleteById(id);
	}

	public Optional<EmployeeType> findById(Integer id) {
		// TODO Auto-generated method stub
		return employeeTypeRepository.findById(id);
	}
	
	
	
	
	
	

}
