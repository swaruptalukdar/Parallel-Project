package com.capg.project.bank.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capg.project.bank.bean.Customer;

public class CustomerDaoImpTest {
	Customer bean=new Customer();
	@Test
	public void testCreateAccount() {
		assertNotNull(bean);
	}

	@Test
	public void testShowBalance() {
		assertNotNull(bean.getAccountNumber());
	}

	@Test
	public void testDeposit() {
		assertNotNull(bean.getAccountNumber());
	}

	@Test
	public void testWithdraw() {
		assertNotNull(bean.getAccountNumber());
	}

	@Test
	public void testFundTransfer() {
		assertNotNull(bean.getAccountNumber());
	}

	@Test
	public void testPrintTansaction() {
		assertNotNull(bean.getAccountNumber());
	}

}
