package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
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
import javax.swing.SwingConstants;

import model.Employee;
import model.EmployeeDAO;
import java.awt.Color;
import java.awt.Font;

public class Personnel extends JPanel {
	private JTable tableList;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtSsn;
	private JTextField txtBdate;
	private JTextField txtAddress;
	private JTextField txtSex;
	private JTextField txtKind;
	private JTextField txtSuperssn;
	private JTextField txtDno;
	private JTextField txtSearch;
	private EmployeeDAO dao;
	private String[][] employees;

	/**
	 * Create the panel.
	 */
	public Personnel(int index,EmployeeDAO employeeDAO) {
		setBackground(Color.WHITE);
		dao = employeeDAO;
		setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		add(tabbedPane, BorderLayout.CENTER);
		
		//인사관리 panel
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(51, 204, 255));
		tabbedPane.addTab("인사 관리", null, panelMain, null);
		panelMain.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 10, 303, 430);
		panelMain.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAllPerson = new JLabel("전체 사원 수 :");
		lblAllPerson.setFont(new Font("양재소슬체S", Font.BOLD, 25));
		lblAllPerson.setBounds(10, 20, 190, 45);
		panel_1.add(lblAllPerson);
		
		JLabel lblAllPerson1 = new JLabel(dao.showAllNumber()+"명");
		lblAllPerson1.setFont(new Font("양재소슬체S", Font.BOLD, 25));
		lblAllPerson1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAllPerson1.setBounds(200, 20, 90, 45);
		panel_1.add(lblAllPerson1);
		
		JLabel lblIntern = new JLabel("인턴 :");
		lblIntern.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblIntern.setBounds(10, 75, 80, 40);
		panel_1.add(lblIntern);
		
		JLabel lblintern1 = new JLabel(dao.showIntern()+" 명");
		lblintern1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblintern1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblintern1.setBounds(190, 75, 100, 40);
		panel_1.add(lblintern1);
		
		JLabel lblNormal = new JLabel("사원 :");
		lblNormal.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblNormal.setBounds(10, 125, 80, 40);
		panel_1.add(lblNormal);
		
		JLabel lblNormal1 = new JLabel(dao.showNormal()+" 명");
		lblNormal1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblNormal1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNormal1.setBounds(210, 125, 80, 40);
		panel_1.add(lblNormal1);
		
		JLabel lblDeputy = new JLabel("대리 :");
		lblDeputy.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblDeputy.setBounds(10, 175, 80, 40);
		panel_1.add(lblDeputy);
		
		JLabel lblDeputy1 = new JLabel(dao.showDeputy()+" 명");
		lblDeputy1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblDeputy1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeputy1.setBounds(210, 175, 80, 40);
		panel_1.add(lblDeputy1);
		
		JLabel lblSection = new JLabel("과장 :");
		lblSection.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSection.setBounds(10, 225, 80, 40);
		panel_1.add(lblSection);
		
		JLabel lblSection1 = new JLabel(dao.showSection()+" 명");
		lblSection1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSection1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSection1.setBounds(210, 225, 80, 40);
		panel_1.add(lblSection1);
		
		JLabel lblSenior = new JLabel("차장 :");
		lblSenior.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSenior.setBounds(10, 275, 80, 40);
		panel_1.add(lblSenior);
		
		JLabel lblSenior1 = new JLabel(dao.showSenior()+" 명");
		lblSenior1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSenior1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenior1.setBounds(210, 275, 80, 40);
		panel_1.add(lblSenior1);
		
		JLabel lblHD = new JLabel("부장 :");
		lblHD.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblHD.setBounds(10, 325, 80, 40);
		panel_1.add(lblHD);
		
		JLabel lblHD1 = new JLabel(dao.showHD()+" 명");
		lblHD1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblHD1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHD1.setBounds(210, 325, 80, 40);
		panel_1.add(lblHD1);
		
		JLabel lblExecutive = new JLabel("임원 :");
		lblExecutive.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblExecutive.setBounds(10, 375, 80, 40);
		panel_1.add(lblExecutive);
		
		JLabel lblExecutive1 = new JLabel(dao.showExecutive()+" 명");
		lblExecutive1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblExecutive1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExecutive1.setBounds(210, 375, 80, 40);
		panel_1.add(lblExecutive1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(341, 10, 303, 430);
		panelMain.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHead = new JLabel("본사 :");
		lblHead.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblHead.setBounds(12, 70, 80, 40);
		panel_2.add(lblHead);
		
		JLabel lblHead1 = new JLabel(dao.showHead()+" 명");
		lblHead1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblHead1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHead1.setBounds(211, 70, 80, 40);
		panel_2.add(lblHead1);
		
		JLabel lblAdmin = new JLabel("관리 :");
		lblAdmin.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblAdmin.setBounds(12, 120, 80, 40);
		panel_2.add(lblAdmin);
		
		JLabel lblAdmin1 = new JLabel (dao.showAdmin()+" 명");
		lblAdmin1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblAdmin1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdmin1.setBounds(211, 120, 80, 40);
		panel_2.add(lblAdmin1);
		
		JLabel lblResearch = new JLabel("연구 :");
		lblResearch.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblResearch.setBounds(12, 170, 80, 40);
		panel_2.add(lblResearch);
		
		JLabel lblResearch1 = new JLabel(dao.showResearch()+" 명");
		lblResearch1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblResearch1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResearch1.setBounds(211, 170, 80, 40);
		panel_2.add(lblResearch1);
		
		JLabel lblSoft = new JLabel("소프트웨어 :");
		lblSoft.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSoft.setBounds(12, 220, 130, 40);
		panel_2.add(lblSoft);
		
		JLabel lblSoft1 = new JLabel(dao.showSoft()+" 명");
		lblSoft1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSoft1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoft1.setBounds(211, 220, 80, 40);
		panel_2.add(lblSoft1);
		
		JLabel lblHard = new JLabel("하드웨어 :");
		lblHard.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblHard.setBounds(12, 270, 130, 40);
		panel_2.add(lblHard);
		
		JLabel lblHard1 = new JLabel(dao.showHard()+" 명");
		lblHard1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblHard1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHard1.setBounds(211, 270, 80, 40);
		panel_2.add(lblHard1);
		
		JLabel lblSales = new JLabel("판매 :");
		lblSales.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSales.setBounds(12, 320, 80, 40);
		panel_2.add(lblSales);
		
		JLabel lblSales1 = new JLabel(dao.showSales()+" 명");
		lblSales1.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSales1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSales1.setBounds(211, 320, 80, 40);
		panel_2.add(lblSales1);
		
		JLabel lblDepartment = new JLabel("부서별 인원현황");
		lblDepartment.setFont(new Font("양재소슬체S", Font.BOLD, 30));
		lblDepartment.setBounds(34, 20, 257, 40);
		panel_2.add(lblDepartment);
		
		//사원목록 panel
		JPanel panelList = new JPanel();
		panelList.setBackground(new Color(51, 204, 255));
		tabbedPane.addTab("사원 목록", null, panelList, null);
		panelList.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelList.add(panel, BorderLayout.NORTH);
		
		String search[] = {"성","이름","사원번호","생일","주소","성별","매니저","부서","직급"};
		
		ImageIcon normalIcon = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/excel.png");
		JButton btnExcel = new JButton("내보내기",normalIcon);
		btnExcel.setFont(new Font("양재소슬체S", Font.BOLD, 12));
		btnExcel.setForeground(new Color(51, 51, 255));
		btnExcel.setBackground(Color.WHITE);
		btnExcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao.personnelToExcel(employees);
				JOptionPane.showMessageDialog(null, "엑셀파일생성!");
			}
		});
		panel.add(btnExcel);
		JComboBox comboBox = new JComboBox(search);
		comboBox.setFont(new Font("양재소슬체S", Font.BOLD, 12));
		comboBox.setForeground(new Color(51, 51, 255));
		comboBox.setBackground(Color.WHITE);
		panel.add(comboBox);
		
		txtSearch = new JTextField();
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		String[] header = {"성","이름","사원번호","생일","주소","성별","매니저","부서","직급"};
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("양재소슬체S", Font.BOLD, 12));
		btnSearch.setForeground(new Color(51, 51, 255));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("성")) employees = dao.searchEmployee("fname", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("이름")) employees = dao.searchEmployee("lname", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("사원번호")) employees = dao.searchEmployee("ssn", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("생일")) employees = dao.searchEmployee("bdate", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("주소")) employees = dao.searchEmployee("address", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("성별")) employees = dao.searchEmployee("sex", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("매니저")) employees = dao.searchEmployee("superssn", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("부서")) employees = dao.searchEmployee("dno", txtSearch.getText());
				if(comboBox.getSelectedItem().equals("직급")) employees = dao.searchEmployee("kno", txtSearch.getText());
				tableList = new JTable(employees,header){
					public boolean isCellEditable(int rowIndex, int vColIndex) {
						return false;
						}
					};
				tableList.addMouseListener(new MouseListener() {		
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
							int row = tableList.rowAtPoint(point);
							PersonnelSearch search = new PersonnelSearch(dao,String.valueOf(tableList.getValueAt(row, 2)));
							search.setVisible(true);
						}
					}
				});
					
				JScrollPane scrollpane = new JScrollPane(tableList);
				panelList.removeAll();
				panelList.add(panel, BorderLayout.NORTH);
				panelList.add(scrollpane, BorderLayout.CENTER);
			}
		});
		panel.add(btnSearch);
		
		employees = dao.showEmployee();
		tableList = new JTable(employees,header){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
			return false;
			}
		};
		tableList.addMouseListener(new MouseListener() {		
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
					int row = tableList.rowAtPoint(point);
					PersonnelSearch search = new PersonnelSearch(dao,String.valueOf(tableList.getValueAt(row, 2)));
					search.setVisible(true);
				}
			}
		});
		
		JScrollPane scrollpane = new JScrollPane(tableList);
		panelList.add(scrollpane, BorderLayout.CENTER);

		//사원 등록 panel
		JPanel panelInsert = new JPanel();
		panelInsert.setBackground(new Color(51, 204, 255));
		tabbedPane.addTab("사원등록", null, panelInsert, null);
		panelInsert.setLayout(null);
		
		JLabel lblFname = new JLabel("성 :");
		lblFname.setForeground(Color.WHITE);
		lblFname.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblFname.setBounds(40, 81, 80, 40);
		panelInsert.add(lblFname);
		
		txtFname = new JTextField();
		txtFname.setBounds(171, 79, 159, 40);
		panelInsert.add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblLname = new JLabel("이름 :");
		lblLname.setForeground(Color.WHITE);
		lblLname.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblLname.setBounds(347, 79, 80, 40);
		panelInsert.add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setBounds(441, 79, 163, 40);
		panelInsert.add(txtLname);
		txtLname.setColumns(10);
		
		JLabel lblSsn = new JLabel("사원 번호 :");
		lblSsn.setForeground(Color.WHITE);
		lblSsn.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSsn.setBounds(45, 139, 120, 40);
		panelInsert.add(lblSsn);
		
		txtSsn = new JTextField();
		txtSsn.setBounds(171, 141, 164, 40);
		panelInsert.add(txtSsn);
		txtSsn.setColumns(10);
		
		JLabel lblBdate = new JLabel("생일 :");
		lblBdate.setForeground(Color.WHITE);
		lblBdate.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblBdate.setBounds(349, 140, 89, 31);
		panelInsert.add(lblBdate);
		
		txtBdate = new JTextField();
		txtBdate.setBounds(443, 134, 161, 40);
		panelInsert.add(txtBdate);
		txtBdate.setColumns(10);
		
		JLabel lblAddress = new JLabel("주소 : ");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblAddress.setBounds(40, 198, 89, 37);
		panelInsert.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(172, 199, 428, 40);
		panelInsert.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblSex = new JLabel("성별 : ");
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSex.setBounds(41, 246, 96, 39);
		panelInsert.add(lblSex);
		
		txtSex = new JTextField();
		txtSex.setBounds(175, 244, 163, 40);
		panelInsert.add(txtSex);
		txtSex.setColumns(10);
		
		JLabel lblKind = new JLabel("직급 : ");
		lblKind.setForeground(Color.WHITE);
		lblKind.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblKind.setBounds(354, 243, 88, 40);
		panelInsert.add(lblKind);
		
		txtKind = new JTextField();
		txtKind.setBounds(447, 244, 158, 40);
		panelInsert.add(txtKind);
		txtKind.setColumns(10);
		
		JLabel lblSuperssn = new JLabel("매니저 : ");
		lblSuperssn.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblSuperssn.setForeground(Color.WHITE);
		lblSuperssn.setBounds(37, 302, 92, 37);
		panelInsert.add(lblSuperssn);
		
		txtSuperssn = new JTextField();
		txtSuperssn.setBounds(171, 297, 169, 40);
		panelInsert.add(txtSuperssn);
		txtSuperssn.setColumns(10);
		
		JLabel lblDno = new JLabel("부서 :");
		lblDno.setForeground(Color.WHITE);
		lblDno.setFont(new Font("양재소슬체S", Font.BOLD, 20));
		lblDno.setBounds(353, 297, 80, 41);
		panelInsert.add(lblDno);
		
		txtDno = new JTextField();
		txtDno.setBounds(448, 296, 155, 40);
		panelInsert.add(txtDno);
		txtDno.setColumns(10);
		
		JButton btnOk = new JButton("추가");
		btnOk.setBackground(Color.WHITE);
		btnOk.setForeground(new Color(51, 204, 255));
		btnOk.setFont(new Font("양재소슬체S", Font.BOLD, 25));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtSsn.getText() == null || txtSsn.getText().equals("")) {
					System.out.println("fuck");
					return;
				}
				Employee employee = new Employee(txtFname.getText(),txtLname.getText(),txtSsn.getText(),Date.valueOf(txtBdate.getText()),
				txtAddress.getText(),txtSex.getText().charAt(0),Integer.parseInt(txtKind.getText()),txtSuperssn.getText(),Integer.parseInt(txtDno.getText()));
				dao.insertEmployee(employee);
				JOptionPane.showMessageDialog(null, "사원가 추가되었습니다.");
				txtFname.setText(null);
				txtLname.setText(null);
				txtSsn.setText(null);
				txtBdate.setText(null);
				txtAddress.setText(null);
				txtSex.setText(null);
				txtKind.setText(null);
				txtSuperssn.setText(null);
				txtDno.setText(null);
			}
		});
		btnOk.setBounds(180, 406, 299, 60);
		panelInsert.add(btnOk);

		//화면 선택
		tabbedPane.setSelectedIndex(index);
	}
}
