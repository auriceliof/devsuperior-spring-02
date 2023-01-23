package com.devsuperior.bds02.services.exceptions;

public class NotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFound(String msg) {
		super(msg);
	}
}

