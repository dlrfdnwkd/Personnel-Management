package model;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class RetirementDAO {
	private Statement stmt = null;
	private ResultSet result = null;
	private Connection con;
	private String url;
	
	public RetirementDAO() {
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
	
	public String[][] showRetirement(){
		int i =0;
		String[][] retirements = null;
		try {		
			String sql = "select r.rssn, r.fname, r.lname, r.bdate, r.sex, r.rdate, k.kind from retirement r, kind k where r.kno = k.knumber;";
			stmt = con.createStatement();	
			result = stmt.executeQuery(sql);
			result.last();
			retirements = new String[result.getRow()][7];
			result.beforeFirst();
			while(result.next()) {
				retirements[i][0] = result.getString("rssn");
				retirements[i][1] = result.getString("fname");
				retirements[i][2] = result.getString("lname");
				retirements[i][3] = result.getString("bdate");
				retirements[i][4] = result.getString("sex");
				retirements[i][5] = result.getString("rdate");
				retirements[i][6] = result.getString("kind");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retirements;
	} 
	
	public void insertRetirement(Employee employee) {
		String sql ="insert into retirement values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getSsn());
			pstmt.setString(2, employee.getFname());
			pstmt.setString(3, employee.getLname());
			pstmt.setString(4, employee.getBdate().toString());
			pstmt.setString(5, String.valueOf(employee.getSex()));
			pstmt.setString(6, new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
			pstmt.setString(7, String.valueOf(employee.getKno()));
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRetirement(String rssn) {
		String sql = "delete from retirement where rssn='"+rssn+"';";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateRetirement(Retirement retirement) {
		String sql = null;
			sql = "update retirement set rssn=?, fname=?, lname=?, bdate=?, sex=?, rdate=?, kno=?;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, retirement.getRssn());
			pstmt.setString(2, retirement.getFname());
			pstmt.setString(3, retirement.getLname());
			pstmt.setDate(4, (java.sql.Date) retirement.getBdate());
			pstmt.setString(5, String.valueOf(retirement.getSex()));
			pstmt.setDate(6, (java.sql.Date) retirement.getRdate());
			pstmt.setInt(7, retirement.getKno());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[][] searchRetirements(String condition,String value){
		int i =0;
		String[][] retirements = null;
		try {		
			String sql = "select r.rssn, r.fname, r.lname, r.bdate, r.sex, r.rdate, k.kind from retirement r, kind k where r.kno = k.knumber and "+condition+" = '"+value+"';";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			retirements = new String[result.getRow()][7];
			result.beforeFirst();
			while(result.next()) {
				retirements[i][0] = result.getString("rssn");
				retirements[i][1] = result.getString("fname");
				retirements[i][2] = result.getString("lname");
				retirements[i][3] = result.getString("bdate");
				retirements[i][4] = result.getString("sex");
				retirements[i][5] = result.getString("rdate");
				retirements[i][6] = result.getString("kind");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retirements;
	}
	
	public Retirement searchRetirement(String rssn) {
		String sql = "select * from retirement where rssn ='"+rssn+"';";
		Retirement retirement = new Retirement();
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			while(result.next()) {
				retirement.setRssn(result.getString("rssn"));
				retirement.setFname(result.getString("fname"));
				retirement.setLname(result.getString("lname"));
				retirement.setBdate(result.getDate("bdate"));
				retirement.setSex(result.getString("sex").charAt(0));
				retirement.setRdate(result.getDate("rdate"));
				retirement.setKno(result.getInt("kno"));
			}
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retirement;
	}
	
	public void retirementToExcel(String[][] retirement) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("C://Users/cps/eclipse-workspace/PersonnelManagement/excel/retirement.xls"));
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Retirement");
			HSSFRow row = null;
			HSSFCell cell = null;
			for(int i=0; i<retirement.length; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(retirement[i][0]);
				cell = row.createCell(1);
				cell.setCellValue(retirement[i][1]);
				cell = row.createCell(2);
				cell.setCellValue(retirement[i][2]);
				cell = row.createCell(3);
				cell.setCellValue(retirement[i][3]);
				cell = row.createCell(4);
				cell.setCellValue(retirement[i][4]);
				cell = row.createCell(5);
				cell.setCellValue(retirement[i][5]);
				cell = row.createCell(6);
				cell.setCellValue(retirement[i][6]);
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
