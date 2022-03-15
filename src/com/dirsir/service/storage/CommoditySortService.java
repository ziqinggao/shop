package com.dirsir.service.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.factory.CommoditySortDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommoditySortService {
	// 查看商品类别
	public List<CommoditySort> CommoditySort(int commodityid) {
		Connection conn = null;
		List<CommoditySort> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).getCommoditySotrByCommodityId(commodityid);
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
