package view;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;

public class PatientView extends JPanel {

	public PatientTable tablePatienView = new PatientTable();
	public GridBagConstraints patientConstraint, patientInfoConstraint;

	public PatientView() {
		setBounds(5, 0, 1350, 670);
		setLayout(new GridBagLayout());
		
		patientConstraint = new GridBagConstraints();
		patientConstraint.gridx=0;
		patientConstraint.gridy=0;
		patientConstraint.gridwidth=3;
		patientConstraint.gridheight=1;
		patientConstraint.weightx=0.55;
		patientConstraint.weighty = 1;
		patientConstraint.fill = GridBagConstraints.BOTH;
		add(tablePatienView.getView(),patientConstraint);
		
		patientInfoConstraint = new GridBagConstraints();
		patientInfoConstraint.gridx=3;
		patientInfoConstraint.gridy=0;
		patientInfoConstraint.gridwidth=1;
		patientInfoConstraint.gridheight=1;
		patientInfoConstraint.weightx=0.45;
		patientInfoConstraint.weighty = 1;
		patientInfoConstraint.fill = GridBagConstraints.BOTH;
		add(new AddPatientForm(),patientInfoConstraint);
		
	}

	public GridBagConstraints getPatientConstraint() {
		return patientInfoConstraint;
	}
		
}
