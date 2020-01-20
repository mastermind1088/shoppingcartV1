package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Product;

public interface ProductService {

	
public long countProduct();
public void deleteProduct(Product entity);
public void deleteAllProducts();
public void deleteAllProducts(Iterable<? extends Product> entities);
public void deleteByProductId(Long id);
public boolean existsByProductId(Long id);
public List<Product> findAllProducts();
public List<Product> findAllByProductId(Iterable<Long> ids);
public Optional<Product> findByProductId(Long id);
public <S extends Product> S saveProduct(S entity);
public <S extends Product> List<S> saveAllProducts(Iterable<S> entities);
public Optional<Product> findByProductName(String productName);
public List<Product>  findByCartCartId(Long cartId);
public List<Product> findByproductCost(Long productCost);
public List<Product> findByproductCostBetween(Long startCost,Long endCost);


}
