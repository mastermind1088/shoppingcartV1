package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Optional<Product> findByProductName(String productName);
	public List<Product>  findByCartCartId(Long cartId);
	public List<Product> findByproductCost(Long productCost);
	public List<Product> findByproductCostBetween(Long startCost,Long endCost);
}
