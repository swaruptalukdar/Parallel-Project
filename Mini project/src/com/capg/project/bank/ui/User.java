package com.capg.project.bank.ui;

import java.util.Scanner;
import com.capg.project.bank.bean.Customer;
import com.capg.project.bank.exception.AccountNotFound;
import com.capg.project.bank.service.CustomerServiceImp;

public class User {

	public static void main(String[] args) 
	{
		while (true) 
		{
			Scanner scanner = new Scanner(System.in);
			Customer bean = new Customer();
			CustomerServiceImp service=new CustomerServiceImp();
			long accountNumber;
			int pin;

			System.out.println("\n-----------------------------------------------");
			System.out.println("------------ Welcome to UIBANK ----------------");
			System.out.println("-----------------------------------------------");
			System.out.println("\n\tMenu");
			System.out.println("1. Create Account");
			System.out.println("2. Show Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Trasaction\n7. Exit");
			System.out.println("-----------------------------------------------");
			System.out.print("\nEnter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) 
			{
			case 1:
				System.out.print("\nAccount creation\n==========================\n");
				
				boolean temp=true;
				
				do 
				{
					System.out.print("\nEnter your name: ");
					String name = scanner.next();
					bean.setName(name);
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your Mobile Number: ");
					int phoneNumber = scanner.nextInt();
					bean.setPhoneNumber(phoneNumber);
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your Address: ");
					String address = scanner.next();
					bean.setAddress(address);
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your PAN number: ");
					String panNumber = scanner.next();
					bean.setPanNumber(panNumber);
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your Aadhar number: ");
					String governmentID = scanner.next();
					bean.setGovernmentID(governmentID);
				} while (temp == false);

				double a = Math.random() * Math.pow(10, 5);
				accountNumber = (long) a;
				bean.setAccountNumber(accountNumber);
				System.out.print("\nYour Account number is : ");
				System.out.print(bean.getAccountNumber());
				
				double p= Math.random() * Math.pow(10, 4);
				pin = (int) p;
				bean.setPin(pin);
				System.out.print("\nYour pin is : ");
				System.out.print(bean.getPin());
				
				boolean isAdded=service.createAccount(accountNumber,bean);
				
				if(isAdded){
					System.err.print("\n\nAccount created successfully...\n");
					//System.out.println(bean);
				}
				else
				{
					System.err.println("Account not created...");
				}
				

				break;

			case 2:
				System.out.print("\nShow Balance\n==========================\n");
				
				System.out.print("\nEnter your Account number : ");
				accountNumber = scanner.nextLong();
				bean.setAccountNumber(accountNumber);
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				
				Customer c=service.showBalance(accountNumber, pin);
				if(c != null)
					System.out.println(c);
				else 
				{
					try 
					{
						throw new AccountNotFound();
					} 
					catch (AccountNotFound e)
					{

						e.getMessage();
					}
				}
				break;

			case 3:
				System.out.print("\nDeposit Amount\n==========================\n");
				System.out.print("\nEnter your Account Number: ");
				accountNumber = scanner.nextLong();
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				System.out.print("\nEnter depositing amount: ");
				double dAmount=scanner.nextDouble();
				
				service.deposit(accountNumber, pin, dAmount);
				break;

			case 4:
				System.out.print("\nWithdraw Amount\n==========================\n");
				System.out.print("\nEnter your Account Number: ");
				accountNumber = scanner.nextLong();
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				System.out.print("\nEnter withdraw amount: ");
				double wAmount = scanner.nextDouble();
				
				service.withdraw(accountNumber, pin, wAmount);
				
				break;

			case 5:
				System.out.print("\nTransfer Fund\n==========================\n");
				
				System.out.print("\nEnter your Account Number: ");
				long accountNumber1 = scanner.nextLong();
				System.out.print("\nEnter your PIN: ");
				pin = scanner.nextInt();
				System.out.print("\nEnter Beneficiary's Account Number: ");
				long accountNumber2 = scanner.nextLong();
				System.out.print("\nEnter the amount to transfer: ");
				dAmount=scanner.nextDouble();
				
				service.fundTransfer(accountNumber1, pin, accountNumber2, dAmount);
				
				break;

			case 6:
				System.out.print("\nPrint Transactions\n==========================\n");
				
				System.out.print("\nEnter your Account Number: ");
				accountNumber = scanner.nextLong();
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				
				service.printTansaction(accountNumber, pin);
				break;
				
			case 7:
				System.out.println("\n----Thank you for using UIBANK----");
				System.exit(0);
				break;

			default:
				System.err.println("Wrong Choice !!!");

			}			
		}
	}
}
