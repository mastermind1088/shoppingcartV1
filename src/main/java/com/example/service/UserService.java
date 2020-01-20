package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.CustomUser;

public interface UserService {
	
public long countUsers();
public void deleteUser(CustomUser entity);
public void deleteAllUsers();
public void deleteAllUsers(Iterable<? extends CustomUser> entities);
public void deleteByUserId(Long id);
public boolean existsByUserId(Long id);
public List<CustomUser> findAllUsers();
public List<CustomUser> findAllByUserId(Iterable<Long> ids);
public Optional<CustomUser> findByUserId(Long id);
public <S extends CustomUser> S saveUser(S entity);
public <S extends CustomUser> List<S> saveAllUsers(Iterable<S> entities);


}
