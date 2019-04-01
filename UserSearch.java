package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;
import model.UserDAO;

public class UserSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtPW;

	/**
	 * Create the dialog.
	 */
	public UserSearch(UserDAO userDAO, String ssn) {
		setBounds(100, 100, 332, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblID = new JLabel("아이디 :");
		lblID.setBounds(55, 51, 57, 15);
		contentPanel.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(124, 48, 116, 21);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblPW = new JLabel("비밀번호 :");
		lblPW.setBounds(55, 89, 70, 15);
		contentPanel.add(lblPW);
		
		txtPW = new JTextField();
		txtPW.setBounds(124, 86, 116, 21);
		contentPanel.add(txtPW);
		txtPW.setColumns(10);
		
		JLabel lblPower = new JLabel("권한 : ");
		lblPower.setBounds(55, 124, 57, 15);
		contentPanel.add(lblPower);
		
		String power[] = {"있음","없음"};
		
		JComboBox comboBox = new JComboBox(power);
		comboBox.setBounds(124, 121, 116, 21);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("수정");
				btnUpdate.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						char power;
						if(comboBox.getSelectedItem().equals("있음")) power = 'Y';
						else power = 'N';
						User user = new User(ssn,txtID.getText(),txtPW.getText(),power);
						userDAO.updateUser(user);
						dispose();
					}
				});
				buttonPane.add(btnUpdate);
			}
			
			JButton btnDelete = new JButton("삭제");
			buttonPane.add(btnDelete);
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					userDAO.deleteUser(ssn);
					dispose();
				}
			});
			{
				JButton btnCancel = new JButton("뒤로");
				btnCancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnCancel);
			}
		}
		
		User user = userDAO.selectUser(ssn);
		txtID.setText(user.getId());
		txtPW.setText(user.getPw());
		if(user.getPower() == 'Y') {
			comboBox.setSelectedItem("있음");
		}else {
			comboBox.setSelectedItem("없음");
		}
	}
}
