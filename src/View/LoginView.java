/***** Author     : Abdessamad AIT OUAKRIM
 ***** Project    : RYAM System
 ***** Professor: Sara ROUBI
 ***** Date       : 17 janv. 2021
 ******************************************/ 

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.DatabaseConnection;

public class LoginView implements ActionListener {

	private static JLabel userLabel;
	private static JComboBox<String> userText;
	private static JLabel passwordLabel;
	private static JTextField passwordText;
	private static JButton loginButton;
	private static JButton resetButton;
	private static JFrame fr;
	private static JFrame fr1;
	private static JFrame fr2;
	private static JLabel erreurMsg;
	
	private static DatabaseConnection connect = new DatabaseConnection();

	public static void main(String[] args) {

		fr = new JFrame();
		JPanel p = new JPanel();

		fr.setSize(400, 350);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.add(p);

		// doctor page ************************************ just pour tester
		fr1 = new JFrame();
		JPanel p1 = new JPanel();
		fr1.setSize(400, 350);
		fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel docText = new JLabel("Hello doctor");
		docText.setBounds(200, 200, 100, 100);
		docText.setSize(100, 100);
		p1.add(docText);
		fr1.add(p1); 												// On doit gerer ce 2 pages au partie de gestion des views

		// sectretaire page ******************************* just pour tester
		fr2 = new JFrame();
		JPanel p2 = new JPanel();
		fr2.setSize(450, 350);
		fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel secText = new JLabel("Hello secretaire");
		secText.setBounds(200, 200, 100, 100);
		secText.setSize(100, 100);
		p2.add(secText);
		fr2.add(p2);
		
		///////////////////////////////////////////////////////
		
		
		p.setLayout(null);

		userLabel = new JLabel("User: ");
		userLabel.setBounds(20, 30, 200, 25);
		p.add(userLabel);

		userText = new JComboBox<String>();
		userText.setBounds(120, 30, 210, 25);
		p.add(userText);
		userText.addItem("Doctor");
		userText.addItem("Secretaire");
		userText.setSelectedItem(null);

		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(20, 60, 200, 25);
		p.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(120, 60, 211, 25);
		p.add(passwordText);

		loginButton = new JButton("Login");
		loginButton.setBounds(120, 90, 100, 25);
		loginButton.setToolTipText("Se connecter");
		p.add(loginButton);

		loginButton.addActionListener(new LoginView());

		resetButton = new JButton("Reset");
		resetButton.setBounds(230, 90, 100, 25);
		p.add(resetButton);

		resetButton.addActionListener(new LoginView());

		erreurMsg = new JLabel();
		erreurMsg.setBounds(20, 130, 200, 25);
		p.add(erreurMsg);

		fr.setVisible(true);
		
	}

	public String getMotDePss(String user){
		
		// J'ai rempli les tables avec les valeurs suivant juste pour tester :
		//insert into doctor (userKey, nom, prenom) values ("admin", "DocTest", "DocTest");
		//insert into secretaire (userKey) values ("admin");
		
		String Mdp = "Null";
		
		try {
				
			String selectQuery="select userKey from ? where username=?";
		
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
			
			preparedStmt.setString(1, user); 
			preparedStmt.setString(2, user); 
			
			preparedStmt.execute();
			
			Mdp = preparedStmt.getResultSet().getString("userKey");
			
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return Mdp;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String password = passwordText.getText();
		
		if (e.getSource() == loginButton) {
			if (userText.getSelectedItem() == "Doctor" && password.equals(getMotDePss("doctor"))) {
				fr.setVisible(false);
				fr1.setVisible(true);
			} else if (userText.getSelectedItem() == "Secretaire" && password.equals(getMotDePss("secretaire"))) {
				fr.setVisible(false);
				fr2.setVisible(true);
			} else if(userText.getSelectedItem() == null)
				erreurMsg.setText("User not selected !");
			else
				erreurMsg.setText("Password not correct !!");
		} else if (e.getSource() == resetButton) {
			passwordText.setText(null);
			userText.setSelectedItem(null);
			erreurMsg.setText("");
		}
	}

}
