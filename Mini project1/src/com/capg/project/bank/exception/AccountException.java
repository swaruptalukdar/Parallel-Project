package com.capg.project.bank.exception;

public class AccountException extends Exception 
{

	public AccountException() {
		super();
	}

	public AccountException(Exception e) {
		e.getMessage();
	}

}
