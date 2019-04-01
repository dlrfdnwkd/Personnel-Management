package model;

public class Project {
	private String pname;
	private int pnumber;
	private String plocation;
	private int dnum;
	
	public Project() {}
	public Project(String pname, int pnumber, String plocation, int dnum) {
		this.pname = pname;
		this.pnumber = pnumber;
		this.plocation = plocation;
		this.dnum = dnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public String getPlocation() {
		return plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
}
