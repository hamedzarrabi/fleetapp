package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired private ClientRepository clientRepository;
	
	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	public void save(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	public Optional<Client> findById(Integer id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id);
	}
	

}
