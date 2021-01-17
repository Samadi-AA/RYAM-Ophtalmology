package secretaireHome;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class rdv implements ActionListener{
	JFrame frame;
	JPanel rdvPanel,container;
	JLabel nomText,prenomText,cinText,dateText;
	JButton login,reset,manuale,automatique;
	JTextField nom,prenome,cin;
	CalenderRdv date;
	
    public rdv() {
    	
    }
    
    public JPanel getView() {
    	// the RDV panel and it's layout (GridGapLayout)
    			rdvPanel = new JPanel();  
    			rdvPanel.setLayout(new GridBagLayout());
    	        
    	       
    			// the manual button and it's position in the gridGapLayout & add it to the RDV panel
    		        manuale = new JButton("manuale");
    		        GridBagConstraints manualConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        manualConstrains.gridx =0;
    		        manualConstrains.gridy = 0;
    		        manualConstrains.gridwidth=2;
    		        manualConstrains.weightx=0.5;
    		        manualConstrains.fill = GridBagConstraints.BOTH;
    		        manualConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(manuale,manualConstrains);
    		        manuale.setBackground(Color.blue);
    		        manuale.addActionListener(this);	// add action listener to the manual button
    	        
    	        // the automatic button and it's position in the gridGapLayout & add it to the RDV panel
    		        automatique = new JButton("automatique");
    		        GridBagConstraints automaticConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        automaticConstrains.gridx =2;
    		        automaticConstrains.gridy = 0;
    		        automaticConstrains.gridwidth=2;
    		        automaticConstrains.weightx=0.5;
    		        automaticConstrains.fill = GridBagConstraints.BOTH;
    		        automaticConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(automatique,automaticConstrains);
    	        
    	        
    		        automatique.addActionListener(this);	// add action listener to the automatic button
    	        
    	        // the Name label and it's position in the gridGapLayout & add it to the RDV panel
    		        nomText = new JLabel("Nom");
    		        GridBagConstraints nomTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        nomTextConstrains.gridx =0;
    		        nomTextConstrains.gridy = 1;
    		        nomTextConstrains.gridwidth=1;
    		        nomTextConstrains.weightx=0.25;
    		        nomTextConstrains.fill = GridBagConstraints.BOTH;
    		        nomTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(nomText,nomTextConstrains);
    	        
    	        // the Name text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        nom = new JTextField();
    		        GridBagConstraints nomConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        nomConstrains.gridx = 1;
    		        nomConstrains.gridy = 1;
    		        nomConstrains.gridwidth=3;
    		        nomConstrains.weightx=0.75;
    		        nomConstrains.fill = GridBagConstraints.BOTH;
    		        nomConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(nom,nomConstrains);
    	        
    	        // the last Name label and it's position in the gridGapLayout & add it to the RDV panel
    		        prenomText = new JLabel("Prenom");
    		        GridBagConstraints prenomTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        prenomTextConstrains.gridx = 0;
    		        prenomTextConstrains.gridy = 2;
    		        prenomTextConstrains.weightx=0.25;
    		        prenomTextConstrains.gridwidth=1;
    		        prenomTextConstrains.fill = GridBagConstraints.BOTH;
    		        prenomTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(prenomText,prenomTextConstrains);
    	        
    	        // the last name text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        prenome = new JTextField();
    		        GridBagConstraints prenomConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        prenomConstrains.gridx = 1;
    		        prenomConstrains.gridy = 2;
    		        prenomConstrains.gridwidth=3;
    		        prenomConstrains.weightx=0.75;
    		        prenomConstrains.fill = GridBagConstraints.BOTH;
    		        prenomConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(prenome,prenomConstrains);
    	        
    	        // the CIN label and it's position in the gridGapLayout & add it to the RDV panel
    		        cinText = new JLabel("CIN");
    		        GridBagConstraints cinTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        cinTextConstrains.gridx = 0;
    		        cinTextConstrains.gridy = 3;
    		        cinTextConstrains.gridwidth=1;
    		        cinTextConstrains.weightx=0.25;
    		        cinTextConstrains.fill = GridBagConstraints.BOTH;
    		        cinTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(cinText,cinTextConstrains);
    		        
    	        // the CIN text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        cin = new JTextField();
    		        GridBagConstraints cinConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        cinConstrains.gridx = 1;
    		        cinConstrains.gridy = 3;
    		        cinConstrains.gridwidth=3;
    		        cinConstrains.weightx=0.75;
    		        cinConstrains.fill = GridBagConstraints.BOTH;
    		        cinConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(cin,cinConstrains);
    	        
    	        // the RDV Date label and it's position in the gridGapLayout & add it to the RDV panel
    		        dateText = new JLabel("Date");
    		        GridBagConstraints dateTextConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        dateTextConstrains.gridx = 0;
    		        dateTextConstrains.gridy = 4;
    		        dateTextConstrains.gridwidth=1;
    		        dateTextConstrains.weightx=0.25;
    		        dateTextConstrains.fill = GridBagConstraints.BOTH;
    		        dateTextConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)

    		        rdvPanel.add(dateText,dateTextConstrains);
    	        
    	        // the RDV date text Field and it's position in the gridGapLayout & add it to the RDV panel
    		        date = new CalenderRdv();
    		        GridBagConstraints dateConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        dateConstrains.gridx = 1;
    		        dateConstrains.gridy = 4;
    		        dateConstrains.gridwidth=3;
    		        dateConstrains.weightx=0.75;
    		        dateConstrains.fill = GridBagConstraints.BOTH;
    		        dateConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		
    		        rdvPanel.add(date.getView(),dateConstrains);
    		        
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
    		        reset = new JButton("Rest");
    		        GridBagConstraints resetConstrains = new GridBagConstraints();			// declare a GridBagConstraints that's will control the element's position in the GridBagLayout 
    		        resetConstrains.gridx = 1;
    		        resetConstrains.gridy = 5;
    		        resetConstrains.gridwidth=1;
    		        resetConstrains.weightx=0.25;
    		        resetConstrains.fill = GridBagConstraints.BOTH;
    		        resetConstrains.insets = new Insets(5,5,5,5);		// set insets between the RDV panel elements (margin)
    		        rdvPanel.add(reset,resetConstrains);
    		        
    		        reset.addActionListener(this);
    		        
    		        rdvPanel.setBorder(new LineBorder(Color.black));	
        return rdvPanel;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login) {		// if the login button clicked this will happen
		
		}
		else if(e.getSource() == reset) {	// if the reset button clicked this will happen
			// set all the text field in the panel to empty string 
			nom.setText("");
			prenome.setText("");
			cin.setText("");
			date.resetdate();
			//date.setText("");
		}
		else if(e.getSource() == manuale) {	// if the manual button clicked this will happen
			manuale.setBackground(Color.blue);	//change manual color 
	        automatique.setBackground(null);	//set the other button color as default
	        // display the RDV date text field and label again  
	        date.enableDate();
		}
		else if(e.getSource() == automatique) {	// if the automatic button clicked this will happen
			automatique.setBackground(Color.BLUE);	//change manual color 
	        manuale.setBackground(null);	//set the other button color as default
	        // remove the RDV date text label and text field 	
	        date.disableDate();
		}
		

	}
}
