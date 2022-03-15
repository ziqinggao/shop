package com.dirsir.dao.entities;

public class ShoppingCart {
	private int cartId;
	private int accountId;
	private int commodityId;
	private String subsort;
	private int commodityNumber;
	private double commodityPrice;
	private double commodityPrices;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	public ShoppingCart(int cartId, int accountId, int commodityId, String subsort, int commodityNumber,
			double commodityPrice, double commodityPrices) {
		super();
		this.cartId = cartId;
		this.accountId = accountId;
		this.commodityId = commodityId;
		this.subsort = subsort;
		this.commodityNumber = commodityNumber;
		this.commodityPrice = commodityPrice;
		this.commodityPrices = commodityPrices;
	}
	public ShoppingCart() {
		super();
	}
	
}
