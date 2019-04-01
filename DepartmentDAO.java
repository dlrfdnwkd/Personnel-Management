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

public class DepartmentDAO {
	private Statement stmt = null;
	private ResultSet result = null;
	private Connection con;
	private String url;
	
	public DepartmentDAO() {
	url = "jdbc:mysql://127.0.0.1:3306/company?serverTimezone=UTC&verifyServerCertificate=false";
	con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch(ClassNotFoundException e) {
		System.err.println("Class Not Found : "+e.getMessage());
	}
	try {
		con = DriverManager.getConnection(url, "root","1234");
	} catch(SQLException e) {
		System.err.println("SQL Error : "+e.getMessage());
	}
	}
	
	public String[][] showDepartment(){
		int i =0;
		String[][] departments = null;
		try {		
			String sql = "select d.dname, d.dnumber, e.lname, d.mgrstartdate from employee e, department d where d.mgrssn = e.ssn;";
			stmt = con.createStatement();	
			result = stmt.executeQuery(sql);
			result.last();
			departments = new String[result.getRow()][4];
			result.beforeFirst();
			while(result.next()) {
				departments[i][0] = result.getString("dname");
				departments[i][1] = result.getString("dnumber");
				departments[i][2] = result.getString("lname");
				departments[i][3] = result.getString("mgrstartdate");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return departments;
	}
	
	public String[][] searchDepartment(String condition,String value){
		int i =0;
		String[][] departments = null;
		String table = null;
		if(condition.equals("lname")) {
			table = "e."+condition;
		}else {
			table = "d."+condition;
		}
		try {		
			String sql = "select d.dname, d.dnumber, e.lname, d.mgrstartdate from employee e, department d where d.mgrssn = e.ssn and "+condition+" = '"+value+"';";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			departments = new String[result.getRow()][4];
			result.beforeFirst();
			while(result.next()) {
				departments[i][0] = result.getString("dname");
				departments[i][1] = result.getString("dnumber");
				departments[i][2] = result.getString("lname");
				departments[i][3] = result.getString("mgrstartdate");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return departments;
	}
	
	public Department selectDepartment(int dnumber) {
		String sql = "select * from department where dnumber ="+dnumber;
		Department department = new Department();
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			while(result.next()) {
				department.setDname(result.getString("dname"));
				department.setDnumber(result.getInt("dnumber"));
				department.setMgrssn(result.getString("mgrssn"));
				department.setMgrstartdate(result.getDate("mgrstartdate"));
			}
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return department;
	}
	
	public void updateDepartment(Department department,int dnumber) {
		String sql = "update department set dname=?, dnumber=?, mgrssn=?, mgrstartdate=? where dnumber ="+dnumber;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, department.getDname());
			pstmt.setString(2, String.valueOf(department.getDnumber()));
			pstmt.setString(3, department.getMgrssn());
			pstmt.setString(4, department.getMgrstartdate().toString());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDepartment(int dnumber) {
		String sql = "delete from department where dnumber = "+dnumber;
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
	
	public void insertDepartment(Department department) {
		String sql ="insert into department values(?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, department.getDname());
			pstmt.setString(2, String.valueOf(department.getDnumber()));
			pstmt.setString(3, department.getMgrssn());
			pstmt.setString(4, department.getMgrstartdate().toString());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void departmentToExcel(String[][] departments) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("C://Users/cps/eclipse-workspace/PersonnelManagement/excel/department.xls"));
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Department");
			HSSFRow row = null;
			HSSFCell cell = null;
			for(int i=0; i<departments.length; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(departments[i][0]);
				cell = row.createCell(1);
				cell.setCellValue(departments[i][1]);
				cell = row.createCell(2);
				cell.setCellValue(departments[i][2]);
				cell = row.createCell(3);
				cell.setCellValue(departments[i][3]);
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