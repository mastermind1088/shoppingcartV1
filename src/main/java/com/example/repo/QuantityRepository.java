package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Quantity;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Long> {

}
