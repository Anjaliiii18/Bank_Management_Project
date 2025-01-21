package com.braindata.bankmanagementsystem.client;

import java.util.*;
import com.braindata.bankmanagementsystem.service.Rbi;
import com.braindata.bankmanagementsystem.serviceimplementation.Sbi;

public class Test 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Rbi b = new Sbi(); 
                     
        while (true) 
        {
            System.out.println("--- SBI Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Display All Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Display the Sorted listS");
            System.out.println("7. Exit");
            System.out.print("********Enter your choice**********");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    b.createAccount();
                    break;
                case 2:
                    b.displayAllDetails();
                    break;
                case 3:
                    b.depositMoney();
                    break;
                case 4:
                    b.withdrawMoney();
                    break;
                case 5:
                    b.balanceCheck();
                    break;
                case 6:
                    b.sortedlist();
                    break;
                case 7:
                    System.out.println("Thank you for using SBI Bank Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}
