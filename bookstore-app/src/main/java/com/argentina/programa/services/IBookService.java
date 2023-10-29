package com.argentina.programa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.argentina.programa.models.Book;

@Service
public interface IBookService {
	
	public void saveBook(Book book);
	
	public List<Book> getAllBooks();
	
	public Book getBookById(Integer id);
	
	public void updateBook(Book book);
	
	public void deleteBook(Integer id);

}
