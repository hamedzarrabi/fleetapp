package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import com.kindsonthegenius.fleetapp.models.*;
import com.kindsonthegenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VehicleController {

	@Autowired private VehicleService vehicleService;
	@Autowired private LocationService locationService;
	@Autowired private EmployeeService employeeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleStatusService vehicleStatusService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleModelService vehicleModelService;

	@GetMapping("/vehicle")
	public String getVehicle(Model model) {
		
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<Location> locations = locationService.geLocations();
		List<Employee> employees = employeeService.getEmployee();
		List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMake();
		List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatus();
		List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleType();
		List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModel();

		model.addAttribute("vehicles", vehicles);
		model.addAttribute("locations", locations);
		model.addAttribute("employees", employees);
		model.addAttribute("vehicleMakes", vehicleMakes);
		model.addAttribute("vehicleStatuses", vehicleStatuses);
		model.addAttribute("vehicleTypes", vehicleTypes);
		model.addAttribute("vehicleModels", vehicleModels);

		return "vehicle";
	}
	
	@PostMapping("/vehicle/addNew")
	public String addNew(Vehicle vehicle) {
		
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping(value = "/vehicle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		vehicleService.delete(id);
		return "redirect:/vehicle";
	}
	
	@RequestMapping(value = "/vehicle/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findById(Integer id) {
		return vehicleService.findById(id);
	}
	
	
}
