package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.EvaluateV;

public interface EvaluateVDao {
	//�����̼���ʾ���е�������Ϣ
	public List<EvaluateV> getEvaluateVByMerchantId(int merchantId) throws Exception;
	
	//������Ʒ��ʾ���е����۷�ҳ��ѯ(��ҳ��ѯ)
	public List<EvaluateV> getEvaluateVByCommodityNameAndMerchantId(String CommodityName,int merchantId,int pages)throws Exception;
	
	//������Ʒ��ʾ���е����۷�ҳ��ѯ����(��ҳ��ѯ)
	public int getMaxPageByCommodityNameAndMerchantId(String CommodityName,int merchantId)throws Exception;
	
	//������Ч����(��ҳ��ѯ)
	public List<EvaluateV> getEvaluateVByCommodityNameAndMerchantId(String CommodityName,int merchantId,int pages,int vaild)throws Exception;
	
	//������Ч����(��ҳ��ѯ)
	public int  getMaxPageByCommodityNameAndMerchantId(String CommodityName,int merchantId,int vaild)throws Exception;
	
	//������ƷId��ȡ���е���������
	public int getEvaluateVNumByCommodityId(int commodityId) throws Exception;

	//������ƷId��ȡ���е�����
	public List<EvaluateV> getEvaluateVByCommodityId(int commodityId) throws Exception;
	
	//�������µ����ۺ�Id��ʾ���е�����
	public List<EvaluateV> getEvaluateVByCommodityIdOrderByDate(int commodityId)throws Exception;
	
	//������ƷId��ȡȫ�����˵�����
	public List<EvaluateV> getEvaluateVByCommodityIdAndFilter(int commodityId) throws Exception;
	//������ƷId��ȡȫ�����˵����۲�����ʱ������
	public List<EvaluateV> getEvaluateVByCommodityIdAndFilterOrderByDate(int commodityId) throws Exception;
}
