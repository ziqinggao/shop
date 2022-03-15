package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.MerchantDao;
import com.dirsir.dao.imp.MerchantDaoImpl;

public class MerchantDaoFcatory {
	public static MerchantDao getMerchantDaoInstance(Connection conn) {
		return new MerchantDaoImpl(conn);

	}
	
	
}
