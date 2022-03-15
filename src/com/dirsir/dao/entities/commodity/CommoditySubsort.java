package com.dirsir.dao.entities.commodity;

public class CommoditySubsort {
	private int subsortId;
	private int sortId;
	private String subsortName;
	private double subsortPrice;
	private double subsortVipPrice;
	private int subsortState;
	private int subsortCode;
	public int getSubsortId() {
		return subsortId;
	}
	public void setSubsortId(int subsortId) {
		this.subsortId = subsortId;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getSubsortName() {
		return subsortName;
	}
	public void setSubsortName(String subsortName) {
		this.subsortName = subsortName;
	}
	public double getSubsortPrice() {
		return subsortPrice;
	}
	public void setSubsortPrice(double subsortPrice) {
		this.subsortPrice = subsortPrice;
	}
	public double getSubsortVipPrice() {
		return subsortVipPrice;
	}
	public void setSubsortVipPrice(double subsortVipPrice) {
		this.subsortVipPrice = subsortVipPrice;
	}
	public int getSubsortState() {
		return subsortState;
	}
	public void setSubsortState(int subsortState) {
		this.subsortState = subsortState;
	}
	public int getSubsortCode() {
		return subsortCode;
	}
	public void setSubsortCode(int subsortCode) {
		this.subsortCode = subsortCode;
	}
	public CommoditySubsort(int subsortId, int sortId, String subsortName, double subsortPrice, double subsortVipPrice,
			int subsortState, int subsortCode) {
		super();
		this.subsortId = subsortId;
		this.sortId = sortId;
		this.subsortName = subsortName;
		this.subsortPrice = subsortPrice;
		this.subsortVipPrice = subsortVipPrice;
		this.subsortState = subsortState;
		this.subsortCode = subsortCode;
	}
	public CommoditySubsort() {
		super();
	}
	@Override
	public String toString() {
		return "CommoditySubsort [subsortId=" + subsortId + ", sortId=" + sortId + ", subsortName=" + subsortName
				+ ", subsortPrice=" + subsortPrice + ", subsortVipPrice=" + subsortVipPrice + ", subsortState="
				+ subsortState + ", subsortCode=" + subsortCode + "]";
	}
	
}
