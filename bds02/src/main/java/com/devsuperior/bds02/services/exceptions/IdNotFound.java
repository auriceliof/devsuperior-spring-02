package com.devsuperior.bds02.services.exceptions;

public class IdNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public IdNotFound(String msg) {
		super(msg);
	}
}

