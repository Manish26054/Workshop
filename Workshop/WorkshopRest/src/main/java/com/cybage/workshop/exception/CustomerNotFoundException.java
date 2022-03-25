package com.cybage.workshop.exception;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 2823687924002491320L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
