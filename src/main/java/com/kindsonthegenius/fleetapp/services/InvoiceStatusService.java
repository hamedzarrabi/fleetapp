package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.InvoiceStatus;
import com.kindsonthegenius.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired private InvoiceStatusRepository invoiceStatusRepository;
	
	public Optional<InvoiceStatus> findById(Integer id) {
		// TODO Auto-generated method stub
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		invoiceStatusRepository.deleteById(id);
	}

	public void save(InvoiceStatus invoiceStatus) {
		// TODO Auto-generated method stub
		invoiceStatusRepository.save(invoiceStatus);
	}

	public List<InvoiceStatus> getInvoiceStatus() {
		// TODO Auto-generated method stub
		return invoiceStatusRepository.findAll();
	}
	
	
	
	

}
