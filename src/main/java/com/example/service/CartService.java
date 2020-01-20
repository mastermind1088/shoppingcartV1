package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Cart;

public interface CartService {
	
public long countCart();
public void deleteCart(Cart entity);
public void deleteAllCarts();
public void deleteAllCarts(Iterable<? extends Cart> entities);
public void deleteByCartId(Long id);
public List<Cart> findAllCarts();
public List<Cart> findAllByCartId(Iterable<Long> ids);
public Optional<Cart> findByCartId(Long id);
public <S extends Cart> S saveCart(S entity);
public <S extends Cart> List<S> saveAllCarts(Iterable<S> entities);
boolean existsByCartId(Long id);


}
