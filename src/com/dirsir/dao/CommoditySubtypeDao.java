package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySubtype;

public interface CommoditySubtypeDao {
	//ͨ������ID��Ѱ�����е���ϸ������Ϣ
	public List<CommoditySubtype> getCommoditySubtypeAllByTypeId(int typeId)throws Exception;
	
	//��ȡ���е�����Id
	public List<CommoditySubtype> getCommoditySubtypeAll()throws Exception; 
}
