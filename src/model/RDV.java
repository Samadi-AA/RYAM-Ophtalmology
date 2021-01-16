package model;
import java.sql.Date;

public class RDV {
	
/*--- Properties ---*/
	private int numRDV;
	private Date dateRDV;
	private float heureRDV;
	
/*--- Constructor ---*/
	public RDV(int numRDV,Date dateRDV,float heureRDV) {
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
	public float getHeureRDV() {
		return heureRDV;
	}
	public void setHeureRDV(int heureRDV) {
		this.heureRDV = heureRDV;
	}

	
	
	/*
	public void imprimiRDV(RDV r) {
	
	}*/

}
