package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySort;

public interface CommoditySortDao {
	//获取所有的类别信息
	public List<CommoditySort> getCommoditySortAll(int commodityId) throws Exception;
	
	//添加新的类别
	public void doInsCommoditySort(CommoditySort commoditySort)throws Exception;
	
	//修改类别
	public void doUpdCommoditySort(CommoditySort commoditySort)throws Exception;
	
	//通过类别ID获取类别详情
	public CommoditySort getCommoditySortBySortId(int sortId)throws Exception;
	
	//删除数据
	public void doDelCommoditySortBysortId(int sortId) throws Exception;
	
	//通过商家Id和商品Id获得类别id
	public List<Integer> getSortIdByCommodityIdAndMerchantId(int commodityId)throws Exception;
	
	//通过商品ID获取商品类别
	public List<CommoditySort> getCommoditySotrByCommodityId(int commodityid) throws Exception;
	
	//通过详细类别id获取类别名称
	public List<String> getSortNameBySubsortId(int subsortId)throws Exception;
}
