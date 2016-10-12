package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetailErro;
import com.algaworks.socialbooks.services.exceptions.AuthorExistingException;
import com.algaworks.socialbooks.services.exceptions.AuthorNotFoundException;
import com.algaworks.socialbooks.services.exceptions.BookNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<DetailErro> handleBookNotFoundException
					(BookNotFoundException e, HttpServletRequest request){
		
		DetailErro erro = new DetailErro();
		erro.setStatus(404l);
		erro.setTitle("O livro não pode ser encontrado!");
		erro.setMessageDeveloper("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AuthorExistingException.class)
	public ResponseEntity<DetailErro> handleAuthorExistingException
					(AuthorExistingException e, HttpServletRequest request){
		
		DetailErro erro = new DetailErro();
		erro.setStatus(409l);
		erro.setTitle("O autor já existente!");
		erro.setMessageDeveloper("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<DetailErro> handleAuthorNotFoundException
					(AuthorNotFoundException e, HttpServletRequest request){
		
		DetailErro erro = new DetailErro();
		erro.setStatus(404l);
		erro.setTitle("O autor não pode ser encontrado!");
		erro.setMessageDeveloper("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetailErro> handleDataIntegrityViolationException
					(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetailErro erro = new DetailErro();
		erro.setStatus(400l);
		erro.setTitle("Requisição inválida!");
		erro.setMessageDeveloper("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
