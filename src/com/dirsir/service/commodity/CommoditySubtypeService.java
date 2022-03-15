package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.dao.factory.CommoditySubtypeDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommoditySubtypeService {
	public List<CommoditySubtype> getSubtypeAllBy(int typeId){
		List<CommoditySubtype> list=null;
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			list=CommoditySubtypeDaoFactory.getCommoditySubtypeInstance(conn).getCommoditySubtypeAllByTypeId(typeId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<CommoditySubtype> getSubtypeAll(){
		List<CommoditySubtype> list=null;
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			list=CommoditySubtypeDaoFactory.getCommoditySubtypeInstance(conn).getCommoditySubtypeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
