package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Cart;
import com.example.model.CustomUser;
import com.example.model.Product;
import com.example.model.UserCart;

public interface ShoppingCartService {
	
	public CustomUser creatUser(CustomUser user);
	public List<CustomUser> getAllUser();
	public Optional<Cart> addProductToCart(Long productId,Long userId);
	public Optional<Object> reomoveProductFromCart(Long userId, Long productId);
	public Cart updateQuantityOfProduct(Long userId,Long productId,Integer qty);
	public Cart addListOfProductsToCart(Long userId,UserCart userCart);
	public Optional<Cart> getProductsListFromCart(Long userId);
	public Cart removeAllProductFromCart(Long userId);
    public Product getProductsSearchByName(String productName);
    public Product getProductsSearchById(Long productId);
    public List<Product> getProductsSearchByType(String pType);
    public List<Product> getproductsSearchProductCost(Long productCost);
    public List<Product> getProductsSearchBetweenProductCost(Long startCost,Long endCost); 
    
}
