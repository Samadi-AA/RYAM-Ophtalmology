package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.DatabaseConnection;

	
	public class Visite {
		long numVisite, numDossier;
	
		Date date_visite;
		String prescription;
		String symptome;
		String  medcine;
		String remede;
		long prix_pay;
		private DatabaseConnection connect;

		
	/*--- Constructor ---*/
		
		// constructor empty
		
		public Visite() {
			super();
			
		}
		
		// constructor with variables
		
		
			public Visite( String prescription, String symptome, String medcine,
					String remede,long prix_pay) {
				super();
				//this.date_visite = date_visite;
				this.prescription = prescription;
				this.symptome = symptome;
				this.medcine = medcine;
				this.remede = remede;
				this.prix_pay = prix_pay;
			}

		
		
		
		


	/*--- Getters and Setters ---*/
			
			
			
			public long getNum_visite() {
				return numVisite;
			}

			public void setNum_visite(long num_visite) {
				this.numVisite = num_visite;
			}
			
			
			

			
			public Date getDate_visite() {
				return date_visite;
			}

			public void setDate_visite(Date date_visite) {
				this.date_visite = date_visite;
			}

			
			
			
			public String getPrescription() {
				return prescription;
			}

			public void setPrescription(String prescription) {
				this.prescription = prescription;
			}

			
			
			public String getSymptome() {
				return symptome;
			}

			public void setSymptome(String symptome) {
				this.symptome = symptome;
			}

			
			
			public String getMedcine() {
				return medcine;
			}

			
			public void setMedcine(String medcine) {
				this.medcine = medcine;
			}

			
			
			public String getRemede() {
				return remede;
			}

			public void setRemede(String remede) {
				this.remede = remede;
			}


			public long getPrix_pay() {
				return prix_pay;
			}

			public void setPrix_payer(long prix_pay) {
				this.prix_pay = prix_pay;
			}
			
			
			
			public Date DateVisite() {
				return date_visite =new Date(System.currentTimeMillis());
			}
			
			
			


	/*--- Methods ---*/
			
			
			
			
			
			// method to get number of folder
			
			public long NumeroDossier() {
				Dossier dossier=new Dossier();
				long numero=dossier.getNumDossier();
				
				return  numero;
			}
			
			
			
			// method to add visit
			
			public void Ajoutevisite() {
				
			
				date_visite =new Date(System.currentTimeMillis());
				
				
				try {
				 connect=new DatabaseConnection();
				
				String insertinfo="INSERT INTO visite(num_dossier,date_visite ,prescription,symptome ,medecine,remede ,paiement)"
						+ "VALUES(?,?,?,?,?,?,?)";
				
				PreparedStatement pstatement=connect.getConnection().prepareStatement(insertinfo);
				
				
				pstatement.setLong(1,NumeroDossier());
				pstatement.setDate(2,date_visite);
				pstatement.setString(3,prescription);
				pstatement.setString(4,symptome);
				pstatement.setString(5,medcine);
				pstatement.setString(6,remede);
				pstatement.setDouble(7,prix_pay);
				
				connect.closeConnection();
				
				
				}catch (Exception e) {
					
					System.out.println("failed add visite "+e);
				}
				
			}

		
		// method update visit
			
			public void ModifierVisite() {
				date_visite =new Date(System.currentTimeMillis());
				
				try {
				connect=new DatabaseConnection();
				
				
				
				String updetevisite="UPDATE visite SET "
						+ "num_dossier=? "
						+ "date_visite=?"
						+ "prescription=? "
						+ "symptome=?"
						+ "medecine=?"
						+ "remede=?"
						+ "paiement=?";
				
				
					PreparedStatement statement=connect.getConnection().prepareStatement(updetevisite);
					statement.setLong(1,NumeroDossier());
					statement.setDate(2,date_visite);
					statement.setString(3,prescription);
					statement.setString(4,symptome);
					statement.setString(5,medcine);
					statement.setString(6,remede);
					statement.setLong(7,prix_pay);
					
					statement.execute();
					connect.closeConnection();
					
				
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			
			
		
			
			
			//method to delete visit 
			
		    public void SupprimerVisite() {
		    	
		    	
		    	
		    	try {
		    		String supprimer="DELETE * FROM visite WHERE num_visite= ?";
		    		
		    		connect=new DatabaseConnection();
		    		
					PreparedStatement statementdelete=connect.getConnection().prepareStatement(supprimer);
					
					statementdelete.setLong(1,numVisite);
					
					
					statementdelete.execute();
					connect.closeConnection();
					
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    }
			

	}
