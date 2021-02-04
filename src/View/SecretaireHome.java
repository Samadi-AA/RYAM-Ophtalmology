package view;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SecretaireHome extends JPanel{

	private RDVTable tableRDVView;
	private AddRDVForm formAddRDV;

	public SecretaireHome() {
		setBounds(5, 0, 1350, 670);
		setLayout(new GridBagLayout());

		tableRDVView = new RDVTable();
		GridBagConstraints tblrdvConstraint = new GridBagConstraints();
		tblrdvConstraint.gridx=0;
		tblrdvConstraint.gridy=0;
		tblrdvConstraint.gridwidth=3;
		tblrdvConstraint.gridheight=1;
		tblrdvConstraint.weightx=0.75;
		tblrdvConstraint.weighty = 1;
		tblrdvConstraint.fill = GridBagConstraints.BOTH;
		tblrdvConstraint.insets = new Insets(0,0,0,0);
		add(tableRDVView.getView(),tblrdvConstraint);
		
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
		add(formAddRDV.getView(),rdvConstraint);
	}
		
}
