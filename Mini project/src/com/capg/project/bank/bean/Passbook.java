package com.capg.project.bank.bean;

public class Passbook {
	private long pAccountNumber;
	private String pDateTime;
	private String detail;
	private double pDeposited;
	private double  pWithdrawn;
	private double pTotalBalance;
	

	public Passbook() 
	{
		super();
	}



	public Passbook(long pAccountNumber, String pDateTime, String detail,
			double pDeposited, double pWithdrawn, double pTotalBalance) 
	{
		super();
		this.pAccountNumber = pAccountNumber;
		this.pDateTime = pDateTime;
		this.detail = detail;
		this.pDeposited = pDeposited;
		this.pWithdrawn = pWithdrawn;
		this.pTotalBalance = pTotalBalance;
	}



	public long getpAccountNumber() {
		return pAccountNumber;
	}


	public void setpAccountNumber(long pAccountNumber) {
		this.pAccountNumber = pAccountNumber;
	}


	public String getpDateTime() {
		return pDateTime;
	}


	public void setpDateTime(String pDateTime) {
		this.pDateTime = pDateTime;
	}


	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}



	public double getpDeposited() {
		return pDeposited;
	}


	public void setpDeposited(double pDeposited) {
		this.pDeposited = pDeposited;
	}


	public double getpWithdrawn() {
		return pWithdrawn;
	}


	public void setpWithdrawn(double pWithdrawn) {
		this.pWithdrawn = pWithdrawn;
	}


	public double getpTotalBalance() {
		return pTotalBalance;
	}


	public void setpTotalBalance(double pTotalBalance) {
		this.pTotalBalance = pTotalBalance;
	}



	@Override
	public String toString() {
		return "Passbook [ pAccountNumber= " + pAccountNumber + ", pDateTime= "
				+ pDateTime + ", detail= " + detail + ", pDeposited="
				+ pDeposited + ", pWithdrawn= " + pWithdrawn
				+ ", pTotalBalance= " + pTotalBalance + " ]";
	}


	
	
}
