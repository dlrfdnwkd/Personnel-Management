package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Project;
import model.ProjectDAO;

public class ProjectSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPname;
	private JTextField txtPnumber;
	private JTextField txtPlocation;
	private JTextField txtDnum;

	public ProjectSearch(ProjectDAO projectDAO,int pnumber) {
		setBounds(100, 100, 383, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPname = new JLabel("프로젝트 이름 :");
		lblPname.setBounds(67, 56, 99, 15);
		contentPanel.add(lblPname);
		
		txtPname = new JTextField();
		txtPname.setBounds(190, 56, 116, 21);
		contentPanel.add(txtPname);
		txtPname.setColumns(10);
		
		JLabel lblPnumber = new JLabel("프로젝트 번호 :");
		lblPnumber.setBounds(67, 88, 99, 15);
		contentPanel.add(lblPnumber);
		
		txtPnumber = new JTextField();
		txtPnumber.setBounds(190, 88, 116, 21);
		contentPanel.add(txtPnumber);
		txtPnumber.setColumns(10);
		
		JLabel lblPlocation = new JLabel("프로젝트 지역 :");
		lblPlocation.setBounds(67, 120, 99, 15);
		contentPanel.add(lblPlocation);
		
		txtPlocation = new JTextField();
		txtPlocation.setBounds(190, 120, 116, 21);
		contentPanel.add(txtPlocation);
		txtPlocation.setColumns(10);
		
		JLabel lblDnum = new JLabel("부서번호 :");
		lblDnum.setBounds(67, 148, 99, 15);
		contentPanel.add(lblDnum);
		
		txtDnum = new JTextField();
		txtDnum.setBounds(190, 148, 116, 21);
		contentPanel.add(txtDnum);
		txtDnum.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		Project project = projectDAO.selectProject(pnumber);
		txtPname.setText(project.getPname());
		txtPnumber.setText(String.valueOf(project.getPnumber()));
		txtPlocation.setText(project.getPlocation());
		txtDnum.setText(String.valueOf(project.getDnum()));
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				project.setPname(txtPname.getText());
				project.setPnumber(Integer.parseInt(txtPnumber.getText()));
				project.setPlocation(txtPlocation.getText());
				project.setDnum(Integer.parseInt(txtDnum.getText()));
				projectDAO.updateProject(project, pnumber);
				JOptionPane.showMessageDialog(null, "프로젝트가 수정되었습니다.");
				dispose();
			}
		});
		buttonPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				projectDAO.deleteProject(pnumber);
				JOptionPane.showMessageDialog(null, "프로젝트가 삭제되었습니다.");
				dispose();
			}
		});
		buttonPane.add(btnDelete);
				
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
