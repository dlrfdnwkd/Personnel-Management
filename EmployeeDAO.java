package model;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class EmployeeDAO {
	private Statement stmt = null;
	private ResultSet result = null;
	private Connection con;
	private String url;
	
	public EmployeeDAO() {
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
	
	public String[][] showEmployee(){
		int i =0;
		String[][] employees = null;
		try {		
			String sql = "select e.fname, e.lname, e.ssn, e.bdate, e.address, e.sex, e.superssn, d.dname, k.kind from employee e, kind k, department d where e.kno = k.knumber and e.dno = d.dnumber;";
			stmt = con.createStatement();	
			result = stmt.executeQuery(sql);
			result.last();
			employees = new String[result.getRow()][9];
			result.beforeFirst();
			while(result.next()) {
				employees[i][0] = result.getString("fname");
				employees[i][1] = result.getString("lname");
				employees[i][2] = result.getString("ssn");
				employees[i][3] = result.getString("bdate");
				employees[i][4] = result.getString("address");
				employees[i][5] = result.getString("sex");
				employees[i][6] = result.getString("superssn");
				employees[i][7] = result.getString("dname");
				employees[i][8] = result.getString("kind");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public String[][] searchEmployee(String condition,String value){
		int i =0;
		String[][] employees = null;
		try {		
			String sql = "select * from employee where "+condition+" = '"+value+"';";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			employees = new String[result.getRow()][9];
			result.beforeFirst();
			while(result.next()) {
				employees[i][0] = result.getString("fname");
				employees[i][1] = result.getString("lname");
				employees[i][2] = result.getString("ssn");
				employees[i][3] = result.getString("bdate");
				employees[i][4] = result.getString("address");
				employees[i][5] = result.getString("sex");
				employees[i][6] = result.getString("kno");
				employees[i][7] = result.getString("superssn");
				employees[i][8] = result.getString("dno");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public void insertEmployee(Employee employee) {
		String sql = null;
		if(employee.getSuperssn() == null || employee.getSuperssn().equals("")) {
			sql = "insert into employee values('"+employee.getFname()+"','"+employee.getLname()+"','"+employee.getSsn()+"','"+employee.getBdate()+
					"','"+employee.getAddress()+"','"+employee.getSex()+"',null,"+employee.getDno()+","+employee.getKno()+");";
		}else {
			sql = "insert into employee values('"+employee.getFname()+"','"+employee.getLname()+"','"+employee.getSsn()+"','"+employee.getBdate()+
					"','"+employee.getAddress()+"','"+employee.getSex()+"',null,"+employee.getDno()+","+employee.getKno()+");";
		}
		try {
			System.out.println(sql);
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int showAllNumber() {
		String sql = "select * from employee;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showIntern() {
		String sql = "select * from employee where kno = 10;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showNormal() {
		String sql = "select * from employee where kno = 9;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showDeputy() {
		String sql = "select * from employee where kno = 8;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showSection() {
		String sql = "select * from employee where kno = 7;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showSenior() {
		String sql = "select * from employee where kno = 6;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showHD() {
		String sql = "select * from employee where kno = 5;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showExecutive() {
		String sql = "select * from employee where kno = 4;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showED() {
		String sql = "select * from employee where kno = 3;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showHead() {
		String sql = "select * from employee where dno = 1;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showAdmin() {
		String sql = "select * from employee where dno = 4;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showResearch() {
		String sql = "select * from employee where dno = 5;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showSoft() {
		String sql = "select * from employee where dno = 6;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showHard() {
		String sql = "select * from employee where dno = 7;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public int showSales() {
		String sql = "select * from employee where dno = 8;";
		int number =0;
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			number = result.getRow();
			result.first();
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public void deleteEmployee(String ssn) {
		String sql = "delete from employee where ssn='"+ssn+"';";
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
	
	public void updateEmployee(Employee employee) {
		String sql = null;
		if(employee.getSuperssn() == null || employee.getSuperssn().equals("")) {
			sql = "update employee set fname='"+employee.getFname()+"', lname='"+employee.getLname()+"', ssn='"+
						employee.getSsn()+"', bdate='"+employee.getBdate()+"', address='"+employee.getAddress()+"', sex='"+
						employee.getSex()+"', dno="+employee.getDno()+", kno="+employee.getKno()+" where ssn='"+employee.getSsn()+"';";
		}else {
			sql = "update employee set fname='"+employee.getFname()+"', lname='"+employee.getLname()+"', ssn='"+
					employee.getSsn()+"', bdate='"+employee.getBdate()+"', address='"+employee.getAddress()+"', sex='"+
					employee.getSex()+"', superssn='"+employee.getSuperssn()+"', dno="+employee.getDno()+", kno="+employee.getKno()+" where ssn='"+employee.getSsn()+"';";
		}
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
	
	public Employee searchPerson(String ssn) {
		String sql = "select * from employee where ssn ='"+ssn+"';";
		Employee employee = new Employee();
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			while(result.next()) {
				employee.setFname(result.getString("fname"));
				employee.setLname(result.getString("lname"));
				employee.setSsn(result.getString("ssn"));
				employee.setBdate(result.getDate("bdate"));
				employee.setAddress(result.getString("address"));
				employee.setSex(result.getString("sex").charAt(0));
				employee.setSuperssn(result.getString("superssn"));
				employee.setDno(result.getInt("dno"));
				employee.setKno(result.getInt("kno"));
			}
		}catch(SQLException e) {
			System.err.println("SQL문 오류 :"+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public void personnelToExcel(String[][] employees) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("C://Users/cps/eclipse-workspace/PersonnelManagement/excel/personnel.xls"));
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Employee");
			HSSFRow row = null;
			HSSFCell cell = null;
			for(int i=0; i<employees.length; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(employees[i][0]);
				cell = row.createCell(1);
				cell.setCellValue(employees[i][1]);
				cell = row.createCell(2);
				cell.setCellValue(employees[i][2]);
				cell = row.createCell(3);
				cell.setCellValue(employees[i][3]);
				cell = row.createCell(4);
				cell.setCellValue(employees[i][4]);
				cell = row.createCell(5);
				cell.setCellValue(employees[i][5]);
				cell = row.createCell(6);
				cell.setCellValue(employees[i][6]);
				cell = row.createCell(7);
				cell.setCellValue(employees[i][7]);
				cell = row.createCell(8);
				cell.setCellValue(employees[i][8]);
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
