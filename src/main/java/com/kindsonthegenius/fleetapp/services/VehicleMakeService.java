package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	
	// insert into db
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	//find id
	public Optional<VehicleMake> findById(Integer id) {
		return vehicleMakeRepository.findById(id);
	}
	
	//delete from db
	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}
	
	//find into db
	public List<VehicleMake> getVehicleMake() {
		return vehicleMakeRepository.findAll();
	}
	
	
}
