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
import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.LocationService;
import com.kindsonthegenius.fleetapp.services.StateService;

@Controller
public class LocationController {

	@Autowired private LocationService locationService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;
	
	
	@PostMapping("/location/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/location";
	}
	
	@RequestMapping(value = "/location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		locationService.delete(id);
		return "redirect:/location";
	}
	
	@GetMapping("/location")
	public String getLocation(Model model) {
		
		List<State> states = stateService.getStates();
		List<Country> countries = countryService.getCountries();
		List<Location> locations = locationService.geLocations();
		
		model.addAttribute("locations", locations);
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		
		return "location";
		
	}
	
	@RequestMapping(value = "/location/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Location location) {
		
		locationService.save(location);
		return "redirect:/location";
	}
	
	
	@GetMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findById(Integer id) {
		return locationService.findById(id);
	}
}
