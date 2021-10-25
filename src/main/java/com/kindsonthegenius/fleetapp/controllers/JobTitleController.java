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

import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {


	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping("/jobtitle")
	public String getJobTitle(Model model) {
		
		List<JobTitle> jobTitles = jobTitleService.getJobTitles();
		model.addAttribute("jobTitles", jobTitles);
		
		return "jobtitle";
	}
	
	@PostMapping("/jobtitle/addNew")
	public String addNew(JobTitle jobTitle) {
		
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitle";
	}
	
	@RequestMapping(value = "/jobtitle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		jobTitleService.delete(id);
		return "redirect:/jobtitle";
	}
	
	@RequestMapping(value = "/jobtitle/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitle";
	}
	
	@RequestMapping("/jobtitle/findById")
	@ResponseBody
	public Optional<JobTitle> findById(Integer id) {
		return jobTitleService.findById(id);
	}
	
	
	
}
