package com.dirsir.service.order.shoppingcart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.ShoppingCartV;
import com.dirsir.dao.entities.commodity.CommoditySubsort;
import com.dirsir.dao.factory.ShoppingCartDaoFactory;
import com.dirsir.util.UtilConnection;

public class ShoppingCartService {
	public static void main(String[] args) {
		Connection conn = UtilConnection.getMySQLConnection();
		List<List<CommoditySubsort>> list = null;
		int commodityId = 5;
		try {
			list = ShoppingCartDaoFactory.getShoppingCart(conn).getSortAndSubsort(commodityId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	public List<ShoppingCartV> getShoppingCartV(int accountId){
		List<ShoppingCartV> cartVList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			cartVList = ShoppingCartDaoFactory.getShoppingCart(conn).getShoppingCartV(accountId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartVList;
	}
	
	public List<CommoditySort> getCommoditySort(int commodityId){
		List<CommoditySort> sortList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			sortList = ShoppingCartDaoFactory.getShoppingCart(conn).getSortByCommodityId(commodityId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sortList;
	}
	

	public List<List<ShoppingCartV>> getShoppingCartVList(int accountId){
		Connection conn = UtilConnection.getMySQLConnection();
		List<List<ShoppingCartV>> list = null;
		try {
			list = ShoppingCartDaoFactory.getShoppingCart(conn).getShoppingCartVList(accountId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<List<CommoditySubsort>> getSortAndSubsort(int commodityId){
		Connection conn = UtilConnection.getMySQLConnection();
		List<List<CommoditySubsort>> list = null;
		try {
			list = ShoppingCartDaoFactory.getShoppingCart(conn).getSortAndSubsort(commodityId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean doUpdCommodityNumberAndPrices(String subsort,int cartId,int commodityNumber) {
		boolean flag = false;
		Connection conn = UtilConnection.getMySQLConnection();
		int x = 0;
		try {
			conn.setAutoCommit(false);
			x = ShoppingCartDaoFactory.getShoppingCart(conn).getCheckRepertory(subsort);
			if(commodityNumber > x) {
				x = 1/0;
			}else if(commodityNumber < 0) {
				x = 1/0;
			}else {
				ShoppingCartDaoFactory.getShoppingCart(conn).doUpdCommodityNumberAndPrices(cartId, commodityNumber);
			}
			conn.commit();
			flag = true;
		} catch (Exception e) {
			try {
				flag = false;
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public void doDelShoppingCart(int cartId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			ShoppingCartDaoFactory.getShoppingCart(conn).doDelCartId(cartId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean doUpdSubsort(int cartId,String subsort) {
		boolean flag = false;
		Connection conn = UtilConnection.getMySQLConnection();
		int x = 0;
		try {
			conn.setAutoCommit(false);
			x = ShoppingCartDaoFactory.getShoppingCart(conn).getCheckRepertory(subsort);
			if(x <= 0) {
				x = 1/0;
			}else {
				ShoppingCartDaoFactory.getShoppingCart(conn).doUpaSubsort(cartId, subsort);
			}
			conn.commit();
			flag = true;
		} catch (Exception e) {
			try {
				conn.rollback();
				flag = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
