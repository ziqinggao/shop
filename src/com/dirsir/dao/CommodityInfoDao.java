package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommodityInfo;

public interface CommodityInfoDao {
	//获取最新上架的商品
	public List<CommodityInfo> getNewCommodityInfo() throws Exception;
	
	//根据商品ID获得商品详细信息
	public List<CommodityInfo> getCommodityInfoByCommodityId(int commodityId)throws Exception;
	
	//根据商品Id获取5个相同类型的商品
	public List<CommodityInfo> getSimilarityCommodityInfoByCommodityId(int commodityId) throws Exception;
	
	//详细类别Id来获取所有的商品
	public List<CommodityInfo> getCommodityInfoBySubsortId(int subSortId) throws Exception; 
	
	//通过详细类别获取商家名字
	public List<String> getMerchantNameBySubsortId(int subSortId)throws Exception;
	
	
	
}
