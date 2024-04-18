package com.Pharmacy_Management_System.ExceptionalHandling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {
	
	static Scanner scanner = new Scanner(System.in);
	
	//Number Validation
    public static int validateInt(String str) {
    	int num=0;
    	do{
        	while(!scanner.hasNextInt()) {
        		System.out.println("\u001B[31m" +"Invalid input!!"+"\u001B[0m");
        		System.out.println("\u001B[0m"+ "\u001B[1m" +"Please enter the " + str + ":");
        		scanner.next();
        	}
        	num=scanner.nextInt();
        	break;
        }while(true);
    	return num;
	}
    
  //String validation
    public static String validateDrugName(String str) {
		String name;
		boolean b = true;
		do {
			name = scanner.next();
			if (name.matches("[a-zA-Z0-9 ]*")) {
				b = false;
			} else {
				System.out.println("\u001B[31m" +"Invalid input!!" );
				System.out.println( "\u001B[0m"+ "\u001B[1m"+"Please enter the " + str + ":");
			}
		} while (b);
		return name;
	}
    
    //String validation
    public static String validateString(String str) {
		String name;
		boolean b = true;
		do {
			name = scanner.next();
			if (name.matches("[a-zA-Z ]*")) {
				b = false;
			} else {
				System.out.println( "\u001B[31m" +"Invalid input!!");
				System.out.println( "\u001B[0m"+ "\u001B[1m"+"Please enter the " + str + ":");
			}
		} while (b);
		return name;
	}
    
    //Validate Date
    public static String validateDate() {
		String date="";
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false);
		boolean b=true;
		while(b) {
			date=scanner.next();
		try {
			Date parsedDate = inputFormat.parse(date);
            String formattedDate = outputFormat.format(parsedDate);
//			df.parse(date);
			b=false;
			return formattedDate;
			} catch (ParseException e) {
				System.out.println("\u001B[31m" +"Invalid input!!Date is not in the correct format.");
				System.out.println( "\u001B[0m"+ "\u001B[1m"+"Please enter the valid Date :");
				b=true;
			
			}
		}
		return date;
	}
    
    
    
  //String validation
    public static String validatePhoneno() {
		String phno="";
		boolean b = true;
		do {
			phno = scanner.next();
			if (phno.matches("^[6789]\\d{9}$"))
		    {
		        break;
		    } 
		    else
		    {
		    	System.out.println("\u001B[31m" + "Invalid input!!");
		        System.out.println( "\u001B[0m"+ "\u001B[1m"+ "Please Enter valid Contact Number :");
		    }
		} while (b);
		return phno;
	}
    

}
