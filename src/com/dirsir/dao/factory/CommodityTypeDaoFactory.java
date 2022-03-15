package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommodityTypeDao;
import com.dirsir.dao.imp.CommodityTypeDaoImp;

public class CommodityTypeDaoFactory {
	public static CommodityTypeDao getCommodityTypeInstance(Connection conn) {
		return new CommodityTypeDaoImp(conn);
	}

}
