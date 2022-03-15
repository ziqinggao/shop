package com.dirsir.dao.entities;

public class Repertory {
	private int repertoryId;
	private int commodityId;
	private String subsort;
	private int checkRepertory;
	private int countRepertory;
	private String checkDate;
	private String checkName;
	public int getRepertoryId() {
		return repertoryId;
	}
	public void setRepertoryId(int repertoryId) {
		this.repertoryId = repertoryId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getSubsort() {
		return subsort;
	}
	public void setSubsort(String subsort) {
		this.subsort = subsort;
	}
	public int getCheckRepertory() {
		return checkRepertory;
	}
	public void setCheckRepertory(int checkRepertory) {
		this.checkRepertory = checkRepertory;
	}
	public int getCountRepertory() {
		return countRepertory;
	}
	public void setCountRepertory(int countRepertory) {
		this.countRepertory = countRepertory;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public Repertory(int repertoryId, int commodityId, String subsort, int checkRepertory, int countRepertory,
			String checkDate, String checkName) {
		super();
		this.repertoryId = repertoryId;
		this.commodityId = commodityId;
		this.subsort = subsort;
		this.checkRepertory = checkRepertory;
		this.countRepertory = countRepertory;
		this.checkDate = checkDate;
		this.checkName = checkName;
	}
	public Repertory() {
		super();
	}
	
}
