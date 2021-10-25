package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.User;
import com.kindsonthegenius.fleetapp.repositories.UserRepository;


@Service
public class UserService {

	@Autowired private BCryptPasswordEncoder encoder;
	@Autowired private UserRepository userRepository;
	
	public List<User> getUsers() {
		return userRepository.findAll();
		
	}

	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	

}
