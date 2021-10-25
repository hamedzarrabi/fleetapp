package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired private ContactRepository contactRepository;
	
	public List<Contact> getContact() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	public void save(Contact contact) {
		// TODO Auto-generated method stub
		contactRepository.save(contact);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
	}

	public Optional<Contact> findById(Integer id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id);
	}
	
	
	
	

}
