package model;

<<<<<<< HEAD
public class CompteDocteur {
=======
import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

public class CompteDocteur extends CompteSecretaire {
>>>>>>> 10684b310a7f4dd4217eed56e8b70f29db087f5a
	
/*--- Properties ---*/
	private String lastNameDoc;
	private String firstNameDoc;
	private DatabaseConnection connect = new DatabaseConnection();
	
/*--- Constructor ---*/
	public CompteDocteur(String firstName, String lastName, String userKey) {
		super(userKey);
		firstNameDoc = firstName;
		lastNameDoc = lastName;
	}

/*--- Getters and Setters ---*/
	public String getLastNameDoc() {
		return lastNameDoc;
	}

	public String getFirstNameDoc() {
		return firstNameDoc;
	}

	public void setLastNameDoc(String lastNameDoc) {
		this.lastNameDoc = lastNameDoc;
	}

	public void setFirstNameDoc(String firstNameDoc) {
		this.firstNameDoc = firstNameDoc;
	}

/*--- Methods ---*/
	public void modifierCompte(String firstName, String lastName) {
		
//		setFirstNameDoc(firstName);
//		setLastNameDoc(lastName);
		
		try {
			String updateQuery="update doctor set nom = ?, prenom = ? where username='doctor'";
		
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(updateQuery);
			
			preparedStmt.setString(1, firstName);
			preparedStmt.setString(2, lastName);
			
			preparedStmt.execute();
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		 
	}
		
}
	
//    its just a test :
//
//public static void main(String[] args) {
//	  SecretaireAccount s = new SecretaireAccount("Admin"); 
//	  DoctorAccount d = new DoctorAccount("DocTest", "test", "admin"); 
//	  d.modifierCompte("1name", "2name", "123456789");
//	  System.out.println(s.userKey); 
//	  System.out.println(d.userKey); 
//}
	
