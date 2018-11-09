package com.capg.project.bank.bean;

public class Passbook {
	private long pAccountNumber;
	private String transactionDetails;
	

	public Passbook() 
	{
		super();
	}


	public long getpAccountNumber() {
		return pAccountNumber;
	}


	public void setpAccountNumber(long pAccountNumber) {
		this.pAccountNumber = pAccountNumber;
	}


	public String getTransactionDetails() {
		return transactionDetails;
	}


	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}


	@Override
	public String toString() {
		return "\nPassbook [pAccountNumber=" + pAccountNumber + ", transactionDetails=" + transactionDetails + "]";
	}


	public Passbook(long pAccountNumber, String transactionDetails) {
		super();
		this.pAccountNumber = pAccountNumber;
		this.transactionDetails = transactionDetails;
	}

	

	
	
	
}