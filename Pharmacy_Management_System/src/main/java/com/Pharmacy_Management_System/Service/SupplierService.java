package com.Pharmacy_Management_System.Service;

import java.sql.SQLException;
import java.util.Scanner;

import com.Pharmacy_Management_System.ExceptionalHandling.Validate;
//import com.Pharmacy_Management_System.models.StockDetails;
import com.Pharmacy_Management_System.models.SupplierDetails;

//import Pharmacy_Management_System.DAO.StockDetailsDAO;
import Pharmacy_Management_System.DAO.SupplierDetailsDAO;

public class SupplierService {
	static Scanner scanner = new Scanner(System.in);

	public static void handleSupplierDetails() throws SQLException {	
		
        
    	while (true) {
    		
    		System.out.println("\u001B[0m"+ "\u001B[1m"+"**************************************************************************");
    		System.out.println("                      HANDLING THE SUPPLIER DETAIL                      ");
    		System.out.println("**************************************************************************");
    		
    		
            System.out.println("Choose an option for Supplier Details:");
            System.out.println("1. Add Supplier Details");
            System.out.println("2. Update Supplier Details");
            System.out.println("3. Delete Supplier Details");
            System.out.println("4. View Supplier Details");
            System.out.println("5. Go Back");

            int choice = Validate.validateInt("Valid Choice");

            switch (choice) {
                case 1:
                    // Add Supplier details
                	System.out.println("Enter Supplier ID:");
                    int supplierID = Validate.validateInt("Valid Supplier ID");
//                    scanner.nextLine();                 
                    
                    
                    System.out.println("Enter Supplier Name:");
                    String supplierName2 = Validate.validateString("Valid Supplier Name");
//            		scanner.nextLine();
            		
            		System.out.println("Enter Drug ID:");
                    int DrugId = Validate.validateInt("Valid Drug ID");
//            		scanner.nextLine();
                    
                    
                    System.out.println("Enter Supplier Contact:");
                    String supplierContact = Validate.validatePhoneno();
//            		scanner.nextLine();
                   
                    
//				new SupplierDetails(supplierID, supplierName2, DrugId ,supplierContact);
				
            	SupplierDetails asud= new SupplierDetails(supplierID, supplierName2, DrugId ,supplierContact);
            	SupplierDetailsDAO.addSupplierDetails(asud);
            	
            	
                    
                    break;
                case 2:
                	
                	System.out.println("Choose the updation method:");
    	            System.out.println("1. Update all details");
    	            System.out.println("2. Update the particular details only");
    	            

    	            int updatechoice = Validate.validateInt("Valid Choice");
    	            
    	            switch (updatechoice) {
	                case 1:
	                	// Update all Sale Details details 
	                    
	                	System.out.println("Enter Supplier ID:");
	                    int usupplierID = Validate.validateInt("Valid Supplier ID");
	                    
	                    
	                    System.out.println("Enter Supplier Name:");
	                    String usupplierName2 = Validate.validateString("Valid Supplier Name");

	            		
	            		System.out.println("Enter Drug ID:");
	                    int uDrugId = Validate.validateInt("Valid Drug ID");	                    
	                    
	                    System.out.println("Enter Supplier Contact:");
	                    String usupplierContact = Validate.validatePhoneno();
	            		
	            		SupplierDetails usup= new SupplierDetails(usupplierID, usupplierName2, uDrugId ,usupplierContact);
	                	SupplierDetailsDAO.updateSupplierDetails(usup);                 
	                    
	                      
	                    break;
	                                     
	                   
	                case 2:
	                	System.out.println("Enter your Supplier id");
	            		int id=Validate.validateInt("Valid Drug ID");
	            		System.out.println("Enter your update data :Name/Contact");
	            		String input=Validate.validateString("Valid choice");
	            		
	            		if(input.equalsIgnoreCase("Name"))
	            		{          		
	            			System.out.println("Enter Supplier Name:");
		                    String upsupplierName = Validate.validateString("Valid Supplier Name");
		                    SupplierDetailsDAO.updateName(id, upsupplierName);
	            			
	            		}
	            		else if(input.equalsIgnoreCase("Contact"))
	            		{            			
	            			System.out.println("Enter Supplier Contact:");
		                    String contactNumber = Validate.validatePhoneno();
		                    SupplierDetailsDAO.updateContact(id, contactNumber);        			
	            			
	            		}
	            		else {
	            			System.out.println("Not a valid option!!");
	            			
	            		}
	            		break;
	                	
	                	
    	            }
                	
//                    // Update Supplier details logic
//                	System.out.println("Enter Supplier ID:");
//                    int usupplierID = Validate.validateInt("Valid Supplier ID");
////                    scanner.nextLine();                 
//                    
//                    
//                    System.out.println("Enter Supplier Name:");
//                    String usupplierName2 = Validate.validateString("Valid Supplier Name");
////            		scanner.nextLine();
//            		
//            		System.out.println("Enter Drug ID:");
//                    int uDrugId = Validate.validateInt("Valid Drug ID");
////            		scanner.nextLine();
////                    
//                    
//                    System.out.println("Enter Supplier Contact:");
//                    String usupplierContact = Validate.validatePhoneno();
////            		scanner.nextLine();
//            		
//            		SupplierDetails usup= new SupplierDetails(usupplierID, usupplierName2, uDrugId ,usupplierContact);
//                	SupplierDetailsDAO.updateSupplierDetails(usup);
//                	
//                	
//                	
                    break;
                case 3:
                    // Delete Supplier details logic
                	
                	System.out.println("Enter SupplierID to delete:");
                    int delSupplierID = Validate.validateInt("Valid Supplier ID");
//                    scanner.nextLine(); 
                    

                    SupplierDetailsDAO.deleteSupplierDetails(delSupplierID);
                	
                    break;
                case 4:
                	// View Supplier details logic
                	System.out.println("Enter SupplierID to view:");
                    int viewSupplierID = Validate.validateInt("Valid Supplier ID");
//                    scanner.nextLine(); 
                    
                    SupplierDetailsDAO.getSupplierDetails(viewSupplierID);
                    
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\u001B[31m" +"Invalid option! Please choose again.");
            }
        }
    	
    }

}
