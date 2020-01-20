package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.model.Apparal;
import com.example.model.Book;
import com.example.service.ApparalService;
import com.example.service.BookService;

@SpringBootApplication
public class ShoppingcartV1Application {
	
	@Autowired
	BookService bookService;
	@Autowired
	ApparalService apparalService;
	public static void main(String[] args) {
		
		SpringApplication.run(ShoppingcartV1Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
	    System.out.println("Pushing data to Database");
	    bookService.deleteAllBooks();
	    apparalService.deleteAllApparals();
	    
	    Book b1 =  new Book();
	    b1.setProductName("Karwalo");
	    b1.setProductDescription("kannada book");
	    b1.setProductCost(100L);
	    b1.setAuthor("Raja");
	    b1.setGenre("Science");
	    b1.setPublications("Best  publications");
	    Book b2 =  new Book();
	    b2.setProductName("Ramayan");
	    b2.setProductDescription("kannada book");
	    b2.setProductCost(100L);
	    b2.setAuthor("Raja1231");
	    b2.setGenre("Devine");
	    b2.setPublications("Best  publications");
	    Book b3 =  new Book();
	    b3.setProductName("Yaana");
	    b3.setProductDescription("kannada book");
	    b3.setProductCost(100L);
	    b3.setAuthor("Raja222");
	    b3.setGenre("space travel");
	    b3.setPublications("Best  publications");
	    Book b4 =  new Book();
	    b4.setProductName("Kanasu");
	    b4.setProductDescription("kannada book");
	    b4.setProductCost(100L);
	    b4.setAuthor("Rajasdsad");
	    b4.setGenre("Horoasdsadr");
	    b4.setPublications("Best  publications");
	    bookService.saveBook(b1);
	    bookService.saveBook(b2);
	    bookService.saveBook(b3);
	    bookService.saveBook(b4);
	    
	    Apparal a1 = new Apparal();
	    a1.setProductName(" T Shirt");
	    a1.setProductDescription("T shirt");
	    a1.setProductCost(10099L);
	    a1.setBrand("brro");
	    a1.setType("men");
	    a1.setDesign("daijd");
	    Apparal a2 = new Apparal();
	    a2.setProductName("full Shirt");
	    a2.setProductDescription("shirt");
	    a2.setProductCost(10099L);
	    a2.setBrand("Tulip");
	    a2.setType("women");
	    a2.setDesign("dojak");
	    
	    Apparal a3 = new Apparal();
	    a3.setProductName("cap");
	    a3.setProductDescription("cap");
	    a3.setProductCost(10099L);
	    a3.setBrand("Pulipwqdwq");
	    a3.setType("boy");
	    a3.setDesign("modas");
	    apparalService.saveApparal(a1);
	    apparalService.saveApparal(a2);
	    apparalService.saveApparal(a3);
	    
	    
	    
	    
	}
	
}
