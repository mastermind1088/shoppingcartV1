package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PRODUCT_TYPE")

public class Product {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	@Column
	private String productDescription;
	@Column
	private String productName;
	@Column
	private Long productCost;
	
	
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductCost() {
		return productCost;
	}
	public void setProductCost(Long productCost) {
		this.productCost = productCost;
	}
	
	@ManyToOne()
	@JsonIgnore
	@JoinTable(name="cart_product",joinColumns= 
     {
    		 @JoinColumn(name="product_Id" , referencedColumnName = "productId")
     },
	inverseJoinColumns= {@JoinColumn(name="cart_Id",  referencedColumnName = "cartId")})
	private Cart cart;

	@OneToOne(cascade = CascadeType.ALL, mappedBy="product",orphanRemoval=true)
	private Quantity qty;
	/**
	 * @return the qty
	 */
	public Quantity getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(Quantity qty) {
		this.qty = qty;
	}




	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((productCost == null) ? 0 : productCost.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (productCost == null) {
			if (other.productCost != null)
				return false;
		} else if (!productCost.equals(other.productCost))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		
		return true;
	}
	
	

}
