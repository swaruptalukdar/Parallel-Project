package com.capg.project.bank.dao;

import com.capg.project.bank.bean.Customer;
import com.capg.project.bank.bean.Passbook;
import com.capg.project.bank.exception.AccountException;

public interface ICustomerDao 
{
	public boolean createAccount(long accountNumber,Customer c) throws AccountException;
	public Customer showBalance(long accountNumber,int pin) throws AccountException;
	public boolean deposit(long accountNumber,int pin,double dAmount) throws AccountException;
	public boolean withdraw(long accountNumber,int pin,double wAmount) throws AccountException;
	public boolean fundTransfer(long dAccountNumber, int dpin, long cAccountNumber, double dAmount) throws AccountException;
	public Passbook printTansaction(long accountNumber,int pin) throws AccountException;
}