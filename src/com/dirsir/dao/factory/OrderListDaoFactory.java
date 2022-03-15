package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.OrderListDao;
import com.dirsir.dao.imp.OrderListDaoImp;

public class OrderListDaoFactory {
	
	public static OrderListDao getOrderListInstance(Connection conn) {
		return new OrderListDaoImp(conn);
	}
	
}
