package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired private JobTitleRepository jobTitleRepository;
	
	
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		
	}


	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
		
	}


	public Optional<JobTitle> findById(Integer id) {
		// TODO Auto-generated method stub
		return jobTitleRepository.findById(id);
	}


	public List<JobTitle> getJobTitles() {
		// TODO Auto-generated method stub
		return jobTitleRepository.findAll();
	}
	
	
	
	

}
