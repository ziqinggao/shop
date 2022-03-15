package com.dirsir.dao.entities;

public class CommodityPicture {
	private int pictureId;
	private int commodityId;
	private int pictureType;
	private String pictureUrl;
	private int picsortCode;
	private int pictureState;
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public int getPictureType() {
		return pictureType;
	}
	public void setPictureType(int pictureType) {
		this.pictureType = pictureType;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public int getPicsortCode() {
		return picsortCode;
	}
	public void setPicsortCode(int picsortCode) {
		this.picsortCode = picsortCode;
	}
	public int getPictureState() {
		return pictureState;
	}
	public void setPictureState(int pictureState) {
		this.pictureState = pictureState;
	}
	public CommodityPicture(int pictureId, int commodityId, int pictureType, String pictureUrl, int picsortCode,
			int pictureState) {
		super();
		this.pictureId = pictureId;
		this.commodityId = commodityId;
		this.pictureType = pictureType;
		this.pictureUrl = pictureUrl;
		this.picsortCode = picsortCode;
		this.pictureState = pictureState;
	}
	public CommodityPicture() {
		super();
	}
	
}
