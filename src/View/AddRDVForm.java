package view;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.RDV;


public class AddRDVForm implements ActionListener{
	JPanel container;
	JLabel lblFullName,lblCIN,lblDate;
	JButton btnAjouter,btnReset,btnMan,btnAuto;
	JTextField fullNameField,cinField;
	DateTimePicker datePicker;
	String modeRDV = "man";
	
	/*-- Design --*/
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 20);
	
    public AddRDVForm() {}
    
    public JPanel getView() {
    	// the RDV panel and it's layout (GridGapLayout)
		container = new JPanel();
		container.setLayout(new GridBagLayout());
		container.setBackground(mainWhite);
		
		
		// the manual button and it's position in the gridGapLayout & add it to the RDV panel
		btnMan = new JButton("Manuel");
		btnMan.setBackground(mainDark);
		btnMan.setForeground(mainWhite);
		btnMan.setFont(mainFont);
		btnMan.setBorder(null);
		btnMan.setFocusPainted(false);
		btnMan.addActionListener(this);
		
		GridBagConstraints btnManConstrains = new GridBagConstraints(); 
		btnManConstrains.gridx =0;
		btnManConstrains.gridy = 0;
		btnManConstrains.gridwidth=2;
		btnManConstrains.weightx=0.5;
		//btnManConstrains.weighty=1;
		btnManConstrains.fill = GridBagConstraints.BOTH;
		btnManConstrains.insets = new Insets(0,0,0,0);
		container.add(btnMan,btnManConstrains);
		
		
		// the automatic button and it's position in the gridGapLayout & add it to the RDV panel
		btnAuto = new JButton("Automatique");
		btnAuto.setBackground(mainWhite);
		btnAuto.setForeground(mainDark);
		btnAuto.setFont(mainFont);
		btnAuto.setBorder(new LineBorder(mainDark, 1));
		btnAuto.setFocusPainted(false);
		btnAuto.addActionListener(this);
		
		GridBagConstraints btnAutoConstrains = new GridBagConstraints(); 
		btnAutoConstrains.gridx =2;
		btnAutoConstrains.gridy = 0;
		btnAutoConstrains.gridwidth=2;
		btnAutoConstrains.weightx=0.5;
		btnAutoConstrains.fill = GridBagConstraints.BOTH;
		btnAutoConstrains.insets = new Insets(0,0,0,0);
		container.add(btnAuto,btnAutoConstrains);
		
		// the Name label and it's position in the gridGapLayout & add it to the RDV panel
		lblFullName = new JLabel("Nom Complete");
		lblFullName.setFont(new Font("Candara", Font.BOLD, 16));
		
		GridBagConstraints nomTextConstrains = new GridBagConstraints(); 
		nomTextConstrains.gridx =0;
		nomTextConstrains.gridy = 1;
		nomTextConstrains.gridwidth=1;
		nomTextConstrains.weightx=0.25;
		nomTextConstrains.fill = GridBagConstraints.BOTH;
		nomTextConstrains.insets = new Insets(15,5,0,10);
		container.add(lblFullName,nomTextConstrains);
		
		// the Name text Field and it's position in the gridGapLayout & add it to the RDV panel
		fullNameField = new JTextField();
		fullNameField.setPreferredSize(new Dimension(1, 30));
		fullNameField.setFont(new Font("Candara", 0, 14));
		fullNameField.setBorder(new LineBorder(mainDark));
		
		
		GridBagConstraints nomConstrains = new GridBagConstraints(); 
		nomConstrains.gridx = 1;
		nomConstrains.gridy = 1;
		nomConstrains.gridwidth=3;
		nomConstrains.weightx=0.75;
		nomConstrains.fill = GridBagConstraints.BOTH;
		nomConstrains.insets = new Insets(15,0,0,0);
		container.add(fullNameField,nomConstrains);
			        
		// the CIN label and it's position in the gridGapLayout & add it to the RDV panel
		lblCIN = new JLabel("CIN");
		lblCIN.setFont(new Font("Candara", Font.BOLD, 16));
		
		GridBagConstraints cinTextConstrains = new GridBagConstraints(); 
		cinTextConstrains.gridx = 0;
		cinTextConstrains.gridy = 3;
		cinTextConstrains.gridwidth=1;
		cinTextConstrains.weightx=0.25;
		//cinTextConstrains.weighty=1;
		cinTextConstrains.fill = GridBagConstraints.BOTH;
		cinTextConstrains.insets = new Insets(10,5,0,0);
		container.add(lblCIN,cinTextConstrains);
		
		// the CIN text Field and it's position in the gridGapLayout & add it to the RDV panel
		cinField = new JTextField();
		cinField.setPreferredSize(new Dimension(1, 30));
		cinField.setFont(new Font("Candara", 0, 14));
		cinField.setBorder(new LineBorder(mainDark));
		
		GridBagConstraints cinConstrains = new GridBagConstraints(); 
		cinConstrains.gridx = 1;
		cinConstrains.gridy = 3;
		cinConstrains.gridwidth=3;
		cinConstrains.weightx=0.75;
		//cinConstrains.weighty=1;
		cinConstrains.fill = GridBagConstraints.BOTH;
		cinConstrains.insets = new Insets(10,0,0,0);
		container.add(cinField,cinConstrains);
		
		// the RDV Date label and it's position in the gridGapLayout & add it to the RDV panel
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Candara", Font.BOLD, 16));
		//lblDate.setBorder(new EmptyBorder(0, 5, 0, 0));
		
		GridBagConstraints dateTextConstrains = new GridBagConstraints(); 
		dateTextConstrains.gridx = 0;
		dateTextConstrains.gridy = 4;
		dateTextConstrains.gridwidth=1;
		dateTextConstrains.weightx=0.25;
		//dateTextConstrains.weighty=1;
		dateTextConstrains.fill = GridBagConstraints.BOTH;
		dateTextConstrains.insets = new Insets(10,5,0,0);
		
		container.add(lblDate,dateTextConstrains);
		
		// the RDV date text Field and it's position in the gridGapLayout & add it to the RDV panel
		Date d = new Date();
		datePicker = new DateTimePicker();
		datePicker.setFormats( DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.MEDIUM ) );
		datePicker.setTimeFormat( DateFormat.getTimeInstance( DateFormat.MEDIUM ) );
		datePicker.setDate(d);
		datePicker.setPreferredSize(new Dimension(1, 30));
		datePicker.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		GridBagConstraints dateConstrains = new GridBagConstraints(); 
		dateConstrains.gridx = 1;
		dateConstrains.gridy = 4;
		dateConstrains.gridwidth=3;
		dateConstrains.weightx=0.75;
		//dateConstrains.weighty=1;
		dateConstrains.fill = GridBagConstraints.BOTH;
		dateConstrains.insets = new Insets(10,0,0,0);
		
		container.add(datePicker,dateConstrains);
		
		// the Ajouter button and it's position in the gridGapLayout & add it to the RDV panel
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(mainDark);
		btnAjouter.setForeground(mainWhite);
		btnAjouter.setFont(new Font("Candara", Font.BOLD, 16));
		btnAjouter.setBorder(null);
		btnAjouter.setFocusPainted(false);
		
		GridBagConstraints loginConstrains = new GridBagConstraints(); 
		loginConstrains.gridx = 3;
		loginConstrains.gridy = 5;
		loginConstrains.gridwidth=1;
		loginConstrains.weightx=0.25;
		//loginConstrains.weighty=1;
		loginConstrains.fill = GridBagConstraints.BOTH;
		loginConstrains.insets = new Insets(10,0,0,0);
		container.add(btnAjouter,loginConstrains);
		
		btnAjouter.addActionListener(this);
		  
		    // the reset button and it's position in the gridGapLayout & add it to the RDV panel
		btnReset = new JButton("Reset");
		btnReset.setBackground(mainDark);
		btnReset.setForeground(mainWhite);
		btnReset.setFont(new Font("Candara", Font.BOLD, 16));
		btnReset.setBorder(null);
		btnReset.setFocusPainted(false);
		
		GridBagConstraints resetConstrains = new GridBagConstraints(); 
		resetConstrains.gridx = 1;
		resetConstrains.gridy = 5;
		resetConstrains.gridwidth=1;
		resetConstrains.weightx=0.25;
		//resetConstrains.weighty=1;
		resetConstrains.fill = GridBagConstraints.BOTH;
		resetConstrains.insets = new Insets(10,0,0,5);
		container.add(btnReset,resetConstrains);
		
		btnReset.addActionListener(this);
		
		return container;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAjouter) {
			RDV rdv = new RDV();
			rdv.setNomPatient(fullNameField.getText());
			rdv.setCIN(cinField.getText());
			if (modeRDV == "auto") rdv.autoRDV();
			else {
				Timestamp time = new Timestamp(datePicker.getDate().getTime());
				rdv.setDatetimeRDV(time);
			}
			if (rdv.Ajouter()) JOptionPane.showMessageDialog(null, "le ronder-vous est bien ajoutée", "Ajouter rondez-vous", 2);
			else JOptionPane.showMessageDialog(null, "Echec d'ajoutation de rondez-vous! veullier verifier les données", "Ajouter rondez-vous", JOptionPane.OK_OPTION);
		}
		else if(e.getSource() == btnReset) {
			fullNameField.setText("");
			cinField.setText("");
		}
		else if(e.getSource() == btnMan) {
			modeRDV = "man";
			btnMan.setBackground(mainDark);
			btnMan.setForeground(mainWhite);
	        btnAuto.setBackground(mainWhite);
	        btnAuto.setForeground(mainDark);
	        btnAuto.setBorder(new LineBorder(mainDark, 1));
	        datePicker.enable();
		}
		else if(e.getSource() == btnAuto) {
			modeRDV = "auto";
			btnAuto.setBackground(mainDark);
			btnAuto.setForeground(mainWhite);
			btnMan.setBackground(mainWhite);
			btnMan.setForeground(mainDark);
	        btnMan.setBorder(new LineBorder(mainDark, 1));
	        datePicker.disable();
		}
		

	}
}
