package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.dao.entities.ShoppingCartV;

public interface OrderListDao {
	
	//查询该用户的默认地址
	public AccountLocation getDefaultLocation(int accountId) throws Exception;
	
	//查询该用户的所有地址
	public List<AccountLocation> getLocations(int accountId) throws Exception;
	
	//用户增加新的地址
	public void doInsLocation(AccountLocation accountLocation) throws Exception;
	
	//需要被提交的订单的信息
	public ShoppingCartV getShoppingCartVInfo(int cartId) throws Exception;
	
	
}
