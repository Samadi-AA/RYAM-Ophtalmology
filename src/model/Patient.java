package model;

import java.sql.*;

import control.DatabaseConnection;

public class Patient {

/*--- Properties ---*/
	int numPatient,numDossier;
	String nom,prenom,CIN,sexe,adresse;
	Date dateNaissance;
	int telephone;

/*--- Constructor ---*/
	
	public Patient(int numDossier, String nom, String prenom, String cIN, String sexe, String adresse, int telephone) {
		super();
		this.numDossier = numDossier;
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.sexe = sexe;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	public Patient() {
		//Dossier dossier = new Dossier();
		//numDossier = dossier.numDossier;
	}

/*--- Getters and Setters ---*/


/*--- Methods ---*/
	public void ajouterPatient() {
		
		try {
			DatabaseConnection Connect = new DatabaseConnection();
						
			String insertQuery = 
					"insert into patient("
					+ "CIN, nom, prenom, sexe, date_naissance, adresse, tel, num_dossier)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setString(1, CIN);
			preparedStmt.setString(2, nom);
			preparedStmt.setString(3, prenom);
			preparedStmt.setString(4, sexe);
			preparedStmt.setDate(5, dateNaissance);
			preparedStmt.setString(6, adresse);
			preparedStmt.setInt(7,telephone);
			preparedStmt.setInt(8,numDossier);
			
			preparedStmt.execute();
			Connect.closeConnection();
 			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void modifierPatient() {
		
		try {
			DatabaseConnection Connect = new DatabaseConnection();
			
			String updateQuery =
					"UPDATE patient SET "
					+ "CNI= ?,"
					+ "nom= ?,"
					+ "prenom= ?,"
					+ "sexe= ?,"
					+ "date_naissance= ?,"
					+ "adresse= ?,"
					+ "tel= ?,"
					+ "num_dossier= ?,"
					+ "WHERE num_patient = ?";
			
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setString(1, CIN);
			preparedStmt.setString(2, nom);
			preparedStmt.setString(3, prenom);
			preparedStmt.setString(4, sexe);
			preparedStmt.setDate(5, dateNaissance);
			preparedStmt.setString(6, adresse);
			preparedStmt.setInt(7,telephone);
			preparedStmt.setInt(8,numDossier);
			
			preparedStmt.execute();
			Connect.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
	}
	
	

}
