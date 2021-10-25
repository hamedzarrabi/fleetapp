package com.kindsonthegenius.fleetapp.services;

import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.repositories.VehicleTypeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    
    public void save(VehicleType vehicleTypeService) {
        vehicleTypeRepository.save(vehicleTypeService);
        
    }
    
    public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}
    
    public List<VehicleType> getVehicleType() {
		return vehicleTypeRepository.findAll();
	}
    
    public Optional<VehicleType> findById(Integer id) {
    	return vehicleTypeRepository.findById(id);
    }
}
