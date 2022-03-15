package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.EvaluateV;

public interface EvaluateVDao {
	//根据商家显示所有的评价信息
	public List<EvaluateV> getEvaluateVByMerchantId(int merchantId) throws Exception;
	
	//根据商品显示所有的评价分页查询(分页查询)
	public List<EvaluateV> getEvaluateVByCommodityNameAndMerchantId(String CommodityName,int merchantId,int pages)throws Exception;
	
	//根据商品显示所有的评价分页查询笔数(分页查询)
	public int getMaxPageByCommodityNameAndMerchantId(String CommodityName,int merchantId)throws Exception;
	
	//过滤无效评价(分页查询)
	public List<EvaluateV> getEvaluateVByCommodityNameAndMerchantId(String CommodityName,int merchantId,int pages,int vaild)throws Exception;
	
	//过滤无效评价(分页查询)
	public int  getMaxPageByCommodityNameAndMerchantId(String CommodityName,int merchantId,int vaild)throws Exception;
	
	//根据商品Id获取所有的评价数量
	public int getEvaluateVNumByCommodityId(int commodityId) throws Exception;

	//根据商品Id获取所有的评价
	public List<EvaluateV> getEvaluateVByCommodityId(int commodityId) throws Exception;
	
	//按照最新的评价和Id显示所有的评价
	public List<EvaluateV> getEvaluateVByCommodityIdOrderByDate(int commodityId)throws Exception;
	
	//根据商品Id获取全部过滤的评价
	public List<EvaluateV> getEvaluateVByCommodityIdAndFilter(int commodityId) throws Exception;
	//根据商品Id获取全部过滤的评价并按照时间排序
	public List<EvaluateV> getEvaluateVByCommodityIdAndFilterOrderByDate(int commodityId) throws Exception;
}
