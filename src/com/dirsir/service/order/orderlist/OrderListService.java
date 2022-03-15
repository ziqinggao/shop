package com.dirsir.service.order.orderlist;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.dao.entities.ShoppingCartV;
import com.dirsir.dao.factory.OrderListDaoFactory;
import com.dirsir.util.UtilConnection;

public class OrderListService {
	
	public AccountLocation getDefaultLocation(int accountId) {
		Connection conn = UtilConnection.getMySQLConnection();
		AccountLocation accountLocation = null;
		try {
			accountLocation = OrderListDaoFactory.getOrderListInstance(conn).getDefaultLocation(accountId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accountLocation;
	}
	
	public List<AccountLocation> getLocation(int accountId){
		List<AccountLocation> listLocation = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			listLocation = OrderListDaoFactory.getOrderListInstance(conn).getLocations(accountId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listLocation;
		
	}
	
	public void doInsLocation(AccountLocation accountLocation) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			OrderListDaoFactory.getOrderListInstance(conn).doInsLocation(accountLocation);
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
	
	public ShoppingCartV getShoppingCartVInfo(int cartId) {
		ShoppingCartV shoppingCartV = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			shoppingCartV = OrderListDaoFactory.getOrderListInstance(conn).getShoppingCartVInfo(cartId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shoppingCartV;
	}
}
