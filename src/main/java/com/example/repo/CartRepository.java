package com.example.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cart;

@Repository 
public interface CartRepository extends JpaRepository<Cart, Long> {

}
