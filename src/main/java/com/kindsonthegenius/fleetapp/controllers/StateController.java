package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.State;

import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/states")
	public String getStates(Model model) {
		
		List<State> states = stateService.getStates();
		model.addAttribute("states", states);

		List<Country> countries = countryService.getCountries();
		model.addAttribute("countries", countries);


		return "state";
	}
	
	@RequestMapping(value = "/states/findById")
	@ResponseBody
	public Optional<State> findById(Integer id) {
		return stateService.findById(id);
	}
	
	@PostMapping("/states/addNew")
	public String addNew(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		stateService.delete(id);
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.POST})
	public String update(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
}
