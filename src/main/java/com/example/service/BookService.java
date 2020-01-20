package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Book;

public interface BookService {
	
public long countBook();
public void deleteBook(Book entity);
public void deleteAllBooks();
public void deleteAllBooks(Iterable<? extends Book> entities);
public void deleteByBookId(Long id);
public boolean existsByBookId(Long id);
public List<Book> findAllBooks();
public List<Book> findAllByBookId(Iterable<Long> ids);
public Optional<Book> findByBookId(Long id);
public <S extends Book> S saveBook(S entity);
public <S extends Book> List<S> saveAllBooks(Iterable<S> entities);


}
