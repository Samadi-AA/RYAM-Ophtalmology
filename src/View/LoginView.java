/***** Author     : Abdessamad AIT OUAKRIM
 ***** Project    : RYAM System
 ***** Professor: Sara ROUBI
 ***** Date       : 17 janv. 2021
 ******************************************/ 

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private static JFrame loginFrame;
	public static JFrame fr1;
	public static JFrame fr2;
	private static JLabel erreurMsg;
	
	static LogoPanel logo = new LogoPanel();
	
	private static DatabaseConnection connect;

	public static void main(String[] args) {
		
		loginFrame = new JFrame();
		JPanel loginContainerPanel = new JPanel();
		
		logo.setLayout(null);
		
		//loginFrame.getContentPane().setBackground( Color.BLACK );
		loginFrame.setSize(400, 250);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//loginFrame.setResizable(false);
		
		loginFrame.add(loginContainerPanel);
		loginFrame.add(logo);
		
/***********************************************************************************************/
		// On doit gerer ce 2 pages au partie de gestion des views
		// doctor page ************************************ just pour tester         1a252c
		fr1 = new JFrame("Doctor");
		JPanel p1 = new JPanel();
		fr1.setSize(400, 350);
		fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel docText = new JLabel("Hello doctor");
		docText.setBounds(200, 200, 100, 100);
		docText.setSize(100, 100);
		p1.add(docText);
		fr1.add(p1);
		fr1.setExtendedState(fr1.getExtendedState() | JFrame.MAXIMIZED_BOTH);

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
		fr2.setExtendedState(fr2.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
/***********************************************************************************************/		
		
		loginContainerPanel.setLayout(null);
		loginContainerPanel.setBounds(100, 100, 400, 200);
		//loginContainerPanel.setBackground(Color.TRANSPARENT);

		userLabel = new JLabel("User: ");
		userLabel.setBounds(20, 30, 200, 25);
		loginContainerPanel.add(userLabel);

		userText = new JComboBox<String>();
		userText.setBounds(120, 30, 210, 25);
		userText.addItem("Doctor");
		userText.addItem("Secretaire");
		userText.setSelectedItem("Doctor");
		loginContainerPanel.add(userText);

		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(20, 60, 200, 25);
		loginContainerPanel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(120, 60, 211, 25);
		loginContainerPanel.add(passwordText);

		loginButton = new JButton("Login");
		loginButton.setBounds(120, 90, 100, 25);
		loginButton.setToolTipText("Se connecter");
		loginButton.addActionListener(new LoginView());
		loginContainerPanel.add(loginButton);

		resetButton = new JButton("Reset");
		resetButton.setBounds(230, 90, 100, 25);
		resetButton.addActionListener(new LoginView());
		loginContainerPanel.add(resetButton);

		erreurMsg = new JLabel();
		erreurMsg.setBounds(20, 130, 200, 25);
		loginContainerPanel.add(erreurMsg);

		loginFrame.setVisible(true);
		
	}

	public static String selectUserKey(String user){
		
		String userKey = null;
		
		try {
			connect = new DatabaseConnection();
			
			String selectQuery = "select userKey from " + user + " where username = '" + user + "'";
		
			PreparedStatement preparedStmt = connect.getConnection().prepareStatement(selectQuery);
			
			ResultSet res = preparedStmt.executeQuery(selectQuery);
			
			while (res.next()) userKey = res.getString("userKey");
		
			connect.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return userKey;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = "";
		String password = passwordText.getText();
		
		if(userText.getSelectedItem() != null) username = userText.getSelectedItem().toString().trim();
		
		if (e.getSource() == loginButton) {
			if (username.equalsIgnoreCase("doctor") && password.equals(selectUserKey(username))) {
				loginFrame.setVisible(false);
				fr1.setVisible(true);
			} 
			else if (username.equalsIgnoreCase("secretaire") && password.equals(selectUserKey(username))) {
				loginFrame.setVisible(false);
				fr2.setVisible(true);
			} 
			else if(username.isEmpty()) erreurMsg.setText("No user selected !!");
			else erreurMsg.setText("Incorrect password !!");
		} 
		else if (e.getSource() == resetButton) {
			if(!username.isEmpty() || !password.isEmpty()) {
				passwordText.setText(null);
				userText.setSelectedItem(null);
				erreurMsg.setText("");
			}
		}
	}

}
