package com.algaworks.socialbooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Author;
import com.algaworks.socialbooks.services.AuthorsService;

@RestController
@RequestMapping("/authors")
public class AuthorsResource {
	
	//Inject Class of Service
	@Autowired
	private AuthorsService authorsService;
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<Author>> list(){
		List<Author> authors = authorsService.list();
		return ResponseEntity.status(HttpStatus.OK).body(authors);
	}

}
