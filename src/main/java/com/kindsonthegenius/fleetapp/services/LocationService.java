package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Location;

import com.kindsonthegenius.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> geLocations() {
		return  (List<Location>) locationRepository.findAll();
	}
	
	public void save(Location location) {
		 locationRepository.save(location);
	}
	
	public Optional<Location> findById(Integer id) {
		return locationRepository.findById(id);
	}
	
	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}
}
