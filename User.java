package model;

public class User {
	private String ssn;
	private String id;
	private String pw;
	private char power;
	
	public User() {}
	public User(String id,String pw) {
		this.id = id;
		this.pw = pw;
	}
	public User(String ssn, String id,String pw,char power) {
		this.ssn = ssn;
		this.id = id;
		this.pw = pw;
		this.power = power;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public char getPower() {
		return power;
	}
	public void setPower(char power) {
		this.power = power;
	}
}
