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

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;
import com.kindsonthegenius.fleetapp.services.SupplierService;
import com.kindsonthegenius.fleetapp.services.SupplierService;

@Controller
public class SupplierController {

	@Autowired private SupplierService supplierService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;
	
	@GetMapping("/supplier")
	public String getSupplier(Model model) {
		
		List<Supplier> suppliers = supplierService.getSupplier();
		List<Country> countries = countryService.getCountries();
		List<State> states = stateService.getStates();
		
		model.addAttribute("states", states);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("countries", countries);
		
		return "supplier";
	}
	
	@PostMapping("/supplier/addNew")
	public String addNew(Supplier supplier) {
		
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	@RequestMapping(value = "/supplier/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		supplierService.delete(id);
		return "redirect:/supplier";
	}
	
	@RequestMapping(value = "/supplier/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/supplier";
	}
	
	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(Integer id) {
		return supplierService.findById(id);
	}
	
	
}
