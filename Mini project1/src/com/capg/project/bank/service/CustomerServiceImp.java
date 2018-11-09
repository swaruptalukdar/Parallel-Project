package com.capg.project.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.project.bank.bean.Customer;
import com.capg.project.bank.bean.Passbook;
import com.capg.project.bank.dao.CustomerDaoImp;
import com.capg.project.bank.dao.ICustomerDao;
import com.capg.project.bank.exception.AccountException;

public class CustomerServiceImp implements ICustomerService {
	ICustomerDao dao=new CustomerDaoImp();
	Customer bean=new Customer();
	
	
	public boolean validateName(String name) throws AccountException
	{
		boolean flag=false;
		Pattern vName=Pattern.compile("^[A-Z][A-Za-z\\s]*$");
		Matcher match = vName.matcher(name);
		
		if(match.matches())
		{
			flag=true;
		}
		return flag;
	}
	
	public boolean validatePhoneNumber(String phoneNumber) throws AccountException
	{
		boolean flag=false;
		Pattern vPhNo=Pattern.compile("\\d{10}");
		Matcher match = vPhNo.matcher(phoneNumber);
		
		if(match.matches())
		{
			flag=true;
		}
		return flag;
	}
	
	
	public boolean validatePAN(String panNumber) throws AccountException
	{
		boolean flag=false;
		Pattern vPAN=Pattern.compile("[0-9][\\dA-Z\\d]{8}[0-9]");
		Matcher match = vPAN.matcher(panNumber);
		
		if(match.matches())
		{
			flag=true;
		}
		return flag;
	}
	
	
	public boolean validateAadhar(String governmentID) throws AccountException
	{
		boolean flag=false;
		Pattern vGovtID=Pattern.compile("\\d{12}");
		Matcher match = vGovtID.matcher(governmentID);
		
		if(match.matches())
		{
			flag=true;
		}
		return flag;
	}
	
	public boolean validateAddress(String address) throws AccountException
	{
		boolean flag=false;
		Pattern vAddress=Pattern.compile("[0-9A-Za-z/,\\s]+");
		Matcher match = vAddress.matcher(address);
		
		if(match.matches())
		{
			flag=true;
		}
		return flag;
	}
	
	@Override
	public boolean createAccount(long accountNumber,Customer c) throws AccountException
	{
		
		return dao.createAccount(accountNumber,c);
	}

	@Override
	public Customer showBalance(long accountNumber, int pin) throws AccountException 
	{
		
		return dao.showBalance(accountNumber, pin);
	}

	@Override
	public boolean deposit(long accountNumber, int pin, double dAmount) throws AccountException
	{
		
		return dao.deposit(accountNumber, pin, dAmount);
	}

	@Override
	public boolean withdraw(long accountNumber, int pin, double wAmount) throws AccountException 
	{

		return dao.withdraw(accountNumber, pin, wAmount);
	}

	@Override
	public boolean fundTransfer(long dAccountNumber, int dpin,
			long cAccountNumber, double dAmount) throws AccountException
	{
	
		return dao.fundTransfer(dAccountNumber, dpin, cAccountNumber, dAmount);
	}

	@Override
	public Passbook printTansaction(long accountNumber, int pin) throws AccountException
	{
	
		return dao.printTansaction(accountNumber, pin);
	}


	
	
}