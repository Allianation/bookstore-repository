package com.argentina.programa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.argentina.programa.models.Editorial;

@Service
public interface IEditorialService {
	
	public void saveEditorial(Editorial editorial);
	
	public List<Editorial> getAllEditorials();
	
	public Editorial getEditorialById(Integer id);
	
	public void updateEditorial(Editorial editorial);
	
	public void deleteEditorial(Integer id);

}
