package com.dirsir.dao;

import java.util.List;
import com.dirsir.dao.entities.CommodityStock;
import com.dirsir.dao.entities.MerchantRepertory;
import com.dirsir.dao.entities.MerchantReturn;
import com.dirsir.dao.entities.MerchantReturnV;
import com.dirsir.dao.entities.StockVV;

public interface CommodityStockDao {
	// 添加进货清单信息
	public void doInsCommodityStock(CommodityStock commoditystock) throws Exception;

	// 通过商品ID获取商品类别返回list;
	public List<String> getCommodityStockByMerchantId(int commodityid) throws Exception;

	// 通过商家ID进行连接表查询 获取商品名字的集合
	// public List<String> getCommodityNamesSortNameByMerchantId(int merchantId)
	// throws Exception;

	// 通过商家ID进行表查询获取进货表所有信息
	public List<CommodityStock> getCommodityAllByMerchantId(int merchantId) throws Exception;

	// 通过日期查询进货清单
	public List<StockVV> getStockVVBuystockDate(String buystockdate, int merchantid) throws Exception;

	// 修改进货清单
	public void doUpdateCommodityStock(CommodityStock commoditystock) throws Exception;

	// 通过进货ID获取要修改的进货信息
	public CommodityStock getCommodityStockBySortid(int stockid) throws Exception;

	// 通过商家ID获取退货信息
	public List<MerchantReturnV> getMerchantReturnBymerchantid(int merchantid) throws Exception;

	// 通过进货ID修改退货清单
	public void doInsMerchantReturn(MerchantReturn merchantreturn) throws Exception;

	// 通过退货ID获取退货信息
	public MerchantReturn getMerchantReturnByReturnId(int returnid) throws Exception;

	// 修改退货清单信息
	public void UpdataMerchantReturn(MerchantReturn merchantreturn) throws Exception;

	// 显示库存信息
	public List<MerchantRepertory> getMerchantRepertoryByRepertory(int repertoryid) throws Exception;

	// 根据商家ID和日期查询退货日期
	public List<MerchantReturnV> getMerchantReturnByMerchantId(int merchantid, String returndate) throws Exception;
}
