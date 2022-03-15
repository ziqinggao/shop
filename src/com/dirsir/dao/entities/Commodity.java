package com.dirsir.dao.entities;

public class Commodity {
	private int commodityId;
	private String commodityName;
	private String commodityDescribe;
	private double price;
	private double vipPrice;
	private int subtypeId;
	private int merchantId;
	private int saleInfo;
	private int checkInfo;
	private String checkDate;
	private int adminId;
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getCommodityDescribe() {
		return commodityDescribe;
	}
	public void setCommodityDescribe(String commodityDescribe) {
		this.commodityDescribe = commodityDescribe;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public int getSubtypeId() {
		return subtypeId;
	}
	public void setSubtypeId(int subtypeId) {
		this.subtypeId = subtypeId;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getSaleInfo() {
		return saleInfo;
	}
	public void setSaleInfo(int saleInfo) {
		this.saleInfo = saleInfo;
	}
	public int getCheckInfo() {
		return checkInfo;
	}
	public void setCheckInfo(int checkInfo) {
		this.checkInfo = checkInfo;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public Commodity(int commodityId, String commodityName, String commodityDescribe, double price, double vipPrice,
			int subtypeId, int merchantId, int saleInfo, int checkInfo, String checkDate, int adminId) {
		super();
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityDescribe = commodityDescribe;
		this.price = price;
		this.vipPrice = vipPrice;
		this.subtypeId = subtypeId;
		this.merchantId = merchantId;
		this.saleInfo = saleInfo;
		this.checkInfo = checkInfo;
		this.checkDate = checkDate;
		this.adminId = adminId;
	}
	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
