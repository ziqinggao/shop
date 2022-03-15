package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySubsort;

public interface CommoditySubsortDao {
	//通过类别ID获取详细类别信息
	public List<CommoditySubsort> getCommoditySubsortBySortId(int sortId) throws Exception;
	
	//添加新的详细类别
	public void doInsCommoditySubsort(CommoditySubsort commoditySubsort) throws Exception;
	
	//修改详细类别
	public void doUpdCommoditySunsort(CommoditySubsort commoditySubsort	) throws Exception;
	
	//修改详细类别状态
	public void doUpdSubsortStateBySubsortId(int subsortState,int subsortId) throws Exception;
	
	//通过subsortId来获取单个详细类别信息
	public CommoditySubsort getCommoditySubsortBySubsortId(int subsortId) throws Exception;
	
	//通过subsortId来删除数据
	public void doDelCommoditySubsortBySubsortId(int subsortId) throws Exception;
	
	//根据商品id获取详细类别
	public List<String> getSubsortByCommodityId(int commodityId) throws Exception;
}
