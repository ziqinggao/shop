package com.dirsir.dao.entities;

//退货清单
public class MerchantReturnV {
	private int merchantId;
	private int stockId;
	private int returnId;
	private String commodityName;
	private String subsort;
	private int returnNumber;
	private double returnPrice;
	private double returnPrices;
	private String returnCause;
	private String buystockDate;
	private String returnDate;
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getSubsort() {
		return subsort;
	}
	public void setSubsort(String subsort) {
		this.subsort = subsort;
	}
	public int getReturnNumber() {
		return returnNumber;
	}
	public void setReturnNumber(int returnNumber) {
		this.returnNumber = returnNumber;
	}
	public double getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(double returnPrice) {
		this.returnPrice = returnPrice;
	}
	public double getReturnPrices() {
		return returnPrices;
	}
	public void setReturnPrices(double returnPrices) {
		this.returnPrices = returnPrices;
	}
	public String getReturnCause() {
		return returnCause;
	}
	public void setReturnCause(String returnCause) {
		this.returnCause = returnCause;
	}
	public String getBuystockDate() {
		return buystockDate;
	}
	public void setBuystockDate(String buystockDate) {
		this.buystockDate = buystockDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public MerchantReturnV(int merchantId, int stockId, int returnId, String commodityName, String subsort,
			int returnNumber, double returnPrice, double returnPrices, String returnCause, String buystockDate,
			String returnDate) {
		super();
		this.merchantId = merchantId;
		this.stockId = stockId;
		this.returnId = returnId;
		this.commodityName = commodityName;
		this.subsort = subsort;
		this.returnNumber = returnNumber;
		this.returnPrice = returnPrice;
		this.returnPrices = returnPrices;
		this.returnCause = returnCause;
		this.buystockDate = buystockDate;
		this.returnDate = returnDate;
	}
	public MerchantReturnV() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
	
}
