package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired private SupplierRepository supplierRepository;
	
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}

	public Optional<Supplier> findById(Integer id) {
		
		return supplierRepository.findById(id);
	}

	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
		
	}

	public List<Supplier> getSupplier() {
		
		return supplierRepository.findAll();
	}
	
	

}
