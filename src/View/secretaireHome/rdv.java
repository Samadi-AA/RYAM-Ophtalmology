package view.secretaireHome;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.RDV;


public class rdv implements ActionListener{
	JFrame frame;
	JPanel rdvPanel,container;
	JLabel lblFullName,prenomText,lblCIN,lblDate;
	JButton login,btnReset,btnMan,btnAuto;
	JTextField fullNameField,prenome,cinField;
	DateTimePicker datePicker;
	String modeRDV = "man";
	
	/*-- Design --*/
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 20);
	
    public rdv() {
    	
    }
    
    public JPanel getView() {
    	// the RDV panel and it's layout (GridGapLayout)
    			rdvPanel = new JPanel();  
    			rdvPanel.setLayout(new GridBagLayout());
    	        
    	       
    			// the manual button and it's position in the gridGapLayout & add it to the RDV panel
    		        btnMan = new JButton("Manuel");
    		        GridBagConstraints btnManConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        btnManConstrains.gridx =0;
    		        btnManConstrains.gridy = 0;
    		        btnManConstrains.gridwidth=2;
    		        btnManConstrains.weightx=0.5;
    		        btnManConstrains.fill = GridBagConstraints.BOTH;
    		        btnManConstrains.insets = new Insets(0,0,0,0);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(btnMan,btnManConstrains);
    		        btnMan.setBackground(mainGreen);
    		        btnMan.setForeground(mainDark);
    		        btnMan.setFont(mainFont);
    		        btnMan.setBorder(null);
    		        btnMan.setFocusPainted(false);
    		        
    		        btnMan.addActionListener(this);	// add action listener to the manual button
    	        
    	        // the automatic button and it's position in the gridGapLayout & add it to the RDV panel
    		        btnAuto = new JButton("Automatique");
    		        GridBagConstraints btnAutoConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        btnAutoConstrains.gridx =2;
    		        btnAutoConstrains.gridy = 0;
    		        btnAutoConstrains.gridwidth=2;
    		        btnAutoConstrains.weightx=0.5;
    		        btnAutoConstrains.fill = GridBagConstraints.BOTH;
    		        btnAutoConstrains.insets = new Insets(0,0,0,0);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(btnAuto,btnAutoConstrains);
    		        btnAuto.setBackground(mainWhite);
    		        btnAuto.setForeground(mainDark);
    		        btnAuto.setFont(mainFont);
    		        btnAuto.setBorder(new LineBorder(mainGreen, 1));
    		        btnAuto.setFocusPainted(false);
    	        
    		        btnAuto.addActionListener(this);	// add action listener to the automatic button
    	        
    	        // the Name label and it's position in the gridGapLayout & add it to the RDV panel
    		        lblFullName = new JLabel("Nom");
    		        GridBagConstraints nomTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        nomTextConstrains.gridx =0;
    		        nomTextConstrains.gridy = 1;
    		        nomTextConstrains.gridwidth=1;
    		        nomTextConstrains.weightx=0.25;
    		        nomTextConstrains.fill = GridBagConstraints.BOTH;
    		        nomTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(lblFullName,nomTextConstrains);
    	        
    	        // the Name text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        fullNameField = new JTextField();
    		        GridBagConstraints nomConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        nomConstrains.gridx = 1;
    		        nomConstrains.gridy = 1;
    		        nomConstrains.gridwidth=3;
    		        nomConstrains.weightx=0.75;
    		        nomConstrains.fill = GridBagConstraints.BOTH;
    		        nomConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(fullNameField,nomConstrains);
    	            	        
    	        // the CIN label and it's position in the gridGapLayout & add it to the RDV panel
    		        lblCIN = new JLabel("CIN");
    		        GridBagConstraints cinTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        cinTextConstrains.gridx = 0;
    		        cinTextConstrains.gridy = 3;
    		        cinTextConstrains.gridwidth=1;
    		        cinTextConstrains.weightx=0.25;
    		        cinTextConstrains.fill = GridBagConstraints.BOTH;
    		        cinTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(lblCIN,cinTextConstrains);
    		        
    	        // the CIN text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        cinField = new JTextField();
    		        GridBagConstraints cinConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        cinConstrains.gridx = 1;
    		        cinConstrains.gridy = 3;
    		        cinConstrains.gridwidth=3;
    		        cinConstrains.weightx=0.75;
    		        cinConstrains.fill = GridBagConstraints.BOTH;
    		        cinConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(cinField,cinConstrains);
    	        
    	        // the RDV Date label and it's position in the gridGapLayout & add it to the RDV panel
    		        lblDate = new JLabel("Date");
    		        GridBagConstraints dateTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        dateTextConstrains.gridx = 0;
    		        dateTextConstrains.gridy = 4;
    		        dateTextConstrains.gridwidth=1;
    		        dateTextConstrains.weightx=0.25;
    		        dateTextConstrains.fill = GridBagConstraints.BOTH;
    		        dateTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)

    		        rdvPanel.add(lblDate,dateTextConstrains);
    	        
    	        // the RDV date text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        Date d = new Date();
    		        datePicker = new DateTimePicker();
    		        datePicker.setFormats( DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.MEDIUM ) );
    		        datePicker.setTimeFormat( DateFormat.getTimeInstance( DateFormat.MEDIUM ) );
    		        datePicker.setDate(d);
    		        GridBagConstraints dateConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        dateConstrains.gridx = 1;
    		        dateConstrains.gridy = 4;
    		        dateConstrains.gridwidth=3;
    		        dateConstrains.weightx=0.75;
    		        dateConstrains.fill = GridBagConstraints.BOTH;
    		        dateConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		
    		        rdvPanel.add(datePicker,dateConstrains);
    		        
    	        // the Login button and it's position in the gridGapLayout & add it to the RDV panel
    		        login = new JButton("creer");
    		        GridBagConstraints loginConstrains = new GridBagConstraints();				// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        loginConstrains.gridx = 3;
    		        loginConstrains.gridy = 5;
    		        loginConstrains.gridwidth=1;
    		        loginConstrains.weightx=0.25;
    		        loginConstrains.fill = GridBagConstraints.BOTH;
    		        loginConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(login,loginConstrains);
    		        
    		        login.addActionListener(this);	// add action listener to the login button
    	      
    	        // the reset button and it's position in the gridGapLayout & add it to the RDV panel
    		        btnReset = new JButton("Rest");
    		        GridBagConstraints resetConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        resetConstrains.gridx = 1;
    		        resetConstrains.gridy = 5;
    		        resetConstrains.gridwidth=1;
    		        resetConstrains.weightx=0.25;
    		        resetConstrains.fill = GridBagConstraints.BOTH;
    		        resetConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(btnReset,resetConstrains);
    		        
    		        btnReset.addActionListener(this);
    		        
    		        rdvPanel.setBorder(new LineBorder(Color.black));	
        return rdvPanel;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login) {		// if the login button clicked this will happen
			RDV rdv = new RDV();
			rdv.setNomPatient(fullNameField.getText());
			rdv.setCIN(cinField.getText());
			if (modeRDV == "auto") rdv.autoRDV();
			else {
				Timestamp t = new Timestamp(datePicker.getDate().getTime());
				rdv.setDatetimeRDV(t);
			}
			rdv.Ajouter();
			
		}
		else if(e.getSource() == btnReset) {	// if the reset button clicked this will happen
			// set all the text field in the panel to empty string 
			fullNameField.setText("");
			prenome.setText("");
			cinField.setText("");
			datePicker.setDate(null);
			//date.setText("");
		}
		else if(e.getSource() == btnMan) {	// if the manual button clicked this will happen
			modeRDV = "man";
			btnMan.setBackground(mainGreen);	//change manual color 
	        btnAuto.setBackground(mainWhite); //set the other button color as default
	        btnAuto.setBorder(new LineBorder(mainGreen, 1));
	        
	        // display the RDV date text field and label again  
	        //datePicker.setDate(d);
		}
		else if(e.getSource() == btnAuto) {	// if the automatic button clicked this will happen
			modeRDV = "auto";
			btnAuto.setBackground(mainGreen);	//change manual color 
	        btnMan.setBackground(mainWhite);	//set the other button color as default
	        btnMan.setBorder(new LineBorder(mainGreen, 1));
	        // remove the RDV date text label and text field 	
	        //date.disableDate();
		}
		

	}
}
