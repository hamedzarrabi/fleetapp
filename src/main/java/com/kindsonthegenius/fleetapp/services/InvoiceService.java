package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired private InvoiceRepository invoiceRepository;
	
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}

	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
		
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
		
	}

	public Optional<Invoice> findById(Integer id) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(id);
	}
	
	
	

}
