package com.dirsir.dao.entities;

public class CommodityInfo {
	private int commodityId;
	private String commodityName;
	private String commodityDescribe;
	private double price;
	private double vipPrice;
	private int subtypId;
	private int saleInfo;
	private int checkInfo;
	private String checkDate;
	private int adminId;
	private int merchantId;
	private String merchantName;
	private int pictureId;
	private int pictureType;
	private String pictureUrl;
	private int picsortCode;
	private int pictureState;
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
	public int getSubtypId() {
		return subtypId;
	}
	public void setSubtypId(int subtypId) {
		this.subtypId = subtypId;
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
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public int getPictureType() {
		return pictureType;
	}
	public void setPictureType(int pictureType) {
		this.pictureType = pictureType;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public int getPicsortCode() {
		return picsortCode;
	}
	public void setPicsortCode(int picsortCode) {
		this.picsortCode = picsortCode;
	}
	public int getPictureState() {
		return pictureState;
	}
	public void setPictureState(int pictureState) {
		this.pictureState = pictureState;
	}
	public CommodityInfo(int commodityId, String commodityName, String commodityDescribe, double price, double vipPrice,
			int subtypId, int saleInfo, int checkInfo, String checkDate, int adminId, int merchantId,
			String merchantName, int pictureId, int pictureType, String pictureUrl, int picsortCode, int pictureState) {
		super();
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityDescribe = commodityDescribe;
		this.price = price;
		this.vipPrice = vipPrice;
		this.subtypId = subtypId;
		this.saleInfo = saleInfo;
		this.checkInfo = checkInfo;
		this.checkDate = checkDate;
		this.adminId = adminId;
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.pictureId = pictureId;
		this.pictureType = pictureType;
		this.pictureUrl = pictureUrl;
		this.picsortCode = picsortCode;
		this.pictureState = pictureState;
	}
	public CommodityInfo() {
		super();
	}
	
}
