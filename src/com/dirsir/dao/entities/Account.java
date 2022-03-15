package com.dirsir.dao.entities;

public class Account {
	private int accountId;
	private String accountName;
	private String phone;
	private String accountPassword;
	private String name;
	private int gender;
	private int age;
	private String birthday;
	private String idCard;
	private double balance;
	private String email;
	private String picture;
	private int vip;
	private String vipDate;
	private String vipBirthday;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getVipDate() {
		return vipDate;
	}
	public void setVipDate(String vipDate) {
		this.vipDate = vipDate;
	}
	public String getVipBirthday() {
		return vipBirthday;
	}
	public void setVipBirthday(String vipBirthday) {
		this.vipBirthday = vipBirthday;
	}
	public Account(int accountId, String accountName, String phone, String accountPassword, String name, int gender,
			int age, String birthday, String idCard, double balance, String email, String picture, int vip,
			String vipDate, String vipBirthday) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.phone = phone;
		this.accountPassword = accountPassword;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.idCard = idCard;
		this.balance = balance;
		this.email = email;
		this.picture = picture;
		this.vip = vip;
		this.vipDate = vipDate;
		this.vipBirthday = vipBirthday;
	}
	public Account() {
		super();
	}

	

}
