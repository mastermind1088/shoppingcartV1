package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Quantity;
import com.example.repo.QuantityRepository;
import com.example.service.QuantityService;

@Service @Transactional
public class QtyServicesImpl implements QuantityService {

	@Autowired
	QuantityRepository quantityRepository;

	public long countQuantity() {
		return quantityRepository.count();
	}


	public void deleteQuantity(Quantity entity) {
		quantityRepository.delete(entity);
	}


	public void deleteAllQuantitys() {
		quantityRepository.deleteAll();
	}


	public void deleteAllQuantitys(Iterable<? extends Quantity> entities) {
		quantityRepository.deleteAll(entities);
		
	}


	public void deleteByQuantityId(Long id) {
		quantityRepository.deleteById(id);
		
	}


	public boolean existsByQuantityId(Long id) {
		return quantityRepository.existsById(id);
	}


	public List<Quantity> findAllQuantitys() {
		return quantityRepository.findAll();
	}


	public List<Quantity> findAllByQuantityId(Iterable<Long> ids) {
		return quantityRepository.findAllById(ids);
	}


	public Optional<Quantity> findByQuantityId(Long id) {
		return quantityRepository.findById(id);
	}


	public <S extends Quantity> S saveQuantity(S entity) {
		return quantityRepository.save(entity);
	}


	public <S extends Quantity> List<S> saveAllQuantitys(Iterable<S> entities) {
		return quantityRepository.saveAll(entities);
	}}
