package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.secretaireHome.*;


public class secretaireView {
		
		static JFrame srcretaireFrame;
		static JPanel container;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		container = new JPanel();
		container.setLayout(new GridBagLayout());

		
		
		menu m = new menu();
		GridBagConstraints menuConstraint = new GridBagConstraints();
		menuConstraint.gridx=0;
		menuConstraint.gridy=0;
		menuConstraint.gridwidth=3;
		menuConstraint.weightx=1;
		menuConstraint.fill = GridBagConstraints.BOTH;
		menuConstraint.insets = new Insets(5,5,5,5);
		container.add(m.getView(),menuConstraint);
		
		patientRDV p = new patientRDV();
		GridBagConstraints patientRdvConstraint = new GridBagConstraints();
		patientRdvConstraint.gridx=0;
		patientRdvConstraint.gridy=1;
		patientRdvConstraint.gridwidth=2;
		patientRdvConstraint.weightx=0.75;
		patientRdvConstraint.fill = GridBagConstraints.BOTH;
		patientRdvConstraint.insets = new Insets(5,5,5,5);
		container.add(p.getView(),patientRdvConstraint);
		
		rdv r = new rdv();
		GridBagConstraints rdvConstraint = new GridBagConstraints();
		rdvConstraint.gridx=3;
		rdvConstraint.gridy=1;
		rdvConstraint.gridwidth=1;
		rdvConstraint.weightx=0.25;
		rdvConstraint.fill = GridBagConstraints.BOTH;
		rdvConstraint.insets = new Insets(5,5,5,5);
		container.add(r.getView(),rdvConstraint);	
		
		srcretaireFrame = new JFrame();
		
		srcretaireFrame.add(container);
		srcretaireFrame.setSize(1650,1080);
		srcretaireFrame.setLocationRelativeTo(null);  
		srcretaireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		srcretaireFrame.setVisible(true);  
	}

}
