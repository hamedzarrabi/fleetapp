package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.repositories.StateRepository;


@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	//get all sates
	public List<State> getStates() {
		return stateRepository.findAll();
	}
	
	//find id
	public Optional<State> findById(Integer id) {
		return stateRepository.findById(id);
	}
	
	//insert in state
	public void save(State state) {
		stateRepository.save(state);
	}
	
	//delete from state 
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}

}
