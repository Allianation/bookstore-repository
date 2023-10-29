package com.argentina.programa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argentina.programa.models.Book;
import com.argentina.programa.repositories.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public void updateBook(Book book) {
		this.saveBook(book);
	}

	@Override
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

}
