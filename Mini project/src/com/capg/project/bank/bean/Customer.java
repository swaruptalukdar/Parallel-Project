package com.capg.project.bank.bean;

public class Customer 
{
	 private long accountNumber;
	 private String name;
	 private int phoneNumber;
	 private String panNumber;
	 private String address;
	 private String governmentID;
	 private int pin;
	 private int cpin;
	 private double balance;

		public Customer() {
			super();
		}

	 
	public Customer(long accountNumber, String name, int phoneNumber, String panNumber,
			String address, String governmentID, int pin,
			int cpin) 
	{
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.address = address;
		this.governmentID = governmentID;
		this.pin = pin;
		this.cpin = cpin;
		this.balance=balance;
	}
	


	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGovernmentID() {
		return governmentID;
	}
	public void setGovernmentID(String governmentID) {
		this.governmentID = governmentID;
	}
	
	public int getCpin() {
		return cpin;
	}
	public void setCpin(int cpin) {
		this.cpin = cpin;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Customer [Account Number="+ accountNumber + ", Name=" + name + "\n Phone Number=" + phoneNumber
				+ ", PAN=" + panNumber + "\n Address=" + address
				+ ", Aadhar Number=" + governmentID + "\n Balance="+ balance + "]";
	}
	 
	 

}
