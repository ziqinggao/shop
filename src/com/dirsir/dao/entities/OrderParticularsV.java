package com.dirsir.dao.entities;

public class OrderParticularsV {
	private int particularsId;
	private int orderId;
	private int commodityId;
	private String subsort;
	private int commodityNumber;
	private double commodityPrice;
	private double commodityPrices;
	private String buyDate;
	private int state;
	private String location;
	private String sendDate;
	public OrderParticularsV(int particularsId, int orderId, int commodityId, String subsort, int commodityNumber,
			double commodityPrice, double commodityPrices, String buyDate, int state, String location,
			String sendDate) {
		super();
		this.particularsId = particularsId;
		this.orderId = orderId;
		this.commodityId = commodityId;
		this.subsort = subsort;
		this.commodityNumber = commodityNumber;
		this.commodityPrice = commodityPrice;
		this.commodityPrices = commodityPrices;
		this.buyDate = buyDate;
		this.state = state;
		this.location = location;
		this.sendDate = sendDate;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public int getParticularsId() {
		return particularsId;
	}
	public void setParticularsId(int particularsId) {
		this.particularsId = particularsId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getCommodityNumber() {
		return commodityNumber;
	}
	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}
	public double getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public double getCommodityPrices() {
		return commodityPrices;
	}
	public void setCommodityPrices(double commodityPrices) {
		this.commodityPrices = commodityPrices;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public OrderParticularsV() {
		super();
	}
	
}
