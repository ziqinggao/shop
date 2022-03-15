package com.dirsir.dao.entities;

public class CommoditySort {
	private int sortId;
	private int commodityId;
	private String sortName;
	private int sortState;
	private int sortCode;
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public int getSortState() {
		return sortState;
	}
	public void setSortState(int sortState) {
		this.sortState = sortState;
	}
	public int getSortCode() {
		return sortCode;
	}
	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}
	public CommoditySort(int sortId, int commodityId, String sortName, int sortState, int sortCode) {
		super();
		this.sortId = sortId;
		this.commodityId = commodityId;
		this.sortName = sortName;
		this.sortState = sortState;
		this.sortCode = sortCode;
	}
	public CommoditySort() {
		super();
	}
	
}
