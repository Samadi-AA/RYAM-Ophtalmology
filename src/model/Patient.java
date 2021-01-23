package model;

import java.sql.*;

import control.DatabaseConnection;

public class Patient implements CRUD{

/*--- Properties ---*/
	long numPatient,numDossier;
	public long getNumPatient() {
		return numPatient;
	}

	String nom,prenom,CIN,sexe,adresse;
	Date dateNaissance;
	String telephone;
	Dossier dossier;
	DatabaseConnection connect;

/*--- Constructor ---*/
	public Patient() {
		
	}
	
	public Patient(String nom, String prenom, String CIN, String sexe, String adresse, String telephone) {
		super();
//		Dossier dossier = new Dossier();
//		numDossier = (int) dossier.getNumDossier();
		this.nom = nom;
		this.prenom = prenom;
		this.CIN = CIN;
		this.sexe = sexe;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	

/*--- Getters and Setters ---*/
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

/*--- Methods ---*/
	public void selectNumPatient() {
		try {
			connect = new DatabaseConnection();
			
			String selectQuery = "select num_patient from patient where cin = '"+CIN+"'";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
			
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			while (res.next()) numPatient = res.getLong("num_patient");
			
			connect.closeConnection();
		}
		catch (Exception e) {
			System.out.println("fuck you "+e.getMessage());
		}
	}
	
	@Override
	public boolean Ajouter() {
		try {
			dossier = new Dossier();
			dossier.Ajouter();
			numDossier = dossier.getNumDossier();
			
			connect = new DatabaseConnection();
						
			String insertQuery = "insert into patient "
					+ "(CIN, nom, prenom, sexe, date_naissance, adresse, tel, num_dossier)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setString(1, CIN);
			preparedStmt.setString(2, nom);
			preparedStmt.setString(3, prenom);
			preparedStmt.setString(4, sexe);
			preparedStmt.setDate(5, dateNaissance);
			preparedStmt.setString(6, adresse);
			preparedStmt.setString(7,telephone);
			preparedStmt.setLong(8,numDossier);
			
			preparedStmt.execute();
			connect.closeConnection();
			
			selectNumPatient();
 			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean Modifier() {
		try {
			connect = new DatabaseConnection();
			String updateQuery =
						"UPDATE patient SET "
						+ "CIN = ?,"
						+ "nom = ?,"
						+ "prenom = ?,"
						+ "sexe = ?,"
						+ "date_naissance = ?,"
						+ "adresse = ?,"
						+ "tel = ?"
						+ "WHERE num_patient = ?";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setString(1, CIN);
			preparedStmt.setString(2, nom);
			preparedStmt.setString(3, prenom);
			preparedStmt.setString(4, sexe);
			preparedStmt.setDate(5, dateNaissance);
			preparedStmt.setString(6, adresse);
			preparedStmt.setString(7, telephone);
			preparedStmt.setLong(8, numPatient);
			
			preparedStmt.execute();
			connect.closeConnection();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean Supprimer() {
		try {
			connect = new DatabaseConnection();
			
			String deleteQuery="delete from patient where cin = ?";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(deleteQuery);
			
			preparedStmt.setString(1, CIN);
			
			preparedStmt.execute();
			
			dossier.Supprimer();
			
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
