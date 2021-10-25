package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.services.ClientService;

@Controller
public class ClientController {

	@Autowired private ClientService clientService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;
	
	@GetMapping("/client")
	public String getClient(Model model) {
		
		List<Client> clients = clientService.getClient();
		List<Country> countries = countryService.getCountries();
		List<State> states = stateService.getStates();

		model.addAttribute("clients", clients);
		model.addAttribute("states", states);
		model.addAttribute("countries", countries);

		return "client";
	}
	
	@PostMapping("/client/addNew")
	public String addNew(Client client) {
		
		clientService.save(client);
		return "redirect:/client";
	}
	
	@RequestMapping(value = "/client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		clientService.delete(id);
		return "redirect:/client";
	}
	
	@RequestMapping(value = "/client/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/client";
	}
	
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findById(Integer id) {
		return clientService.findById(id);
	}
}
