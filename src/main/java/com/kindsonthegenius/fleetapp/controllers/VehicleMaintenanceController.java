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
public class VehicleMaintenanceController {

	@Autowired private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired private VehicleService vehicleService;
	@Autowired private SupplierService supplierService;
	
	@GetMapping("/vehiclemaintenance")
	public String getMaintenance(Model model) {

		List<VehicleMaintenance> vehicleMaintenances = vehicleMaintenanceService.getVehicleMaintenances();
		List<Vehicle> vehicles = vehicleService.getVehicles();
		List<Supplier> suppliers = supplierService.getSupplier();

		model.addAttribute("vehicleMaintenances", vehicleMaintenances);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("suppliers", suppliers);

		return "vehiclemaintenance";
	}
	
	@RequestMapping(value = "/vehiclemaintenance/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehiclemaintenance";
	}
	
	@RequestMapping(value = "/vehiclemaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenance";
	}
	
	@RequestMapping("/vehiclemaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(Integer id) {
		return vehicleMaintenanceService.findById(id);
	}
	
	@PostMapping("/vehiclemaintenance/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenance";
	}
}
