package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Employee;
import model.EmployeeDAO;
import model.RetirementDAO;

public class EmployeeToRetirement extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public EmployeeToRetirement(EmployeeDAO employeeDAO, RetirementDAO retirementDAO,String ssn) {
		setBounds(150, 150, 303, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lable = new JLabel("퇴직처리 하겠습니까?");
			lable.setFont(new Font("굴림", Font.PLAIN, 20));
			lable.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lable, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("예");
				btnOK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Employee employee = employeeDAO.searchPerson(ssn);
						employeeDAO.deleteEmployee(ssn);
						retirementDAO.insertRetirement(employee);
						dispose();
					}
				});
				buttonPane.add(btnOK);

			}
			{
				JButton btnCancel = new JButton("아니요");
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
