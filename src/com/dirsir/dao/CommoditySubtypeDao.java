package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySubtype;

public interface CommoditySubtypeDao {
	//通过类型ID来寻找所有的详细类型信息
	public List<CommoditySubtype> getCommoditySubtypeAllByTypeId(int typeId)throws Exception;
	
	//获取所有的类型Id
	public List<CommoditySubtype> getCommoditySubtypeAll()throws Exception; 
}
