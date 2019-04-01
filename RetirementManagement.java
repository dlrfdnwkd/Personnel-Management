package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.EmployeeDAO;
import model.RetirementDAO;

public class RetirementManagement extends JPanel {
	private JTextField txtRetirement;
	private JTextField txtEmployee;
	private String[][] retirements;
	private String[][] employees;
	private JTable tableRetirement;
	private JTable tableEmployee;

	/**
	 * Create the panel.
	 */
	public RetirementManagement(RetirementDAO retirementDAO,EmployeeDAO employeeDAO,int index) {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		//�������
		JPanel panelRetirement = new JPanel();
		tabbedPane.addTab("�������", null, panelRetirement, null);
		panelRetirement.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRetirementCenter = new JPanel();
		panelRetirement.add(panelRetirementCenter, BorderLayout.CENTER);
		
		String headerRetirement[] = {"������ȣ","��","�̸�","����","����","������","����"};
		panelRetirementCenter.setLayout(new BorderLayout(0, 0));
		
		retirements = retirementDAO.showRetirement();
		tableRetirement = new JTable(retirements,headerRetirement) {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
				}
		};
		tableRetirement.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}			
			@Override
			public void mousePressed(MouseEvent e) {}			
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {if(e.getClickCount() == 2) {
				Point point = e.getPoint();
				int row = tableRetirement.rowAtPoint(point);
				RetirementSearch rSearch = new RetirementSearch(retirementDAO,String.valueOf(tableRetirement.getValueAt(row, 0)));
				rSearch.setVisible(true);
			}
			}
		});
		
		JScrollPane scrollRetirement = new JScrollPane(tableRetirement);
		panelRetirementCenter.add(scrollRetirement);
		
		JPanel panelRetirementTop = new JPanel();
		FlowLayout fl_panelRetirementTop = (FlowLayout) panelRetirementTop.getLayout();
		fl_panelRetirementTop.setAlignment(FlowLayout.RIGHT);
		panelRetirement.add(panelRetirementTop, BorderLayout.NORTH);
		
		ImageIcon normalIcon = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/excel.png");
		JButton btnExcel = new JButton("��������",normalIcon);
		btnExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				retirementDAO.retirementToExcel(retirements);
				JOptionPane.showMessageDialog(null, "�������ϻ���!");
			}
		});
		panelRetirementTop.add(btnExcel);
		JComboBox comboRetirement = new JComboBox(headerRetirement);
		panelRetirementTop.add(comboRetirement);
		
		txtRetirement = new JTextField();
		panelRetirementTop.add(txtRetirement);
		txtRetirement.setColumns(10);
		
		JButton btnRetirement = new JButton("�˻�");
		panelRetirementTop.add(btnRetirement);
		btnRetirement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboRetirement.getSelectedItem().equals("������ȣ")) retirements = retirementDAO.searchRetirements("rssn", txtRetirement.getText());
				if(comboRetirement.getSelectedItem().equals("��")) retirements = retirementDAO.searchRetirements("fname", txtRetirement.getText());
				if(comboRetirement.getSelectedItem().equals("�̸�")) retirements = retirementDAO.searchRetirements("lname", txtRetirement.getText());
				if(comboRetirement.getSelectedItem().equals("����")) retirements = retirementDAO.searchRetirements("bdate", txtRetirement.getText());
				if(comboRetirement.getSelectedItem().equals("����")) retirements = retirementDAO.searchRetirements("sex", txtRetirement.getText());
				if(comboRetirement.getSelectedItem().equals("������")) retirements = retirementDAO.searchRetirements("rdate", txtRetirement.getText());
				if(comboRetirement.getSelectedItem().equals("����")) retirements = retirementDAO.searchRetirements("kno", txtRetirement.getText());
				tableRetirement = new JTable(retirements,headerRetirement) {
					public boolean isCellEditable(int rowIndex, int vColIndex) {
						return false;
						}
				};
				tableRetirement.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {}			
					@Override
					public void mousePressed(MouseEvent e) {}			
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mouseEntered(MouseEvent e) {}
					@Override
					public void mouseClicked(MouseEvent e) {if(e.getClickCount() == 2) {
						Point point = e.getPoint();
						int row = tableRetirement.rowAtPoint(point);
						RetirementSearch rSearch = new RetirementSearch(retirementDAO,String.valueOf(tableRetirement.getValueAt(row, 0)));
						rSearch.setVisible(true);
					}
					}
				});
				JScrollPane scrollpane = new JScrollPane(tableRetirement);
				panelRetirementCenter.removeAll();
				panelRetirementCenter.add(scrollpane, BorderLayout.CENTER);
			}
		});
		
		//����ó��
		JPanel panelEmployee = new JPanel();
		tabbedPane.addTab("������", null, panelEmployee, null);
		panelEmployee.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEmployeeTop = new JPanel();
		FlowLayout fl_panelEmployeeTop = (FlowLayout) panelEmployeeTop.getLayout();
		fl_panelEmployeeTop.setAlignment(FlowLayout.RIGHT);
		panelEmployee.add(panelEmployeeTop, BorderLayout.NORTH);
		
		String headerPersonnel[] = {"��","�̸�","�����ȣ","����","�ּ�","����","�Ŵ���","�μ�","����"};
		
		ImageIcon normalIcon2 = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/excel.png");
		JButton btnExcelPersonnel = new JButton("��������",normalIcon2);
		btnExcelPersonnel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				retirementDAO.retirementToExcel(retirements);
				JOptionPane.showMessageDialog(null, "�������ϻ���!");
			}
		});
		panelEmployeeTop.add(btnExcelPersonnel);
		JComboBox comboEmployee = new JComboBox(headerPersonnel);
		panelEmployeeTop.add(comboEmployee);
		
		txtEmployee = new JTextField();
		txtEmployee.setColumns(10);
		panelEmployeeTop.add(txtEmployee);
		
		JButton btnEmployee = new JButton("�˻�");
		panelEmployeeTop.add(btnEmployee);
		
		JPanel panelEmployeeCenter = new JPanel();
		panelEmployee.add(panelEmployeeCenter, BorderLayout.CENTER);
		panelEmployeeCenter.setLayout(new BorderLayout(0, 0));

		btnEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboEmployee.getSelectedItem().equals("��")) employees = employeeDAO.searchEmployee("fname", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("�̸�")) employees = employeeDAO.searchEmployee("lname", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("�����ȣ")) employees = employeeDAO.searchEmployee("ssn", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("����")) employees = employeeDAO.searchEmployee("bdate", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("�ּ�")) employees = employeeDAO.searchEmployee("address", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("����")) employees = employeeDAO.searchEmployee("sex", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("�Ŵ���")) employees = employeeDAO.searchEmployee("superssn", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("�μ�")) employees = employeeDAO.searchEmployee("dno", txtEmployee.getText());
				if(comboEmployee.getSelectedItem().equals("����")) employees = employeeDAO.searchEmployee("kno", txtEmployee.getText());
				tableEmployee = new JTable(employees,headerRetirement){
					public boolean isCellEditable(int rowIndex, int vColIndex) {
						return false;
						}
					};
				tableEmployee.addMouseListener(new MouseListener() {		
					@Override
					public void mouseReleased(MouseEvent e) {}
					@Override
					public void mousePressed(MouseEvent e) {}	
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mouseEntered(MouseEvent e) {}
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 2) {
							Point point = e.getPoint();
							int row = tableEmployee.rowAtPoint(point);
							EmployeeToRetirement etor = new EmployeeToRetirement(employeeDAO,retirementDAO,String.valueOf(tableEmployee.getValueAt(row, 2)));
							etor.setVisible(true);
						}
					}
				});	
				JScrollPane scrollpane = new JScrollPane(tableEmployee);
				panelEmployeeCenter.removeAll();
				panelEmployeeCenter.add(scrollpane, BorderLayout.CENTER);
			}
		});
		
		employees = employeeDAO.showEmployee();
		tableEmployee = new JTable(employees,headerPersonnel){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
			return false;
			}
		};
		tableEmployee.addMouseListener(new MouseListener() {		
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}	
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Point point = e.getPoint();
					int row = tableEmployee.rowAtPoint(point);
					EmployeeToRetirement etor = new EmployeeToRetirement(employeeDAO,retirementDAO,String.valueOf(tableEmployee.getValueAt(row, 2)));
					etor.setVisible(true);
				}
			}
		});
		
		JScrollPane scrollEmployee = new JScrollPane(tableEmployee);
		panelEmployeeCenter.add(scrollEmployee,BorderLayout.CENTER);
		
		//ȭ�� ����
		tabbedPane.setSelectedIndex(index);
	}

}
