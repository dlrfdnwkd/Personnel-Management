package model;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UserDAO {
	private Statement stmt = null;
	private ResultSet result = null;
	private Connection con;
	private String url;
	
	public UserDAO() {
	url = "jdbc:mysql://127.0.0.1:3306/company?serverTimezone=UTC&verifyServerCertificate=false";
	con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch(ClassNotFoundException e) {
		System.err.println("Class Not Found : "+e.getMessage());
	}
	
	try {
		con = DriverManager.getConnection(url, "root","1234");
		System.out.println("Successfully connected to DBMS!");
	} catch(SQLException e) {
		System.err.println("SQL Error : "+e.getMessage());
	}
	}
	
	public boolean userCheck(User user){
		try {		
			String sql = "select * from user where id="+user.getId()+" and pw="+user.getPw();
			stmt = con.createStatement();	
			result = stmt.executeQuery(sql);
			if(!result.next()) {
				return false;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public String[][] showUser(){
		int i =0;
		String[][] users = null;
		try {		
			String sql = "select e.fname, e.lname , u.ssn, u.id, u.pw, u.power from employee e, user u where e.ssn = u.ssn;";
			stmt = con.createStatement();	
			result = stmt.executeQuery(sql);
			result.last();
			users = new String[result.getRow()][6];
			result.beforeFirst();
			while(result.next()) {
				users[i][0] = result.getString("fname");
				users[i][1] = result.getString("lname");
				users[i][2] = result.getString("ssn");
				users[i][3] = result.getString("id");
				users[i][4] = result.getString("pw");
				users[i][5] = result.getString("power");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public String[][] searchUser(String condition,String value){
		int i =0;
		String[][] users = null;
		String table = null;
		if(condition.equals("fname") || condition.equals("lname")) {
			table = "e."+condition;
		}else {
			table = "u."+condition;
		}
		try {		
			String sql = "select e.fname, e.lname , u.ssn, u.id, u.pw, u.power from employee e, user u where e.ssn = u.ssn and "+table+" = '"+value+"';";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			users = new String[result.getRow()][6];
			result.beforeFirst();
			while(result.next()) {
				users[i][0] = result.getString("fname");
				users[i][1] = result.getString("lname");
				users[i][2] = result.getString("ssn");
				users[i][3] = result.getString("id");
				users[i][4] = result.getString("pw");
				users[i][5] = result.getString("power");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User selectUser(String ssn) {
		String sql = "select * from user where ssn ="+ssn;
		User user = new User();
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			while(result.next()) {
				user.setId(result.getString("id"));
				user.setPw(result.getString("pw"));
				user.setPower(result.getString("power").charAt(0));
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void updateUser(User user) {
		String sql = "update user set id=?, pw=?, power=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, String.valueOf(user.getPower()));
			pstmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String ssn) {
		String sql = "delete from user where ssn="+ssn;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertUser(User user) {
		String sql = "insert into user values('"+user.getSsn()+"','"+user.getId()+"','"+user.getPw()+"','"+user.getPower()+"');";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void userToExcel(String[][] users) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("C://Users/cps/eclipse-workspace/PersonnelManagement/excel/user.xls"));
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("User");
			HSSFRow row = null;
			HSSFCell cell = null;
			for(int i=0; i<users.length; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(users[i][0]);
				cell = row.createCell(1);
				cell.setCellValue(users[i][1]);
				cell = row.createCell(2);
				cell.setCellValue(users[i][2]);
				cell = row.createCell(3);
				cell.setCellValue(users[i][3]);
				}
			wb.write(fos);
			if(fos != null) {
				fos.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
