package com.dirsir.dao.entities;
//进货清单
public class CommodityStock {
	private int stockId;
	private int merchantId;
	private int commodityId;
	private String subsort;
	private int stockNumber;
	private double stockPrice;
	private double stockPrices;
	private String procurement;
	private String buystockDate;
	private String supplier;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
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
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public double getStockPrices() {
		return stockPrices;
	}
	public void setStockPrices(double stockPrices) {
		this.stockPrices = stockPrices;
	}
	public String getProcurement() {
		return procurement;
	}
	public void setProcurement(String procurement) {
		this.procurement = procurement;
	}
	public String getBuystockDate() {
		return buystockDate;
	}
	public void setBuystockDate(String buystockDate) {
		this.buystockDate = buystockDate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public CommodityStock(int stockId, int merchantId, int commodityId, String subsort, int stockNumber,
			double stockPrice, double stockPrices, String procurement, String buystockDate, String supplier) {
		super();
		this.stockId = stockId;
		this.merchantId = merchantId;
		this.commodityId = commodityId;
		this.subsort = subsort;
		this.stockNumber = stockNumber;
		this.stockPrice = stockPrice;
		this.stockPrices = stockPrices;
		this.procurement = procurement;
		this.buystockDate = buystockDate;
		this.supplier = supplier;
	}
	public CommodityStock() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
