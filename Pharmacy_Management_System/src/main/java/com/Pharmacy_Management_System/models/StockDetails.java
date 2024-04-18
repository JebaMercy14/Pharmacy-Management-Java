package com.Pharmacy_Management_System.models;

//import Pharmacy_Management_System.DAO.*;
//import com.pharmacyManagementSystem.Pharmacy_Management_System.*;

public class StockDetails {
	
	
		private int drugID;
	    private String drugName;
	    
	    private int quantity;
	    private String expiredDate;
	    private int price;
//	    private String status;

	    // Constructor
	    public StockDetails(int drugID, String drugName,  int quantity, String expiredDate, int price) {
	        this.drugID = drugID;
	        this.drugName = drugName;
	        
	        this.quantity = quantity;
	        this.expiredDate = expiredDate;
	        this.price = price;
	    }

		public int getDrugID() {
			return drugID;
		}

		public void setDrugID(int drugID) {
			this.drugID = drugID;
		}

		public String getDrugName() {
			return drugName;
		}

		public void setDrugName(String drugName) {
			this.drugName = drugName;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getExpiredDate() {
			return expiredDate;
		}

		public void setExpiredDate(String expiredDate) {
			this.expiredDate = expiredDate;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	    
	    // Getters and setters    
	    
	    
	    
}
