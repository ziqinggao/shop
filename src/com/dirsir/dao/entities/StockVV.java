package com.dirsir.dao.entities;

//通过视图查询商品进货
public class StockVV {
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
	private String commodityName;
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
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public StockVV(int stockId, int merchantId, int commodityId, String subsort, int stockNumber, double stockPrice,
			double stockPrices, String procurement, String buystockDate, String supplier, String commodityName) {
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
		this.commodityName = commodityName;
	}
	public StockVV() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

}
