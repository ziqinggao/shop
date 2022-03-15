package com.dirsir.dao.entities;

public class AccountTarding {
	private int tardingId;
	private int  accountId;
	private String  tardingDate;
	private double  tardingPrices;
	private  int tardingType;
	private String note;
	public int getTardingId() {
		return tardingId;
	}
	public void setTardingId(int tardingId) {
		this.tardingId = tardingId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getTardingDate() {
		return tardingDate;
	}
	public void setTardingDate(String tardingDate) {
		this.tardingDate = tardingDate;
	}
	public double getTardingPrices() {
		return tardingPrices;
	}
	public void setTardingPrices(double tardingPrices) {
		this.tardingPrices = tardingPrices;
	}
	public int getTardingType() {
		return tardingType;
	}
	public void setTardingType(int tardingType) {
		this.tardingType = tardingType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public AccountTarding(int tardingId, int accountId, String tardingDate, double tardingPrices, int tardingType,
			String note) {
		super();
		this.tardingId = tardingId;
		this.accountId = accountId;
		this.tardingDate = tardingDate;
		this.tardingPrices = tardingPrices;
		this.tardingType = tardingType;
		this.note = note;
	}
	public AccountTarding() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	

}
