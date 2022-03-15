package com.dirsir.dao.entities;

public class CommoditySubtype {
	private int subtypeId;
	private int typeId;
	private String subtypeName;
	private String subtypeDescribe;
	private int subtypeState;
	private int subsortCode;
	public int getSubtypeId() {
		return subtypeId;
	}
	public void setSubtypeId(int subtypeId) {
		this.subtypeId = subtypeId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getSubtypeName() {
		return subtypeName;
	}
	public void setSubtypeName(String subtypeName) {
		this.subtypeName = subtypeName;
	}
	public String getSubtypeDescribe() {
		return subtypeDescribe;
	}
	public void setSubtypeDescribe(String subtypeDescribe) {
		this.subtypeDescribe = subtypeDescribe;
	}
	public int getSubtypeState() {
		return subtypeState;
	}
	public void setSubtypeState(int subtypeState) {
		this.subtypeState = subtypeState;
	}
	public int getSubsortCode() {
		return subsortCode;
	}
	public void setSubsortCode(int subsortCode) {
		this.subsortCode = subsortCode;
	}
	public CommoditySubtype(int subtypeId, int typeId, String subtypeName, String subtypeDescribe, int subtypeState,
			int subsortCode) {
		super();
		this.subtypeId = subtypeId;
		this.typeId = typeId;
		this.subtypeName = subtypeName;
		this.subtypeDescribe = subtypeDescribe;
		this.subtypeState = subtypeState;
		this.subsortCode = subsortCode;
	}
	public CommoditySubtype() {
		super();
	}
	
}
