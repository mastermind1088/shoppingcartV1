package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cart;
import com.example.model.CustomUser;
import com.example.model.Product;
import com.example.model.UserCart;
import com.example.service.ShoppingCartService;

/**
 * @author M1051088
 *
 */
@RestController
public class ShoppingCartController {

	/**
	 * Shpping Cart Service
	 */
	@Autowired
	ShoppingCartService shoppingCartService;

	
	/**
	 * 
	 * 
	 * create new user by passing request Body 
	 *  {
     *    "userName" : "mindtree",
	 *        
	 *   }     
	
	 * 
	 * @param user
	 * @return
	 */
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public CustomUser creatUser(@RequestBody CustomUser user) {
		return shoppingCartService.creatUser(user);
	}
	
	
	
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<CustomUser> getAllUser() {
		return shoppingCartService.getAllUser();
	}


	/**
	 * adding product to cart by product Id 
	 * 
	 * @param productId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "user/{userId}/products/{productId}", method = RequestMethod.POST)
	public Optional<Cart> addProductToCart(@PathVariable("productId") Long productId,
			@PathVariable("userId") Long userId) {
		return shoppingCartService.addProductToCart(productId, userId);
	}

	/**
	 * 
	 * removing product by id.
	 * 
	 * @param userId
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "user/{userId}/products/{productId}", method = RequestMethod.DELETE)
	public Optional<Object> reomoveProductFromCart(@PathVariable("userId") Long userId,
			@PathVariable("productId") Long productId) {
		return shoppingCartService.reomoveProductFromCart(userId, productId);
	}

	/**
	 * 
	 * Update quantity with new quantity
	 * 
	 * @param userId
	 * @param productId
	 * @param qty
	 * @return
	 */
	@RequestMapping(value = "user/{userId}/products/{productId}/quantity/{qty}", method = RequestMethod.PUT)
	public Cart updateQuantityOfProduct(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId,
			@PathVariable("qty") Integer qty) {
		return shoppingCartService.updateQuantityOfProduct(userId, productId, qty);
	}

	/**
	 * adding list of product to cart *****Product Name is mandatory*** 
	 * 
	 * 
	 * @param userId
	 * @param userCart
	 * @return
	 */
	@RequestMapping(value = "user/{userId}/products", method = RequestMethod.POST)
	public Cart addProductsListToCart(@PathVariable("userId") Long userId, @RequestBody UserCart userCart) {
		return shoppingCartService.addListOfProductsToCart(userId, userCart);
	}

	/**
	 * get the all products that are added to cart
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "user/{userId}/products", method = RequestMethod.GET)
	public Optional<Cart> getAllProductsOfCart(@PathVariable("userId") Long userId) {
		return shoppingCartService.getProductsListFromCart(userId);
	}

	/**
	 * remove all products from cart 
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "user/{userId}/products", method = RequestMethod.DELETE)
	public Cart removeAllProductsFromCart(@PathVariable("userId") Long userId) {
		return shoppingCartService.removeAllProductFromCart(userId);
	}

	/**
	 * 
	 * search product by product name 
	 * @param pName
	 * @return
	 */
	@RequestMapping(value = "productsSearchByName/{productName}", method = RequestMethod.GET)
	public Product getProductsSearchByName(@PathVariable("productName") String productName) {
		return shoppingCartService.getProductsSearchByName(productName);
	}

	/**
	 * ssearch product by product name  Id
	 * 
	 * @param pId
	 * @return
	 */
	@RequestMapping(value = "productsSearchById/{productId}", method = RequestMethod.GET)
	public Product getProductsSearchById(@PathVariable("productId") Long productId) {
		return shoppingCartService.getProductsSearchById(productId);
	}

	/**
	 * 
	 * search product by product type
	 * 
	 * @param pType
	 * @return
	 */
	@RequestMapping(value = "productsSearchByType/{productType}", method = RequestMethod.GET)
	public List<Product> getProductsSearchByType(@PathVariable("productType") String productType) {
		return shoppingCartService.getProductsSearchByType(productType);
	}

	/**
	 * search by product by cost
	 * 
	 * @param productCost
	 * @return
	 */
	@RequestMapping(value = "productsSearchByProductCost/{productCost}", method = RequestMethod.GET)
	public List<Product> getProductsSearchProductCost(@PathVariable("productCost") Long productCost) {
		return shoppingCartService.getproductsSearchProductCost(productCost);
	}
	
	
	/**
	 * search by product by cost
	 * 
	 * @param productCost
	 * @return
	 */
	@RequestMapping(value = "productsSearchByProductCostRange/{startCost}/{endCost}", method = RequestMethod.GET)
	public List<Product> getproductsSearchBetweenProductCost(@PathVariable("startCost") Long startCost,@PathVariable("endCost") Long endCost) {
		
		return shoppingCartService.getProductsSearchBetweenProductCost(startCost, endCost);
	}

}
