package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DepartmentDAO;
import model.EmployeeDAO;
import model.ProjectDAO;
import model.RetirementDAO;
import model.UserDAO;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		RetirementDAO retirementDAO = new RetirementDAO();
		UserDAO userDAO = new UserDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		ProjectDAO projectDAO = new ProjectDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 20, 840, 680);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		ImageIcon image = new ImageIcon("C:\\Users\\cps\\eclipse-workspace\\PersonnelManagement\\image/Home.png");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		menuBar.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		menuBar.add(panel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setForeground(Color.WHITE);
		menuBar.add(panel_5);
		JLabel lblHome = new JLabel(image);
		menuBar.add(lblHome);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		menuBar.add(panel_3);
		
		ImageIcon normalIcon = new ImageIcon("C://Users/cps/eclipse-workspace/PersonnelManagement/image/Out.png");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		menuBar.add(panel_4);
		JLabel lblOut = new JLabel(normalIcon);
		lblOut.addMouseListener(new MouseListener() {		
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
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		menuBar.add(lblOut);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPersonnelMain = new JButton("인원 현황");
		btnPersonnelMain.setForeground(Color.WHITE);
		btnPersonnelMain.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnPersonnelMain.setBackground(new Color(51, 204, 255));
		btnPersonnelMain.setBounds(160, 10, 115, 30);
		contentPane.add(btnPersonnelMain);
		
		JButton btnPersonnelList = new JButton("사원 목록");
		btnPersonnelList.setForeground(Color.WHITE);
		btnPersonnelList.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnPersonnelList.setBackground(new Color(51, 153, 255));
		btnPersonnelList.setBounds(160, 40, 115, 30);
		contentPane.add(btnPersonnelList);
		
		JButton btnPersonnelInset = new JButton("사원 등록");
		btnPersonnelInset.setForeground(Color.WHITE);
		btnPersonnelInset.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnPersonnelInset.setBackground(new Color(51, 102, 255));
		btnPersonnelInset.setBounds(160, 70, 115, 30);
		contentPane.add(btnPersonnelInset);
		
		JButton btnDepartmentList = new JButton("부서목록");
		btnDepartmentList.setForeground(Color.WHITE);
		btnDepartmentList.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnDepartmentList.setBackground(new Color(51, 204, 255));
		
		btnDepartmentList.setBounds(160, 110, 115, 30);
		contentPane.add(btnDepartmentList);
		btnDepartmentList.setVisible(false);
		
		JButton btnDepartmentInsert = new JButton("부서추가");
		btnDepartmentInsert.setForeground(Color.WHITE);
		btnDepartmentInsert.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnDepartmentInsert.setBackground(new Color(51, 153, 255));
		btnDepartmentInsert.setBounds(160, 140, 115, 30);
		contentPane.add(btnDepartmentInsert);
		
		JButton btnProject = new JButton("프로젝트목록");
		btnProject.setForeground(Color.WHITE);
		btnProject.setFont(new Font("양재소슬체S", Font.BOLD, 12));
		btnProject.setBackground(new Color(51, 102, 255));
		btnProject.setBounds(160, 170, 115, 30);
		contentPane.add(btnProject);
		btnProject.setVisible(false);
		
		JButton btnProjectInsert = new JButton("프로젝트추가");
		btnProjectInsert.setForeground(Color.WHITE);
		btnProjectInsert.setFont(new Font("양재소슬체S", Font.BOLD, 12));
		btnProjectInsert.setBackground(new Color(51, 51, 255));
		btnProjectInsert.setBounds(160, 200, 115, 30);
		contentPane.add(btnProjectInsert);
		btnProjectInsert.setVisible(false);
		
		JButton btnRetirementList = new JButton("퇴직목록");
		btnRetirementList.setForeground(Color.WHITE);
		btnRetirementList.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnRetirementList.setBackground(new Color(51, 204, 255));
		btnRetirementList.setBounds(160, 210, 115, 30);
		contentPane.add(btnRetirementList);
		btnRetirementList.setVisible(false);
		
		JButton btnRetirementAdd = new JButton("퇴직처리");
		btnRetirementAdd.setForeground(Color.WHITE);
		btnRetirementAdd.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnRetirementAdd.setBackground(new Color(51, 153, 255));
		btnRetirementAdd.setBounds(160, 240, 115, 30);
		contentPane.add(btnRetirementAdd);
		btnRetirementAdd.setVisible(false);
		
		JButton btnUser = new JButton("유저관리");
		btnUser.setForeground(Color.WHITE);
		btnUser.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnUser.setBackground(new Color(51, 204, 255));
		btnUser.setBounds(160, 310, 115, 30);
		contentPane.add(btnUser);
		btnUser.setVisible(false);
		
		JButton btnUserInsert = new JButton("유저추가");
		btnUserInsert.setForeground(Color.WHITE);
		btnUserInsert.setFont(new Font("양재소슬체S", Font.BOLD, 15));
		btnUserInsert.setBackground(new Color(51, 153, 255));
		btnUserInsert.setBounds(160, 340, 115, 30);
		contentPane.add(btnUserInsert);
		btnUserInsert.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(160, 0, 661, 579);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSideMenu = new JPanel();
		panelSideMenu.setBackground(Color.WHITE);
		panelSideMenu.setBounds(0, 0, 160, 579);
		contentPane.add(panelSideMenu);
		panelSideMenu.setLayout(null);
		
		JButton btnPersonnel = new JButton("인사 관리");
		
		btnPersonnel.setBackground(new Color(51, 204, 255));
		btnPersonnel.setForeground(Color.WHITE);
		btnPersonnel.setFont(new Font("양재소슬체S", Font.BOLD, 27));
		btnPersonnel.setBounds(0, 10, 160, 100);
		panelSideMenu.add(btnPersonnel);
		
		JButton btnDepartment = new JButton("부서 관리");
		btnDepartment.setBackground(new Color(51, 153, 255));
		btnDepartment.setForeground(Color.WHITE);
		btnDepartment.setFont(new Font("양재소슬체S", Font.BOLD, 27));
		
		btnDepartment.setBounds(0, 110, 160, 100);
		panelSideMenu.add(btnDepartment);
		
		JButton btnRetirement = new JButton("퇴직 관리");
		btnRetirement.setForeground(Color.WHITE);
		btnRetirement.setBackground(new Color(51, 102, 255));
		btnRetirement.setFont(new Font("양재소슬체S", Font.BOLD, 27));
		btnRetirement.setBounds(0, 210, 160, 100);
		panelSideMenu.add(btnRetirement);
		
		JButton btnSystem = new JButton("시스템 ");
		btnSystem.setForeground(Color.WHITE);
		btnSystem.setBackground(new Color(51, 51, 255));
		btnSystem.setFont(new Font("양재소슬체S", Font.BOLD, 27));
		btnSystem.setBounds(0, 310, 160, 100);
		panelSideMenu.add(btnSystem);
		
		//인사관리
		btnPersonnel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}		
			@Override
			public void mouseExited(MouseEvent e) {
				btnPersonnelMain.setVisible(false);
				btnPersonnelList.setVisible(false);
				btnPersonnelInset.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPersonnelMain.setVisible(true);
				btnPersonnelList.setVisible(true);
				btnPersonnelInset.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		//부서관리
		btnDepartment.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDepartmentList.setVisible(false);
				btnDepartmentInsert.setVisible(false);
				btnProject.setVisible(false);
				btnProjectInsert.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDepartmentList.setVisible(true);
				btnDepartmentInsert.setVisible(true);
				btnProject.setVisible(true);
				btnProjectInsert.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		//퇴직관리
		btnRetirement.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRetirementList.setVisible(false);
				btnRetirementAdd.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRetirementList.setVisible(true);
				btnRetirementAdd.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		//시스템 관리
		btnSystem.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnUser.setVisible(false);
				btnUserInsert.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUser.setVisible(true);
				btnUserInsert.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		btnDepartmentInsert.setVisible(false);
		
			btnPersonnelMain.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPersonnelMain.setVisible(false);
				btnPersonnelList.setVisible(false);
				btnPersonnelInset.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPersonnelMain.setVisible(true);
				btnPersonnelList.setVisible(true);
				btnPersonnelInset.setVisible(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Personnel personnel = new Personnel(0,employeeDAO);
				panel.removeAll();
				panel.add(personnel,BorderLayout.CENTER);
			}
		});
			
			btnPersonnelList.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnPersonnelMain.setVisible(false);
					btnPersonnelList.setVisible(false);
					btnPersonnelInset.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnPersonnelMain.setVisible(true);
					btnPersonnelList.setVisible(true);
					btnPersonnelInset.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					Personnel personnel = new Personnel(1,employeeDAO);
					panel.removeAll();
					panel.add(personnel,BorderLayout.CENTER);
				}
			});
			
			btnPersonnelInset.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnPersonnelMain.setVisible(false);
					btnPersonnelList.setVisible(false);
					btnPersonnelInset.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnPersonnelMain.setVisible(true);
					btnPersonnelList.setVisible(true);
					btnPersonnelInset.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				Personnel personnel = new Personnel(2,employeeDAO);
				panel.removeAll();
				panel.add(personnel,BorderLayout.CENTER);
				}
			});
			
			btnDepartmentList.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnDepartmentList.setVisible(false);
					btnDepartmentInsert.setVisible(false);
					btnProject.setVisible(false);
					btnProjectInsert.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnDepartmentList.setVisible(true);
					btnDepartmentInsert.setVisible(true);
					btnProject.setVisible(true);
					btnProjectInsert.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					DepartmentManagement departmentManagement = new DepartmentManagement(departmentDAO,projectDAO,0);
					panel.removeAll();
					panel.add(departmentManagement,BorderLayout.CENTER);
				}
			});

			btnDepartmentInsert.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnDepartmentList.setVisible(false);
					btnDepartmentInsert.setVisible(false);
					btnProject.setVisible(false);
					btnProjectInsert.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
				btnDepartmentList.setVisible(true);
				btnDepartmentInsert.setVisible(true);
				btnProject.setVisible(true);
				btnProjectInsert.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					DepartmentManagement departmentManagement = new DepartmentManagement(departmentDAO,projectDAO,1);
					panel.removeAll();
					panel.add(departmentManagement,BorderLayout.CENTER);
				}
			});
			
			btnProject.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnDepartmentList.setVisible(false);
					btnDepartmentInsert.setVisible(false);
					btnProject.setVisible(false);
					btnProjectInsert.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
				btnDepartmentList.setVisible(true);
				btnDepartmentInsert.setVisible(true);
				btnProject.setVisible(true);
				btnProjectInsert.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					DepartmentManagement departmentManagement = new DepartmentManagement(departmentDAO,projectDAO,2);
					panel.removeAll();
					panel.add(departmentManagement,BorderLayout.CENTER);
				}
			});
			
			btnProjectInsert.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnDepartmentList.setVisible(false);
					btnDepartmentInsert.setVisible(false);
					btnProject.setVisible(false);
					btnProjectInsert.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
				btnDepartmentList.setVisible(true);
				btnDepartmentInsert.setVisible(true);
				btnProject.setVisible(true);
				btnProjectInsert.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					DepartmentManagement departmentManagement = new DepartmentManagement(departmentDAO,projectDAO,3);
					panel.removeAll();
					panel.add(departmentManagement,BorderLayout.CENTER);
				}
			});
			
			btnRetirementList.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnRetirementList.setVisible(false);
					btnRetirementAdd.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRetirementList.setVisible(true);
					btnRetirementAdd.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					RetirementManagement retirement = new RetirementManagement(retirementDAO,employeeDAO,0);
					panel.removeAll();
					panel.add(retirement,BorderLayout.CENTER);
				}
			});
			
			btnRetirementAdd.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnRetirementList.setVisible(false);
					btnRetirementAdd.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRetirementList.setVisible(true);
					btnRetirementAdd.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					RetirementManagement retirement = new RetirementManagement(retirementDAO,employeeDAO,1);
					panel.removeAll();
					panel.add(retirement,BorderLayout.CENTER);
				}
			});
			
			btnUser.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {}
				
				@Override
				public void mouseExited(MouseEvent e) {
					btnUser.setVisible(false);
					btnUserInsert.setVisible(false);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					btnUser.setVisible(true);
					btnUserInsert.setVisible(true);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					UserSystem user = new UserSystem(userDAO,employeeDAO,0);
					panel.removeAll();
					panel.add(user,BorderLayout.CENTER);
				}
			});
			
			btnUserInsert.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					btnUser.setVisible(false);
					btnUserInsert.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnUser.setVisible(true);
					btnUserInsert.setVisible(true);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					UserSystem user = new UserSystem(userDAO,employeeDAO,1);
					panel.removeAll();
					panel.add(user,BorderLayout.CENTER);
				}
			});
			
			//홈 버튼
			lblHome.addMouseListener(new MouseListener() {
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
					Personnel personnel = new Personnel(0,employeeDAO);
					panel.removeAll();
					panel.add(personnel,BorderLayout.CENTER);
				}
			});
			Personnel personnel = new Personnel(0,employeeDAO);
			panel.add(personnel,BorderLayout.CENTER);
		btnPersonnelMain.setVisible(false);
		btnPersonnelList.setVisible(false);
		btnPersonnelInset.setVisible(false);

			}
}
