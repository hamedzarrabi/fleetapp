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

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public String getContact(Model model) {
		
		List<Contact> contacts = contactService.getContact();
		model.addAttribute("contacts", contacts);
		
		return "contact";
	}
	
	@PostMapping("/contact/addNew")
	public String addNew(Contact contact) {
		
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping(value = "/contact/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		contactService.delete(id);
		return "redirect:/contact";
	}
	
	@RequestMapping(value = "/contact/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findById(Integer id) {
		return contactService.findById(id);
	}
	
}
