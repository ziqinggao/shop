package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommodityType;
import com.dirsir.dao.factory.CommodityTypeDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommodityTypeService {
	public List<CommodityType> getCommodityAll(){
		Connection conn=UtilConnection.getMySQLConnection();
		List<CommodityType> list=null;
		try {
			list=CommodityTypeDaoFactory.getCommodityTypeInstance(conn).getCommodityTypeAll();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
