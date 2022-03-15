package com.dirsir.dao.entities;

public class AccountLocation {
	private int locationId;
	private int accountId;
	private String provinces;
	private String city;
	private String county;
	private String specificLocation;
	private int defaultLocation;
	private String consignee;
	private String phone;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getProvinces() {
		return provinces;
	}
	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getSpecificLocation() {
		return specificLocation;
	}
	public void setSpecificLocation(String specificLocation) {
		this.specificLocation = specificLocation;
	}
	public int getDefaultLocation() {
		return defaultLocation;
	}
	public void setDefaultLocation(int defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public AccountLocation(int locationId, int accountId, String provinces, String city, String county,
			String specificLocation, int defaultLocation, String consignee, String phone) {
		super();
		this.locationId = locationId;
		this.accountId = accountId;
		this.provinces = provinces;
		this.city = city;
		this.county = county;
		this.specificLocation = specificLocation;
		this.defaultLocation = defaultLocation;
		this.consignee = consignee;
		this.phone = phone;
	}
	public AccountLocation() {
		super();
	}
	
}
