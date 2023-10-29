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

import com.argentina.programa.models.Author;
import com.argentina.programa.services.AuthorServiceImpl;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorServiceImpl authorService;

	@PostMapping("/create")
	public ResponseEntity<String> createAuthor(@RequestBody Author author) {

		try {
			authorService.saveAuthor(author);
			return new ResponseEntity<>("Autor creado", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> allAuthors = authorService.getAllAuthors();

		if (!allAuthors.isEmpty()) {
			return new ResponseEntity<>(allAuthors, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/{authorId}")
	public ResponseEntity<Author> getAuthorById(@PathVariable("authorId") Integer authorId) {
		Author author = authorService.getAuthorById(authorId);

		if (author != null) {
			return new ResponseEntity<>(author, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
		try {
			authorService.updateAuthor(author);
			Author authorUpdated = authorService.getAuthorById(author.getIdAuthor());

			if (authorUpdated != null) {
				return new ResponseEntity<>(authorUpdated, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{authorId}")
	public ResponseEntity<String> deleteAuthorById(@PathVariable Integer authorId) {
		try {
			Author author = authorService.getAuthorById(authorId);
			if (author != null) {
				authorService.deleteAuthor(authorId);
				return new ResponseEntity<>("Author borrado", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No existe autor con ese ID", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
