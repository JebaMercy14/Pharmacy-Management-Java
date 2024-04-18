package Pharmacy_Management_System.DAO;

//import com.pharmacyManagementSystem.PharmacyManagementSystem.SaleDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Pharmacy_Management_System.models.SaleDetails;
//import com.Pharmacy_Management_System.models.StockDetails;
//import com.pharmacyManagementSystem.GetterSetter.*;
//import com.pharmacyManagementSystem.Pharmacy_Management_System.*;

public class SaleDetailsDAO {
//	private static Connection connection;

//    public SaleDetailsDAO(Connection connection) {
//        this.connection = connection;
//    }
	
	public static void updateName(int cusId,String name) throws SQLException
	{		
	String query="update SaleDetails set customerName=? where saleId = ?";

		Connection con=DbConnection.getConnection();	
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,name);
		
		pst.setInt(2, cusId);
		
		int rowsUpdated = pst.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("\u001B[32m" +"Customer details updated successfully.");
            return;
        } else {
            System.out.println("\u001B[31m" +"No records updated. SaleID not found.");
            return;
        }
	}
	
	public static void updateContact(int sale_id,String contact) throws SQLException
	{
		String query1 = "select saleId from SaleDetails where saleId = ?;";
	Connection connection = DbConnection.getConnection();
	PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
	preparedStatement1.setInt(1, sale_id);
	ResultSet resultSet = preparedStatement1.executeQuery();
	int id = 0;
	while(resultSet.next()) {
		id = resultSet.getInt(1);
	}
	if(id==0) {
		System.out.println("sales ID does not exist!!");
		return;
	}
	
		
	String query="update SaleDetails set customerContact=? where saleId=?";

		Connection con=DbConnection.getConnection();	
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,contact);
		
		pst.setInt(2, sale_id);
		int rowsUpdated = pst.executeUpdate();
        

        
        if (rowsUpdated > 0) {
            System.out.println("\u001B[32m" +"Sales details updated successfully.");
            return;
        } else {
            System.out.println("\u001B[31m" +"No records updated. SaleID not found.");
            return;
        }

	}
//	public static void updateEmail(int sales_id,String email) throws SQLException
//	{
//		String query1 = "select Sale_id from SalesDetails where sale_id = ?;";
//		Connection connection = DbConnection.getConnection();
//		PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
//		preparedStatement1.setInt(1, sales_id);
//		ResultSet resultSet = preparedStatement1.executeQuery();
//		int id = 0;
//		while(resultSet.next()) {
//			id = resultSet.getInt(1);
//		}
//		if(id==0) {
//			System.out.println("sales ID does not exist!!");
//			return;
//		}
//	
//	String query="update SalesDetails set email=? where sale_id=?";
//
//		Connection con=DbConnection.getConnection();	
//		PreparedStatement pst=con.prepareStatement(query);
//		pst.setString(1,email);
//		
//		pst.setInt(2, sales_id);
//	pst.executeUpdate();	
//	System.out.println("sales email is Updated Successfully");
//	}
	
	
	//////////////////////////////////////////////////////////////////////

    public static boolean addSaleDetails(SaleDetails saleDetails) {
        String query = "INSERT INTO SaleDetails (saleID, customerName, customerContact ,DrugID ,quantity, price,totalAmount) VALUES (?, ?, ?, ?, ?, ?, ?)";
       
        try (	Connection connection1 = DbConnection.getConnection();
        		PreparedStatement statement = connection1.prepareStatement(query)) {
        	
        	
        	// Check if the drugID already exists in StockDetails
            String drugQuery = "SELECT COUNT(*) FROM StockDetails WHERE drugID = ?";
            try (PreparedStatement drugStatement = connection1.prepareStatement(drugQuery)) {
                drugStatement.setInt(1, saleDetails.getDrugID());
                try (ResultSet drugResultSet = drugStatement.executeQuery()) {
                    drugResultSet.next();
                    int drugCount = drugResultSet.getInt(1);
                    if (drugCount == 0) {
                        System.out.println("\u001B[31m" +"DrugID " + saleDetails.getDrugID() + " does not exist. Record not inserted.");
                        return false;
                    }
                }
            }
        	
            statement.setInt(1, saleDetails.getSaleID());
            statement.setString(2, saleDetails.getCustomerName());
            statement.setString(3, saleDetails.getCustomerContact());
            statement.setInt(4, saleDetails.getDrugID());
            statement.setInt(5, saleDetails.getQuantity());
            statement.setInt(6, saleDetails.getPrice());
            statement.setInt(7, saleDetails.getTotalAmount());
            
         // Check if the saleID already exists
            String checkQuery = "SELECT COUNT(*) FROM SaleDetails WHERE saleID = ?";
            try (PreparedStatement checkStatement = connection1.prepareStatement(checkQuery)) {
                checkStatement.setInt(1, saleDetails.getSaleID());
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        System.out.println("\u001B[31m" +"SaleID " + saleDetails.getSaleID() + " already exists. Record not inserted.");
                        return false;
                    }
                }
            }
            
