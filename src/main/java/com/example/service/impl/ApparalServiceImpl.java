package com.example.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Apparal;
import com.example.repo.ApparalRepository;
import com.example.service.ApparalService;
@Service  
@Transactional(propagation=Propagation.SUPPORTS,
readOnly=true) 
public class ApparalServiceImpl implements ApparalService {


	@Autowired
	ApparalRepository apparalRepository;
	



	
	public long countApparal() {
		return apparalRepository.count();
	}


	public void deleteApparal(Apparal entity) {
		apparalRepository.delete(entity);
	}


	public void deleteAllApparals() {
		apparalRepository.deleteAll();
	}


	public void deleteAllApparals(Iterable<? extends Apparal> entities) {
		apparalRepository.deleteAll(entities);
		
	}


	public void deleteByApparalId(Long id) {
		apparalRepository.deleteById(id);
		
	}



	public List<Apparal> findAllApparals() {
		return apparalRepository.findAll();
	}


	public List<Apparal> findAllByApparalId(Iterable<Long> ids) {
		return apparalRepository.findAllById(ids);
	}


	public Optional<Apparal> findByApparalId(Long id) {
		return apparalRepository.findById(id);
	}


	public <S extends Apparal> S saveApparal(S entity) {
		return apparalRepository.save(entity);
	}


	public <S extends Apparal> List<S> saveAllApparals(Iterable<S> entities) {
		return apparalRepository.saveAll(entities);
	}


	public boolean existsByApparalId(Long id) {
		return apparalRepository.existsById(id);
	}
	
}
