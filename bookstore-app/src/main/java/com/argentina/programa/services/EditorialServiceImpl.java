package com.argentina.programa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argentina.programa.models.Editorial;
import com.argentina.programa.repositories.IEditorialRepository;

@Service
public class EditorialServiceImpl implements IEditorialService {
	
	@Autowired
	private IEditorialRepository editorialRepository;

	@Override
	public void saveEditorial(Editorial editorial) {
		editorialRepository.save(editorial);
		
	}

	@Override
	public List<Editorial> getAllEditorials() {
		return editorialRepository.findAll();
	}

	@Override
	public Editorial getEditorialById(Integer id) {
		return editorialRepository.findById(id).orElse(null);
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		this.saveEditorial(editorial);
		
	}

	@Override
	public void deleteEditorial(Integer id) {
		editorialRepository.deleteById(id);
	}

}
