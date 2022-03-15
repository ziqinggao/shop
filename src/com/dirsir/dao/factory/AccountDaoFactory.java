package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.AccountDao;
import com.dirsir.dao.imp.AccountDaoImpl;

public class AccountDaoFactory {
	public static AccountDao getAccountDaoInstance(Connection conn) {
		return new AccountDaoImpl(conn);
	}
	

}
