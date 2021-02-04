package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Patient;

public class AddPatientForm extends JPanel {
	
	/*-- Components --*/
	private JLabel lblHeader;
	private JLabel lblNom;
	private JPanel nomPanel;
		private JTextField nomField;
	private JLabel lblPrenom;
	private JPanel prenomPanel;
		private JTextField prenomField;
	private JLabel lblCIN;
	private JPanel cinPanel;
		private JTextField cinField;
	private JLabel lblSexe;
	private JPanel sexePanel;
		private JComboBox<String> sexeField;
	private JLabel lblBirth;
	private JPanel birthPanel;
		private Calender dateNaissancePicker;
	private JLabel lblAdresse;
	private JPanel adressePanel;
		private JTextArea adresseField;
	private JLabel lblTel;
	private JPanel telPanel;
		private JTextField telField;
	private JButton btnReset;
	private JButton btnConfirm;

	/*-- Design --*/
	private ImageIcon patientIcon = new ImageIcon(LoginView.class.getResource("/view/icons/patientIcon.png"));
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 20);
	private final Font fieldFont = new Font("Candara", Font.BOLD, 14);
	
	/*-- Constructor --*/
	public AddPatientForm() {
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(mainDark);
		
		lblHeader = new JLabel("");
		lblHeader.setBounds(40, 10, 344, 128);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(mainGreen);
		lblHeader.setIcon(patientIcon);
		add(lblHeader);
		
		lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 149, 122, 30);
		add(lblNom);
		lblNom.setFont(new Font("Candara", Font.BOLD, 16));
		lblNom.setForeground(mainWhite);
		
		nomPanel = new JPanel();
		nomPanel.setBounds(150, 149, 214, 30);
		nomPanel.setLayout(null);
		nomPanel.setBorder(null);
		nomPanel.setBackground(mainWhite);
		add(nomPanel);
		
		nomField = new JTextField();
		nomField.setBounds(5, 0, 202, 30);
		nomField.setBackground(mainWhite);
		nomField.setFont(fieldFont);
		nomField.setBorder(null);
		nomPanel.add(nomField);
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(20, 190, 122, 30);
		lblPrenom.setForeground(mainWhite);
		lblPrenom.setFont(new Font("Candara", Font.BOLD, 16));
		add(lblPrenom);
		
		prenomPanel = new JPanel();
		prenomPanel.setBounds(150, 190, 214, 30);
		prenomPanel.setLayout(null);
		prenomPanel.setBorder(null);
		prenomPanel.setBackground(mainWhite);
		add(prenomPanel);
		
		prenomField = new JTextField();
		prenomField.setBounds(5, 0, 202, 30);
		prenomField.setBorder(null);
		prenomField.setBackground(mainWhite);
		prenomField.setFont(fieldFont);
		prenomPanel.add(prenomField);
		
		lblCIN = new JLabel("CIN");
		lblCIN.setBounds(20, 231, 122, 30);
		lblCIN.setForeground(mainWhite);
		lblCIN.setFont(new Font("Candara", Font.BOLD, 16));
		add(lblCIN);
		
		cinPanel = new JPanel();
		cinPanel.setBounds(150, 231, 214, 30);
		cinPanel.setLayout(null);
		cinPanel.setBorder(null);
		cinPanel.setBackground(mainWhite);
		add(cinPanel);
		
		cinField = new JTextField();
		cinField.setBounds(5, 0, 202, 30);
		cinField.setBorder(null);
		cinField.setBackground(mainWhite);
		cinField.setFont(fieldFont);
		cinPanel.add(cinField);
		
		lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(20, 272, 122, 30);
		lblSexe.setForeground(mainWhite);
		lblSexe.setFont(new Font("Candara", Font.BOLD, 16));
		add(lblSexe);
		
		sexePanel = new JPanel();
		sexePanel.setBounds(150, 272, 214, 30);
		sexePanel.setLayout(null);
		sexePanel.setBorder(null);
		sexePanel.setBackground(mainWhite);
		add(sexePanel);
		
		sexeField = new JComboBox<String>();
		sexeField.setBounds(0, 0, 214, 30);
		sexeField.addItem(" Masculin");
		sexeField.addItem(" Feminin");
		sexeField.setMaximumRowCount(2);
		sexeField.setBackground(mainWhite);
		sexeField.setFont(fieldFont);
		sexeField.setFocusable(false);
		sexePanel.add(sexeField);
		
		lblBirth = new JLabel("Date de naissance");
		lblBirth.setBounds(20, 313, 122, 30);
		lblBirth.setForeground(mainWhite);
		lblBirth.setFont(new Font("Candara", Font.BOLD, 16));
		add(lblBirth);
		
		birthPanel = new JPanel();
		birthPanel.setBounds(150, 313, 214, 30);
		birthPanel.setLayout(new GridBagLayout());
		birthPanel.setBorder(null);
		birthPanel.setBackground(mainDark);
		add(birthPanel);
		
		
		dateNaissancePicker = new Calender();
		GridBagConstraints dateNaissancePickerConstrains = new GridBagConstraints();			
        dateNaissancePickerConstrains.gridx = 0;
        dateNaissancePickerConstrains.gridy = 0;
        dateNaissancePickerConstrains.gridwidth=1;
        dateNaissancePickerConstrains.weightx=1;
        dateNaissancePickerConstrains.fill = GridBagConstraints.BOTH;
        birthPanel.add(dateNaissancePicker.getView(),dateNaissancePickerConstrains);
		
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(20, 354, 122, 30);
		lblAdresse.setForeground(mainWhite);
		lblAdresse.setFont(new Font("Candara", Font.BOLD, 16));
		add(lblAdresse);
		
		adressePanel = new JPanel();
		adressePanel.setBounds(150, 354, 214, 60);
		adressePanel.setLayout(null);
		adressePanel.setBorder(null);
		adressePanel.setBackground(mainWhite);
		add(adressePanel);
		
		adresseField = new JTextArea();
		adresseField.setBounds(5, 3, 202, 57);
		adresseField.setBackground(mainWhite);
		adresseField.setFont(fieldFont);
		adressePanel.add(adresseField);
		
		lblTel = new JLabel("Telephone");
		lblTel.setBounds(20, 425, 122, 30);
		lblTel.setForeground(mainWhite);
		lblTel.setFont(new Font("Candara", Font.BOLD, 16));
		add(lblTel);
		
		telPanel = new JPanel();
		telPanel.setBounds(150, 425, 214, 30);
		telPanel.setLayout(null);
		telPanel.setBorder(null);
		telPanel.setBackground(mainWhite);
		add(telPanel);
		
		telField = new JTextField();
		telField.setBounds(5, 0, 202, 30);
		telField.setBorder(null);
		telField.setBackground(mainWhite);
		telField.setFont(fieldFont);
		telPanel.add(telField);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(20, 473, 168, 30);
		btnReset.setBorder(null);
		btnReset.setFocusPainted(false);
		btnReset.setBackground(mainGreen);
		btnReset.setForeground(mainWhite);
		btnReset.setFont(mainFont);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnReset);
		
		btnConfirm = new JButton("Enregistrer");
		btnConfirm.setBounds(196, 473, 168, 30);
		btnConfirm.setBorder(null);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBackground(mainGreen);
		btnConfirm.setForeground(mainWhite);
		btnConfirm.setFont(mainFont);
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnConfirm);
		
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String  nom = nomField.getText(),
						prenom = prenomField.getText(),
						CIN = cinField.getText(),
						sexe = sexeField.getSelectedItem().toString(),
						adresse = adresseField.getText(),
						telephone = telField.getText();
				Date dateNaissance = Calender.getDate();
								
				Patient pat =  new Patient(nom, prenom, CIN, sexe, adresse, dateNaissance, telephone);
				if (pat.Ajouter()) {
					JOptionPane.showMessageDialog(null, "Le Patient a bien ete ajouté", "Ajouter Patient", 2);
					nomField.setText(null);
					prenomField.setText(null);
					cinField.setText(null);
					adresseField.setText(null);
					telField.setText(null);
					dateNaissancePicker.resetdate();
				}
				else JOptionPane.showMessageDialog(null, "Echec d'insertion!", "Ajouter Patient", JOptionPane.OK_OPTION);
			}
		});
		
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				nomField.setText(null);
				prenomField.setText(null);
				cinField.setText(null);
				adresseField.setText(null);
				telField.setText(null);
				dateNaissancePicker.resetdate();
			}
		});
	}

}
