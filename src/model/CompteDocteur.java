package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

public class CompteDocteur extends CompteSecretaire implements CRUD{
	
/*--- Properties ---*/
	private String nomDocteur;
	private String prenomDocteur;
	private DatabaseConnection connect = new DatabaseConnection();
	
/*--- Constructor ---*/
	public CompteDocteur(String prenomDocteur, String nomDocteur, String userKey) {
		super(userKey);
		this.prenomDocteur = prenomDocteur;
		this.nomDocteur = nomDocteur;
	}

/*--- Getters and Setters ---*/
	public String getNomDocteur() {
		return nomDocteur;
	}

	public void setNomDocteur(String nomDocteur) {
		this.nomDocteur = nomDocteur;
	}

	public String getPrenomDocteur() {
		return prenomDocteur;
	}

	public void setPrenomDocteur(String prenomDocteur) {
		this.prenomDocteur = prenomDocteur;
	}

/*--- Methods ---*/

	
	@Override
	public boolean Ajouter() {
		try {						
			String insertQuery = 
					"insert into doctor("
					+ "userkey, nom, prenom)"
					+ " values (?, ?, ?)";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setString(1, userKey);
			preparedStmt.setString(2, nomDocteur);
			preparedStmt.setString(3, prenomDocteur);
			
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
			String updateQuery="update doctor set nom = ?, prenom = ?, userKey = ? where username = ?";
		
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setString(1, nomDocteur);
			preparedStmt.setString(2, prenomDocteur);
			preparedStmt.setString(3, userKey);
			preparedStmt.setString(4, "doctor");
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
		
