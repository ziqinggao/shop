package com.dirsir.dao.entities;

public class ShoppingCartV {
	private int cartId;
	private int accountId;
	private int commodityId;
	private int merchantId;
	private String subsort;
	private int commodityNumber;
	private double commodityPrice;
	private double commodityPrices;
	private String merchantName;
	private String commodityName;
	private double price;
	private double vipPrice;
	private String pictureUrl;
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
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
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
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
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public ShoppingCartV(int cartId, int accountId, int commodityId, int merchantId, String subsort,
			int commodityNumber, double commodityPrice, double commodityPrices, String merchantName,
			String commodityName, double price, double vipPrice, String pictureUrl) {
		super();
		this.cartId = cartId;
		this.accountId = accountId;
		this.commodityId = commodityId;
		this.merchantId = merchantId;
		this.subsort = subsort;
		this.commodityNumber = commodityNumber;
		this.commodityPrice = commodityPrice;
		this.commodityPrices = commodityPrices;
		this.merchantName = merchantName;
		this.commodityName = commodityName;
		this.price = price;
		this.vipPrice = vipPrice;
		this.pictureUrl = pictureUrl;
	}
	public ShoppingCartV() {
		super();
	}
	@Override
	public String toString() {
		return "ShoppingCartV [cartId=" + cartId + ", accountId=" + accountId + ", commodityId=" + commodityId
				+ ", merchantId=" + merchantId + ", subsort=" + subsort + ", commodityNumber=" + commodityNumber
				+ ", commodityPrice=" + commodityPrice + ", commodityPrices=" + commodityPrices + ", merchantName="
				+ merchantName + ", commodityName=" + commodityName + ", price=" + price + ", vipPrice=" + vipPrice
				+ ", pictureUrl=" + pictureUrl + "]";
	}
	
}
