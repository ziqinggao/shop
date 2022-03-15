package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommodityDao;
import com.dirsir.dao.imp.CommodityDaoImp;

public class CommodityDaoFactory {
public static CommodityDao getCommodityInstance(Connection conn) {
	return new CommodityDaoImp(conn);
	
}
}
