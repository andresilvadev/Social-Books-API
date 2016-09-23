package com.algaworks.socialbooks.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Book;

@RestController
public class BooksResources {
	
	@RequestMapping(value= "/books", method = RequestMethod.GET)
	public List<Book> list(){
		
		Book b1 = new Book("Rest Aplicado");
		Book b2 = new Book("Git passo a passo");
		
		Book[] books = {b1, b2};
		
		return Arrays.asList(books);
	}

}
