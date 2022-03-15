package com.dirsir.dao.entities;

public class Merchant {
	private int merchantId;
	private String merchantName;
	private String account;
	private String merchantPassword;
	private String unifyCode;
	private String manage;
	private String location;
	private double money;
	private String corp;
	private String corpPhone;
	private String director; // Ö÷¹Ü
	private String directorPhone;
	private double merchantBalance; // Óà¶î
	private String recordDate;
	private int recordState;
	private int adminId;
	private String checkDate;
	private String licensPicture;
	private String corpPicture;
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMerchantPassword() {
		return merchantPassword;
	}
	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}
	public String getUnifyCode() {
		return unifyCode;
	}
	public void setUnifyCode(String unifyCode) {
		this.unifyCode = unifyCode;
	}
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	public String getCorpPhone() {
		return corpPhone;
	}
	public void setCorpPhone(String corpPhone) {
		this.corpPhone = corpPhone;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDirectorPhone() {
		return directorPhone;
	}
	public void setDirectorPhone(String directorPhone) {
		this.directorPhone = directorPhone;
	}
	public double getMerchantBalance() {
		return merchantBalance;
	}
	public void setMerchantBalance(double merchantBalance) {
		this.merchantBalance = merchantBalance;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public int getRecordState() {
		return recordState;
	}
	public void setRecordState(int recordState) {
		this.recordState = recordState;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getLicensPicture() {
		return licensPicture;
	}
	public void setLicensPicture(String licensPicture) {
		this.licensPicture = licensPicture;
	}
	public String getCorpPicture() {
		return corpPicture;
	}
	public void setCorpPicture(String corpPicture) {
		this.corpPicture = corpPicture;
	}
	public Merchant(int merchantId, String merchantName, String account, String merchantPassword, String unifyCode,
			String manage, String location, double money, String corp, String corpPhone, String director,
			String directorPhone, double merchantBalance, String recordDate, int recordState, int adminId,
			String checkDate, String licensPicture, String corpPicture) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.account = account;
		this.merchantPassword = merchantPassword;
		this.unifyCode = unifyCode;
		this.manage = manage;
		this.location = location;
		this.money = money;
		this.corp = corp;
		this.corpPhone = corpPhone;
		this.director = director;
		this.directorPhone = directorPhone;
		this.merchantBalance = merchantBalance;
		this.recordDate = recordDate;
		this.recordState = recordState;
		this.adminId = adminId;
		this.checkDate = checkDate;
		this.licensPicture = licensPicture;
		this.corpPicture = corpPicture;
	}
	public Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
