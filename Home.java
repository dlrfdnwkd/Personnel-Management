package controller;

import javax.swing.JPanel;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 249, 183);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(273, 10, 165, 183);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 203, 426, 87);
		add(panel_2);

	}
}
