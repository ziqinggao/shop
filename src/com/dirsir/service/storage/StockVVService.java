package com.dirsir.service.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.entities.StockVV;
import com.dirsir.dao.factory.StockVVDaoFactory;
import com.dirsir.util.UtilConnection;

public class StockVVService {
	public List<StockVV> StockVV(int merchantId,int pages) {
		Connection conn = null;
		List<StockVV> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list = StockVVDaoFactory.getCommodityStockDaoInstaer(conn).getStockVVAllByMerchanId(merchantId, pages);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;

	}
	public List<StockVV> StockVVSubsort(int commodityid) {
		Connection conn = null;
		List<StockVV> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list=StockVVDaoFactory.getCommodityStockDaoInstaer(conn).getStockVVSubsortByCommodityId(commodityid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;

	}
	
	public List<StockVV> Stock(int merchantId) {
		Connection conn = null;
		List<StockVV> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list = StockVVDaoFactory.getCommodityStockDaoInstaer(conn).getStockVVAllByMerchanId(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;

	}

}
