package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.DatabaseConnection;

public class DoctorHome extends JPanel{
	String num,cin,nom,prenom,sexe,date,adresse,tel;
	
	/*-- Design --*/
	private ImageIcon patientIcon = new ImageIcon(LoginView.class.getResource("/view/icons/patientInfo.png"));
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 30);
	private final Font fieldFont = new Font(Font.MONOSPACED, Font.BOLD, 16);

	public JPanel OrdonanceForm = new JPanel();
	public GridBagConstraints patientCourantConstraint, OrdonanceFormConstraint;
	
	
	
	
	public DoctorHome() {
		getPatientCourant();
		setBounds(0, 0, 1350, 670);
		setLayout(new GridBagLayout());
		//setBackground(mainDark);
		
		patientCourantConstraint = new GridBagConstraints();
		patientCourantConstraint.gridx=0;
		patientCourantConstraint.gridy=0;
		patientCourantConstraint.gridwidth=1;
		patientCourantConstraint.gridheight=1;
		patientCourantConstraint.weightx=0.5;
		patientCourantConstraint.weighty = 1;
		patientCourantConstraint.fill = GridBagConstraints.BOTH;
		add(new patientCourantInfo(),patientCourantConstraint);
		
		OrdonanceFormConstraint = new GridBagConstraints();
		OrdonanceFormConstraint.gridx=1;
		OrdonanceFormConstraint.gridy=0;
		OrdonanceFormConstraint.gridwidth=1;
		OrdonanceFormConstraint.gridheight=1;
		OrdonanceFormConstraint.weightx=0.5;
		OrdonanceFormConstraint.weighty = 1;
		OrdonanceFormConstraint.fill = GridBagConstraints.HORIZONTAL;
		add(OrdonanceForm,OrdonanceFormConstraint);
		
		JLabel ordonanceFormTestLabel = new JLabel("Espace du formulaire d'ordonance...");
		ordonanceFormTestLabel.setFont(mainFont);
		ordonanceFormTestLabel.setForeground(mainGreen);
		OrdonanceForm.add(ordonanceFormTestLabel);
		
	}
	
	public class patientCourantInfo extends JPanel{
		
		JLabel lblHeader,lblTitle;
		JLabel lblNom;
		JPanel nomPanel;
			JLabel nomField;
		JLabel lblPrenom;
		JPanel prenomPanel;
			JLabel prenomField;
		JLabel lblCIN;
		JPanel cinPanel;
			JLabel cinField;
		JLabel lblSexe;
		JPanel sexePanel;
			JLabel sexeField;
		JLabel lblBirth;
		JPanel birthPanel;
			JLabel birthField;
		JLabel lblAdresse;
		JPanel adressePanel;
			JTextArea adresseField;
		JLabel lblTel;
		JPanel telPanel;
			JLabel telField;
			
		public patientCourantInfo() {
			setLayout(null);
			setBackground(mainDark);
			/*--- Header -------------------------------------------------------*/
			lblTitle = new JLabel("Le Patient Entrant");
			lblTitle.setBounds(70, 97 , 300, 330);
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Candara", Font.BOLD, 30));
			lblTitle.setForeground(mainWhite);
			add(lblTitle);
			
			lblHeader = new JLabel("");
			lblHeader.setBounds(70, 0, 300, 256);
			lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
			lblHeader.setIcon(patientIcon);
			add(lblHeader);
			
			/*--- Nom -------------------------------------------------------*/
			lblNom = new JLabel("Nom");
			lblNom.setBounds(20, 284, 122, 30);
			add(lblNom);
			lblNom.setFont(new Font("Candara", Font.BOLD, 16));
			lblNom.setForeground(mainWhite);
			
			nomPanel = new JPanel();
			nomPanel.setBounds(150, 284, 254, 30);
			nomPanel.setLayout(null);
			nomPanel.setBorder(null);
			nomPanel.setBackground(mainWhite);
			add(nomPanel);
			
			nomField = new JLabel(nom);
			nomField.setBounds(5, 0, 252, 30);
			nomField.setBackground(mainWhite);
			nomField.setFont(fieldFont);
			nomField.setBorder(null);
			nomPanel.add(nomField);
			
			/*--- Prenom -------------------------------------------------------*/
			lblPrenom = new JLabel("Prenom");
			lblPrenom.setBounds(20, 330, 122, 30);
			lblPrenom.setForeground(mainWhite);
			lblPrenom.setFont(new Font("Candara", Font.BOLD, 16));
			add(lblPrenom);
			
			prenomPanel = new JPanel();
			prenomPanel.setBounds(150, 330, 254, 30);
			prenomPanel.setLayout(null);
			prenomPanel.setBorder(null);
			prenomPanel.setBackground(mainWhite);
			add(prenomPanel);
			
			prenomField = new JLabel(prenom);
			prenomField.setBounds(5, 0, 252, 30);
			prenomField.setBorder(null);
			prenomField.setBackground(mainWhite);
			prenomField.setFont(fieldFont);
			prenomPanel.add(prenomField);
			
			/*--- CIN -------------------------------------------------------*/
			lblCIN = new JLabel("CIN");
			lblCIN.setBounds(20, 376, 122, 30);
			lblCIN.setForeground(mainWhite);
			lblCIN.setFont(new Font("Candara", Font.BOLD, 16));
			add(lblCIN);
			
			cinPanel = new JPanel();
			cinPanel.setBounds(150, 376, 254, 30);
			cinPanel.setLayout(null);
			cinPanel.setBorder(null);
			cinPanel.setBackground(mainWhite);
			add(cinPanel);
			
			cinField = new JLabel(cin);
			cinField.setBounds(5, 0, 252, 30);
			cinField.setBorder(null);
			cinField.setBackground(mainWhite);
			cinField.setFont(fieldFont);
			cinPanel.add(cinField);
			
			/*--- Sexe -------------------------------------------------------*/
			lblSexe = new JLabel("Sexe");
			lblSexe.setBounds(20, 422, 122, 30);
			lblSexe.setForeground(mainWhite);
			lblSexe.setFont(new Font("Candara", Font.BOLD, 16));
			add(lblSexe);
			
			sexePanel = new JPanel();
			sexePanel.setBounds(150, 422, 254, 30);
			sexePanel.setLayout(null);
			sexePanel.setBorder(null);
			sexePanel.setBackground(mainWhite);
			add(sexePanel);
			
			sexeField = new JLabel(sexe);
			sexeField.setBounds(5, 0, 252, 30);
			sexeField.setBackground(mainWhite);
			sexeField.setFont(fieldFont);
			sexeField.setFocusable(false);
			sexePanel.add(sexeField);

	/*--- Date de naissance -------------------------------------------------------*/
			lblBirth = new JLabel("Date de naissance");
			lblBirth.setBounds(20, 468, 122, 30);
			lblBirth.setForeground(mainWhite);
			lblBirth.setFont(new Font("Candara", Font.BOLD, 16));
			add(lblBirth);
			
			birthPanel = new JPanel();
			birthPanel.setBounds(150, 468, 254, 30);
			birthPanel.setLayout(null);
			birthPanel.setBorder(null);
			birthPanel.setBackground(mainWhite);
			add(birthPanel);
				
			birthField = new JLabel(date);
	        birthField.setBounds(5, 0, 252, 30);
	        birthField.setBorder(null);
	        birthField.setBackground(mainWhite);
	        birthField.setFont(fieldFont);
	        birthPanel.add(birthField);

	/*--- Sexe -------------------------------------------------------*/ 
			lblAdresse = new JLabel("Adresse");
			lblAdresse.setBounds(20, 514, 122, 30);
			lblAdresse.setForeground(mainWhite);
			lblAdresse.setFont(new Font("Candara", Font.BOLD, 16));
			add(lblAdresse);
			
			adressePanel = new JPanel();
			adressePanel.setBounds(150, 514, 254, 60);
			adressePanel.setLayout(null);
			adressePanel.setBorder(null);
			adressePanel.setBackground(mainWhite);
			add(adressePanel);
			
			adresseField = new JTextArea(adresse);
			adresseField.setBounds(5, 3, 252, 57);
			adresseField.setBackground(mainWhite);
			adresseField.setFont(fieldFont);
			adresseField.setEditable(false);
			adressePanel.add(adresseField);

	/*--- Telephone -------------------------------------------------------*/
			lblTel = new JLabel("Telephone");
			lblTel.setBounds(20, 590, 122, 30);
			lblTel.setForeground(mainWhite);
			lblTel.setFont(new Font("Candara", Font.BOLD, 16));
			add(lblTel);
			
			telPanel = new JPanel();
			telPanel.setBounds(150, 590, 254, 30);
			telPanel.setLayout(null);
			telPanel.setBorder(null);
			telPanel.setBackground(mainWhite);
			add(telPanel);
			
			telField = new JLabel(tel);
			telField.setBounds(5, 0, 252, 30);
			telField.setBorder(null);
			telField.setBackground(mainWhite);
			telField.setFont(fieldFont);
			telPanel.add(telField);
		}
	}
	
	public void getPatientCourant() {
		try {
			DatabaseConnection connect = new DatabaseConnection();
			
			String selectQuery = "select * from patient where num_patient = (select num_pat_courant from patient_courant)";
			
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
						
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			res = preparedStmt.executeQuery(selectQuery);
				
	        while (res.next()) {
	        	num = res.getString("num_patient");
	        	cin = res.getString("CIN");
	        	nom = res.getString("nom");
	        	prenom = res.getString("prenom");
	        	sexe = res.getString("sexe");
	        	date = res.getString("date_naissance");
	        	adresse = res.getString("adresse");
	        	tel = res.getString("tel");
			}
	        					
			connect.closeConnection();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
