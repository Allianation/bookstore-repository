package com.argentina.programa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.argentina.programa.models.Author;

@Service
public interface IAuthorService {
	
	public void saveAuthor(Author author);
	
	public List<Author> getAllAuthors();
	
	public Author getAuthorById(Integer id);
	
	public void updateAuthor(Author author);
	
	public void deleteAuthor(Integer id);

}
