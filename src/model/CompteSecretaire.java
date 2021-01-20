package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

public class CompteSecretaire implements CRUD{
	
/*--- Properties ---*/
	protected String userKey;
	private DatabaseConnection connect = new DatabaseConnection();
	
/*--- Constructor ---*/
	public CompteSecretaire(String userKey) {
		this.userKey = userKey;
	}

/*--- Getters and Setters ---*/
	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

/*--- Methods ---*/

	@Override
	public boolean Ajouter() {
		try {						
			String insertQuery = "insert into secretaire(userkey) values (?)";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setString(1, userKey);
	
			preparedStmt.execute();
			connect.closeConnection();
				
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public boolean Modifier() {
		try {
			String updateQuery="update secretaire set userKey = ? where username = ?";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setString(1, userKey);
			preparedStmt.setString(2, "secretaire");
	
			preparedStmt.execute();
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	
		return true;
	}
	
	@Override
	public boolean Supprimer() {
		// TODO Auto-generated method stub
		return false;
	}

}
