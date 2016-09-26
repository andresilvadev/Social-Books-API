package com.algaworks.socialbooks.services.exceptions;

public class BookNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2095419504039109832L;

	public BookNotFoundException(String message){
		super(message);
	}
	
	public BookNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
