package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommodityType;

public interface CommodityTypeDao {

	//获取所有的类型名称
	public List<CommodityType> getCommodityTypeAll() throws Exception;
	
}
