package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Book;
import com.algaworks.socialbooks.repository.BooksRepository;
import com.algaworks.socialbooks.services.exceptions.BookNotFoundException;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public List<Book> list(){
		return booksRepository.findAll();
	}
	
	public Book search(Long id){
		Book book = booksRepository.findOne(id);		
		if(book == null){
			throw new BookNotFoundException("O livro não pode ser encontrado.");
		}		
		return book;
	}
	
	public Book save(Book book){
		book.setId(null);		
		book = booksRepository.save(book);		
		return book;
	}
	
	public void remove(Long id){
		try {
			booksRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BookNotFoundException("O livro não pode ser encontrado.");
		}
	}
	
	public void update(Book book){
		verifierExist(book);
		booksRepository.save(book);
	}
	
	private void verifierExist(Book book){
		search(book.getId());
	}	
	
}
