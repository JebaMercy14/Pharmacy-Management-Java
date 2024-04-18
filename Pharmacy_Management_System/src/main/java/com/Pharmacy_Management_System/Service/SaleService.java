package com.Pharmacy_Management_System.Service;

import java.sql.SQLException;
import java.util.Scanner;

import com.Pharmacy_Management_System.ExceptionalHandling.Validate;
import com.Pharmacy_Management_System.models.SaleDetails;
//import com.Pharmacy_Management_System.models.StockDetails;

import Pharmacy_Management_System.DAO.SaleDetailsDAO;
import Pharmacy_Management_System.DAO.StockDetailsDAO;


public class SaleService {
	
	static Scanner scanner = new Scanner(System.in);

	public static void handleSaleDetails() throws SQLException {
        
    	while (true) {
    		

    		System.out.println("\u001B[0m"+ "\u001B[1m" +"**************************************************************************");
    		System.out.println("                      HANDLING THE SALE DETAIL                       ");
    		System.out.println("**************************************************************************");
    		
    		
            System.out.println("Choose an option for Sale Details:");
            System.out.println("1. Add Sale Details");
            System.out.println("2. Update Sale Details");
            System.out.println("3. Delete Sale Details");
            System.out.println("4. View Sale Details");
            System.out.println("5. Go Back");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Add Sale details
                	System.out.println("Enter Sale ID:");
                    int saleID = Validate.validateInt("Valid Sale ID");
//                    scanner.nextLine(); 
                    
                    
                    System.out.println("Enter Customer Name:");                    
                    String customerName = Validate.validateString("Valid Customer Name");
//                    scanner.nextLine(); 
                    
                    System.out.println("Enter Customer Contact:");                    
                    String customerContact = Validate.validatePhoneno();
//                    scanner.nextLine(); 
                    
                    System.out.println("Enter Drug ID:");
                    int drugID2 = Validate.validateInt("Valid Drug ID");
//                    scanner.nextLine(); 
                    
                    System.out.println("Enter Quantity:");
                    int quantity2 = Validate.validateInt("Valid Quantity");
//                    scanner.nextLine();
                    StockDetailsDAO.updateStockQuantity(drugID2, quantity2);
                    


                    System.out.println("Enter price:");
                    int price = Validate.validateInt("Valid Price");
//                    scanner.nextLine();
                    
//                    System.out.println("Enter Total Amount:");
                    int totalAmount =price*quantity2;
////            		scanner.nextInt();
                    
				SaleDetails usad = new SaleDetails(saleID, customerName, customerContact ,drugID2, quantity2, price ,totalAmount);
				SaleDetailsDAO.addSaleDetails(usad);
				
				
				
				
				
				
//				SaleDetails n2= SaleDetails(saleID, customerName, customerContact ,drugID2, quantity2, price ,totalAmount);
//				SaleDetailsDAO.addSaleDetails(n2);
                    
                    break;
                case 2:
                    // Update Sale details logic
                	
                	
                	System.out.println("Choose the updation method:");
    	            System.out.println("1. Update all details");
    	            System.out.println("2. Update the particular details only");
    	            

    	            int updatechoice = Validate.validateInt("Valid Choice");
    	            
    	            switch (updatechoice) {
	                case 1:
	                	System.out.println("Enter Sale ID:");
	                    int usaleID = Validate.validateInt("Valid Sale ID");
	                    
	                    
	                    System.out.println("Enter Customer Name:");                    
	                    String ucustomerName = Validate.validateString("Valid Customer Name");

	                    
	                    System.out.println("Enter Customer Contact:");                    
	                    String ucustomerContact = Validate.validatePhoneno();

	                    
	                    System.out.println("Enter Drug ID:");
	                    int udrugID2 = Validate.validateInt("Valid Drug ID");

	                    
	                    System.out.println("Enter Quantity:");
	                    int uquantity2 = Validate.validateInt("Valid Quantity");

	                    
	                    System.out.println("Enter price:");
	                    int uprice = Validate.validateInt("Valid Price");

	                    int utotalAmount = uquantity2*uprice;

	                    
					SaleDetails usal = new SaleDetails(usaleID, ucustomerName, ucustomerContact ,udrugID2, uquantity2, uprice ,utotalAmount);
					SaleDetailsDAO.updateSaleDetails(usal);                                       
	                      
	                    break;
	                                     
	                   
	                case 2:
	                	
	                	System.out.println("Enter your id");
	            		int id = Validate.validateInt("Valid Sale ID");
	            		System.out.println("Enter your update data:Name/Contact");
	            		String input=scanner.next();
	            		
	            		if(input.equalsIgnoreCase("Name"))
	            		{          		
	            			System.out.println("Enter customer Name:");
		                    String upcusName = Validate.validateString("Valid customer Name");
		                    SaleDetailsDAO.updateName(id, upcusName);
	            			
	            		}
	            		
	            		else if(input.equalsIgnoreCase("Contact"))
	            		{
	            			System.out.println("Enter Customer Contact:");                    
		                    String contactNumber = Validate.validatePhoneno();
		                    SaleDetailsDAO.updateContact(id, contactNumber);
	            			
	            		}
	            		else {
	            			System.out.println("Not a valid option!!");
	            		}
	            		
//	            		if(input.equalsIgnoreCase("email"))
//	            		{
//	            			
//	            			String email="";
//	            		//	try {      
//	            			while(true)
//	            			    	  
//	            			      {
//	            			    	  System.out.println("Enter your email id");
//	            						 email= scanner.next();
//	            						 scanner.nextLine();
//
//	            			String regex="^[A-Za-z0-9+_.-]+@(gmail.com|yahoo.com|cognizant.com)$";
//
//	            				        
//	            				        Pattern pattern = Pattern.compile(regex);
//	            				        Matcher matcher = pattern.matcher(email);
//	            			    	  if (matcher.matches())
//	            				        {
//	            			    		  break;
//	            			    		  } else 
//	            				        {
//	            				            System.out.println(email + " is not a valid email address.");
//	            				       
//	            				        } 
//	            			      }
//
//	            		SalesDao.updateEmail(id, email);
//	            		}
//	            	}
	                	
	                	
	                	break;
	                	
	                	
    	            }
                	
//                	System.out.println("Enter Sale ID:");
//                    int usaleID = Validate.validateInt("Valid Sale ID");
////                    scanner.nextLine(); 
//                    
//                    
//                    System.out.println("Enter Customer Name:");                    
//                    String ucustomerName = Validate.validateString("Valid Customer Name");
////                    scanner.nextLine(); 
//                    
//                    System.out.println("Enter Customer Contact:");                    
//                    String ucustomerContact = Validate.validatePhoneno();
////                    scanner.nextLine(); 
//                    
//                    System.out.println("Enter Drug ID:");
//                    int udrugID2 = Validate.validateInt("Valid Drug ID");
////                    scanner.nextLine(); 
//                    
//                    System.out.println("Enter Quantity:");
//                    int uquantity2 = Validate.validateInt("Valid Quantity");
////                    scanner.nextLine();
//                    
//                    System.out.println("Enter price:");
//                    int uprice = Validate.validateInt("Valid Price");
////                    scanner.nextLine();
//                    
////                    System.out.println("Enter Total Amount:");
//                    int utotalAmount = uquantity2*uprice;
////            		scanner.nextInt();
//                    
//				SaleDetails usal = new SaleDetails(usaleID, ucustomerName, ucustomerContact ,udrugID2, uquantity2, uprice ,utotalAmount);
//				SaleDetailsDAO.updateSaleDetails(usal);
				
                   
                    break;
                    
                case 3:
                    // Delete Sale details logic
                	
                	System.out.println("Enter SupplierID to delete:");
                    int delDrugID = Validate.validateInt("Valid Supplier ID");
//                    scanner.nextLine(); 
                    

                    SaleDetailsDAO.deleteSaleDetails(delDrugID);
                	
                    break;
                case 4:
                    // View Sale details logic
                	System.out.println("Enter SaleID to view:");
                    int viewSaleID = Validate.validateInt("Valid Sale ID");
//                    scanner.nextLine(); 
                    
                    SaleDetailsDAO.getSaleDetails(viewSaleID);
                    break;
                case 5:
                    return;

                default:
                    System.out.println("\u001B[31m" +"Invalid option! Please choose again.");
            }
    	}
    }

}
