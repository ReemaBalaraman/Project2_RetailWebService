package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Product;

public class DBconnection {

	private static String dbUrl = "jdbc:mysql://127.0.0.1:8080/lsmarketplace";
	private static String dbUsername = "reema";
	private static String dbPassword = "root123";

	private Statement statement = null;

	public Product searchProduct(int productID)
	{
		Product product = new Product();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			statement = connection.createStatement();
			ResultSet result = null;
			/*System.out.println("Database connection established");

			System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO product " +
		                   "VALUES (4, 'Chair', 75.50)";
		   statement.executeUpdate(sql);
		   System.out.println("Inserted records into the table...");*/
			String query = "select * from product where ProductID=1";
			result = statement.executeQuery(query);
			if(result!=null)
			{
				System.out.println("Inserting records into the table...");
				result.next();
				product.setProductID(result.getInt("ProductID"));
				product.setProductDescription(result.getString("ProductDescription"));
				product.setUnitPrice(result.getDouble("UnitPrice"));
			}


		} catch(SQLException e) {
			System.err.print(e.getMessage());
		} catch(Exception e) {
			System.err.print(e.getMessage());
		}
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return product;
	}	

}
