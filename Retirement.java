package model;

import java.util.Date;

public class Retirement {
	private String rssn;
	private String fname;
	private String lname;
	private Date bdate;
	private char sex;
	private Date rdate;
	private int kno;
	
	public Retirement() {}
	
	public Retirement(String rssn, String fname, String lname, Date bdate, char sex, Date rdate, int kno) {
		this.rssn = rssn;
		this.fname = fname;
		this.lname = lname;
		this.bdate = bdate;
		this.sex = sex;
		this.rdate = rdate;
		this.kno = kno;
	}

	public String getRssn() {
		return rssn;
	}

	public void setRssn(String rssn) {
		this.rssn = rssn;
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

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public int getKno() {
		return kno;
	}

	public void setKno(int kno) {
		this.kno = kno;
	}
	
	
	
}
