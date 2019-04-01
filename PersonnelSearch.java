package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Employee;
import model.EmployeeDAO;
import java.awt.Font;

public class PersonnelSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private EmployeeDAO dao;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtBdate;
	private JTextField txtSsn;
	private JTextField txtAddress;
	private JTextField txtSex;
	private JTextField txtSuperssn;
	private JTextField txtKno;
	private JTextField txtDno;

	/**
	 * Create the dialog.
	 */
	public PersonnelSearch(EmployeeDAO employeeDAO,String ssn) {
		dao = employeeDAO;
		setBounds(100, 100, 640, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblHead = new JLabel("사원 정보");
		lblHead.setFont(new Font("굴림", Font.PLAIN, 31));
		lblHead.setBounds(233, 22, 134, 43);
		contentPanel.add(lblHead);
		
		JLabel lblFname = new JLabel("성 :");
		lblFname.setBounds(105, 95, 57, 15);
		contentPanel.add(lblFname);
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBounds(174, 92, 116, 21);
		contentPanel.add(txtFname);
		
		JLabel lblLname = new JLabel("이름 :");
		lblLname.setBounds(312, 95, 57, 15);
		contentPanel.add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(381, 92, 116, 21);
		contentPanel.add(txtLname);
		
		JLabel lblSsn = new JLabel("사원번호 :");
		lblSsn.setBounds(99, 144, 69, 15);
		contentPanel.add(lblSsn);
		
		txtSsn = new JTextField();
		txtSsn.setColumns(10);
		txtSsn.setBounds(168, 141, 116, 21);
		contentPanel.add(txtSsn);
		
		JLabel lblBdate = new JLabel("생일 :");
		lblBdate.setBounds(306, 144, 57, 15);
		contentPanel.add(lblBdate);
		
		txtBdate = new JTextField();
		txtBdate.setColumns(10);
		txtBdate.setBounds(375, 141, 116, 21);
		contentPanel.add(txtBdate);
		
		JLabel lblAddress = new JLabel("주소 : ");
		lblAddress.setBounds(101, 193, 57, 15);
		contentPanel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(170, 190, 323, 21);
		contentPanel.add(txtAddress);
		
		JLabel lblSex = new JLabel("성별 : ");
		lblSex.setBounds(103, 244, 57, 15);
		contentPanel.add(lblSex);
		
		txtSex = new JTextField();
		txtSex.setColumns(10);
		txtSex.setBounds(172, 241, 116, 21);
		contentPanel.add(txtSex);
		
		JLabel lblKno = new JLabel("직급 : ");
		lblKno.setBounds(310, 244, 57, 15);
		contentPanel.add(lblKno);
		
		txtKno = new JTextField();
		txtKno.setColumns(10);
		txtKno.setBounds(379, 241, 116, 21);
		contentPanel.add(txtKno);
		
		JLabel lblSuperssn = new JLabel("매니저 : ");
		lblSuperssn.setBounds(104, 295, 57, 15);
		contentPanel.add(lblSuperssn);
		
		txtSuperssn = new JTextField();
		txtSuperssn.setColumns(10);
		txtSuperssn.setBounds(173, 292, 116, 21);
		contentPanel.add(txtSuperssn);
		
		JLabel lblDno = new JLabel("부서 :");
		lblDno.setBounds(311, 295, 57, 15);
		contentPanel.add(lblDno);
		
		txtDno = new JTextField();
		txtDno.setColumns(10);
		txtDno.setBounds(380, 292, 116, 21);
		contentPanel.add(txtDno);
		
		Employee employee = dao.searchPerson(ssn);
		txtFname.setText(employee.getFname());
		txtLname.setText(employee.getLname());
		txtSsn.setText(employee.getSsn());
		txtBdate.setText(String.valueOf(employee.getBdate()));
		txtAddress.setText(employee.getAddress());
		txtSex.setText(String.valueOf(employee.getSex()));
		txtSuperssn.setText(employee.getSuperssn());
		txtKno.setText(String.valueOf(employee.getKno()));
		txtDno.setText(String.valueOf(employee.getDno()));
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("수정");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						employee.setFname(txtFname.getText());
						employee.setLname(txtLname.getText());
						employee.setSsn(txtSsn.getText());
						employee.setBdate(Date.valueOf(txtBdate.getText()));
						employee.setAddress(txtAddress.getText());
						employee.setSex(txtSex.getText().charAt(0));
						employee.setSuperssn(txtSuperssn.getText());
						employee.setDno(Integer.parseInt(txtDno.getText()));
						employee.setKno(Integer.parseInt(txtKno.getText()));
						dao.updateEmployee(employee);
						dispose();
					}
				});
				buttonPane.add(btnUpdate);
				
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnDelete = new JButton("삭제");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dao.deleteEmployee(ssn);
						System.out.println("삭제함");
						dispose();
					}
				});
				buttonPane.add(btnDelete);
			}
			{
				JButton btnCancel = new JButton("뒤로");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				buttonPane.add(btnCancel);
			}
		}
	}
}
