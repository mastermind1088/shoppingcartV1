package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repo.ProductRepository;
import com.example.service.ProductService;

@Service @Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public long countProduct() {
		return productRepository.count();
	}

	
	public void deleteProduct(Product entity) {
		productRepository.delete(entity);
	}

	
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}

	
	public void deleteAllProducts(Iterable<? extends Product> entities) {
		productRepository.deleteAll(entities);
		
	}

	
	public void deleteByProductId(Long id) {
		productRepository.deleteById(id);
		
	}

	
	public boolean existsByProductId(Long id) {
		return productRepository.existsById(id);
	}

	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	
	public List<Product> findAllByProductId(Iterable<Long> ids) {
		return productRepository.findAllById(ids);
	}

	
	public Optional<Product> findByProductId(Long id) {
		return productRepository.findById(id);
	}

	
	public <S extends Product> S saveProduct(S entity) {
		return productRepository.save(entity);
	}

	
	public <S extends Product> List<S> saveAllProducts(Iterable<S> entities) {
		return productRepository.saveAll(entities);
	}

	
	public Optional<Product> findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

	
	public List<Product> findByCartCartId(Long cartId) {
		return productRepository.findByCartCartId(cartId);
	}

	
	public List<Product> findByproductCost(Long productCost) {
		return productRepository.findByproductCost(productCost);
	}


	public List<Product> findByproductCostBetween(Long startCost, Long endCost) {
		
		return productRepository.findByproductCostBetween(startCost, endCost);
	}


}
