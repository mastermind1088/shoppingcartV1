package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table

public class Quantity {

	@Id @GeneratedValue
	private Long qId;
	@Column
	private int quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	Product product;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuser == null) ? 0 : cuser.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((qId == null) ? 0 : qId.hashCode());
		result = prime * result + quantity;
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
		Quantity other = (Quantity) obj;
		if (cuser == null) {
			if (other.cuser != null)
				return false;
		} else if (!cuser.equals(other.cuser))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (qId == null) {
			if (other.qId != null)
				return false;
		} else if (!qId.equals(other.qId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	CustomUser cuser;
	
	
	/**
	 * @return the cuser
	 */
	public CustomUser getCuser() {
		return cuser;
	}
	/**
	 * @param cuser the cuser to set
	 */
	public void setCuser(CustomUser cuser) {
		this.cuser = cuser;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the qId
	 */
	public Long getqId() {
		return qId;
	}
	/**
	 * @param qId the qId to set
	 */
	public void setqId(Long qId) {
		this.qId = qId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
