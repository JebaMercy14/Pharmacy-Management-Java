package Pharmacy_Management_System.DAO;

//import com.pharmacyManagementSystem.PharmacyManagementSystem.SupplierDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Pharmacy_Management_System.models.SupplierDetails;
//import com.pharmacyManagementSystem.GetterSetter.*;
//import com.pharmacyManagementSystem.Pharmacy_Management_System.*;

public class SupplierDetailsDAO {
//	 private static Connection connection;

//	    public SupplierDetailsDAO(Connection connection) {
//	        this.connection = connection;
//	    }
	
		public static void updateContact(int supplier_id,String contact) throws SQLException
		{
			String query1 = "select supplierId from SupplierDetails where supplierId = ?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
		preparedStatement1.setInt(1, supplier_id);
		ResultSet resultSet = preparedStatement1.executeQuery();
		int id = 0;
		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}
		if(id==0) {
			System.out.println("\u001B[31m" +"supplier ID does not exist!!");
			return;
		}
		
			
		String query="update SupplierDetails set supplierContact=? where supplierId=?";
	
			Connection con=DbConnection.getConnection();	
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,contact);
			
			pst.setInt(2, supplier_id);
			int rowsUpdated = pst.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("\u001B[32m" +"Supplier details updated successfully.");
                return;
            } else {
                System.out.println("\u001B[31m" +"No records updated. SupplierID not found.");
                return;
            }
	
		}
		
		public static void updateName(int supplierId,String name) throws SQLException
		{		
		String query="update SupplierDetails set supplierName=? where supplierId=?";
	
			Connection con=DbConnection.getConnection();	
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,name);
			
			pst.setInt(2, supplierId);
			
			int rowsUpdated = pst.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("\u001B[32m" +"Supplier details updated successfully.");
                return;
            } else {
                System.out.println("\u001B[31m" +"No records updated. SupplierID not found.");
                return;
            }
		}
		
		////////////////////////////////////////////////////////////////////////////

	    public static boolean addSupplierDetails(SupplierDetails supplierDetails) {
	        String query = "INSERT INTO SupplierDetails (supplierID, supplierName, drugID ,supplierContact) VALUES (?, ?, ?, ?)";
	        try (   Connection connection1 = DbConnection.getConnection();
	        		PreparedStatement statement = connection1.prepareStatement(query)) {
	        	
	        	// Check if the drugID already exists in StockDetails
	            String drugQuery = "SELECT COUNT(*) FROM StockDetails WHERE drugID = ?";
	            try (PreparedStatement drugStatement = connection1.prepareStatement(drugQuery)) {
	                drugStatement.setInt(1, supplierDetails.getDrugID());
	                try (ResultSet drugResultSet = drugStatement.executeQuery()) {
	                    drugResultSet.next();
	                    int drugCount = drugResultSet.getInt(1);
	                    if (drugCount == 0) {
	                        System.out.println("\u001B[31m" +"DrugID " + supplierDetails.getDrugID() + " does not exist. Record not inserted.");
	                        return false;
	                    }
	                }
	            }
	        	
	            statement.setInt(1, supplierDetails.getSupplierID());
	            statement.setString(2, supplierDetails.getSupplierName());
	            statement.setInt(3, supplierDetails.getDrugID());
	            statement.setString(4, supplierDetails.getSupplierContact());
	            
	         // Check if the supplierID already exists
	            String checkQuery = "SELECT COUNT(*) FROM SupplierDetails WHERE supplierID = ?";
	            try (PreparedStatement checkStatement = connection1.prepareStatement(checkQuery)) {
	                checkStatement.setInt(1, supplierDetails.getSupplierID());
	                try (ResultSet resultSet = checkStatement.executeQuery()) {
	                    resultSet.next();
	                    int count = resultSet.getInt(1);
	                    if (count > 0) {
	                        System.out.println("\u001B[31m" +"SupplierID " + supplierDetails.getSupplierID() + " already exists. Record not inserted.");
	                        return false;
	                    }
	                }
	            }
	            
	            int rowsInserted = statement.executeUpdate();
	            
	            System.out.println("\u001B[32m" +"Supplier details added successfully.");
	            
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public static boolean updateSupplierDetails(SupplierDetails supplierDetails) {
	        String query = "UPDATE SupplierDetails SET supplierName = ?, supplierContact = ? WHERE supplierID = ?";
	        try (	Connection connection2 = DbConnection.getConnection();
	        		PreparedStatement statement = connection2.prepareStatement(query)) {
	            statement.setString(1, supplierDetails.getSupplierName());
	            statement.setString(2, supplierDetails.getSupplierContact());
	            
	            statement.setInt(3, supplierDetails.getSupplierID());
	            int rowsUpdated = statement.executeUpdate();
	            
	            if (rowsUpdated > 0) {
	                System.out.println("\u001B[32m" +"Supplier details updated successfully.");
	                return true;
	            } else {
	                System.out.println("\u001B[31m" +"No records updated. SupplierID not found.");
	                return false;
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    

	    public static boolean deleteSupplierDetails(int supplierID) {
	        String query = "DELETE FROM SupplierDetails WHERE supplierID = ?";
	        try (	Connection connection3 = DbConnection.getConnection();
	        		PreparedStatement statement = connection3.prepareStatement(query)) {
	            statement.setInt(1, supplierID);
	            int rowsDeleted = statement.executeUpdate();
//	            return rowsDeleted > 0;
	            if (rowsDeleted > 0) {
	                System.out.println("\u001B[32m" +"Supplier with ID " + supplierID + " has been deleted successfully.");
	                return true;
	            } else {
	                System.out.println("\u001B[31m" +"No supplier found with ID " + supplierID + ". Deletion failed.");
	                return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Implement read operation
	    public static SupplierDetails getSupplierDetails(int supplierID) {
	        String query = "SELECT * FROM SupplierDetails WHERE supplierID = ?";
	        try (	Connection connection4 = DbConnection.getConnection();
	        		PreparedStatement statement = connection4.prepareStatement(query)) {
	            statement.setInt(1, supplierID);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) { 
	                
	                System.out.println("+-------------------+------------------------+");
	            	System.out.println(" Supplier ID        | " + resultSet.getInt(1) );
	                System.out.println(" Supplier Name      | " + resultSet.getString(2));
	                System.out.println(" Drug ID            | " + resultSet.getInt(3)  );
	                System.out.println(" Supplier Contact   | " + resultSet.getString(4) );	                
	                System.out.println("+-------------------+------------------------+");

	                
	            }
	            else {
	                System.out.println("\u001B[31m" +"No supplier found with ID " + supplierID);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
