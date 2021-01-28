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

public class SecretaireHomeFrame extends JFrame {

	private JPanel container;
	private RDVTableView tableRDVView;
	private AddRDVForm formAddRDV;

	public SecretaireHomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		container = new JPanel();
		container.setBorder(new EmptyBorder(0, 0, 0, 0));
		container.setLayout(new GridBagLayout());
		setContentPane(container);
		
		
		tableRDVView = new RDVTableView();
		GridBagConstraints tblrdvConstraint = new GridBagConstraints();
		tblrdvConstraint.gridx=0;
		tblrdvConstraint.gridy=0;
		tblrdvConstraint.gridwidth=3;
		tblrdvConstraint.gridheight=1;
		tblrdvConstraint.weightx=0.75;
		tblrdvConstraint.weighty = 1;
		tblrdvConstraint.fill = GridBagConstraints.BOTH;
		tblrdvConstraint.insets = new Insets(0,0,0,0);
		container.add(tableRDVView.getView(),tblrdvConstraint);
		
		formAddRDV = new AddRDVForm();
		GridBagConstraints rdvConstraint = new GridBagConstraints();
		rdvConstraint.gridx=3;
		rdvConstraint.gridy=0;
		rdvConstraint.gridwidth=1;
		rdvConstraint.gridheight=1;
		rdvConstraint.weightx=0.25;
		rdvConstraint.weighty=1;
		rdvConstraint.fill = GridBagConstraints.HORIZONTAL;
		rdvConstraint.insets = new Insets(0,0,0,0);
		container.add(formAddRDV.getView(),rdvConstraint);
	}

	// launch the frame
	public static void launch() {
		SecretaireHomeFrame secHomeWindow = new SecretaireHomeFrame();
		secHomeWindow.setVisible(true);
	}
		
}
