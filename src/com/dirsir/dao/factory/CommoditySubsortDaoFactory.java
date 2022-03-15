package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommoditySubsortDao;
import com.dirsir.dao.imp.CommoditySubsortDaoImp;

public class CommoditySubsortDaoFactory {
	public static CommoditySubsortDao getCommoditySubsortDaoInstance(Connection conn) {
		
		return new CommoditySubsortDaoImp(conn);
	}
	
	
}
