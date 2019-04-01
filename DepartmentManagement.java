package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Department;
import model.DepartmentDAO;
import model.Project;
import model.ProjectDAO;
import java.awt.Font;

public class DepartmentManagement extends JPanel {
	private JTextField txtDepartment;
	private String[][] departments;
	private String[][] projects;
	private JTable tableDepartment;
	private JTable tableProject;
	private JTextField txtDname;
	private JTextField txtDnumber;
	private JTextField txtMgrssn;
	private JTextField txtMgrstartdate;
	private JTextField txtProject;
	private JTextField txtPname;
	private JTextField txtPnumber;
	private JTextField txtPlocation;
	private JTextField txtDnum;

	/**
	 * Create the panel.
	 */
	public DepartmentManagement(DepartmentDAO departmentDAO,ProjectDAO projectDAO,int index) {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		//부서목록
		JPanel panelDepartment = new JPanel();
		tabbedPane.addTab("부서목록", null, panelDepartment, null);
		panelDepartment.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDepartmentTop = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDepartmentTop.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelDepartment.add(panelDepartmentTop, BorderLayout.NORTH);
		
		String headerDepartment[] = {"부서이름","부서번호","부장","시작일"};
		
		ImageIcon normalIcon = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/excel.png");
		JButton btnExcel= new JButton("내보내기",normalIcon);
		btnExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				departmentDAO.departmentToExcel(departments);
				JOptionPane.showMessageDialog(null, "엑셀파일생성!");
			}
		});
		panelDepartmentTop.add(btnExcel);
		
		JComboBox comboDepartment = new JComboBox(headerDepartment);
		panelDepartmentTop.add(comboDepartment);
		
		txtDepartment = new JTextField();
		panelDepartmentTop.add(txtDepartment);
		txtDepartment.setColumns(10);
		
		JPanel panelDepartmentCenter = new JPanel();
		panelDepartment.add(panelDepartmentCenter, BorderLayout.CENTER);
		panelDepartmentCenter.setLayout(new BorderLayout(0, 0));
		
		JButton btnDepartment = new JButton("검색");
		btnDepartment.addMouseListener(new MouseListener() {
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
				if(comboDepartment.getSelectedItem().equals("부서이름")) departments = departmentDAO.searchDepartment("dname", txtDepartment.getText());
				if(comboDepartment.getSelectedItem().equals("부서번호")) departments = departmentDAO.searchDepartment("dnumber", txtDepartment.getText());
				if(comboDepartment.getSelectedItem().equals("부장")) departments = departmentDAO.searchDepartment("lname", txtDepartment.getText());
				if(comboDepartment.getSelectedItem().equals("시작일")) departments = departmentDAO.searchDepartment("mgrstartdate", txtDepartment.getText());
				tableDepartment = new JTable(departments,headerDepartment){
					public boolean isCellEditable(int rowIndex, int vColIndex) {
					return false;
					}
				};
				tableDepartment.addMouseListener(new MouseListener() {		
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
							int row = tableDepartment.rowAtPoint(point);
							//PersonnelSearch search = new PersonnelSearch(dao,String.valueOf(tableDepartment.getValueAt(row, 2)));
							//search.setVisible(true);
							DepartmentSearch search = new DepartmentSearch(departmentDAO, Integer.parseInt(String.valueOf(tableDepartment.getValueAt(row, 1))));
							search.setVisible(true);
						}
					}
				});
				JScrollPane scrollpane = new JScrollPane(tableDepartment);
				panelDepartmentCenter.removeAll();
				panelDepartmentCenter.add(scrollpane, BorderLayout.CENTER);
			}
		});
		panelDepartmentTop.add(btnDepartment);
		
		departments = departmentDAO.showDepartment();
		tableDepartment = new JTable(departments,headerDepartment){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
			return false;
			}
		};
		tableDepartment.addMouseListener(new MouseListener() {		
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
					int row = tableDepartment.rowAtPoint(point);
					//PersonnelSearch search = new PersonnelSearch(dao,String.valueOf(tableDepartment.getValueAt(row, 2)));
					//search.setVisible(true);
					DepartmentSearch search = new DepartmentSearch(departmentDAO, Integer.parseInt(String.valueOf(tableDepartment.getValueAt(row, 1))));
					search.setVisible(true);
				}
			}
		});
		
		JScrollPane scrollpane = new JScrollPane(tableDepartment);
		panelDepartmentCenter.add(scrollpane, BorderLayout.CENTER);
		
		//부서추가
		JPanel panelDepartmentInsert = new JPanel();
		tabbedPane.addTab("부서추가", null, panelDepartmentInsert, null);
		panelDepartmentInsert.setLayout(null);
		
		JLabel lblDname = new JLabel("부서이름 :");
		lblDname.setFont(new Font("굴림", Font.BOLD, 20));
		lblDname.setBounds(152, 109, 107, 28);
		panelDepartmentInsert.add(lblDname);
		
		txtDname = new JTextField();
		txtDname.setBounds(314, 103, 168, 39);
		panelDepartmentInsert.add(txtDname);
		txtDname.setColumns(10);
		
		JLabel lblDnumber = new JLabel("부서번호 :");
		lblDnumber.setFont(new Font("굴림", Font.BOLD, 20));
		lblDnumber.setBounds(152, 169, 107, 28);
		panelDepartmentInsert.add(lblDnumber);
		
		txtDnumber = new JTextField();
		txtDnumber.setBounds(314, 164, 168, 39);
		panelDepartmentInsert.add(txtDnumber);
		txtDnumber.setColumns(10);
		
		JLabel lblMgrssn = new JLabel("부장 :");
		lblMgrssn.setFont(new Font("굴림", Font.BOLD, 20));
		lblMgrssn.setBounds(152, 230, 107, 28);
		panelDepartmentInsert.add(lblMgrssn);
		
		txtMgrssn = new JTextField();
		txtMgrssn.setBounds(314, 227, 168, 39);
		panelDepartmentInsert.add(txtMgrssn);
		txtMgrssn.setColumns(10);
		
		JLabel lblMgrstartdate = new JLabel("시작날짜 :");
		lblMgrstartdate.setFont(new Font("굴림", Font.BOLD, 20));
		lblMgrstartdate.setBounds(152, 294, 107, 28);
		panelDepartmentInsert.add(lblMgrstartdate);
		
		txtMgrstartdate = new JTextField();
		txtMgrstartdate.setBounds(314, 291, 168, 39);
		panelDepartmentInsert.add(txtMgrstartdate);
		txtMgrstartdate.setColumns(10);
		
		JButton btnDepartmentInsert = new JButton("추가");
		btnDepartmentInsert.setFont(new Font("굴림", Font.BOLD, 30));
		btnDepartmentInsert.setBounds(169, 407, 300, 50);
		btnDepartmentInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Department department = new Department(txtDname.getText(),Integer.parseInt(txtDnumber.getText()),txtMgrssn.getText(),Date.valueOf(txtMgrstartdate.getText()));
				departmentDAO.insertDepartment(department);
				JOptionPane.showMessageDialog(null, "부서가 추가되었습니다.");
				txtDname.setText(null);
				txtDnumber.setText(null);
				txtMgrssn.setText(null);
				txtMgrstartdate.setText(null);
			}
		});
		panelDepartmentInsert.add(btnDepartmentInsert);
		
		//프로젝트 목록
		JPanel panelProject = new JPanel();
		tabbedPane.addTab("프로젝트 목록", null, panelProject, null);
		panelProject.setLayout(new BorderLayout(0, 0));
		
		JPanel panelProjectTop = new JPanel();
		FlowLayout fl_panelProjectTop = (FlowLayout) panelProjectTop.getLayout();
		fl_panelProjectTop.setAlignment(FlowLayout.RIGHT);
		panelProject.add(panelProjectTop, BorderLayout.NORTH);
		
		String headerProject[] = {"프로젝트 이름","프로젝트 번호","지역","부서이름"};
		
		ImageIcon normalIcon2 = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/excel.png");
		JButton btnExcelProject= new JButton("내보내기",normalIcon2);
		btnExcelProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				projectDAO.projectToExcel(projects);
				JOptionPane.showMessageDialog(null, "엑셀파일생성!");
			}
		});
		panelDepartmentTop.add(btnExcel);
		panelProjectTop.add(btnExcelProject);
		
		JComboBox comboProject = new JComboBox(headerProject);
		panelProjectTop.add(comboProject);
		
		txtProject = new JTextField();
		panelProjectTop.add(txtProject);
		txtProject.setColumns(10);
		
		JButton btnProject = new JButton("검색");
		panelProjectTop.add(btnProject);
		
		JPanel panelProjectCenter = new JPanel();
		panelProject.add(panelProjectCenter, BorderLayout.CENTER);
		panelProjectCenter.setLayout(new BorderLayout(0, 0));
		btnProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboProject.getSelectedItem().equals("프로젝트 이름")) projects = projectDAO.searchProject("pname", txtProject.getText());
				if(comboProject.getSelectedItem().equals("프로젝트 번호")) projects = projectDAO.searchProject("pnumber", txtProject.getText());
				if(comboProject.getSelectedItem().equals("지역")) projects = projectDAO.searchProject("plocation", txtProject.getText());
				if(comboProject.getSelectedItem().equals("부서이름")) projects = projectDAO.searchProject("dname", txtProject.getText());
				tableProject = new JTable(projects,headerProject){
					public boolean isCellEditable(int rowIndex, int vColIndex) {
						return false;
						}
					};
				tableProject.addMouseListener(new MouseListener() {		
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
							int row = tableProject.rowAtPoint(point);
							ProjectSearch search = new ProjectSearch(projectDAO,Integer.parseInt(String.valueOf(tableProject.getValueAt(row, 1))));
							search.setVisible(true);
						}
					}
				});
					
				JScrollPane scrollProject = new JScrollPane(tableProject);
				panelProjectCenter.removeAll();
				panelProjectCenter.add(scrollProject, BorderLayout.CENTER);
			}
		});
		
		projects = projectDAO.showProject();
		tableProject = new JTable(projects,headerProject){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
			return false;
			}
		};
		tableProject.addMouseListener(new MouseListener() {		
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
					int row = tableProject.rowAtPoint(point);
					ProjectSearch search = new ProjectSearch(projectDAO,Integer.parseInt(String.valueOf(tableProject.getValueAt(row, 1))));
					search.setVisible(true);
				}
			}
		});
		
		JScrollPane scrollProject = new JScrollPane(tableProject);
		panelProjectCenter.add(scrollProject, BorderLayout.CENTER);

		
		//프로젝트 추가
		JPanel panelProjectInesrt = new JPanel();
		tabbedPane.addTab("프로젝트 추가", null, panelProjectInesrt, null);
		panelProjectInesrt.setLayout(null);
		
		JLabel lblPname = new JLabel("프로젝트 이름 :");
		lblPname.setFont(new Font("굴림", Font.BOLD, 20));
		lblPname.setBounds(161, 113, 151, 47);
		panelProjectInesrt.add(lblPname);
		
		txtPname = new JTextField();
		txtPname.setBounds(347, 122, 151, 34);
		panelProjectInesrt.add(txtPname);
		txtPname.setColumns(10);
		
		JLabel lblPnumber = new JLabel("프로젝트 번호 :");
		lblPnumber.setFont(new Font("굴림", Font.BOLD, 20));
		lblPnumber.setBounds(161, 180, 151, 47);
		panelProjectInesrt.add(lblPnumber);
		
		txtPnumber = new JTextField();
		txtPnumber.setBounds(347, 189, 151, 34);
		panelProjectInesrt.add(txtPnumber);
		txtPnumber.setColumns(10);
		
		JLabel lblPlocation = new JLabel("프로젝트 지역 :");
		lblPlocation.setFont(new Font("굴림", Font.BOLD, 20));
		lblPlocation.setBounds(161, 237, 151, 47);
		panelProjectInesrt.add(lblPlocation);
		
		txtPlocation = new JTextField();
		txtPlocation.setBounds(347, 246, 151, 34);
		panelProjectInesrt.add(txtPlocation);
		txtPlocation.setColumns(10);
		
		JLabel lblDnum = new JLabel("부서번호 :");
		lblDnum.setFont(new Font("굴림", Font.BOLD, 20));
		lblDnum.setBounds(161, 294, 151, 47);
		panelProjectInesrt.add(lblDnum);
		
		txtDnum = new JTextField();
		txtDnum.setBounds(347, 296, 151, 34);
		panelProjectInesrt.add(txtDnum);
		txtDnum.setColumns(10);
		
		JButton btnInsert = new JButton("추가");
		btnInsert.setBounds(179, 378, 301, 54);
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Project project = new Project(txtPname.getText(),Integer.parseInt(txtPnumber.getText()),txtPlocation.getText(),Integer.parseInt(txtDnum.getText()));
				projectDAO.insertProject(project);
				JOptionPane.showMessageDialog(null, "프로젝트가 추가되었습니다.");
				txtPname.setText(null);
				txtPnumber.setText(null);
				txtPlocation.setText(null);
				txtDnum.setText(null);
			}
		});
		panelProjectInesrt.add(btnInsert);
		
		
		//화면 선택
		tabbedPane.setSelectedIndex(index);
	}

}
