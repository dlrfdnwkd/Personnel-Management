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
import model.UserDAO;

public class UserSystem extends JPanel {
	private JTextField txtSearch;
	private JTable table;
	private String[][] users;
	private String[][] employees;
	private JTextField txtEmployee;
	private JTable tableEmployee;

	/**
	 * Create the panel.
	 */
	public UserSystem(UserDAO userDAO,EmployeeDAO employeeDAO,int index) {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		//유저목록
		JPanel panelUserSystem = new JPanel();
		tabbedPane.addTab("유저목록", null, panelUserSystem, null);
		panelUserSystem.setLayout(new BorderLayout(0, 0));
		
		JPanel panelUserTop = new JPanel();
		panelUserSystem.add(panelUserTop, BorderLayout.NORTH);
		FlowLayout flowLayout = (FlowLayout) panelUserTop.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		String header[] = {"성","이름","사원번호","아이디","비밀번호","권한"};
		
		
		ImageIcon normalIcon = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/excel.png");
		JButton btnExcel = new JButton("내보내기",normalIcon);
		btnExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userDAO.userToExcel(users);
				JOptionPane.showMessageDialog(null, "엑셀파일생성!");
			}
		});
		panelUserTop.add(btnExcel);
		
		JComboBox comboBox = new JComboBox(header);
		panelUserTop.add(comboBox);
		
		JPanel panelUserCenter = new JPanel();
		panelUserSystem.add(panelUserCenter);
		panelUserCenter.setLayout(new BorderLayout(0, 0));
		
		txtSearch = new JTextField();
		panelUserTop.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("성")) users = userDAO.searchUser("fname", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("이름")) users = userDAO.searchUser("lname", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("사원번호")) users = userDAO.searchUser("ssn", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("아이디")) users = userDAO.searchUser("id", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("비밀번호")) users = userDAO.searchUser("pw", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("권한")) users = userDAO.searchUser("power", txtSearch.getText());
				table = new JTable(users,header){
					public boolean isCellEditable(int rowIndex, int vColIndex) {
					return false;
					}
				};
				table.addMouseListener(new MouseListener() {		
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
							int row = table.rowAtPoint(point);
							UserSearch userSearch = new UserSearch(userDAO,String.valueOf(table.getValueAt(row, 2)));
							userSearch.setVisible(true);
						}
					}
				});
				JScrollPane scroll = new JScrollPane(table);
				panelUserCenter.removeAll();
				panelUserCenter.add(scroll, BorderLayout.CENTER);
			}
		});
		panelUserTop.add(btnSearch);
		users = userDAO.showUser();
		table = new JTable(users,header){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
			return false;
			}
		};
		table.addMouseListener(new MouseListener() {		
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
					int row = table.rowAtPoint(point);
					UserSearch userSearch = new UserSearch(userDAO,String.valueOf(table.getValueAt(row, 2)));
					userSearch.setVisible(true);
				}
			}
		});
		
		JScrollPane scroll = new JScrollPane(table);
		panelUserCenter.add(scroll,BorderLayout.CENTER);
		
		//유저추가
		JPanel panelUserInsert = new JPanel();
		tabbedPane.addTab("유저추가", null, panelUserInsert, null);
		panelUserInsert.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInsertTop = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelInsertTop.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelUserInsert.add(panelInsertTop, BorderLayout.NORTH);
		
		String headerPersonnel[] = {"성","이름","사원번호","생일","주소","성별","매니저","부서","직급"};
		
		JComboBox comboBoxinsert = new JComboBox(headerPersonnel);
		panelInsertTop.add(comboBoxinsert);
		
		txtEmployee = new JTextField();
		panelInsertTop.add(txtEmployee);
		txtEmployee.setColumns(10);
		
		JPanel panelInsertCenter = new JPanel();
		panelUserInsert.add(panelInsertCenter, BorderLayout.CENTER);
		
		JButton btnEmployee = new JButton("검색");
		btnEmployee.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxinsert.getSelectedItem().equals("성")) employees = employeeDAO.searchEmployee("fname", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("이름")) employees = employeeDAO.searchEmployee("lname", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("사원번호")) employees = employeeDAO.searchEmployee("ssn", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("생일")) employees = employeeDAO.searchEmployee("bdate", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("주소")) employees = employeeDAO.searchEmployee("address", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("성별")) employees = employeeDAO.searchEmployee("sex", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("매니저")) employees = employeeDAO.searchEmployee("superssn", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("부서")) employees = employeeDAO.searchEmployee("dno", txtEmployee.getText());
				if(comboBoxinsert.getSelectedItem().equals("직급")) employees = employeeDAO.searchEmployee("kno", txtEmployee.getText());
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
							//EmployeeToRetirement etor = new EmployeeToRetirement(employeeDAO,retirementDAO,String.valueOf(tableEmployee.getValueAt(row, 2)));
							//etor.setVisible(true);
							UserCreate userCreate = new UserCreate(userDAO,String.valueOf(tableEmployee.getValueAt(row, 2)));
							userCreate.setVisible(true);
						}
					}
				});	
				JScrollPane scrollpane = new JScrollPane(tableEmployee);
				panelInsertCenter.removeAll();
				panelInsertCenter.add(scrollpane, BorderLayout.CENTER);
			}
			});
		panelInsertTop.add(btnEmployee);
		
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
					//EmployeeToRetirement etor = new EmployeeToRetirement(employeeDAO,retirementDAO,String.valueOf(tableEmployee.getValueAt(row, 2)));
					//etor.setVisible(true);
					UserCreate userCreate = new UserCreate(userDAO,String.valueOf(tableEmployee.getValueAt(row, 2)));
					userCreate.setVisible(true);
				}
			}
		});
		panelInsertCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollEmployee = new JScrollPane(tableEmployee);
		panelInsertCenter.add(scrollEmployee);
		
		//화면 선택
		tabbedPane.setSelectedIndex(index);
	}

}
