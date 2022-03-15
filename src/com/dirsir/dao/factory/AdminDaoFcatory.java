package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.AdminDao;
import com.dirsir.dao.imp.AdminDaoImpl;

public class AdminDaoFcatory {
	public static AdminDao getAdminDaoInstance(Connection conn) {
		return new AdminDaoImpl(conn);
	}
	
	
}
