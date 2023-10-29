package com.argentina.programa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argentina.programa.models.Author;
import com.argentina.programa.repositories.IAuthorRepository;

@Service
public class AuthorServiceImpl implements IAuthorService {
	
	@Autowired
	private IAuthorRepository authorRepository;

	@Override
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(Integer id) {
		return authorRepository.findById(id).orElse(null);
	}

	@Override
	public void updateAuthor(Author author) {
		this.saveAuthor(author);
	}

	@Override
	public void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
	}

}
