package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommoditySubsort;
import com.dirsir.dao.factory.CommoditySubsortDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommoditySubsortService {
	public List<CommoditySubsort> getCommoditySubsortBySortId(int sortId){
		Connection conn=UtilConnection.getMySQLConnection();
		List<CommoditySubsort> list=null;
		try {
			list=CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).getCommoditySubsortBySortId(sortId);
			
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
	
	public boolean doInsCommoditySubsort(CommoditySubsort commoditySubsort) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).doInsCommoditySubsort(commoditySubsort);
			falg=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return falg;
		
		
	}
	
	public CommoditySubsort getCommoditySubsortBySubsortId(int subsortId) {
		Connection conn=UtilConnection.getMySQLConnection();
		CommoditySubsort commoditySubsort=null;
		try {
			commoditySubsort=CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).getCommoditySubsortBySubsortId(subsortId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commoditySubsort;
		
	}
	
	public boolean doUpdSubsortStateBySubsort(int subsortId,int state) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).doUpdSubsortStateBySubsortId(state, subsortId);
			falg=true;
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
		return falg;
	}
	
	public boolean doUpdSubsort(CommoditySubsort commoditySubsort) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).doUpdCommoditySunsort(commoditySubsort);
			falg=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return falg;
		
	}
	public boolean doDelCommoditySubsort(int subsortId) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).doDelCommoditySubsortBySubsortId(subsortId);
			falg=true;
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
		return falg;
		
	}
}
