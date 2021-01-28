package view;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.secretaireHome.RDVTableView;
import view.secretaireHome.AddRDVForm;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PatientFrame extends JFrame {

	private JPanel container;
	private PatientTable tablePatienView = new PatientTable();

	public PatientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		container = new JPanel();
		container.setBorder(new EmptyBorder(0, 0, 0, 0));
		container.setLayout(new GridBagLayout());
		setContentPane(container);
		
		GridBagConstraints patientConstraint = new GridBagConstraints();
		patientConstraint.gridx=0;
		patientConstraint.gridy=0;
		patientConstraint.gridwidth=3;
		patientConstraint.gridheight=1;
		patientConstraint.weightx=0.75;
		patientConstraint.weighty = 1;
		patientConstraint.fill = GridBagConstraints.BOTH;
		patientConstraint.insets = new Insets(0,0,0,0);
		container.add(tablePatienView.getView(),patientConstraint);
		
	}

	// launch the frame
	public static void launch() {
		PatientFrame secHomeWindow = new PatientFrame();
		secHomeWindow.setVisible(true);
	}
		
}
