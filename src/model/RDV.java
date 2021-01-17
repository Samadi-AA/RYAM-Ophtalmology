package model;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

public class RDV {
	
/*--- Properties ---*/
	private int numRDV;
	private Date dateRDV;
	private Date heureRDV;
	private DatabaseConnection Connect = new DatabaseConnection();
	
/*--- Constructor ---*/
	public RDV(int numRDV,Date dateRDV,Date heureRDV) {
		this.numRDV=numRDV;
		this.dateRDV=dateRDV;
		this.heureRDV=heureRDV;
	}

/*--- Getters and Setters ---*/

	public int getNumRDV() {
		return numRDV;
	}
	public void setNumRDV(int numRDV) {
		this.numRDV = numRDV;
	}
	public Date getDateRDV() {
		return dateRDV;
	}
	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}
	public Date getHeureRDV() {
		return heureRDV;
	}
	public void setHeureRDV(Date heureRDV) {
		this.heureRDV = heureRDV;
	}

	/*--- methods ---*/
	
	//Ajoute RDV
	
	public void ajouteRDV() {
		try {
			String insertQuery = 
					"insert into rdv(num_rdv,date_rdv,heur_rdv) values (?,?,?)";
			
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setInt(1,numRDV);
			preparedStmt.setDate(2,dateRDV);
			preparedStmt.setDate(3,heureRDV);
			
			preparedStmt.execute();
			Connect.closeConnection();
				
		}
			catch(SQLException e) {
					System.out.println(e.getMessage());
			}
	}
	
	// Annul RDV
	
	public void annuleRDV() {
		try {
		String anuuleQuery= "delete from rdv where num_rdv=?";
		
		
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(anuuleQuery);
			
			preparedStmt.setInt(1,numRDV);
			preparedStmt.execute();
			Connect.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Modifier RDV
	
	public void modifieRDV() {
		try {
			String updateQuery =
					"UPDATE rdv SET "
					+ "num_rdv= ?,"
					+ "date_rdv= ?,"
					+ "heure_rdv= ?"
					+ "where num_rdv=?";
			
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setInt(1,numRDV);
			preparedStmt.setDate(2, dateRDV);
			preparedStmt.setDate(3, heureRDV);
			
			preparedStmt.setInt(4,numRDV);
			
			preparedStmt.execute();
			Connect.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	/*
	public void imprimiRDV(RDV r) {

	}*/

}