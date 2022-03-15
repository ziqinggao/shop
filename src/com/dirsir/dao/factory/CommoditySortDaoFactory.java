package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommoditySortDao;
import com.dirsir.dao.imp.CommoditySortDaoImp;

public class CommoditySortDaoFactory {
	public static CommoditySortDao getCommoditySortDaoInstance(Connection conn) {
		return new CommoditySortDaoImp(conn);

	}

}
