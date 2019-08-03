package dbutil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLConnection {
	 
	
	public static Connection getConnection() 
	{
	/* Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/employee_management";
	String username="root";
	String password="root";	
	connection = DriverManager.getConnection("url", username, password);
	return connection; */
		
		System.out.println("12345");
	    Connection dbConnection = null;

	    try {
	      String url = "jdbc:mysql://localhost:3306/employee_management";
	      Properties info = new Properties();
	      info.put("user", "root");
	      info.put("password", "root");

	      dbConnection = DriverManager.getConnection(url, info);
	      
	      Statement stmt = dbConnection.createStatement();

	      String sql = "SELECT user_id,password FROM login_master";
	      ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("user_id");
	         String pass  = rs.getString("password");

	         System.out.print("ID: " + id); 
	         System.out.print("pass: " + pass); 
	         System.out.println(" "); 
	         
	      }
	      rs.close();

	      if (dbConnection != null) {
	        System.out.println("Successfully connected to MySQL database test");
	      }

	    } catch (SQLException ex) {
	      System.out.println("An error occurred while connecting MySQL databse");
	      ex.printStackTrace();
	    }
	    
		return dbConnection;
	}
}
