package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommoditySubtypeDao;
import com.dirsir.dao.imp.CommoditySubtypeDaoImp;

public class CommoditySubtypeDaoFactory {
	public static CommoditySubtypeDao getCommoditySubtypeInstance(Connection conn) {
		return new CommoditySubtypeDaoImp(conn);
	}

}
