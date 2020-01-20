package com.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity @Table
public class Cart  {
	@Id 
	@GenericGenerator(name="cart_id",strategy="com.example.customid.CartIdGenerators")
	@GeneratedValue(generator="cart_id")
	private Long cartId;
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	
	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long long1) {
		this.totalCost = long1;
	}

	@Column
	private Long totalCost=0L;


	@OneToMany(cascade = CascadeType.ALL, mappedBy="cart")
	private Set<Product> productList = new HashSet<>();
	
	public Set<Product> getProductList() {
		return productList;
	}

	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}

	
	public void addProduct1(Product product) {
		this.getProductList().add(product);
		product.setCart(this);
	}
	
	public void removeProduct1(Product product) {
		this.getProductList().remove(product);
		
	}


	
	
}
