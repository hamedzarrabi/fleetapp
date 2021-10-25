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

import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {

	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehiclemake")
	public String getVehicleMake(Model model) {
		
		List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMake();
		model.addAttribute("vehicleMakes", vehicleMakes);
		return "vehiclemake";
	}
	
	@RequestMapping(value = "/vehiclemake/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehiclemake";
	}
	
	@RequestMapping(value = "/vehiclemake/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(Integer id) {
		return vehicleMakeService.findById(id);
	}
	
	@RequestMapping(value = "/vehiclemake/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemake";
	}
	
	@PostMapping("vehiclemake/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemake";
	}
	
}
