package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.OrderParticulars;
import com.dirsir.dao.entities.OrderParticularsV;
import com.dirsir.dao.entities.Repertory;
import com.dirsir.dao.entities.RepertoryV;

public interface StorageDao {
	
	//根据商家id查询所有商品的Id
	public List<Integer> getCommodityById(int merchantId) throws Exception;
	
	//根据通过所有的商品Id获取到所有该商家的订单详情表
	/*public List<OrderParticulars> getOrderParticulars(int commodityId) throws Exception;*/
	
	//根据商家Id查询订单详情
	public List<OrderParticulars> getOrderparticulars(int merchantId) throws Exception;
	
	//根据视图查询订单数据
	public List<OrderParticularsV> getOrderParticularsV(int merchantId,int limit) throws Exception;
	
	//修改销售清单的订单状态
	public void doUpdOrderParticulars(int particularsId,int state) throws Exception;
	
	//根据订单状态查询销售清单
	public List<OrderParticularsV> getOrderParticularsVByState(int merchantId,int state,int limit) throws Exception;
	
	//根据发货日期查询订单
	public List<OrderParticularsV> getOrderParticularsVByDate(int merchantId,String sendDate,int limit) throws Exception;
	
	//根据视图查询订单数据,返回有多少条数据
	public int getCountOrderParticularsV(int merchantId) throws Exception;
	
	//订单状态查询订单数据,返回有多少条数据
	public int getCountOrderParticularsVByState(int merchantId,int state) throws Exception;
	
	//发货日期查询数据，返回共有多少条数据
	public int getCountOrderParticularsVBytDate(int merchantId,String sendDate) throws Exception;
	
	//1、根据商家id查询所有的商品Id
	public List<Integer> getCommodityId(int merchantId) throws Exception;
	
	//根据商品Id查询商品的类别id
	public List<Integer> getsortId(int commodityId) throws Exception;
	
	//2、根据商品id查出所有的类别id	
	public List<Integer> getSortId(List<Integer> commodityIdList) throws Exception;
	
	//3、根据sortId查询出所有的细类
	public List<Repertory> doCheckRepertory(List<Integer> commodityIdList) throws Exception;
	
	//根据商家Id并查询所有审核通过的产品的Id,根据商品Id查询该商品所有的类别Id
	public List<Integer> getCommoditySortId(int merchantId) throws Exception;
	
	//循环根据 sort_id 查询所有的细类并且进行内容拼凑,把sortId循环放入进行查询，动态增加sortId查询的次数
	public List<Repertory> checkRepertory(List<Integer> intList) throws Exception;
	
	//将查询到的所有信息放入到盘点库存表中
	public void doInsRepertory(int merchantId) throws Exception;
	
	//传入日期进行查询是否有盘点信息repertory
	public List<Repertory> getRepertory(String checkDate,int merchantId) throws Exception;
	
	//删除查询日期的所有信息
	public void doDelRepertory(String checkDate,int merchantId) throws Exception;
	
	//根据视图查询日期的信息
	public List<RepertoryV> getRepertoryV(String checkDate,int merchantId) throws Exception;
	
	//修改盘点库存
	public void doUpdRepertory(int repertoryId,int checkRepertory) throws Exception;
	
}
