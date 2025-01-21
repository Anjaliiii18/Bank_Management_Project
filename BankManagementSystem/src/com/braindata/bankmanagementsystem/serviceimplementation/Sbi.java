package com.braindata.bankmanagementsystem.serviceimplementation;

import java.util.*;

import com.braindata.bankmanagementsystem.model.Account;
import com.braindata.bankmanagementsystem.service.Rbi;

public class Sbi implements Rbi {

	Scanner sc = new Scanner(System.in);
	List<Account> acc = new ArrayList<>();

	public void createAccount() {
		Account a = new Account();
		System.out.println("Enter Account Number (8 digits):");
		while (true) {
			int accNo = sc.nextInt();
			int s = accNo;
			int c = 0;
			while (accNo != 0) {
				accNo = accNo / 10;
				c++;
			}
			if (c == 8) {
				a.setAccNo(s);
				break;
			} else {
				System.out.println("Invalid Account Number. Please enter an 8-digit number:");
			}
		}

		sc.nextLine();
		System.out.println("Enter Name (only alphabets):");
		while (true) {
			String name = sc.nextLine();
			int i;
			for (i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && c != ' ') {
					System.out.println("Invalid Name. Please enter only alphabetical characters:");
					// break;
				}
			}
			if (i == name.length() && name.length() > 0) {
				a.setName(name);
				break;
			}
		}

		System.out.println("Enter Mobile Number (10 digits):");
		while (true) {
			String mobNo = sc.nextLine();
			if (mobNo.length() == 10) {
				a.setMobNo(mobNo);
				break;
			} else {
				System.out.println("Invalid Mobile Number. Please enter a valid 10-digit number:");
			}
		}

		System.out.println("Enter Adhar Number (12 digits):");
		while (true) {
			String adharNo = sc.nextLine();
			if (adharNo.length() == 12) {
				a.setAdharNo(adharNo);
				break;
			} else {
				System.out.println("Invalid Adhar Number. Please enter a 12-digit number:");
			}
		}

		System.out.println("Enter Gender (male/female):");
		while (true) {
			String gender = sc.nextLine().toLowerCase();
			if (gender.equals("male") || gender.equals("female")) {
				a.setGender(gender);
				break;
			} else {
				System.out.println("Invalid Gender. Please enter 'male' or 'female':");
			}
		}

		System.out.println("Enter Age (18-150):");
		while (true) {
			int age = sc.nextInt();
			if (age >= 18 && age <= 150) {
				a.setAge(age);
				break;
			} else {
				System.out.println("Invalid Age. Please enter an age between 18 and 100:");
			}
		}

		System.out.println("Enter Initial Balance must be greater than 500:");
		while (true) {
			double balance = sc.nextDouble();
			if (balance > 500) {
				a.setBalance(balance);
				break;
			} else {
				System.out.println("Invalid Balance. Please enter a positive balance:");
			}
		}

		acc.add(a);
		
		acc.forEach((n)->System.out.println(n));
		System.out.println("Account created successfully!");
	}

	public void displayAllDetails() {
		System.out.println("Enter your Account Number to display Details:");
		int enterAccNo = sc.nextInt();

		acc.forEach((x) -> {

			if (enterAccNo == x.getAccNo()) {

			System.out.println("---- Account Details ----");
			System.out.println("Account Number: " + x.getAccNo());
			System.out.println("Name: " + x.getName());
			System.out.println("Mobile Number: " + x.getMobNo());
			System.out.println("Adhar Number: " + x.getAdharNo());
			System.out.println("Gender: " + x.getGender());
			System.out.println("Age: " + x.getAge());
			System.out.println("Balance: " + x.getBalance());
			}
		});

	}

	public void depositMoney() {
		System.out.println("Enter your Account Number to deposit money:");
		int enterAccNo = sc.nextInt();
		for (Account s : acc) 
		{
			if (enterAccNo == s.getAccNo()) 
			{
				System.out.println("Enter amount to deposit:");
				double amount = sc.nextDouble();
				if (amount > 0) {
					s.setBalance(s.getBalance() + amount);
					System.out.println("Amount deposited successfully. Current balance: " + s.getBalance());
				} else {
					System.out.println("Invalid deposit amount.");
				}
			}
			else 
			{
				System.out.println("Account number does not match. Please try again.");
			}
		}
	}

	public void withdrawMoney() {
		System.out.println("Enter your Account Number to withdraw money:");
		int enterAccNo = sc.nextInt();
		for (Account s : acc) {
			if (enterAccNo == s.getAccNo()) {
				System.out.println("Enter amount to withdraw:");
				double amount = sc.nextDouble();
				if (amount > 0 && amount <= s.getBalance()) {
					s.setBalance(s.getBalance() - amount);
					System.out.println("Amount withdrawn successfully. Current balance: " + s.getBalance());
				} else {
					System.out.println("Invalid withdrawal amount or insufficient balance.");
				}
			}
		}
	}

	public void balanceCheck() {
		System.out.println("Enter your Account Number to check balance:");
		int enterAccNo = sc.nextInt();
		for (Account s : acc) {
			if (enterAccNo == s.getAccNo()) {
				System.out.println("Your current balance is: " + s.getBalance());
			}
		}
	}
	
	public void sortedlist()
	{
		acc.forEach((x) -> {

			

			System.out.println("---- Account Details ----");
			System.out.println("Account Number: " + x.getAccNo());
			System.out.println("Name: " + x.getName());
			System.out.println("Mobile Number: " + x.getMobNo());
			System.out.println("Adhar Number: " + x.getAdharNo());
			System.out.println("Gender: " + x.getGender());
			System.out.println("Age: " + x.getAge());
			System.out.println("Balance: " + x.getBalance());
			
		});
		
	}
}
