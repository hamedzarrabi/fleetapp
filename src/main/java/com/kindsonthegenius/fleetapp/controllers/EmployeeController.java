package com.kindsonthegenius.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import com.kindsonthegenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetapp.models.Employee;

@Controller
public class EmployeeController {

	@Autowired private EmployeeService employeeService;
	@Autowired private JobTitleService jobTitleService;
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;

	@GetMapping("/employee")
	public String getEmployee(Model model) {


		model.addAttribute("employees", employeeService.getEmployee());
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeType());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());

		return "employee";
	}
	
	@PostMapping("/employee/addNew")
	public String addNew(Employee employee) {
		
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@RequestMapping(value = "/employee/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		employeeService.delete(id);
		return "redirect:/employee";
	}
	
	@RequestMapping(value = "/employee/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee";
	}
	
	@RequestMapping("/employee/findById")
	@ResponseBody
	public Optional<Employee> findById(Integer id) {
		return employeeService.findById(id);
	}
}
