package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

public class Dossier {
	
/*--- Properties ---*/
	
<<<<<<< HEAD
	private static long numDossier = 0;
=======
	static long numDossier=0;
>>>>>>> 10684b310a7f4dd4217eed56e8b70f29db087f5a
	private Date dateCreationDossier;
	private DatabaseConnection Connect = new DatabaseConnection();

	
/*--- Constructor ---*/
	public Dossier() {
		numDossier++;
		this.AjouteDossier();
	}

/*--- Getters and Setters ---*/

	public long getNumDossier() {
		return numDossier;
	}
	public void setNumDossier(int numDossier) {
		Dossier.numDossier = numDossier;
	}
	public Date getDateCreationDossier() {
		return dateCreationDossier;
	}
	public void setDateCreationDossier(Date dateCreationDossier) {
		this.dateCreationDossier = dateCreationDossier;
	}

/*--- Methods ---*/
	
	public void AjouteDossier() {
		try {
			
			dateCreationDossier = new Date(System.currentTimeMillis());
			
			String insertQuery="insert into dossier values(?,?)";
		
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(insertQuery);
			
<<<<<<< HEAD
=======
			dateCreationDossier = System.currentTimeMillis();
			
>>>>>>> 10684b310a7f4dd4217eed56e8b70f29db087f5a
			preparedStmt.setLong(1, Dossier.numDossier);
			preparedStmt.setDate(2,dateCreationDossier);
			
			preparedStmt.execute();
			Connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
	}
	
	public void supprimerDossier() {
		try {
			String deleteQuery="delete from dossier where num_dossier=?";
			PreparedStatement preparedStmt = Connect.getConnection().prepareStatement(deleteQuery);
			
			preparedStmt.setLong(1, Dossier.numDossier);
			
			preparedStmt.execute();
			Connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
