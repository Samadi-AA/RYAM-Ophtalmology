package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;

public class DoctorView extends JFrame{
	
	/*-- Components --*/
	private JPanel container;
		private JPanel menuPanel; 
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
			private JPanel rdvTablePanel;
	
	/*-- Design --*/
	private ImageIcon homeImage = new ImageIcon(DoctorView.class.getResource("/view/icons/home.png"));
	private ImageIcon patientImage = new ImageIcon(DoctorView.class.getResource("/view/icons/patient.png"));
	private ImageIcon rdvImage = new ImageIcon(DoctorView.class.getResource("/view/icons/calendar.png"));
	private ImageIcon signOutImage = new ImageIcon(DoctorView.class.getResource("/view/icons/signOut.png"));	
	private final Color mainDark = Color.decode("#1a252c");
	private final Color mainWhite = Color.decode("#eeeeee");
	private final Color mainGreen = Color.decode("#39b672");
	private final Font mainFont = new Font("Candara", Font.BOLD, 25);

	
	/*-- Constructor --*/
	
	public DoctorView() {
		setTitle("Docteur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		container = new JPanel();
		container.setBackground(mainWhite);
		setContentPane(container);
		container.setLayout(new GridBagLayout()); 
		
		// set the menu bar : **************************************************
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1, 5, 0, 0));
		menuPanel.setBackground(mainDark);
		
		GridBagConstraints menuPanelConstraints = new GridBagConstraints();                      // menuPanel's constraints
		setGridBagConstraints(menuPanelConstraints, 0, 0, 1, 1, 1, 0.07, GridBagConstraints.BOTH);
		
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
		
		menuPanel.add(homePanel);
		
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
		
		menuPanel.add(patientPanel);
		
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
		
		menuPanel.add(rdvPanel);
		
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
		
		menuPanel.add(signOutPanel);
		
		container.add(menuPanel, menuPanelConstraints);
		
		// set the content of main panel ******************************************************
		contentPane = new JLayeredPane();
		contentPane.setLayout(null);
				
		GridBagConstraints contentPaneConstraints = new GridBagConstraints();		               // constraints for the main Panel
		setGridBagConstraints(contentPaneConstraints, 0, 1, 1, 9, 1, 0.90, GridBagConstraints.BOTH);
		contentPaneConstraints.insets = new Insets(10, 0, 10, 0);
		
		container.add(contentPane, contentPaneConstraints);
		panelSelected(new DoctorHome());
		homePanel.setBorder(BorderFactory.createMatteBorder(0, 0, homePanel.getHeight(), 0, Color.gray));
		patientPanel.setBorder(null);
		rdvPanel.setBorder(null);
		
	}
	
	/*-- set listeners --*/
	private class PanelMouseAdapter extends MouseAdapter{
		JPanel panel;
		
		public PanelMouseAdapter(JPanel panel) {
			panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(mainGreen);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(mainDark);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			//panel.setBackground(Color.gray);      
			if(e.getComponent() == homePanel) {
				panelSelected(new DoctorHome());
				homePanel.setBorder(BorderFactory.createMatteBorder(0, 0, panel.getHeight(), 0, Color.gray));
				patientPanel.setBorder(null);
				rdvPanel.setBorder(null);
			}
			if(e.getComponent() == patientPanel) {
				panelSelected(new PatientView());
				patientPanel.setBorder(BorderFactory.createMatteBorder(0, 0, panel.getHeight(), 0, Color.gray));
				homePanel.setBorder(null);
				rdvPanel.setBorder(null);
			}
			if(e.getComponent() == rdvPanel) {
				rdvTablePanel = new JPanel();
				rdvTablePanel.setBounds(5, 0, 1350, 670);
				rdvTablePanel.setLayout(new GridBagLayout());
				GridBagConstraints tblrdvConstraint = new GridBagConstraints();
				tblrdvConstraint.gridx=0;
				tblrdvConstraint.gridy=0;
				tblrdvConstraint.gridwidth=1;
				tblrdvConstraint.gridheight=1;
				tblrdvConstraint.weightx=1;
				tblrdvConstraint.weighty = 1;
				tblrdvConstraint.fill = GridBagConstraints.BOTH;
				rdvTablePanel.add(new AllRDVTable().getView(),tblrdvConstraint);
				panelSelected(rdvTablePanel);
				rdvPanel.setBorder(BorderFactory.createMatteBorder(0, 0, panel.getHeight(), 0, Color.gray));
				homePanel.setBorder(null);
				patientPanel.setBorder(null);
			}
			if(e.getComponent() == signOutPanel) {
				if(JOptionPane.showConfirmDialog(null, "Vous voullez se decoonecter ?", "Annulation", JOptionPane.YES_NO_OPTION) == 0) {
					DoctorView.this.dispose();
					LoginView.launch();
				}
			}
		}
		
	}
	
	/*-- Methods --*/
	
	// launch the frame
	public static void launch() {
		DoctorView homeDoctorView = new DoctorView();
		homeDoctorView.setVisible(true);
	}

	
	// initialize the image's dimensions :
		public ImageIcon resizeImage(ImageIcon image, int width, int height) {
			Image imgScale = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(imgScale);
			return scaledIcon;
		}
		
	// initialize the constraints of a component
	public void setGridBagConstraints(GridBagConstraints constraints, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill) {
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		}
	
	public void panelSelected(JPanel panel){
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
