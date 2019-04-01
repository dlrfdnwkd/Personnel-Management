package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;
import model.UserDAO;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPW;
	private JLabel lblID;
	private JLabel lblPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 20, 840, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(getBounds());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uC778\uC0AC\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		label.setForeground(new Color(51, 51, 255));
		label.setFont(new Font("양재소슬체S", Font.BOLD, 50));
		label.setBounds(192, 132, 449, 72);
		contentPane.add(label);
		
		lblID = new JLabel("ID :");
		lblID.setForeground(new Color(51, 51, 255));
		lblID.setBackground(Color.WHITE);
		lblID.setFont(new Font("양재소슬체S", Font.BOLD, 30));
		lblID.setBounds(115, 256, 59, 50);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(212, 256, 400, 50);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		lblPW = new JLabel("PW :");
		lblPW.setForeground(new Color(51, 51, 255));
		lblPW.setFont(new Font("양재소슬체S", Font.BOLD, 30));
		lblPW.setBackground(Color.WHITE);
		lblPW.setBounds(115, 350, 71, 50);
		contentPane.add(lblPW);
		
		txtPW = new JPasswordField();
		
		txtPW.setBounds(212, 350, 400, 50);
		contentPane.add(txtPW);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(51, 51, 255));
		btnLogin.setFont(new Font("양재소슬체S", Font.BOLD, 35));
		btnLogin.setBounds(212, 485, 400, 50);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User user = new User(txtID.getText(),String.valueOf(txtPW.getPassword()));
				UserDAO dao = new UserDAO();
				if(dao.userCheck(user)) {		
				Menu menu = new Menu();
				dispose();
				menu.setVisible(true);
				}else {
					System.out.println("탈락");
				}
			}
		});
		contentPane.add(btnLogin);
	}
}
