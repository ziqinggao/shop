package com.dirsir.dao.entities;
//退货清单
public class MerchantReturn {
	private int returnId;
	private int stockId;
	private String returnCause;
	private String returnDate;
	private int returnNumber;
	private double returnPrice;
	private double returnPrices;
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getReturnCause() {
		return returnCause;
	}
	public void setReturnCause(String returnCause) {
		this.returnCause = returnCause;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
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
	public MerchantReturn(int returnId, int stockId, String returnCause, String returnDate, int returnNumber,
			double returnPrice, double returnPrices) {
		super();
		this.returnId = returnId;
		this.stockId = stockId;
		this.returnCause = returnCause;
		this.returnDate = returnDate;
		this.returnNumber = returnNumber;
		this.returnPrice = returnPrice;
		this.returnPrices = returnPrices;
	}
	public MerchantReturn() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
