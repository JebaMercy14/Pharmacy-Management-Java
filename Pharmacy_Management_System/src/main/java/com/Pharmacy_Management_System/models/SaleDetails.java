package com.Pharmacy_Management_System.models;

//import Pharmacy_Management_System.DAO.*;
//import com.pharmacyManagementSystem.Pharmacy_Management_System.*;

public class SaleDetails {
	private int saleID;
    private String customerName;
    private String customerContact;
    private int drugID;  
        
    private int price;
    private int quantity;
    
    private int totalAmount;
    
    

    // Constructor
    public SaleDetails(int saleID, String customerName, String customerContact ,int drugID, int price, int quantity, int totalAmount) {
        this.saleID = saleID;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.drugID = drugID;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }



	public int getSaleID() {
		return saleID;
	}



	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerContact() {
		return customerContact;
	}



	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}



	public int getDrugID() {
		return drugID;
	}



	public void setDrugID(int drugID) {
		this.drugID = drugID;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}



	

}
