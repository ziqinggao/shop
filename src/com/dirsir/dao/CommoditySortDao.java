package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySort;

public interface CommoditySortDao {
	//��ȡ���е������Ϣ
	public List<CommoditySort> getCommoditySortAll(int commodityId) throws Exception;
	
	//����µ����
	public void doInsCommoditySort(CommoditySort commoditySort)throws Exception;
	
	//�޸����
	public void doUpdCommoditySort(CommoditySort commoditySort)throws Exception;
	
	//ͨ�����ID��ȡ�������
	public CommoditySort getCommoditySortBySortId(int sortId)throws Exception;
	
	//ɾ������
	public void doDelCommoditySortBysortId(int sortId) throws Exception;
	
	//ͨ���̼�Id����ƷId������id
	public List<Integer> getSortIdByCommodityIdAndMerchantId(int commodityId)throws Exception;
	
	//ͨ����ƷID��ȡ��Ʒ���
	public List<CommoditySort> getCommoditySotrByCommodityId(int commodityid) throws Exception;
	
	//ͨ����ϸ���id��ȡ�������
	public List<String> getSortNameBySubsortId(int subsortId)throws Exception;
}
