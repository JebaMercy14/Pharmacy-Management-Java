package com.Pharmacy_Management_System.Service;

import java.sql.SQLException;
import java.util.Scanner;

import com.Pharmacy_Management_System.ExceptionalHandling.Validate;
import com.Pharmacy_Management_System.models.StockDetails;

import Pharmacy_Management_System.DAO.StockDetailsDAO;

public class StockService {
	static Scanner scanner = new Scanner(System.in);
	 public static void handleStockDetails() throws SQLException {
		 
		 
	        while (true) {
	        	
	        	System.out.println("\u001B[0m"+ "\u001B[1m"+"**************************************************************************");
	    		System.out.println("                      HANDLING THE STOCK DETAIL                       ");
	    		System.out.println("**************************************************************************");
	    		
	        	
	            System.out.println("Choose an option for Stock Detail:");
	            System.out.println("1. Add Stock Details");
	            System.out.println("2. Update Stock Details");
	            System.out.println("3. Delete Stock Details");
	            System.out.println("4. View Stock Details");
	            
	            System.out.println("5. Go Back");

	            int choice = Validate.validateInt("Valid Choice");
//	            scanner.nextLine(); // Consume newline

				switch (choice) {
	                case 1:
	                    // Add stock details 
	                	System.out.println("Enter DrugID:");                    
	                    int drugID= Validate.validateInt("Valid Drug ID");                    
//	                    scanner.nextLine(); 
	                	
	                    System.out.println("Enter Drug Name:");
	                    String drugName = Validate.validateDrugName("Valid Drug Name");
//	            		scanner.nextLine();              
	                    
	                                        
	                    System.out.println("Enter Quantity:");
	                    int quantity = Validate.validateInt("Valid Quantity");
//	                    scanner.nextLine();                  
	                    
	                    System.out.println("Enter a date (dd/MM/yyyy): ");
	                    String expiredDate = Validate.validateDate();
//	            		scanner.nextLine();                   
	                    
	                    System.out.println("Enter Price:");
	                    int price = Validate.validateInt("Valid Price");
//	            		scanner.nextInt();                  
	                    
	            		StockDetails ast= new StockDetails(drugID, drugName, quantity, expiredDate, price);
	                    StockDetailsDAO.addStockDetails(ast);                  
	                    
	                    
	                    break;
	                    
	                case 2:
	                	
	                	System.out.println("Choose the updation method:");
	    	            System.out.println("1. Update all details");
	    	            System.out.println("2. Update the particular details only");
	    	            

	    	            int updatechoice = Validate.validateInt("Valid Choice");
	    	            
	    	            switch (updatechoice) {
		                case 1:
		                	// Update stock details 
		                	System.out.println("Enter DrugID to update:");
		                    int udrugID = Validate.validateInt("Valid Drug ID");

		                
		                    System.out.println("Enter new Drug Name:");
		                    String udrugName = Validate.validateDrugName("Valid Drug Name");                   
		                    
		                    
		                    System.out.println("Enter new Quantity:");
		                    int uquantity = Validate.validateInt("Valid Quantity");
		                    
		                    System.out.println("Enter new Expired Date:");
		                    String uexpiredDate = Validate.validateDate();
		                    
		                    System.out.println("Enter new Price:");
		                    int uprice = Validate.validateInt("Valid Price");

		            		StockDetails ust= new  StockDetails(udrugID, udrugName, uquantity, uexpiredDate, uprice);
		                    StockDetailsDAO.updateStockDetails(ust);                     
		                    
		                      
		                    break;
		                                     
		                   
		                case 2:
		                	
		                	System.out.println("Enter your Drug id");
		            		int id=Validate.validateInt("Valid Drug ID");
		            		System.out.println("Enter your data to be updated:DrugName/Quantity/price ");
		            		String input=Validate.validateString("Valid Option");
		            		if(input.equalsIgnoreCase("DrugName"))
		            		{
		            			System.out.println("Enter the Drug Name to be Updated:");
		            			String name = Validate.validateDrugName("Valid Drug Name");
		            			StockDetailsDAO.updateName(id, name);	
		            		
		            		
		            		}
		            		else if(input.equalsIgnoreCase("quantity"))
		            		{
		            			System.out.println("Enter the Drug Quanity to be Updated:");
		            			int upquantity=Validate.validateInt("Valid Quantity");
		            			StockDetailsDAO.updateQuantity(id, upquantity);
		            			

		            			}
		            		else if(input.equalsIgnoreCase("price"))
		            		{
		            			System.out.println("Enter the Drug price to be Updated:");
		            			int upprice=Validate.validateInt("Valid Quantity");
		            			StockDetailsDAO.updatePrice(id, upprice);
		            			
		            		}
		            		else {
		            			System.out.println("Not a valid option!!");
		            		}
		                	 
		            		break;
		          
	                	
//	                    // Update stock details 
//	                	System.out.println("Enter DrugID to update:");
//	                    int udrugID = Validate.validateInt("Valid Drug ID");
////	                    scanner.nextLine(); 
//
//	                
//	                    System.out.println("Enter new Drug Name:");
//	                    String udrugName = Validate.validateDrugName("Valid Drug Name");
////	            		scanner.nextLine();                   
//	                    
//	                    
//	                    System.out.println("Enter new Quantity:");
//	                    int uquantity = Validate.validateInt("Valid Quantity");
////	                    scanner.nextLine(); 
//	                    
//	                    System.out.println("Enter new Expired Date:");
//	                    String uexpiredDate = Validate.validateDate();
////	            		scanner.nextLine();
//	                    
//	                    System.out.println("Enter new Price:");
//	                    int uprice = Validate.validateInt("Valid Price");
////	            		scanner.nextDouble();
//	            		
//	            		StockDetails ust= new  StockDetails(udrugID, udrugName, uquantity, uexpiredDate, uprice);
//	                    StockDetailsDAO.updateStockDetails(ust);                        
//	                    
//	                          
//	                      
	                    
	    	            }
	    	            break;
	                    
	                case 3:
	                    // Delete stock details 
	                	System.out.println("Enter DrugID to delete:");
	                    int delDrugID = Validate.validateInt("Valid DrugID");
//	                    scanner.nextLine(); 
	                    

	                    StockDetailsDAO.deleteStockDetails(delDrugID); 
	                    break;
	                   
	                case 4  :
	                    // View stock details
	                	
	                	System.out.println("Enter DrugID to view:");
	                    int viewDrugID = Validate.validateInt("Valid DrugID");
//	                    scanner.nextLine();                  
	                    
	                    StockDetailsDAO.getStockDetails(viewDrugID);                
	                    
	                    break;
	                case 5:
	                    return;
	                default:
	                    System.out.println("\u001B[31m" +"Invalid option! Please choose again.");
	            }
	        
	    }
	 }
}
