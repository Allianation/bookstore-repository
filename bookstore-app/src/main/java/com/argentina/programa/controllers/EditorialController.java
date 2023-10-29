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

import com.argentina.programa.models.Editorial;
import com.argentina.programa.services.EditorialServiceImpl;

@RestController
@RequestMapping("/editorials")
public class EditorialController {
	
	@Autowired
	private EditorialServiceImpl editorialService;

	@PostMapping("/create")
	public ResponseEntity<String> createEditorial(@RequestBody Editorial editorial) {

		try {
			editorialService.saveEditorial(editorial);
			return new ResponseEntity<>("Editorial creada", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Editorial>> getAllEditorials() {
		List<Editorial> allEditorials = editorialService.getAllEditorials();

		if (!allEditorials.isEmpty()) {
			return new ResponseEntity<>(allEditorials, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/{editorialId}")
	public ResponseEntity<Editorial> getEditorialById(@PathVariable("editorialId") Integer editorialId) {
		Editorial editorial = editorialService.getEditorialById(editorialId);

		if (editorial != null) {
			return new ResponseEntity<>(editorial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Editorial> updateEditorial(@RequestBody Editorial editorial) {
		try {
			editorialService.updateEditorial(editorial);
			Editorial editorialUpdated = editorialService.getEditorialById(editorial.getIdEditorial());

			if (editorialUpdated != null) {
				return new ResponseEntity<>(editorialUpdated, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{editorialId}")
	public ResponseEntity<String> deleteEditorialById(@PathVariable Integer editorialId) {
		try {
			Editorial editorial = editorialService.getEditorialById(editorialId);
			if (editorial != null) {
				editorialService.deleteEditorial(editorialId);
				return new ResponseEntity<>("Editorial borrada", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No existe editorial con ese ID", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
