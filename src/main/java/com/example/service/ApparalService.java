package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Apparal;

public interface ApparalService {
	
public long countApparal();
public void deleteApparal(Apparal entity);
public void deleteAllApparals();
public void deleteAllApparals(Iterable<? extends Apparal> entities);
public void deleteByApparalId(Long id);
public boolean existsByApparalId(Long id);
public List<Apparal> findAllApparals();
public List<Apparal> findAllByApparalId(Iterable<Long> ids);
public Optional<Apparal> findByApparalId(Long id);
public <S extends Apparal> S saveApparal(S entity);
public <S extends Apparal> List<S> saveAllApparals(Iterable<S> entities);


}
