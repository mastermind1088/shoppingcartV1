package com.example.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Apparal;
import com.example.model.Book;
import com.example.model.Cart;
import com.example.model.CustomUser;
import com.example.model.Product;
import com.example.model.Quantity;
import com.example.model.UserCart;
import com.example.service.ApparalService;
import com.example.service.BookService;
import com.example.service.CartService;
import com.example.service.ProductService;
import com.example.service.QuantityService;
import com.example.service.ShoppingCartService;
import com.example.service.UserService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,
readOnly=true) 
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	ApparalService apparalService;
	@Autowired
	QuantityService qtyService;

	@Override 	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false) 	
	public CustomUser creatUser(CustomUser user) {
		
		if (user.getCart()== null) {
		    Cart cart = new Cart();
		    user.setCart(cart);
		}
		cartService.saveCart(user.getCart());
		return userService.saveUser(user);

	}

	@Override
	public List<CustomUser> getAllUser() {
		
		return userService.findAllUsers();

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false) 
	public Optional<Cart> addProductToCart(Long productId, Long userId) {

		return productService.findByProductId(productId).map(p -> {

			Cart cart = userService.findByUserId(userId).get().getCart();

			if (cart.getProductList().stream().filter(p1 -> p1.getProductId().equals(p.getProductId())).findFirst()
					.isPresent()) {
				p.getQty().setQuantity(p.getQty().getQuantity() + 1);
				qtyService.saveQuantity(p.getQty());
			} else {
				if (null == p.getQty()) {
					Quantity qty = new Quantity();
					qty.setQuantity(1);
					qty.setProduct(p);
					qty.setCuser(userService.findByUserId(userId).get());
					p.setQty(qty);
					qtyService.saveQuantity(qty);

				}

			}
			long totalC = cart.getTotalCost() + p.getProductCost();
			cart.setTotalCost(totalC);
			cart.addProduct1(p);
			p.setCart(cart);
			productService.saveProduct(p);
			return cartService.saveCart(cart);

		});

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false) 
	public Optional<Object> reomoveProductFromCart(Long userId, Long productId) {
		return productService.findByProductId(productId).map(p -> {

			Cart cart = userService.findByUserId(userId).get().getCart();

			if (cart.getProductList().stream().filter(p1 -> p1.getProductId().equals(p.getProductId())).findFirst()
					.isPresent()) {

				long totalC = cart.getTotalCost() - (p.getQty().getQuantity() * p.getProductCost());
				cart.setTotalCost(totalC);
					Quantity qnty = qtyService.findByQuantityId(p.getQty().getqId()).get();
					qnty.setProduct(null);
					p.setQty(null);
					qnty.setCuser(null);
					p.getCart().removeProduct1(p);
					p.setCart(null);
					cart.getProductList().remove(p);
				productService.saveProduct(p);

			}
			return cartService.saveCart(cart);


		});
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false) 
	public Cart updateQuantityOfProduct(Long userId, Long productId, Integer qty) {
		Cart cart = userService.findByUserId(userId).get().getCart();

		if (cart.getProductList().stream().filter(p1 -> p1.getProductId().equals(productId)).findFirst().isPresent()) {
			Product p = cart.getProductList().stream().filter(p1 -> p1.getProductId().equals(productId)).findFirst()
					.get();
			if (qty == 0) {
				long previousProductCost = qty * p.getProductCost();
				long currentTotalCost = cart.getTotalCost() - previousProductCost;
				cart.setTotalCost(currentTotalCost);
				Quantity qnty = qtyService.findByQuantityId(p.getQty().getqId()).get();
				qnty.setProduct(null);
				p.setQty(null);
				qnty.setCuser(null);
				p.getCart().removeProduct1(p);
				p.setCart(null);
				cart.getProductList().remove(p);
			} else {
				if (qty > 0) {
					long prCost = p.getQty().getQuantity() * p.getProductCost();
					long lessPrevQuantTotalCost = cart.getTotalCost() - prCost;
					long newTotalCost = lessPrevQuantTotalCost + (qty * p.getProductCost());
					p.getQty().setQuantity(qty);
					cart.setTotalCost(newTotalCost);

				}

			}

			productService.saveProduct(p);
			cartService.saveCart(cart);
		}

		return cart;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false) 
	public Cart addListOfProductsToCart(Long userId, UserCart userCart) {

		Cart cart = userService.findByUserId(userId).get().getCart();

		userCart.getProductSet()
				.forEach(p -> {
					boolean isProductExist = productService.findByProductName(p.getProductName()).isPresent();
					if (isProductExist && !productService.findByProductName(p.getProductName()).empty().isPresent()) {
						Product pp = productService.findByProductName(p.getProductName()).get();
						if (cart.getProductList().stream().filter(p1 -> p1.getProductId().equals(pp.getProductId()))
								.findFirst().isPresent()) {
							pp.getQty().setQuantity(pp.getQty().getQuantity() + 1);
							qtyService.saveQuantity(pp.getQty());
						} else {
							Quantity qty = new Quantity();
							qty.setQuantity(1);
							qty.setProduct(pp);
							qty.setCuser(userService.findByUserId(userId).get());
							pp.setQty(qty);
							qtyService.saveQuantity(qty);
						}
						long totalC = cart.getTotalCost() + pp.getProductCost();
						cart.setTotalCost(totalC);
						cart.addProduct1(pp);
						pp.setCart(cart);
						productService.saveProduct(pp);
						cartService.saveCart(cart);
					}

				});

		return cart;
	}

	@Override
	public Optional<Cart> getProductsListFromCart(Long userId) {

		Cart cart = userService.findByUserId(userId).get().getCart();

		return cartService.findByCartId(cart.getCartId());
	}

	@Override
	public Cart removeAllProductFromCart(Long userId) {

		Cart cart = userService.findByUserId(userId).get().getCart();
		List<Product> plist = cart.getProductList().stream().collect(Collectors.toList());

		plist.stream().filter(p -> p != null).forEach(p -> {
			Quantity qnty = qtyService.findByQuantityId(p.getQty().getqId()).get();
			qnty.setProduct(null);
			p.setQty(null);
			qnty.setCuser(null);
			p.getCart().removeProduct1(p);
			p.setCart(null);
			cart.getProductList().remove(p);
			cart.setTotalCost(0L);
			productService.saveProduct(p);
			cartService.saveCart(cart);
		});

		return cart;
	}

	@Override
	public Product getProductsSearchByName(String productName) {

		List<Product> pList = (List<Product>) productService.findAllProducts();
		Optional<Product> resultProduct = pList.stream().filter(p -> p.getProductName().equals(productName)).findFirst();
		if (resultProduct.isPresent()) {
			return resultProduct.get();
		}
		return null;
	}

	@Override
	public Product getProductsSearchById(Long productId) {

		List<Product> pList = (List<Product>) productService.findAllProducts();
		Optional<Product> resultProduct = pList.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
		if (resultProduct.isPresent()) {
			return resultProduct.get();
		}
		return null;
	}

	@Override
	public List<Product> getProductsSearchByType(String pType) {

		List<Product> pList = (List<Product>) productService.findAllProducts();

		if (pType.equalsIgnoreCase("Book")) {
			return pList.stream().filter(p -> p instanceof Book).collect(Collectors.toList());
		} else if (pType.equalsIgnoreCase("Apparal")) {
			return pList.stream().filter(p -> p instanceof Apparal).collect(Collectors.toList());
		}
		return null;

	}

	@Override
	public List<Product> getproductsSearchProductCost(Long productCost) {

		return productService.findByproductCost(productCost);

	}

	@Override
	public List<Product> getProductsSearchBetweenProductCost(Long startCost, Long endCost) {

		return productService.findByproductCostBetween(startCost, endCost);

	}

}
