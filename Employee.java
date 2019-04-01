package model;

import java.util.Date;

public class Employee {
	private String fname;
	private String lname;
	private String ssn;
	private Date bdate;
	private String address;
	private char sex;
	private int kno;
	private String superssn;
	private int dno;
	
	public Employee() {}
	
	public Employee(String fname, String lname, String ssn, Date bdate, String address, char sex, int kno, String superssn,
			int dno) {
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
		this.bdate = bdate;
		this.address = address;
		this.sex = sex;
		this.kno = kno;
		this.superssn = superssn;
		this.dno = dno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getKno() {
		return kno;
	}

	public void setKno(int kno) {
		this.kno = kno;
	}

	public String getSuperssn() {
		return superssn;
	}

	public void setSuperssn(String superssn) {
		this.superssn = superssn;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}
	
}
