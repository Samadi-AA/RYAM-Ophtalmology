package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.DatabaseConnection;

public class Dossier implements CRUD{
	
/*--- Properties ---*/
	private static long numIncrement = 0;
	private long numDossier;
	private Date dateCreationDossier;
	private DatabaseConnection connect;
	
/*--- Constructor ---*/
	public Dossier() {
		initData();
		numIncrement++;
		numDossier = numIncrement;
		dateCreationDossier = new Date(System.currentTimeMillis());
	}

/*--- Getters and Setters ---*/

	public long getNumDossier() {
		return numDossier;
	}
	public void setNumDossier(int numDossier) {
		this.numDossier = numDossier;
	}
	public Date getDateCreationDossier() {
		return dateCreationDossier;
	}
	public void setDateCreationDossier(Date dateCreationDossier) {
		this.dateCreationDossier = dateCreationDossier;
	}

/*--- Methods ---*/	

	public void initData() {
		// get the next numDossier
		try {
			connect = new DatabaseConnection();
			
			String selectQuery = "SELECT max(num_dossier) as num FROM dossier";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
			
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			while (res.next()) numIncrement = res.getLong("num");
			
			connect.closeConnection();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public boolean Ajouter() {
		try {
			connect = new DatabaseConnection();
			String insertQuery="insert into dossier (num_dossier, date_creation) values(?,?)";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setLong(1, numDossier);
			preparedStmt.setDate(2, dateCreationDossier);
			
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
	public boolean Modifier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Supprimer() {
		try {
			connect = new DatabaseConnection();
			String deleteQuery="delete from dossier where num_dossier = ?";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(deleteQuery);
			
			preparedStmt.setLong(1, numDossier);
			
			preparedStmt.execute();
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
