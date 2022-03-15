package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Commodity;

public interface CommodityDao {
	//ͨ���̼�ID��ȡ���������е���Ʒ��Ϣ
	public List<Commodity> getCommodityAllByMerchantId(int merchantId) throws Exception;
	
	//�����Ʒ��Ϣ
	public void doInsCommodity(Commodity commodity)throws Exception;
	
	//ͨ����Ʒ��������ѯ��Ʒ��ҳ��ѯ��Ĭ��10������һҳ��
	public List<Commodity> getCommodityAllByCommodityNameLimit(String commodityName,int merchantId,int pages )throws Exception;
	
	//��ȡ���в�ѯ����
	public int getSearchNumByCommodityName(String commodityName,int merchantId)throws Exception;
	
	//�޸�����״̬
	public void doUpdSaleStateByMerchantIDAndCommodityIdAndSaleState(int merchantId,int commodityId,int saleState) throws Exception;
	
	//�޸���Ʒ��Ϣ
	public void doUpdCommodityInfo(Commodity commodity) throws Exception;
	
	//��������
	//��ȡ�����ϼܵ���Ʒ
	public List<Commodity> getNewCommodity()throws Exception;
	
	//ͨ����Ʒ��ȡ��Ʒ��ϸ��Ϣ
	public Commodity getCommodityInfoByCommodityId( int commodityId)throws Exception;
	
	//ͨ����ƷId��ȡ������
	public int getSaleNumbyCommodityId(int commodityId) throws Exception;
	
}

