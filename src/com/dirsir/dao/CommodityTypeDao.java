package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommodityType;

public interface CommodityTypeDao {

	//��ȡ���е���������
	public List<CommodityType> getCommodityTypeAll() throws Exception;
	
}
