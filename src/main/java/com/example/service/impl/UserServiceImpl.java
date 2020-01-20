package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CustomUser;
import com.example.repo.UserRepository;
import com.example.service.UserService;

@Service @Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	public long countUsers() {
		return userRepository.count();
	}


	public void deleteUser(CustomUser entity) {
		userRepository.delete(entity);
	}


	public void deleteAllUsers() {
		userRepository.deleteAll();
	}


	public void deleteAllUsers(Iterable<? extends CustomUser> entities) {
		userRepository.deleteAll(entities);
		
	}


	public void deleteByUserId(Long id) {
		userRepository.deleteById(id);
		
	}


	public boolean existsByUserId(Long id) {
		return userRepository.existsById(id);
	}


	public List<CustomUser> findAllUsers() {
		return userRepository.findAll();
	}


	public List<CustomUser> findAllByUserId(Iterable<Long> ids) {
		return userRepository.findAllById(ids);
	}


	public Optional<CustomUser> findByUserId(Long id) {
		return userRepository.findById(id);
	}


	public <S extends CustomUser> S saveUser(S entity) {
		return userRepository.save(entity);
	}


	public <S extends CustomUser> List<S> saveAllUsers(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}}
