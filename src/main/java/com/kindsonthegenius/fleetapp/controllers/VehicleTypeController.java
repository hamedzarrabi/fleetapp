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

import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;


	@Controller
	public class VehicleTypeController {

		@Autowired private VehicleTypeService vehicleTypeService;
		
		@GetMapping("/vehicletype")
		public String getVehicleType(Model model) {
			
			List<VehicleType> vehicleType = vehicleTypeService.getVehicleType();
			model.addAttribute("vehicleType", vehicleType);
			return "/vehicletype";
		}
		
		@RequestMapping(value = "/vehicletype/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
		public String delete (Integer id) {
			vehicleTypeService.delete(id);
			return "redirect:/vehicletype";
		}
		
		@PostMapping("/vehicletype/addNew")
		public String addNew(VehicleType vehicleType) {
			vehicleTypeService.save(vehicleType);
			return "redirect:/vehicletype";
		}
		
		@RequestMapping("/vehicletype/findById")
		@ResponseBody
		public Optional<VehicleType> findById(Integer id) {
			return vehicleTypeService.findById(id);
		}
		
		@RequestMapping(value = "/vehicletype/update", method = {RequestMethod.PUT, RequestMethod.GET})
		public String update(VehicleType vehicleType) {
			vehicleTypeService.save(vehicleType);
			return "redirect:/vehicletype";
		}
}
