package com.dirsir.dao.entities;

public class Admin {
	private int adminId;
	private int adminNumber;
	private String adminName;
	private String adminPassword;
	private String realName;
	private int state;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Admin(int adminId, int adminNumber, String adminName, String adminPassword, String realName, int state) {
		super();
		this.adminId = adminId;
		this.adminNumber = adminNumber;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.realName = realName;
		this.state = state;
	}
	public Admin() {
		super();
	}
	
}
