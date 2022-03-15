package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.StockVV;

public interface StockVVDao {
	// 通过视图查询信息,分页查询
	public List<StockVV> getStockVVAllByMerchanId(int merchantId, int pages) throws Exception;
    //通过视图 商品ID获取商品类别
	public  List<StockVV> getStockVVSubsortByCommodityId(int commodityid) throws Exception;
	public List<StockVV> getStockVVAllByMerchanId(int merchantid) throws Exception;
}
