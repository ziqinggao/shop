package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.StockVV;

public interface StockVVDao {
	// ͨ����ͼ��ѯ��Ϣ,��ҳ��ѯ
	public List<StockVV> getStockVVAllByMerchanId(int merchantId, int pages) throws Exception;
    //ͨ����ͼ ��ƷID��ȡ��Ʒ���
	public  List<StockVV> getStockVVSubsortByCommodityId(int commodityid) throws Exception;
	public List<StockVV> getStockVVAllByMerchanId(int merchantid) throws Exception;
}
