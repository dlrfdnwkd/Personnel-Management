package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Department;
import model.DepartmentDAO;

public class DepartmentSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDname;
	private JTextField txtDnumber;
	private JTextField txtMgrssn;
	private JTextField txtMgrdate;

	public DepartmentSearch(DepartmentDAO departmentDAO,int dnumber) {
		setBounds(100, 100, 407, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDname = new JLabel("�μ��̸� :");
		lblDname.setBounds(96, 37, 57, 15);
		contentPanel.add(lblDname);
		
		txtDname = new JTextField();
		txtDname.setBounds(195, 34, 116, 21);
		contentPanel.add(txtDname);
		txtDname.setColumns(10);
		
		JLabel lblDnumber = new JLabel("�μ���ȣ :");
		lblDnumber.setBounds(96, 72, 57, 15);
		contentPanel.add(lblDnumber);
		
		txtDnumber = new JTextField();
		txtDnumber.setBounds(195, 69, 116, 21);
		contentPanel.add(txtDnumber);
		txtDnumber.setColumns(10);
		
		JLabel lblMgrssn = new JLabel("���� �����ȣ:");
		lblMgrssn.setBounds(96, 104, 87, 15);
		contentPanel.add(lblMgrssn);
		
		txtMgrssn = new JTextField();
		txtMgrssn.setBounds(195, 101, 116, 21);
		contentPanel.add(txtMgrssn);
		txtMgrssn.setColumns(10);
		
		JLabel lblMgrdate = new JLabel("�μ� ������: ");
		lblMgrdate.setBounds(96, 138, 87, 15);
		contentPanel.add(lblMgrdate);
		
		txtMgrdate = new JTextField();
		txtMgrdate.setBounds(195, 135, 116, 21);
		contentPanel.add(txtMgrdate);
		txtMgrdate.setColumns(10);
		
		Department department = departmentDAO.selectDepartment(dnumber);
		txtDname.setText(department.getDname());
		txtDnumber.setText(String.valueOf(department.getDnumber()));
		txtMgrssn.setText(department.getMgrssn());
		txtMgrdate.setText(department.getMgrstartdate().toString());
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnUpdate = new JButton("����");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				department.setDname(txtDname.getText());
				department.setDnumber(Integer.parseInt(txtDnumber.getText()));
				department.setMgrssn(txtMgrssn.getText());
				department.setMgrstartdate(Date.valueOf(txtMgrdate.getText()));
				departmentDAO.updateDepartment(department,dnumber);
				JOptionPane.showMessageDialog(null, "�μ��� �����Ǿ����ϴ�.");
				dispose();
			}
		});
		buttonPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("����");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				departmentDAO.deleteDepartment(dnumber);
				JOptionPane.showMessageDialog(null, "�μ��� �����Ǿ����ϴ�.");
				dispose();
			}
		});
		buttonPane.add(btnDelete);
			
		JButton btnCancel = new JButton("�ڷ�");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(btnCancel);
		
	}
}
