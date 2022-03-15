package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.ShoppingCart;
import com.dirsir.dao.entities.ShoppingCartV;
import com.dirsir.dao.entities.commodity.CommoditySubsort;

public interface ShoppingCartDao {
	//ͨ����Ʒ������ƷId
	public ShoppingCart getShoppingCartByCommodityIdAndAccountIdAndSubsort(int commodityId ,int accountId, String subSort) throws Exception;		
	
	//�޸Ĺ��ﳵ
	public void doUpdShoppingCart(ShoppingCart shopping) throws Exception;
	
	//��ӹ��ﳵ
	public void doInsShoppingCart(ShoppingCart shopping) throws Exception;
	
	//ͨ���û�Id��ȡ���ﳵ����
	public int getCartSbyAccountId(int accountId) throws Exception;
	
	//��ѯ���ﳵ�в��ܱ��ı����Ϣ
	public List<ShoppingCartV> getShoppingCartV(int accountId) throws Exception;
	
	//��ѯ���ﳵ����Ϣ
	public List<ShoppingCart> getShoppingCart(int cartId) throws Exception;
	
	//������Ʒ��ѯ���
	public List<CommoditySort> getSortByCommodityId(int commodityId) throws Exception;
	
	//��ѯ��Ʒ����ϸ���
	public List<CommoditySubsort> getSubsortBySortId(CommoditySort sort) throws Exception;
	
	//�Ȳ�ѯ�����ﳵ�������е��̼�id(ȥ��)
	public List<Integer> getMerchantId(int accountId) throws Exception;
	
	//��ѯ�����̼ҹ��ﳵ�����������Ʒ
	public List<ShoppingCartV> getShoppingCartVByMerchantId(int merchantId) throws Exception;
	
	//Ȼ����ݲ�ͬ�̼�id��ѯ���̼ҵ�������Ʒ���뵽һ��list��Ȼ��Ѷ��list����ͬһ��list��
	public List<List<ShoppingCartV>> getShoppingCartVList(int accountId) throws Exception;
	
	//��ѯ��Ʒ�����
	public List< List<CommoditySubsort>> getSortAndSubsort(int commodityId) throws Exception;
	
	//��ѯ��Ʒ�Ŀ�棬������Ʒ��ϸ��������жϿ��
	public int getCheckRepertory(String subsort) throws Exception;
	
	//���ݹ��ﳵ���id�޸���Ʒ�������Լ��޸���Ʒ���ܼ�
	public void doUpdCommodityNumberAndPrices(int cartId,int commodityNumber) throws Exception;
	
	//���ݹ��ﳵ��Idɾ�����ﳵ�������Ʒ
	public void doDelCartId(int cartId) throws Exception;
	
	//�޸���Ʒ�����
	public void doUpaSubsort(int cartId,String subsort) throws Exception;
}
