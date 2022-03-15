package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.StockVVDao;
import com.dirsir.dao.imp.StockVVDaoImpl;

public class StockVVDaoFactory {
	public static StockVVDao getCommodityStockDaoInstaer(Connection conn) {
		return new StockVVDaoImpl(conn);

	}
}