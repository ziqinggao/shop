package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.ShoppingCart;
import com.dirsir.dao.entities.ShoppingCartV;
import com.dirsir.dao.entities.commodity.CommoditySubsort;

public interface ShoppingCartDao {
	//通过商品类别和商品Id
	public ShoppingCart getShoppingCartByCommodityIdAndAccountIdAndSubsort(int commodityId ,int accountId, String subSort) throws Exception;		
	
	//修改购物车
	public void doUpdShoppingCart(ShoppingCart shopping) throws Exception;
	
	//添加购物车
	public void doInsShoppingCart(ShoppingCart shopping) throws Exception;
	
	//通过用户Id获取购物车数量
	public int getCartSbyAccountId(int accountId) throws Exception;
	
	//查询购物车中不能被改变的信息
	public List<ShoppingCartV> getShoppingCartV(int accountId) throws Exception;
	
	//查询购物车的信息
	public List<ShoppingCart> getShoppingCart(int cartId) throws Exception;
	
	//根据商品查询类别
	public List<CommoditySort> getSortByCommodityId(int commodityId) throws Exception;
	
	//查询商品的详细类别
	public List<CommoditySubsort> getSubsortBySortId(CommoditySort sort) throws Exception;
	
	//先查询出购物车表中所有的商家id(去重)
	public List<Integer> getMerchantId(int accountId) throws Exception;
	
	//查询单个商家购物车里面的所有商品
	public List<ShoppingCartV> getShoppingCartVByMerchantId(int merchantId) throws Exception;
	
	//然后根据不同商家id查询该商家的所有商品放入到一个list中然后把多个list放入同一个list中
	public List<List<ShoppingCartV>> getShoppingCartVList(int accountId) throws Exception;
	
	//查询商品的类别
	public List< List<CommoditySubsort>> getSortAndSubsort(int commodityId) throws Exception;
	
	//查询商品的库存，根据商品详细类别名字判断库存
	public int getCheckRepertory(String subsort) throws Exception;
	
	//根据购物车表的id修改商品数量，以及修改商品的总价
	public void doUpdCommodityNumberAndPrices(int cartId,int commodityNumber) throws Exception;
	
	//根据购物车的Id删除购物车里面的商品
	public void doDelCartId(int cartId) throws Exception;
	
	//修改商品的类别
	public void doUpaSubsort(int cartId,String subsort) throws Exception;
}
