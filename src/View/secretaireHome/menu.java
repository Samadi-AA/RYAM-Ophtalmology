package secretaireHome;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class menu {
	
	JButton aceuille,patients,rdv;
	static JFrame menuFrame;
	static JPanel menuPanel;
	public menu() {
		
	}
	
	public JPanel getView() {
		menuPanel = new JPanel(new FlowLayout());
		
		aceuille = new JButton("Home");
		menuPanel.add(aceuille);
		
		patients = new JButton("Patients");
		menuPanel.add(patients);
		
		rdv = new JButton("RDV");
		menuPanel.add(rdv);
		menuPanel.setBackground(Color.black);
		
		return menuPanel;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu m = new menu();
		
		menuFrame = new JFrame();
		
		
		menuFrame.add(m.getView());
		
		menuFrame.setSize(1650,1080);
		menuFrame.setLocationRelativeTo(null);  
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        menuFrame.setVisible(true);  
	}

}
