package com.argentina.programa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argentina.programa.models.Book;
import com.argentina.programa.services.BookServiceImpl;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;

	@PostMapping("/create")
	public ResponseEntity<String> createBook(@RequestBody Book book) {

		try {
			bookService.saveBook(book);
			return new ResponseEntity<>("Libro creado", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> allBooks = bookService.getAllBooks();

		if (!allBooks.isEmpty()) {
			return new ResponseEntity<>(allBooks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") Integer bookId) {
		Book book = bookService.getBookById(bookId);

		if (book != null) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		try {
			bookService.updateBook(book);
			Book bookUpdated = bookService.getBookById(book.getIdBook());

			if (bookUpdated != null) {
				return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer bookId) {
		try {
			Book book = bookService.getBookById(bookId);
			if (book != null) {
				bookService.deleteBook(bookId);
				return new ResponseEntity<>("Libro borrado", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No existe libro con ese ID", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
