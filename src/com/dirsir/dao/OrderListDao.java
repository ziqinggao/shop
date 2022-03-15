package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.dao.entities.ShoppingCartV;

public interface OrderListDao {
	
	//��ѯ���û���Ĭ�ϵ�ַ
	public AccountLocation getDefaultLocation(int accountId) throws Exception;
	
	//��ѯ���û������е�ַ
	public List<AccountLocation> getLocations(int accountId) throws Exception;
	
	//�û������µĵ�ַ
	public void doInsLocation(AccountLocation accountLocation) throws Exception;
	
	//��Ҫ���ύ�Ķ�������Ϣ
	public ShoppingCartV getShoppingCartVInfo(int cartId) throws Exception;
	
	
}
