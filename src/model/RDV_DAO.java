package model;

import java.sql.*;

import control.DatabaseConnection;

public class RDV_DAO {
	
	private DatabaseConnection Connect = new DatabaseConnection();
	
	public void ajouteRDV(RDV r) {
		try {
			DatabaseConnection Connect = new DatabaseConnection();
			String insertQuery = 
					"insert into rdv(num_rdv,date_rdv) values (?, ?)";
			
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setInt(1,r.getNumRDV());
			preparedStmt.setDate(2, r.getDateRDV());
			//preparedStmt.setFloat(3, r.getHeureRDV());
			
			preparedStmt.execute();
			Connect.closeConnection();
				
		}
			catch(SQLException e) {
					System.out.println(e.getMessage());
			}
	}
	
	public void annuleRDV(int num_rdv) {
		try {
		String anuuleQuery= "delete from rdv where num_rdv=?";
		
		
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(anuuleQuery);
			
			preparedStmt.setInt(1,num_rdv);
			preparedStmt.execute();
			Connect.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateRDV(RDV r) {
		try {
			String updateQuery =
					"UPDATE rdv SET "
					+ "num_rdv= ?,"
					+ "date_rdv= ?,"
					+ "heure_rdv= ?"
					+ "where num_rdv=?";
			
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setInt(1, r.getNumRDV());
			preparedStmt.setDate(2, r.getDateRDV());
			preparedStmt.setDate(3, r.getHeureRDV());
			
			preparedStmt.setInt(4, r.getNumRDV());
			
			preparedStmt.execute();
			Connect.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
