package com.capg.project.bank.ui;

import java.util.Scanner;



import com.capg.project.bank.bean.Customer;
import com.capg.project.bank.exception.AccountException;
import com.capg.project.bank.service.CustomerServiceImp;


public class User {

	public static void main(String[] args) throws AccountException
	{
		while (true) 
		{
			Scanner scanner = new Scanner(System.in);
			Customer bean = new Customer();
			CustomerServiceImp service=new CustomerServiceImp();
			
			long accountNumber;
			int pin;

			System.out.println("\n===============================================");
			System.out.println("#----------- Welcome to UIBANK ---------------#");
			System.out.println("===============================================");
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
				System.out.print("\n==========================\n Account creation\n==========================\n");
				
				boolean temp=false;
				
				do 
				{	
					System.out.print("\nEnter your name(InitCaps): ");
					String name = scanner.next();
					if(service.validateName(name))
					{
						System.out.println(name);
						temp=true;
						bean.setName(name);	
					}
					else
					{
						System.out.println("1"+name);
						System.err.println("\nInvalid... Only InitCap alphabets allowed !!!");
						temp=false;
					}
					
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your Mobile Number (10 digits): ");
					String phoneNumber = scanner.next();
					if(service.validatePhoneNumber(phoneNumber))
					{
						System.out.println(phoneNumber);
						temp=true;
						bean.setPhoneNumber(phoneNumber);
					}
					else
					{
						System.out.println("1");
						System.err.println("Invalid... Only 10 digits allowed!!!");
						temp=false;
					}
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your Address : ");
					String address = scanner.next();
					System.out.println(" ");
					if(service.validateAddress(address))
					{
						temp=true;
						bean.setAddress(address);
					}
					
					else
					{
						System.err.println("Invalid Address [format: digits String String]...!!!");
						temp=false;
					}
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your PAN number(alphanumeric 10 chars): ");
					String panNumber = scanner.next();
					if(service.validatePAN(panNumber))
					{
						temp=true;
						bean.setPanNumber(panNumber);
					}
					else
					{
						System.err.println("Invalid... Only 12 characters (alphanumeric) are allowed - must start and end with atleast 1 digit !!!");
						temp=false;
					}
				} while (temp == false);

				do 
				{
					System.out.print("\nEnter your Aadhar number(12 digits): ");
					String governmentID = scanner.next();
					if(service.validateAadhar(governmentID))
					{
						temp=true;
						bean.setGovernmentID(governmentID);
					}
					else
					{
						System.err.println("Invalid... 12 digits allowed !!!");
						temp=false;
					}
					
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
				System.out.println("\nbean "+bean);
				boolean isAdded=service.createAccount(accountNumber,bean);
				
				if(isAdded)
				{
					System.err.print("\n\nAccount created successfully...\n");
				}
				else
				{
					System.err.println("Account not created...");
				}
				

				break;

			case 2:
				System.out.print("\n==========================\n Show Balance\n==========================\n");
				
				System.out.print("\nEnter your Account number : ");
				accountNumber = scanner.nextLong();
				bean.setAccountNumber(accountNumber);
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				
				Customer bean1=service.showBalance(accountNumber, pin);
				if(bean1 != null)
					System.out.println(bean1);
				else 
				{
					try 
					{
						throw new AccountException();
	
					} 
					catch (AccountException e)
					{

						e.getMessage();
					}
				}
				break;

			case 3:
				System.out.print("\n==========================\n Deposit Amount\n==========================\n");
				System.out.print("\nEnter your Account Number: ");
				accountNumber = scanner.nextLong();
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				System.out.print("\nEnter depositing amount: ");
				double dAmount=scanner.nextDouble();
				
				boolean isDeposited =	service.deposit(accountNumber, pin, dAmount);
				if(isDeposited)
				{ System.out.println("Rs."+dAmount+" is Deposited.");
				}
				else
				{
					try 
					{
						System.err.println("Invalid... a/c no. or pin...");
						throw new AccountException();
	
					} 
					catch (AccountException e)
					{

						e.getMessage();
					}
				}
				break;

			case 4: 
				System.out.print("\n==========================\n Withdraw Amount\n==========================\n");
				System.out.print("\nEnter your Account Number: ");
				accountNumber = scanner.nextLong();
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				System.out.print("\nEnter withdraw amount: ");
				double wAmount = scanner.nextDouble();
				
				boolean isWithdrawn =service.withdraw(accountNumber, pin, wAmount);
				if(isWithdrawn)
				{ System.out.println("Rs."+wAmount+" is Withdrawn.");
				}
				else
				{
					
				}
				
				break;

			case 5:
				System.out.print("\n==========================\n Transfer Fund\n==========================\n");
				
				System.out.print("\nEnter your Account Number: ");
				long accountNumber1 = scanner.nextLong();
				System.out.print("\nEnter your PIN: ");
				pin = scanner.nextInt();
				System.out.print("\nEnter Beneficiary's Account Number: ");
				long accountNumber2 = scanner.nextLong();
				System.out.print("\nEnter the amount to transfer: ");
				dAmount=scanner.nextDouble();
				
				boolean isTransferred = service.fundTransfer(accountNumber1, pin, accountNumber2, dAmount);
				if(isTransferred)
				{ System.out.println("Rs."+dAmount+" is Transferred from "+accountNumber1+" to "+accountNumber2);
				}
				else
				{
					System.err.println("Transaction Unsuccessful....");
					throw new AccountException();
				}
				break;

			case 6:
				System.out.print("\n==========================\n Print Transactions\n==========================\n");
				
				System.out.print("\nEnter your Account Number: ");
				accountNumber = scanner.nextLong();
				System.out.print("\nEnter PIN: ");
				pin = scanner.nextInt();
				
				System.out.println("\n\n Date\t   Time\t       A/C No.\t\tDetails\t\t\t\t\t\t\tBal");
				System.out.println("-----------------------------------------------------------------------------------------------------");
				service.printTansaction(accountNumber, pin);
				System.out.println("-----------------------------------------------------------------------------------------------------");
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