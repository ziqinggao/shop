package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommodityStockDao;
import com.dirsir.dao.imp.CommodityStockDaoImpl;

public class CommodityStockDaoFactory {
	public static CommodityStockDao  getCommodityDaoInsater(Connection conn) {
		return new CommodityStockDaoImpl(conn);
		
	}

}
