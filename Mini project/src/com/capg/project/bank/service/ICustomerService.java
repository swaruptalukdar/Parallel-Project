package com.capg.project.bank.service;

import com.capg.project.bank.bean.Customer;


public interface ICustomerService 
{
	public boolean createAccount(long accountNumber,Customer c);
	public Customer showBalance(long accountNumber,int pin);
	public boolean deposit(long accountNumber,int pin,double dAmount);
	public boolean withdraw(long accountNumber,int pin,double wAmount);
	public boolean fundTransfer(long dAccountNumber, int dpin, long cAccountNumber, double dAmount);
	public boolean printTansaction(long accountNumber,int pin);
	 
}
