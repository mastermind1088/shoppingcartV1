package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Quantity;

public interface QuantityService {
	
public long countQuantity();
public void deleteQuantity(Quantity entity);
public void deleteAllQuantitys();
public void deleteAllQuantitys(Iterable<? extends Quantity> entities);
public void deleteByQuantityId(Long id);
public boolean existsByQuantityId(Long id);
public List<Quantity> findAllQuantitys();
public List<Quantity> findAllByQuantityId(Iterable<Long> ids);
public Optional<Quantity> findByQuantityId(Long id);
public <S extends Quantity> S saveQuantity(S entity);
public <S extends Quantity> List<S> saveAllQuantitys(Iterable<S> entities);


}
