package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cart;
import com.example.repo.CartRepository;
import com.example.service.CartService;

@Service @Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	public long countCart() {
		return cartRepository.count();
	}


	public void deleteCart(Cart entity) {
		cartRepository.delete(entity);
	}


	public void deleteAllCarts() {
		cartRepository.deleteAll();
	}


	public void deleteAllCarts(Iterable<? extends Cart> entities) {
		cartRepository.deleteAll(entities);
		
	}


	public void deleteByCartId(Long id) {
		cartRepository.deleteById(id);
		
	}


	public boolean existsByCartId(Long id) {
		return cartRepository.existsById(id);
	}


	public List<Cart> findAllCarts() {
		return cartRepository.findAll();
	}


	public List<Cart> findAllByCartId(Iterable<Long> ids) {
		return cartRepository.findAllById(ids);
	}


	public Optional<Cart> findByCartId(Long id) {
		return cartRepository.findById(id);
	}


	public <S extends Cart> S saveCart(S entity) {
		return cartRepository.save(entity);
	}


	public <S extends Cart> List<S> saveAllCarts(Iterable<S> entities) {
		return cartRepository.saveAll(entities);
	}}
