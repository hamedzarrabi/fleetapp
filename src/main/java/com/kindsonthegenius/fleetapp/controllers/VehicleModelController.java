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

import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired private VehicleModelService vehicleModelService;
	
	@GetMapping("/vehiclemodel")
	public String getVehicleModel(Model model) {
		
		List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModel();
		model.addAttribute("vehicleModels", vehicleModels);
		return "vehiclemodel";
	}
	
	@RequestMapping(value = "/vehiclemodel/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete (Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/vehiclemodel";
	}
	
	@PostMapping("/vehiclemodel/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodel";
	}
	
	@RequestMapping("/vehiclemodel/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(Integer id) {
		return vehicleModelService.findById(id);
	}
	
	@RequestMapping(value = "/vehiclemodel/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodel";
	}
}
