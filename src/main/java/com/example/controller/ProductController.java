package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController

public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public List<Product> allproduct() {
		return (List<Product>) productService.findAllProducts();
		
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public Product addproduct(@RequestBody Product product) {
		return productService.saveProduct(product) ;
		
	}
	
	@RequestMapping(value="/product/{productId}", method=RequestMethod.PUT)
	public Product addproduct(@PathVariable("productId") Long Id,@RequestBody Product product) {
		return productService.saveProduct(product) ;
		
	}
	
	@RequestMapping(value="/product/{productId}", method=RequestMethod.DELETE)
	public void addproduct(@PathVariable("productId") Long Id) {
		 productService.deleteByProductId(Id);
		
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable("id") Long id) {
		return  productService.findByProductId(id);
		
	}
	
	
}
