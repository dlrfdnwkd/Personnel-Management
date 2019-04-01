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

import model.Retirement;
import model.RetirementDAO;

public class RetirementSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRssn;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtBdate;
	private JTextField txtSex;
	private JTextField txtRdate;
	private JTextField txtKno;
	private RetirementDAO dao;

	/**
	 * Create the dialog.
	 */
	public RetirementSearch(RetirementDAO retirementDAO,String rssn) {
		dao = retirementDAO;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRssn = new JLabel("퇴직번호 :");
		lblRssn.setBounds(27, 47, 57, 15);
		contentPanel.add(lblRssn);		
		
		txtRssn = new JTextField();
		txtRssn.setBounds(107, 44, 116, 21);
		contentPanel.add(txtRssn);
		txtRssn.setColumns(10);
		
		JLabel lblFname = new JLabel("성 :");
		lblFname.setBounds(27, 83, 57, 15);
		contentPanel.add(lblFname);
		
		txtFname = new JTextField();
		txtFname.setBounds(107, 80, 116, 21);
		contentPanel.add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblLname = new JLabel("이름 :");
		lblLname.setBounds(235, 83, 57, 15);
		contentPanel.add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setBounds(306, 80, 116, 21);
		contentPanel.add(txtLname);
		txtLname.setColumns(10);
		
		JLabel lblBdate = new JLabel("생일 :");
		lblBdate.setBounds(27, 115, 57, 15);
		contentPanel.add(lblBdate);
		
		txtBdate = new JTextField();
		txtBdate.setBounds(107, 111, 116, 21);
		contentPanel.add(txtBdate);
		txtBdate.setColumns(10);
		
		JLabel lblSex = new JLabel("성별 :");
		lblSex.setBounds(235, 115, 57, 15);
		contentPanel.add(lblSex);
		
		txtSex = new JTextField();
		txtSex.setBounds(306, 111, 116, 21);
		contentPanel.add(txtSex);
		txtSex.setColumns(10);
		
		JLabel lblRdate = new JLabel("퇴직일");
		lblRdate.setBounds(27, 149, 57, 15);
		contentPanel.add(lblRdate);
		
		txtRdate = new JTextField();
		txtRdate.setBounds(107, 146, 116, 21);
		contentPanel.add(txtRdate);
		txtRdate.setColumns(10);
		
		JLabel lblKno = new JLabel("직급 :");
		lblKno.setBounds(235, 149, 57, 15);
		contentPanel.add(lblKno);
		
		txtKno = new JTextField();
		txtKno.setBounds(306, 146, 116, 21);
		contentPanel.add(txtKno);
		txtKno.setColumns(10);
		
		Retirement retirement = dao.searchRetirement(rssn);
		txtRssn.setText(retirement.getRssn());
		txtFname.setText(retirement.getFname());
		txtLname.setText(retirement.getLname());
		txtBdate.setText(retirement.getBdate().toString());
		txtSex.setText(String.valueOf(retirement.getSex()));
		txtRdate.setText(retirement.getRdate().toString());
		txtKno.setText(String.valueOf(retirement.getKno()));
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEdit = new JButton("수정");
				btnEdit.addActionListener(new ActionListener() {			
					@Override
					public void actionPerformed(ActionEvent e) {
						retirement.setRssn(txtRssn.getText());
						retirement.setFname(txtFname.getText());
						retirement.setLname(txtLname.getText());
						retirement.setBdate(Date.valueOf(txtBdate.getText()));
						retirement.setSex(txtSex.getText().charAt(0));
						retirement.setRdate(Date.valueOf(txtRdate.getText()));
						retirement.setKno(Integer.parseInt(txtKno.getText()));
						dao.updateRetirement(retirement);
						dispose();
					}
				});
				buttonPane.add(btnEdit);
			}
			{
				JButton btnDelete = new JButton("삭제");
				btnDelete.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dao.deleteRetirement(rssn);
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
