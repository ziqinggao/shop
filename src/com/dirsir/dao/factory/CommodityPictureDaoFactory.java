package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.CommodityPictureDao;
import com.dirsir.dao.imp.CommodityPictureDaoImp;

public class CommodityPictureDaoFactory {
	public static CommodityPictureDao getCommodityPictureDaoInstance(Connection conn) {
		return new CommodityPictureDaoImp(conn);
	}

}
