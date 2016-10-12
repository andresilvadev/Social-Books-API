package com.algaworks.socialbooks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.domain.Author;
import com.algaworks.socialbooks.services.AuthorsService;

@RestController
@RequestMapping("/authors")
public class AuthorsResource {
	
	//Inject Class of Service
	@Autowired
	private AuthorsService authorsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> list(){
		List<Author> authors = authorsService.list();
		return ResponseEntity.status(HttpStatus.OK).body(authors);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Author author){
		author = authorsService.save(author);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(author.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<Author> search(@PathVariable("id") Long id){
		Author author = authorsService.search(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}

}
