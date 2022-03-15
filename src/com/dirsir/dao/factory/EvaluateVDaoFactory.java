package com.dirsir.dao.factory;

import java.sql.Connection;

import com.dirsir.dao.EvaluateVDao;
import com.dirsir.dao.imp.EvaluateVDaoImp;

public class EvaluateVDaoFactory {
	public static EvaluateVDao getEvaluateVDaoInstance(Connection conn) {
		return new EvaluateVDaoImp(conn);
	}

}
