package com.example.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class UserCart {

	private Long userId;
	private Set<Product> productSet = new HashSet<>();
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Set<Product> getProductSet() {
		return productSet;
	}
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productSet == null) ? 0 : productSet.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserCart other = (UserCart) obj;
		if (productSet == null) {
			if (other.productSet != null)
				return false;
		} else if (!productSet.equals(other.productSet))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}
