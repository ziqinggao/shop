package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommodityInfoDao;
import com.dirsir.dao.imp.CommodityInfoDaoImp;

public class CommodityInfoDaoFactory {
	public static CommodityInfoDao getCommodityInfoDaoInstance(Connection conn) {
		return new CommodityInfoDaoImp(conn);
	}

}
