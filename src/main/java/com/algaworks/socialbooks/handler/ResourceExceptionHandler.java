package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetailErro;
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
}
