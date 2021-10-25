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

import com.kindsonthegenius.fleetapp.models.InvoiceStatus;
import com.kindsonthegenius.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {


	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@GetMapping("/invoicestatus")
	public String getInvoiceStatus(Model model) {
		
		List<InvoiceStatus> invoiceStatus = invoiceStatusService.getInvoiceStatus();
		model.addAttribute("invoiceStatus", invoiceStatus);
		
		return "invoicestatus";
	}
	
	@PostMapping("/invoicestatus/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping(value = "/invoicestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping(value = "/invoicestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatus";
	}
	
	@RequestMapping("/invoicestatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(Integer id) {
		return invoiceStatusService.findById(id);
	}
	
}
