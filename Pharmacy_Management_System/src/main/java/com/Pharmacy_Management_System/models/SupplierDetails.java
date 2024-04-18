package com.Pharmacy_Management_System.models;

//import Pharmacy_Management_System.DAO.*;
//import com.pharmacyManagementSystem.Pharmacy_Management_System.*;

public class SupplierDetails {
	private int supplierID;
    private String supplierName;
    private int drugID;
    private String supplierContact;

    // Constructor
    public SupplierDetails(int supplierID, String supplierName, int drugID ,String supplierContact) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.drugID = drugID;
        this.supplierContact = supplierContact;
    }
    
    // Getters and setters	

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getDrugID() {
		return drugID;
	}

	public void setDrugID(int drugID) {
		this.drugID = drugID;
	}

	public String getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
    
    

	
    
    
}
