package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Author;
import com.algaworks.socialbooks.repository.AuthorsRepository;

@Service
public class AuthorsService {
	
	@Autowired
	private AuthorsRepository authorsRepository;
	
	public List<Author> list(){
		return authorsRepository.findAll();
	}
}
