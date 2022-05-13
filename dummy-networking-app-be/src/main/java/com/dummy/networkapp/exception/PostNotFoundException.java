package com.dummy.networkapp.exception;

public class PostNotFoundException extends RuntimeException {

	public PostNotFoundException() {
		super();
	}
	
    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
        
    }
}
