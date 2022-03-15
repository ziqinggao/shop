package com.dirsir.dao.entities;

public class EvaluateV {
	private int evaluateId;
	private int commodityScore;
	private int logisticScore;
	private int serviceScore;
	private String evaluate;
	private String evlauateDate;
	private int particularsId;
	private String subsort;
	private int state;
	private int commodityId;
	private String commodityName;
	private int merchantId;
	private int orderId;
	private String orderNumber;
	private int accountId;
	private String accountName;
	
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	public int getCommodityScore() {
		return commodityScore;
	}
	public void setCommodityScore(int commodityScore) {
		this.commodityScore = commodityScore;
	}
	public int getLogisticScore() {
		return logisticScore;
	}
	public void setLogisticScore(int logisticScore) {
		this.logisticScore = logisticScore;
	}
	public int getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(int serviceScore) {
		this.serviceScore = serviceScore;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getEvlauateDate() {
		return evlauateDate;
	}
	public void setEvlauateDate(String evlauateDate) {
		this.evlauateDate = evlauateDate;
	}
	public int getParticularsId() {
		return particularsId;
	}
	public void setParticularsId(int particularsId) {
		this.particularsId = particularsId;
	}
	public String getSubsort() {
		return subsort;
	}
	public void setSubsort(String subsort) {
		this.subsort = subsort;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public EvaluateV(int evaluateId, int commodityScore, int logisticScore, int serviceScore, String evaluate,
			String evlauateDate, int particularsId, String subsort, int state, int commodityId, String commodityName,
			int merchantId, int orderId, String orderNumber, int accountId, String accountName) {
		super();
		this.evaluateId = evaluateId;
		this.commodityScore = commodityScore;
		this.logisticScore = logisticScore;
		this.serviceScore = serviceScore;
		this.evaluate = evaluate;
		this.evlauateDate = evlauateDate;
		this.particularsId = particularsId;
		this.subsort = subsort;
		this.state = state;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.merchantId = merchantId;
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.accountId = accountId;
		this.accountName = accountName;
	}
	public EvaluateV() {
		super();
	}
}
