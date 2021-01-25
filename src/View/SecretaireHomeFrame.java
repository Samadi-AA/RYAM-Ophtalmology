package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SecretaireHomeFrame extends JFrame {

	private JPanel contentPane;


	public SecretaireHomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	// launch the frame
	public static void launch() {
		SecretaireHomeFrame secHomeWindow = new SecretaireHomeFrame();
		secHomeWindow.setVisible(true);
	}
		
}
