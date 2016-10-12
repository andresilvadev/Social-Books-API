package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Author;
import com.algaworks.socialbooks.repository.AuthorsRepository;
import com.algaworks.socialbooks.services.exceptions.AuthorExistingException;
import com.algaworks.socialbooks.services.exceptions.AuthorNotFoundException;

@Service
public class AuthorsService {
	
	@Autowired
	private AuthorsRepository authorsRepository;
	
	public List<Author> list(){
		return authorsRepository.findAll();
	}
		
	//if the author is not null, search the repository, if it exists show that it already exists,
	//if none of this happens saves the author
	public Author save(Author author){
		if(author.getId() != null){
			Author a = authorsRepository.findOne(author.getId());
			
			if(a != null){
				throw new AuthorExistingException("O autor já existe.");
			}
		}
		return authorsRepository.save(author);
	}
	
	public Author search(Long id){
		Author author = authorsRepository.findOne(id);
		
		if(author == null){
			throw new AuthorNotFoundException("O autor não pode ser encontrado!");
		}
		
		return author;
	}
}