//         // Update stock quantity in the stock
//            String stockquery="update StockDetails set quantity=quantity-? where drug_id=?";
//            PreparedStatement pst=connection1.prepareStatement(stockquery);
//            	pst.setInt(1, saleDetails.getQuantity());
//                pst.setInt(2, saleDetails.getDrugID());
//                pst.executeUpdate();
//                    
//            }
            
//            {
//        		
//        		String stockquery="update StockDetails set quantity=quantity-? where drug_id=?";
//        	
//        				
//        			PreparedStatement pst=connection1.prepareStatement(stockquery);
//        			pst.setInt(1,quantity);
//        			
//        			pst.setInt(2, drug_id);
//        		pst.executeUpdate();		
//        		}
            
            int rowsInserted = statement.executeUpdate();
            
            System.out.println("\u001B[32m" +"Sale details added successfully.");
            
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateSaleDetails(SaleDetails saleDetails) {
        String query = "UPDATE SaleDetails SET customerName = ?, customerContact = ? , price=? ,quantity = ?, totalAmount = ? WHERE saleID = ?";
        try (	Connection connection2 = DbConnection.getConnection();
        		PreparedStatement statement = connection2.prepareStatement(query)) {
            statement.setString(1, saleDetails.getCustomerName());
            statement.setString(2, saleDetails.getCustomerContact());
            
            statement.setInt(3, saleDetails.getPrice());
            statement.setInt(4, saleDetails.getQuantity());
            statement.setInt(5, saleDetails.getTotalAmount());
            statement.setInt(6, saleDetails.getSaleID());
            int rowsUpdated = statement.executeUpdate();
            

            
            if (rowsUpdated > 0) {
                System.out.println("\u001B[32m" +"Sales details updated successfully.");
                return true;
            } else {
                System.out.println("\u001B[31m" +"No records updated. SaleID not found.");
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteSaleDetails(int saleID) {
        String query = "DELETE FROM saleDetails WHERE saleID = ?";
        try (	Connection connection3 = DbConnection.getConnection();
        		PreparedStatement statement = connection3.prepareStatement(query)) {
            statement.setInt(1, saleID);
            int rowsDeleted = statement.executeUpdate();
//            return rowsDeleted > 0;
            
            if (rowsDeleted > 0) {
                System.out.println("\u001B[32m" +"The sale detail with ID " + saleID + " has been deleted.");
                return true;
            } else {
                System.out.println("\u001B[31m" +"No matching sale detail found for deletion.");
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Implement read operation
    public static SaleDetails getSaleDetails(int saleID) {
        String query = "SELECT * FROM SaleDetails WHERE saleID = ?";
        try (	Connection connection4 = DbConnection.getConnection();
        		PreparedStatement statement = connection4.prepareStatement(query)) {
            statement.setInt(1, saleID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
              
              
              System.out.println("+-------------------+------------------------+");
          	  System.out.println(" Sale ID            | " + resultSet.getInt(1) );
              System.out.println(" Customer Name      | " + resultSet.getString(2));
              System.out.println(" Customer Contact   | " + resultSet.getString(3));
              System.out.println(" Drug ID            | " + resultSet.getInt(4) );
              System.out.println(" Quantity           | " + resultSet.getInt(5)  );
              System.out.println(" Price              | Rs. " + resultSet.getInt(6) );
              System.out.println(" Total Amount       | Rs. " + resultSet.getInt(7) );
              System.out.println("+-------------------+------------------------+");
              
            }
            else {
                System.out.println("\u001B[31m" +"No matching sale detail found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
