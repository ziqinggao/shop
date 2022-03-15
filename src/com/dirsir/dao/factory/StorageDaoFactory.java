package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.StorageDao;
import com.dirsir.dao.imp.StorageDaoImpl;

public class StorageDaoFactory {
	
	public static StorageDao getStorageDaoIntance(Connection conn) throws Exception{
		return new StorageDaoImpl(conn);
	}
}
