package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

public class CompteSecretaire {
	
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
	public void modifierMotDePass(String userKey) {
		//setUserKey(userKey);
		
		try {
			String updateQuery="update secretaire set userKey = ? where username='secretaire'";
		
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setString(1, userKey);

			preparedStmt.execute();
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
