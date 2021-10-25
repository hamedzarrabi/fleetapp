package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleMovementService;
import com.kindsonthegenius.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired private VehicleMovementService vehicleMovementService;
	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	
	
	@GetMapping("/vehiclemovement")
	public String getVehicleMovement(Model movement) {
		
		List<VehicleMovement> vehicleMovements = vehicleMovementService.getVehicleMovement();
		List<Location> locations = locationService.geLocations();
		List<Vehicle> vehicles = vehicleService.getVehicles();
		
		movement.addAttribute("vehicleMovements", vehicleMovements);
		movement.addAttribute("locations", locations);
		movement.addAttribute("vehicles", vehicles);
		
		return "vehiclemovement";
	}
	
	@RequestMapping(value = "/vehiclemovement/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete (Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:vehiclemovement";
	}
	
	@PostMapping("/vehiclemovement/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovement";
	}
	
	@RequestMapping("/vehiclemovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementService.findById(id);
	}
	
	@RequestMapping(value = "/vehiclemovement/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovement";
	}
}
