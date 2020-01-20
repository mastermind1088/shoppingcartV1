package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.model.Book;
import com.example.repo.BookRepository;
import com.example.service.BookService;

@Service @Transactional
public class BookServiceImpl implements BookService {


	@Autowired
	BookRepository bookRepository;
	
	
	public long countBook() {
		return bookRepository.count();
	}

	
	public void deleteBook(Book entity) {
		bookRepository.delete(entity);
	}

	
	public void deleteAllBooks() {
		bookRepository.deleteAll();
	}

	
	public void deleteAllBooks(Iterable<? extends Book> entities) {
		bookRepository.deleteAll(entities);
		
	}

	
	public void deleteByBookId(Long id) {
		bookRepository.deleteById(id);
		
	}


	
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	
	public List<Book> findAllByBookId(Iterable<Long> ids) {
		return bookRepository.findAllById(ids);
	}

	
	public Optional<Book> findByBookId(Long id) {
		return bookRepository.findById(id);
	}

	
	public <S extends Book> S saveBook(S entity) {
		return bookRepository.save(entity);
	}

	
	public <S extends Book> List<S> saveAllBooks(Iterable<S> entities) {
		return bookRepository.saveAll(entities);
	}

	public boolean existsByBookId(Long id) {
		return bookRepository.existsById(id);
	}
}
