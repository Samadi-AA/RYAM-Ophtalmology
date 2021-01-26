package model;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import control.DatabaseConnection;

public class RDV implements CRUD{
	
/*--- Properties ---*/
	private String nomPatient;
	private String CIN;
	private long numPatient, numRDV;
	private Timestamp datetimeRDV;
	private Date dateResevation;
	private DatabaseConnection connect;
	
/*--- Constructor ---*/
	public RDV(long numRDV) {
		this.numRDV = numRDV;
	}
	public RDV() {
		// empty constructor
	}
	public RDV(String nomPatient, String CIN) {
		this.nomPatient = nomPatient;
		this.CIN = CIN;
	}

/*--- Getters and Setters ---*/
	public String getNomPatient() {
		return nomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public long getNumPatient() {
		return numPatient;
	}
	public void setNumPatient(long numPatient) {
		this.numPatient = numPatient;
	}
	public long getNumRDV() {
		return numRDV;
	}
	public Timestamp getDatetimeRDV() {
		return datetimeRDV;
	}
	public void setDatetimeRDV(Timestamp datetimeRDV) {
		this.datetimeRDV = datetimeRDV;
	}
	public Date getDateResevation() {
		return dateResevation;
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
	
	public Timestamp selectLatestRDVDate() {
		Timestamp latestRDV = null;		
		try {
			connect = new DatabaseConnection();
			
			String selectQuery = "SELECT max(datetime_rdv) maxDatetime FROM rdv";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
			
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			while (res.next()) latestRDV = Timestamp.valueOf(res.getString("maxDatetime"));
			
			connect.closeConnection();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return latestRDV;
	}
	
	public void autoRDV() {
		Timestamp nextRDV = selectLatestRDVDate();
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String lastRDVTime = format.format(nextRDV);
		String endWorkTime = format.format(Timestamp.valueOf("1000-10-10 17:30:00.0"));
				
		if (lastRDVTime.contains(endWorkTime)) {
			long noWorkTime = ((14*60)+30)*60*1000;
			nextRDV.setTime(nextRDV.getTime() + noWorkTime);
		}
		else {
			long working = 30*60*1000;
			nextRDV.setTime(nextRDV.getTime() + working);
		}
		
		datetimeRDV = nextRDV;
	}
	
	public boolean confirmerVisite() {
		try {
			connect = new DatabaseConnection();
			String updateQuery = "UPDATE patient_courant SET num_pat_courant = "+ numPatient +" WHERE id = 0";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.execute();
			connect.closeConnection();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public boolean Ajouter() {
		if(CIN.isEmpty()) {
			Patient pat = new Patient();
			pat.Ajouter();
			numPatient = pat.getNumPatient();
		}
		else selectNumPatient();
		try {
			connect = new DatabaseConnection();
			String insertQuery = 
					"insert into rdv(nom_pat, num_pat, cin, datetime_rdv) "
					+ "values (?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(insertQuery);
			
			preparedStmt.setString(1, nomPatient);
			preparedStmt.setLong(2,numPatient);
			preparedStmt.setString(3, CIN);
			preparedStmt.setTimestamp(4, datetimeRDV);
						
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
		try {
			connect = new DatabaseConnection();
			String updateQuery =
					"UPDATE rdv SET "
					+ "datetime_rdv = ?"
					+ "where num_rdv =?";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setTimestamp(1, datetimeRDV);
			preparedStmt.setLong(2,numRDV);
			
			preparedStmt.execute();
			connect.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean Supprimer() {
		try {
			connect = new DatabaseConnection();
			String deleteQuery= "delete from rdv where num_rdv = " + numRDV;
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(deleteQuery);
			
			preparedStmt.execute();
			
			connect.closeConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}