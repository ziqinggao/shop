package com.dirsir.dao.entities;

public class CommodityType {
	private int typeId;
	private String typeName;
	private String typeDescribe;
	private int typeState;
	private int sortCode;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescribe() {
		return typeDescribe;
	}
	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe;
	}
	public int getTypeState() {
		return typeState;
	}
	public void setTypeState(int typeState) {
		this.typeState = typeState;
	}
	public int getSortCode() {
		return sortCode;
	}
	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}
	public CommodityType(int typeId, String typeName, String typeDescribe, int typeState, int sortCode) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDescribe = typeDescribe;
		this.typeState = typeState;
		this.sortCode = sortCode;
	}
	public CommodityType() {
		super();
	}
	
}
