package Pharmacy_Management_System.DAO;

//import com.pharmacyManagementSystem.PharmacyManagementSystem.SaleDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.Pharmacy_Management_System.models.SaleDetails;
import com.Pharmacy_Management_System.models.StockDetails;
//import com.pharmacyManagementSystem.GetterSetter.*;
//import com.pharmacyManagementSystem.Pharmacy_Management_System.*;
//import com.pharmacyManagementSystem.PharmacyManagementSystem.DbConnection;

public class StockDetailsDAO {
//	private static Connection connection;

//    public StockDetailsDAO(Connection connection) {
//        this.connection = connection;
//    }
	
		public static void updateName(int drug_id,String name) throws SQLException
		{
		
		String query="update StockDetails set drugName=? where drugId=?";
	
			Connection con=DbConnection.getConnection();	
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,name);
			
			pst.setInt(2, drug_id);
			int rowsUpdated = pst.executeUpdate();
            
            
	        if (rowsUpdated > 0) {
	            System.out.println("\u001B[32m" +"Stock details updated successfully.");
	            return;
	        } else {
	            System.out.println("\u001B[31m" +"DrugID not found!!!... No records updated.");
	            return;
	        }		
		}
		
		
		public static void updateQuantity(int drug_id,int quantity) throws SQLException
		{
		
		String query="update StockDetails set quantity=? where drugId=?";
	
			Connection con=DbConnection.getConnection();	
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,quantity);
			
			pst.setInt(2, drug_id);
			int rowsUpdated = pst.executeUpdate();
            
            
	        if (rowsUpdated > 0) {
	            System.out.println("\u001B[32m" +"Stock details updated successfully.");
	            return;
	        } else {
	            System.out.println("\u001B[31m" +"DrugID not found!!!... No records updated.");
	            return;
	        }		
		}
		public static void updatePrice(int drug_id,int price) throws SQLException
		{
		
		String query="update StockDetails set price=? where drugId=?";
	
			Connection con=DbConnection.getConnection();	
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,price);
			
			pst.setInt(2, drug_id);
			int rowsUpdated = pst.executeUpdate();
			            
			            
	        if (rowsUpdated > 0) {
	            System.out.println("\u001B[32m" +"Stock details updated successfully.");
	            return;
	        } else {
	            System.out.println("\u001B[31m" +"DrugID not found!!!... No records updated.");
	            return;
	        }		
		}
		
		
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public static void updateStockQuantity(int id,int quantity) throws SQLException	{
          String stockquery = "update StockDetails set quantity=quantity-? where drugID=?";
          Connection connection = DbConnection.getConnection();
        		  PreparedStatement pst=connection.prepareStatement(stockquery);
        	  pst.setInt(1,quantity);
              pst.setInt(2, id);
              pst.executeUpdate();
	
	}
	
	
   ///////////////////////////////////////////////////////////////////////////////////////////

    public static boolean addStockDetails(StockDetails stockDetails) {
    	
    	
    	
        String query = "INSERT INTO StockDetails (drugID, drugName, quantity, expiredDate, price) VALUES (?, ?, ?, ?, ?)";
        try (	Connection connection1 = DbConnection.getConnection();
        		PreparedStatement statement = connection1.prepareStatement(query)) {
            statement.setInt(1, stockDetails.getDrugID());
            statement.setString(2, stockDetails.getDrugName());            
            statement.setInt(3, stockDetails.getQuantity());
            statement.setString(4, stockDetails.getExpiredDate());
            statement.setInt(5, stockDetails.getPrice());
            
         // Check if the drugID already exists
            String checkQuery = "SELECT COUNT(*) FROM StockDetails WHERE drugID = ?";
            try (PreparedStatement checkStatement = connection1.prepareStatement(checkQuery)) {
                checkStatement.setInt(1, stockDetails.getDrugID());
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        System.out.println("\u001B[31m" +"DrugID " + stockDetails.getDrugID() + " already exists. Record not inserted.");
                        return false;
                    }
                }
            }
            
            int rowsInserted = statement.executeUpdate();
            
            System.out.println("\u001B[32m" +"Stock details added successfully.");
            
            
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateStockDetails(StockDetails stockDetails) {
        String query = "UPDATE StockDetails SET drugName = ?, quantity = ?, expiredDate = ?, price = ? WHERE drugID = ?";
        try (	Connection connection2 = DbConnection.getConnection();
        		PreparedStatement statement = connection2.prepareStatement(query)) {
            statement.setString(1, stockDetails.getDrugName());            
            statement.setInt(2, stockDetails.getQuantity());
            statement.setString(3, stockDetails.getExpiredDate());
            statement.setInt(4, stockDetails.getPrice());
            statement.setInt(5, stockDetails.getDrugID());
            int rowsUpdated = statement.executeUpdate();
            
            
            if (rowsUpdated > 0) {
                System.out.println("\u001B[32m" +"Stock details updated successfully.");
                return true;
            } else {
                System.out.println("\u001B[31m" +"DrugID not found!!!... No records updated.");
                return false;
            }
            
//            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteStockDetails(int drugID) {
        String query = "DELETE FROM StockDetails WHERE drugID = ?";
        try (	Connection connection2 = DbConnection.getConnection();
        		PreparedStatement statement = connection2.prepareStatement(query)) {
        	
        	
        	// Check if the drugID already exists in SaleDetails
            String saleQuery = "SELECT COUNT(*) FROM SaleDetails WHERE drugID = ?";
            try (PreparedStatement saleStatement = connection2.prepareStatement(saleQuery)) {
                saleStatement.setInt(1, drugID);
                try (ResultSet saleResultSet = saleStatement.executeQuery()) {
                    saleResultSet.next();
                    int saleCount = saleResultSet.getInt(1);
                    if (saleCount > 0) {
                        System.out.println("\u001B[31m" + "DrugID " + drugID + " is used as reference to Sales Detail. This cannot be deleted.");
                        return false;
                    }
                }
            }

            // Check if the drugID already exists in SupplierDetails
            String supplierQuery = "SELECT COUNT(*) FROM SupplierDetails WHERE drugID = ?";
            try (PreparedStatement supplierStatement = connection2.prepareStatement(supplierQuery)) {
                supplierStatement.setInt(1, drugID);
                try (ResultSet supplierResultSet = supplierStatement.executeQuery()) {
                    supplierResultSet.next();
                    int supplierCount = supplierResultSet.getInt(1);
                    if (supplierCount > 0) {
                        System.out.println("\u001B[31m" + "DrugID " + drugID + " is used as reference to Supplier Detail. This cannot be deleted.");
                        return false;
                    }
                }
            }
        	
            statement.setInt(1, drugID);
            int rowsDeleted = statement.executeUpdate();           
            
            
//            return rowsDeleted > 0;
            if (rowsDeleted > 0) {
                System.out.println("\u001B[32m" +"The required drug detail has been deleted.");
                return true;
            } else {
                System.out.println("No matching drug detail found for deletion.");
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public static StockDetails getStockDetails(int drugID) {
        String query = "SELECT * FROM StockDetails WHERE drugId = ?";
        try (	Connection connection3 = DbConnection.getConnection();
        		PreparedStatement statement = connection3.prepareStatement(query)) {
            statement.setInt(1, drugID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	System.out.println("+-------------------+------------------------+");
            	System.out.println(" Drug ID            | " + resultSet.getInt(1) );
                System.out.println(" Drug Name          | " + resultSet.getString(2));
                System.out.println(" Quantity           | " + resultSet.getInt(3)  );
                System.out.println(" Expired Date       | " + resultSet.getString(4) );
                System.out.println(" Price              | Rs. " + resultSet.getInt(5) );
                System.out.println("+-------------------+------------------------+");
            }
            else {
                System.out.println("\u001B[31m" +"No matching drug detail found!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

}
}
