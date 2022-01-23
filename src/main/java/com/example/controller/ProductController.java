package com.example.controller;

import java.util.List;

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
	public void deleteproduct(@PathVariable("productId") Long Id) {
		 productService.deleteByProductId(Id);
		
	}
	
	@RequestMapping(value="/product", method=RequestMethod.DELETE)
	public void deleteProduct() {
		 productService.deleteAllProducts();
		
	}
	
	
}
