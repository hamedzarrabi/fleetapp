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

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.models.InvoiceStatus;
import com.kindsonthegenius.fleetapp.services.ClientService;
import com.kindsonthegenius.fleetapp.services.InvoiceService;
import com.kindsonthegenius.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {

	@Autowired private InvoiceService invoiceService;
	@Autowired private ClientService clientService;
	@Autowired private InvoiceStatusService invoiceStatusService;
	
	
	@GetMapping("/invoice")
	public String getInvoices(Model model) {
		List<Invoice> invoices = invoiceService.getInvoices();
		List<Client> clients = clientService.getClient();
		List<InvoiceStatus> invoiceStatus = invoiceStatusService.getInvoiceStatus();
		
		model.addAttribute("invoices", invoices);
		model.addAttribute("clients", clients);
		model.addAttribute("invoiceStatus", invoiceStatus);
		
		return "invoice";
	}
	
	@PostMapping("/invoice/addNew")
	public String addNew(Invoice invoice) {
		
		invoiceService.save(invoice);
		return "redirect:/invoice";
			
	}
	
	@RequestMapping(value = "/invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		
		invoiceService.delete(id);
		return "redirect:/invoice";
	}
	
	
	@RequestMapping(value = "/invoice/findById")
	@ResponseBody
	public Optional<Invoice> fingById(Integer id) {
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value = "/invoice/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoice";
	}
	
	
	
	
}
