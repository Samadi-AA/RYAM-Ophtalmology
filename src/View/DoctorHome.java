/***** Author     : Abdessamad AIT OUAKRIM
 ***** Project    : RYAM System
 ***** Professor: Sara ROUBI
 ***** Date       : 28 janv. 2021
 ******************************************/ 


package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class DoctorHome extends JFrame{
	
	/*-- Components --*/
	private JPanel container;
		private JPanel menuPanel; 
			private JPanel logoPanel;
				private JLabel logoLabel;
			private JPanel menuElementPanel;
				private JPanel homePanel;
					private JLabel homeLabel;
					private JLabel homeIcon;
				private JPanel patientPanel;
					private JLabel patientLabel;
					private JLabel patientIcon;
				private JPanel rdvPanel;
					private JLabel rdvLabel;
					private JLabel rdvIcon;
				private JPanel signOutPanel;
					private JLabel signOutLabel;
					private JLabel signOutIcon;
		private JLayeredPane contentPane;
			private JPanel homeContent; 
			private JLabel homeMsg;
			private JPanel patientContent;
			private JLabel PatientMsg;
			private JPanel rdvContent;
			private JLabel rdvMsg;
	
	/*-- Design --*/
	private ImageIcon logoImage = new ImageIcon(DoctorHome.class.getResource("/view/icons/logo.png"));
	private ImageIcon homeImage = new ImageIcon(DoctorHome.class.getResource("/view/icons/home.png"));
	private ImageIcon patientImage = new ImageIcon(DoctorHome.class.getResource("/view/icons/patient.png"));
	private ImageIcon rdvImage = new ImageIcon(DoctorHome.class.getResource("/view/icons/calendar.png"));
	private ImageIcon signOutImage = new ImageIcon(DoctorHome.class.getResource("/view/icons/signOut.png"));	
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 30);

	
	/*-- Constructor --*/
	
	public DoctorHome() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		container = new JPanel();
		container.setBackground(mainWhite);
		setContentPane(container);
		container.setLayout(new GridBagLayout()); 
		
		// set the menu bar : **************************************************
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridBagLayout());
		menuPanel.setBackground(mainDark);
		
		GridBagConstraints menuPanelConstraints = new GridBagConstraints();                      // menuPanel's constraints
		setGridBagCinstraints(menuPanelConstraints, 0, 0, 3, 1, 0.30, 1, GridBagConstraints.BOTH);
		
		//set the logo panel in menu bar : //////////////////////////////////////
		logoPanel = new JPanel();
		logoPanel.setBackground(mainDark);
		logoPanel.setLayout(null);
		
		GridBagConstraints logoPanelConstraints = new GridBagConstraints();
		setGridBagCinstraints(logoPanelConstraints, 0, 0, 1, 1, 1, 0.2, GridBagConstraints.BOTH);
		
		logoLabel = new JLabel();   // Label for logo icon
		logoLabel.setBounds(50, 5, 250, 100);
		logoLabel.setIcon(resizeImage(logoImage, logoLabel.getWidth(), logoLabel.getHeight()));
		logoPanel.add(logoLabel);
		
		menuPanel.add(logoPanel, logoPanelConstraints);
		
		menuElementPanel = new JPanel();
		menuElementPanel.setBackground(mainDark);
		menuElementPanel.setLayout(new GridLayout(10, 1, 0, 10));
		
		GridBagConstraints menuElementPanelConstraints = new GridBagConstraints();
		setGridBagCinstraints(menuElementPanelConstraints, 0, 1, 1, 4, 1, 0.8, GridBagConstraints.BOTH);
		
		//set the home panel in menu bar : //////////////////////////////////////
		homePanel = new JPanel();
		homePanel.addMouseListener(new PanelMouseAdapter(homePanel));
		homePanel.setLayout(null);
		homePanel.setBackground(mainDark);
		
		homeLabel = new JLabel("Accueil");
		homeLabel.setBounds(70, 10, 100, 40);
		homeLabel.setFont(mainFont);
		homeLabel.setForeground(mainWhite);
		
		homeIcon = new JLabel();                       // Label for home icon
		homeIcon.setBounds(25, 4, 40, 40);
		homeIcon.setIcon(resizeImage(homeImage, 30, 30));
		
		homePanel.add(homeIcon);
		homePanel.add(homeLabel);
		
		menuElementPanel.add(homePanel);
		
		//set the patient panel in menu bar : //////////////////////////////////////
		patientPanel = new JPanel();
		patientPanel.addMouseListener(new PanelMouseAdapter(patientPanel));
		patientPanel.setLayout(null);
		patientPanel.setBackground(mainDark);
		
		patientLabel = new JLabel("Listes Des Patients");
		patientLabel.setBounds(70, 10, 250, 40);
		patientLabel.setFont(mainFont);
		patientLabel.setForeground(mainWhite);
		
		patientIcon = new JLabel();						 // Label for patient icon
		patientIcon.setBounds(25, 4, 40, 40);
		patientIcon.setIcon(resizeImage(patientImage, 30, 30));
		
		patientPanel.add(patientIcon);
		patientPanel.add(patientLabel);
		
		menuElementPanel.add(patientPanel);
		
		//set the rdv panel in menu bar : /////////////////////////////////////////////
		rdvPanel = new JPanel();
		rdvPanel.addMouseListener(new PanelMouseAdapter(rdvPanel));
		rdvPanel.setLayout(null);
		rdvPanel.setBackground(mainDark);
		
		rdvLabel = new JLabel("Listes Des RDVs");
		rdvLabel.setBounds(70, 10, 250, 40);
		rdvLabel.setFont(mainFont);
		rdvLabel.setForeground(mainWhite);
		
		rdvIcon = new JLabel();							// Label for rdv icon
		rdvIcon.setBounds(25, 4, 40, 40);
		rdvIcon.setIcon(resizeImage(rdvImage, 30, 30));
		
		rdvPanel.add(rdvIcon);
		rdvPanel.add(rdvLabel);
		
		menuElementPanel.add(rdvPanel);
		
		//set the signOut panel in menu bar : /////////////////////////////////////////
		signOutPanel = new JPanel();
		signOutPanel.addMouseListener(new PanelMouseAdapter(signOutPanel));
		signOutPanel.setLayout(null);
		signOutPanel.setBackground(mainDark);
		
		signOutLabel = new JLabel("Se Deconnecter");
		signOutLabel.setBounds(70, 10, 250, 40);
		signOutLabel.setFont(mainFont);
		signOutLabel.setForeground(mainWhite);
		
		signOutIcon = new JLabel();						// Label for log out icon
		signOutIcon.setBounds(25, 4, 40, 40);
		signOutIcon.setIcon(resizeImage(signOutImage, 30, 30));
		
		signOutPanel.add(signOutIcon);
		signOutPanel.add(signOutLabel);
		
		menuElementPanel.add(signOutPanel);
		
		
		menuPanel.add(menuElementPanel, menuElementPanelConstraints);
		
		container.add(menuPanel, menuPanelConstraints);
		
		// set the content of main panel ******************************************************
		contentPane = new JLayeredPane();
		contentPane.setLayout(null);
				
		GridBagConstraints contentPaneConstraints = new GridBagConstraints();		               // constraints for the main Panel
		setGridBagCinstraints(contentPaneConstraints, 3, 0, 7, 1, 0.7, 1, GridBagConstraints.BOTH);
				
		container.add(contentPane, contentPaneConstraints);
		
		/////////////////////////////////////////////////// Just a TEST   //////////////////////////////////////////
		homeContent = new JPanel();
		homeContent.setBounds(10, 11, 600, 400);
		homeContent.setLayout(null);
		
		homeMsg = new JLabel("Welcome at home XD");
		homeMsg.setBounds(200, 250, 200, 20);
		homeContent.add(homeMsg);
		
		patientContent = new JPanel();
		patientContent.setBounds(10, 11, 600, 400);
		patientContent.setLayout(null);
		
		PatientMsg = new JLabel("La listes des patients");
		PatientMsg.setBounds(200, 250, 200, 20);
		patientContent.add(PatientMsg);
		
		rdvContent = new JPanel();
		rdvContent.setBounds(10, 11, 600, 400);
		rdvContent.setLayout(null);
		
		rdvMsg = new JLabel("La listes des RDVs");
		rdvMsg.setBounds(200, 250, 200, 20);
		rdvContent.add(rdvMsg);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	/*-- set listeners --*/
	private class PanelMouseAdapter extends MouseAdapter{
		JPanel panel;
		
		public PanelMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(mainGreen);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(mainDark);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(Color.green);     // change this color !!!!!!!!  
			if(e.getComponent() == homePanel) {
				panelSelected(homeContent);
			}
			if(e.getComponent() == patientPanel) {
				panelSelected(patientContent);
			}
			if(e.getComponent() == rdvPanel) {
				panelSelected(rdvContent);
			}
			if(e.getComponent() == signOutPanel) {
				if(JOptionPane.showConfirmDialog(null, "Vous voullez se decoonecter ?", "Annulation", JOptionPane.YES_NO_OPTION) == 0) {
					DoctorHome.this.dispose();
					LoginFrame.launch();
				}
			}
		}
		
	}
	
	/*-- Methods --*/
	
	// launch the frame
	public static void launch() {
		DoctorHome homeDoctorView = new DoctorHome();
		homeDoctorView.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorHome.launch();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// initialize the image's dimensions :
		public ImageIcon resizeImage(ImageIcon image, int width, int height) {
			Image imgScale = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(imgScale);
			return scaledIcon;
		}
		
	// initialize the constraints of a component
	public void setGridBagCinstraints(GridBagConstraints constraints, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill) {
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		}
	
	public void panelSelected(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
