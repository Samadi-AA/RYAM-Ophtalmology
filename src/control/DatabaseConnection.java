package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetOphta","root","");
	        // "jdbc:mysql://localhost:3306/db_test","root",""
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
