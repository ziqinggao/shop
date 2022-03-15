package com.dirsir.service.shoping;

import java.sql.Connection;
import java.sql.SQLException;

import com.dirsir.dao.entities.ShoppingCart;
import com.dirsir.dao.factory.ShoppingCartDaoFactory;
import com.dirsir.util.UtilConnection;

public class ShoppingCartService {
	//通过商品类别和商品Id
	public ShoppingCart getShoppingCartByCommodityIdAndAccountIdAndSubsort(int commodityId,int accountId ,String subSort) {
		Connection conn=UtilConnection.getMySQLConnection();
		ShoppingCart shopping=null;
		try {
			shopping=ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).getShoppingCartByCommodityIdAndAccountIdAndSubsort(commodityId, accountId, subSort);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shopping;
	}
	
		//修改购物车
		public boolean  doUpdShoppingCart(ShoppingCart shopping) {
			boolean falg=false;
			Connection conn=UtilConnection.getMySQLConnection();
			try {
				ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).doUpdShoppingCart(shopping);
				falg=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return falg;
			
		} 		
		//添加购物车
		public boolean doInsShoppingCart(ShoppingCart shopping) {
			boolean falg=false;
			Connection conn=UtilConnection.getMySQLConnection();
			try {
				ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).doInsShoppingCart(shopping);
				falg=true;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return falg;
		}
		
		//通过用户Id获取购物车数量
		public int getCartSbyAccountId(int accountId) {
			int num=0;
			Connection conn=UtilConnection.getMySQLConnection();
			try {
				num=ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).getCartSbyAccountId(accountId);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return num;
			
		}
		
		public boolean doAddShoppingCart(ShoppingCart shopping) {
			Connection conn=UtilConnection.getMySQLConnection();
			ShoppingCart shoppingCart=null;
			boolean falg=false;
			try {
				conn.setAutoCommit(false);
				shoppingCart=ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).getShoppingCartByCommodityIdAndAccountIdAndSubsort(shopping.getCommodityId(),shopping.getAccountId(),shopping.getSubsort());
				if(shoppingCart==null) {
					ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).doInsShoppingCart(shopping);
				}else {
					shoppingCart.setCommodityNumber(shoppingCart.getCommodityNumber()+shopping.getCommodityNumber());
					shoppingCart.setCommodityPrices(shoppingCart.getCommodityNumber()*shoppingCart.getCommodityPrice());
					ShoppingCartDaoFactory.getShoppingCarDaoInstance(conn).doUpdShoppingCart(shoppingCart);
				}
				conn.commit();
				falg=true;
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return falg;
		}
}
