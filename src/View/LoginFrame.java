package view;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import control.DatabaseConnection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
	private static DatabaseConnection connect;
	/*-- Components --*/
	private JPanel container;
		private JLabel logo;
		private JPanel usernamePanel;
			private JComboBox<String> usernameField;
		private JPanel passwordPanel;
			private JTextField passwordField;
			private JLabel lblPassword;
		private JLabel lblErrorMsg;
		private JButton btnLogin;
		private JButton btnCancel;
		
	/*-- Design --*/
	private ImageIcon logoImage = new ImageIcon(LoginFrame.class.getResource("/view/icons/logo.png"));
	private ImageIcon passwordIcon = new ImageIcon(LoginFrame.class.getResource("/view/icons/pwdIcon.png"));
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 20);
		
	/*-- Constructor --*/
	public LoginFrame() {
		// set the window/Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Se Connecter");
		
		// set the container panel
		container = new JPanel();
		container.setBorder(new LineBorder(mainWhite, 2));
		container.setBackground(mainDark);
		container.setLayout(null);
		setContentPane(container);
		
		// set the logo
		logo = new JLabel("");
		logo.setBounds(74, 11, 299, 116);
		logo.setIcon(logoImage);
		container.add(logo);
		
		// set the username panel
		usernamePanel = new JPanel();
		usernamePanel.setBounds(85, 141, 280, 30);
		usernamePanel.setLayout(null);
		container.add(usernamePanel);
		
		// set the username field (ComboBox)
		usernameField = new JComboBox<String>();
		usernameField.addItem("   Doctor");
		usernameField.addItem("   Secretaire");
		usernameField.setBounds(0, 0, 280, 30);
		usernameField.setBorder(null);
		usernameField.setMaximumRowCount(2);
		usernameField.setBackground(mainWhite);
		usernameField.setFont(new Font("Candara", Font.BOLD, 16));
		usernameField.setFocusable(false);
		usernamePanel.add(usernameField);
		
		// set the password panel
		passwordPanel = new JPanel();
		passwordPanel.setLayout(null);
		passwordPanel.setBounds(85, 187, 280, 30);
		container.add(passwordPanel);
		
		// set the password field
		passwordField = new JPasswordField(20);
		passwordField.setBounds(15, 0, 225, 30);
		passwordField.setBorder(null);
		passwordField.setToolTipText("Mot de passe");
		passwordField.setColumns(10);
		passwordField.setBackground(mainWhite);
		passwordField.setForeground(mainDark);
		passwordPanel.add(passwordField);
			
		// set the password icon
		lblPassword = new JLabel("");
		lblPassword.setBounds(250, 3, 24, 24);
		lblPassword.setIcon(passwordIcon);
		passwordPanel.add(lblPassword);
		
		// set the error message label
		lblErrorMsg = new JLabel("");
		lblErrorMsg.setBounds(90, 171, 225, 16);
		lblErrorMsg.setForeground(Color.red);
		lblErrorMsg.setFont(new Font("monospace", 0, 11));
		container.add(lblErrorMsg);
		
		// set the login button
		btnLogin = new JButton("Se Connecter");
		btnLogin.setBounds(85, 233, 135, 30);
		btnLogin.setBorder(null);
		btnLogin.setFocusPainted(false);
		btnLogin.setBackground(mainGreen);
		btnLogin.setForeground(mainWhite);
		btnLogin.setFont(mainFont);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		container.add(btnLogin);
		
		// set the login button
		btnCancel = new JButton("Annuler");
		btnCancel.setBounds(230, 233, 135, 30);
		btnCancel.setBorder(null);
		btnCancel.setFocusPainted(false);
		btnCancel.setBackground(mainGreen);
		btnCancel.setForeground(mainWhite);
		btnCancel.setFont(mainFont);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		container.add(btnCancel);
		
		/*-- set listeners --*/
		// listener for the login button
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mev) {
				String username = usernameField.getSelectedItem().toString().trim();
				String password = passwordField.getText();
				
				if (username.equalsIgnoreCase("doctor") && password.equals(selectUserKey(username))) {
					LoginFrame.this.dispose(); //close the login window
					//HomeDoctorFrame.launchHomeWindow(); launch the doctor's home window
				} 
				else if (username.equalsIgnoreCase("secretaire") && password.equals(selectUserKey(username))) {
					LoginFrame.this.dispose();
					//HomeSecretaireFrame.launchHomeWindow(); launch the secretaire's home window
				} 
				else lblErrorMsg.setText("Incorrect Password...!?");
			}
		});
		
		// listener for the cancel button
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mev) {
				if(JOptionPane.showConfirmDialog(null, "Quiter l'application !?", "Annulation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginFrame.this.dispose();
				}
			}
		});
		
	}

	/*-- Methods --*/
	// launch the frame
	public static void launchLogin() {
		LoginFrame loginWindow = new LoginFrame();
		loginWindow.setVisible(true);
	}
	
	// get the password from the data base
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

}
