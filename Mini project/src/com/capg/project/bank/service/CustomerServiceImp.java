package com.capg.project.bank.service;

import com.capg.project.bank.bean.Customer;
import com.capg.project.bank.bean.Passbook;
import com.capg.project.bank.dao.CustomerDaoImp;

public class CustomerServiceImp implements ICustomerService {
	CustomerDaoImp dao=new CustomerDaoImp();
	@Override
	public boolean createAccount(long accountNumber,Customer c) {
		
		return dao.createAccount(accountNumber,c);
	}

	@Override
	public Customer showBalance(long accountNumber, int pin) {
		
		return dao.showBalance(accountNumber, pin);
	}

	@Override
	public boolean deposit(long accountNumber, int pin, double dAmount) {
		
		return dao.deposit(accountNumber, pin, dAmount);
	}

	@Override
	public boolean withdraw(long accountNumber, int pin, double wAmount) {

		return dao.withdraw(accountNumber, pin, wAmount);
	}

	@Override
	public boolean fundTransfer(long dAccountNumber, int dpin,
			long cAccountNumber, double dAmount) {
	
		return dao.fundTransfer(dAccountNumber, dpin, cAccountNumber, dAmount);
	}

	@Override
	public boolean printTansaction(long accountNumber, int pin) {
	
		return dao.printTansaction(accountNumber, pin);
	}
	
	
	
	public boolean validateData(Customer c)
	{	boolean flag=false;
		if(c.getName().equals("[A-Z][a-z A-Z]+") && c.getAddress().equals("[0-9]+ [A-Z a-Z]+ ") 
				&& c.getPanNumber().equals("[0-9 A-Z 0-9]+")) 
		{
			flag=true;
		}
		return flag;	
	}

	
	public boolean validateCid(int cid)
	{
		boolean flag=false;
		if(cid>99){
			flag=true;
		}
		return flag;
	}

}
