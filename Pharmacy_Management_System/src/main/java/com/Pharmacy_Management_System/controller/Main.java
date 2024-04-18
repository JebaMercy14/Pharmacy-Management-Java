package com.Pharmacy_Management_System.controller;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.Date;

import com.Pharmacy_Management_System.Service.*;

//import com.pharmacyManagementSystem.GetterSetter.*;
import Pharmacy_Management_System.DAO.*;
import java.util.Scanner;
import com.Pharmacy_Management_System.ExceptionalHandling.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException, SQLException{
		
		String login="";
		String password="";
		
        System.out.println("WELCOME  TO PHARMACY MANAGEMENT SYSTEM!");
        System.out.println("Please enter your credentials to log in.");
		
		while (true) {
			System.out.println("\u001B[0m" +"Enter your Login ID");
			login=scanner.next();
			System.out.println("Enter your Password");
			password=scanner.next();
			if(LoginDAO.loginvalidate(login, password))
			{
				System.out.println("\u001B[32m" +"Successfully logged in!");
				break;
			}
			else {
				System.out.println("\u001B[31m" +"Invalid Credentials!!");
				System.out.println("\u001B[0m" +"please enter correct login id and password");
			}
		}
		
        while (true) {
			System.out.println("\u001B[33m"+ "\u001B[1m" + "**************************************************************************");
			System.out.println("                      PHARMACY MANAGEMENT SYSTEM                        ");
			System.out.println("**************************************************************************");
			
		    System.out.println( "\u001B[0m"+ "\u001B[1m" +"Choose an option:");
		    System.out.println("1. Stock Details");
		    System.out.println("2. Supplier Details");
		    System.out.println("3. Sale Details");		    
		    System.out.println("4. Exit");

		    int choice = Validate.validateInt("Valid Choice");
//		    scanner.nextLine(); // Consume newline

		    switch (choice) {
		        case 1:
		            StockService.handleStockDetails();
		            break;
		        case 2:
		        	SupplierService.handleSupplierDetails();
		            break;
		        case 3:
		            SaleService.handleSaleDetails();
		            break;		        
		            
		        case 4:
		            System.out.println("Exiting...");
		            System.exit(0);
		        default:
		            System.out.println("\u001B[31m"+"Invalid option! Please choose again.");
		    }
}
    }

  
    
}
