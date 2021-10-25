package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.Vehicle;
import com.kindsonthegenius.fleetapp.services.ClientService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.services.VehicleHireService;

@Controller
public class VehicleHireController {

	@Autowired private VehicleHireService vehicleHireService;
	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	@Autowired private ClientService clientService;

	@GetMapping("/vehiclehire")
	public String getVehicleHire(Model model) {
		
		List<VehicleHire> vehicleHires = vehicleHireService.getVehicleHire();
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<Location> locations = locationService.geLocations();
		List<Client> clients = clientService.getClient();

		model.addAttribute("vehicleHires", vehicleHires);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("locations", locations);
		model.addAttribute("clients", clients);

		return "vehiclehire";
	}
	
	@RequestMapping(value = "/vehiclehire/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}
	
	@PostMapping("vehiclehire/addNew")
	public String addNew(VehicleHire vehicleHire) {
		
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehiclehire";
	}
	
	@RequestMapping(value = "/vehiclehire/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehiclehire";
	}
	
	@RequestMapping("/vehiclehire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(Integer id) {
		return vehicleHireService.findById(id);
		
	}
}
