import java.util.Date;

public class dossier {
	private int numDossier;
	private Date dateCreationDossier;
	
	public dossier(int numDossier,Date dateCreationDossier) {
		this.numDossier=numDossier;
		this.dateCreationDossier=dateCreationDossier;
	}
	
	public int getNumDossier() {
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
}
