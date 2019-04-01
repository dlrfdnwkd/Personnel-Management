package model;

import java.util.Date;

public class Department {
	private String dname;
	private int dnumber;
	private String mgrssn;
	private Date mgrstartdate;
	
	public Department() {}
	public Department(String dname, int dnumber, String mgrssn, Date mgrstartdate) {
		this.dname = dname;
		this.dnumber = dnumber;
		this.mgrssn = mgrssn;
		this.mgrstartdate = mgrstartdate;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getDnumber() {
		return dnumber;
	}

	public void setDnumber(int dnumber) {
		this.dnumber = dnumber;
	}

	public String getMgrssn() {
		return mgrssn;
	}

	public void setMgrssn(String mgrssn) {
		this.mgrssn = mgrssn;
	}

	public Date getMgrstartdate() {
		return mgrstartdate;
	}

	public void setMgrstartdate(Date mgrstartdate) {
		this.mgrstartdate = mgrstartdate;
	}
	
	
}
