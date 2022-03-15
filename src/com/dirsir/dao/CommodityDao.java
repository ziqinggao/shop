package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Commodity;

public interface CommodityDao {
	//通过商家ID获取店铺中所有的商品信息
	public List<Commodity> getCommodityAllByMerchantId(int merchantId) throws Exception;
	
	//添加商品信息
	public void doInsCommodity(Commodity commodity)throws Exception;
	
	//通过商品名称来查询商品分页查询（默认10个数据一页）
	public List<Commodity> getCommodityAllByCommodityNameLimit(String commodityName,int merchantId,int pages )throws Exception;
	
	//获取所有查询个数
	public int getSearchNumByCommodityName(String commodityName,int merchantId)throws Exception;
	
	//修改销售状态
	public void doUpdSaleStateByMerchantIDAndCommodityIdAndSaleState(int merchantId,int commodityId,int saleState) throws Exception;
	
	//修改商品信息
	public void doUpdCommodityInfo(Commodity commodity) throws Exception;
	
	//卖场方法
	//获取最新上架的商品
	public List<Commodity> getNewCommodity()throws Exception;
	
	//通过商品获取商品详细信息
	public Commodity getCommodityInfoByCommodityId( int commodityId)throws Exception;
	
	//通过商品Id获取销售量
	public int getSaleNumbyCommodityId(int commodityId) throws Exception;
	
}

