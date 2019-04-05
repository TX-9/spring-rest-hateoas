package com.tx9.payroll.exception;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(Long id) {
		super("Could not find order " + id);
	}
}
