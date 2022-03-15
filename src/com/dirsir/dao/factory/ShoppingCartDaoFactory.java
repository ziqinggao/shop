package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.ShoppingCartDao;
import com.dirsir.dao.imp.ShoppingCartDaoImp;

public class ShoppingCartDaoFactory {
	public static ShoppingCartDao getShoppingCarDaoInstance(Connection conn) {
		return new ShoppingCartDaoImp(conn);
	}
	public static ShoppingCartDao getShoppingCart(Connection conn) throws Exception {
		return new ShoppingCartDaoImp(conn);
	}
}
