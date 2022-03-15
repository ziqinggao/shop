package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySubsort;

public interface CommoditySubsortDao {
	//ͨ�����ID��ȡ��ϸ�����Ϣ
	public List<CommoditySubsort> getCommoditySubsortBySortId(int sortId) throws Exception;
	
	//����µ���ϸ���
	public void doInsCommoditySubsort(CommoditySubsort commoditySubsort) throws Exception;
	
	//�޸���ϸ���
	public void doUpdCommoditySunsort(CommoditySubsort commoditySubsort	) throws Exception;
	
	//�޸���ϸ���״̬
	public void doUpdSubsortStateBySubsortId(int subsortState,int subsortId) throws Exception;
	
	//ͨ��subsortId����ȡ������ϸ�����Ϣ
	public CommoditySubsort getCommoditySubsortBySubsortId(int subsortId) throws Exception;
	
	//ͨ��subsortId��ɾ������
	public void doDelCommoditySubsortBySubsortId(int subsortId) throws Exception;
	
	//������Ʒid��ȡ��ϸ���
	public List<String> getSubsortByCommodityId(int commodityId) throws Exception;
}
