package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommodityInfo;

public interface CommodityInfoDao {
	//��ȡ�����ϼܵ���Ʒ
	public List<CommodityInfo> getNewCommodityInfo() throws Exception;
	
	//������ƷID�����Ʒ��ϸ��Ϣ
	public List<CommodityInfo> getCommodityInfoByCommodityId(int commodityId)throws Exception;
	
	//������ƷId��ȡ5����ͬ���͵���Ʒ
	public List<CommodityInfo> getSimilarityCommodityInfoByCommodityId(int commodityId) throws Exception;
	
	//��ϸ���Id����ȡ���е���Ʒ
	public List<CommodityInfo> getCommodityInfoBySubsortId(int subSortId) throws Exception; 
	
	//ͨ����ϸ����ȡ�̼�����
	public List<String> getMerchantNameBySubsortId(int subSortId)throws Exception;
	
	
	
}
