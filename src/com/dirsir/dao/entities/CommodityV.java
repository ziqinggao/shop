package com.dirsir.dao.entities;

public class CommodityV {
	private int commodityId;
	private String commodityName;
	private String commodityDescribe;
	private double price;
	private double vipPrice;
	private String subtypeName;
	private String subtypeDescribe;
	private int subtypeState;
	private String typeName;
	private String typeDescribe;
	private int typeState;
	private String merchantName;
	private int recordState;
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
	public String getSubtypeName() {
		return subtypeName;
	}
	public void setSubtypeName(String subtypeName) {
		this.subtypeName = subtypeName;
	}
	public String getSubtypeDescribe() {
		return subtypeDescribe;
	}
	public void setSubtypeDescribe(String subtypeDescribe) {
		this.subtypeDescribe = subtypeDescribe;
	}
	public int getSubtypeState() {
		return subtypeState;
	}
	public void setSubtypeState(int subtypeState) {
		this.subtypeState = subtypeState;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescribe() {
		return typeDescribe;
	}
	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe;
	}
	public int getTypeState() {
		return typeState;
	}
	public void setTypeState(int typeState) {
		this.typeState = typeState;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public int getRecordState() {
		return recordState;
	}
	public void setRecordState(int recordState) {
		this.recordState = recordState;
	}
	public CommodityV(int commodityId, String commodityName, String commodityDescribe, double price, double vipPrice,
			String subtypeName, String subtypeDescribe, int subtypeState, String typeName, String typeDescribe,
			int typeState, String merchantName, int recordState) {
		super();
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityDescribe = commodityDescribe;
		this.price = price;
		this.vipPrice = vipPrice;
		this.subtypeName = subtypeName;
		this.subtypeDescribe = subtypeDescribe;
		this.subtypeState = subtypeState;
		this.typeName = typeName;
		this.typeDescribe = typeDescribe;
		this.typeState = typeState;
		this.merchantName = merchantName;
		this.recordState = recordState;
	}
	public CommodityV() {
		super();
		// TODO Auto-generated constructor stub
	}
}
