package com.tx9.payroll.exception;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
