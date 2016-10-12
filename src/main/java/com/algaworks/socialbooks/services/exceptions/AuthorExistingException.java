package com.algaworks.socialbooks.services.exceptions;

public class AuthorExistingException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2095419504039109832L;

	public AuthorExistingException(String message){
		super(message);
	}
	
	public AuthorExistingException(String message, Throwable cause){
		super(message, cause);
	}
}
