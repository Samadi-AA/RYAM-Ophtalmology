package view;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SecretaireHomeFrame extends JFrame {

	private JPanel container;
	

	public SecretaireHomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setLayout(new GridBagLayout());
		setContentPane(container);
	}

	// launch the frame
	public static void launch() {
		SecretaireHomeFrame secHomeWindow = new SecretaireHomeFrame();
		secHomeWindow.setVisible(true);
	}
		
}
