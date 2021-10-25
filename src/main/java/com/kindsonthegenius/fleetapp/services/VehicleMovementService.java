package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
	
	public List<VehicleMovement> getVehicleMovement() {
		return vehicleMovementRepository.findAll();
	}
	
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementRepository.findById(id);
	}
}
