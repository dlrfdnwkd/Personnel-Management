package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import model.User;
import model.UserDAO;

public class UserCreate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtPW;

	/**
	 * Create the dialog.
	 */
	public UserCreate(UserDAO userDAO, String ssn) {
		setBounds(100, 100, 346, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblID = new JLabel("���̵� :");
			lblID.setBounds(58, 26, 57, 15);
			contentPanel.add(lblID);
		}
		{
			txtID = new JTextField();
			txtID.setBounds(137, 23, 116, 21);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			JLabel lblPW = new JLabel("��й�ȣ :");
			lblPW.setBounds(58, 55, 73, 15);
			contentPanel.add(lblPW);
		}
		{
			txtPW = new JTextField();
			txtPW.setBounds(137, 52, 116, 21);
			contentPanel.add(txtPW);
			txtPW.setColumns(10);
		}
		{
			JLabel lblPower = new JLabel("���� :");
			lblPower.setBounds(58, 86, 57, 15);
			contentPanel.add(lblPower);
		}
		
		String power[] = {"����","����"};
		
		
			JComboBox comboBox = new JComboBox(power);
			comboBox.setBounds(137, 83, 116, 21);
			contentPanel.add(comboBox);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						char powerSelect;
						if(comboBox.getSelectedItem().equals("����")) powerSelect = 'Y';
						else powerSelect = 'N';
						User user = new User(ssn,txtID.getText(),txtPW.getText(),powerSelect);
						userDAO.insertUser(user);
						JOptionPane.showMessageDialog(null, "�μ��� �߰��Ǿ����ϴ�.");
						dispose();
						txtID.setText(null);
						txtPW.setText(null);
					}
				});
				buttonPane.add(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnCancel);
			}
		}
	}

}
