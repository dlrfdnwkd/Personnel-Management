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

public class ProjectDAO {
	private Statement stmt = null;
	private ResultSet result = null;
	private Connection con;
	private String url;
	
	public ProjectDAO() {
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
	
	public String[][] showProject(){
		int i =0;
		String[][] projects = null;
		try {		
			String sql = "select p.pname, p.pnumber, p.plocation, d.dname from project p, department d where p.dnum = d.dnumber;";
			stmt = con.createStatement();	
			result = stmt.executeQuery(sql);
			result.last();
			projects = new String[result.getRow()][4];
			result.beforeFirst();
			while(result.next()) {
				projects[i][0] = result.getString("pname");
				projects[i][1] = result.getString("pnumber");
				projects[i][2] = result.getString("plocation");
				projects[i][3] = result.getString("dname");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public String[][] searchProject(String condition,String value){
		int i =0;
		String[][] projects = null;
		String table = null;
		if(condition.equals("dname")) {
			table = "d."+condition;
		}else {
			table = "p."+condition;
		}
		try {		
			String sql = "select p.pname, p.pnumber, p.plocation, d.dname from project p, department d where p.dnum = d.dnumber and "+condition+" = '"+value+"';";
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			result.last();
			projects = new String[result.getRow()][4];
			result.beforeFirst();
			while(result.next()) {
				projects[i][0] = result.getString("pname");
				projects[i][1] = result.getString("pnumber");
				projects[i][2] = result.getString("plocation");
				projects[i][3] = result.getString("dname");
				i++;
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return projects;
	}
	
	public Project selectProject(int pnumber) {
		String sql = "select * from project where pnumber ="+pnumber;
		Project project = new Project();
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(sql);
			while(result.next()) {
				project.setPname(result.getString("pname"));
				project.setPnumber(result.getInt("pnumber"));
				project.setPlocation(result.getString("plocation"));
				project.setDnum(result.getInt("dnum"));
			}
			result.close();
			stmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return project;
	}
	
	public void updateProject(Project project,int pnumber) {
		String sql = "update project set pname=?, pnumber=?, plocation=?, dnum=? where pnumber="+pnumber;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project.getPname());
			pstmt.setInt(2, project.getPnumber());
			pstmt.setString(3, project.getPlocation());
			pstmt.setInt(4,project.getDnum());
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProject(int pnumber) {
		String sql = "delete from project where pnumber="+pnumber;
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
	
	public void insertProject(Project project) {
		String sql ="insert into project values(?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project.getPname());
			pstmt.setInt(2, project.getPnumber());
			pstmt.setString(3, project.getPlocation());
			pstmt.setInt(4, project.getDnum());
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			System.err.println("레코드 삽입 오류 : "+e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void projectToExcel(String[][] projects) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("C://Users/cps/eclipse-workspace/PersonnelManagement/excel/project.xls"));
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Project");
			HSSFRow row = null;
			HSSFCell cell = null;
			for(int i=0; i<projects.length; i++) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(projects[i][0]);
				cell = row.createCell(1);
				cell.setCellValue(projects[i][1]);
				cell = row.createCell(2);
				cell.setCellValue(projects[i][2]);
				cell = row.createCell(3);
				cell.setCellValue(projects[i][3]);
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
