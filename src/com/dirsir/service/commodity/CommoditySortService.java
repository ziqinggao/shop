package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.factory.CommoditySortDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommoditySortService {
	//通过商品ID获取所有的商品类别
	public List<CommoditySort> getCommoditySortByCommodityId(int commodityId){
		Connection conn=UtilConnection.getMySQLConnection();
		List<CommoditySort> list=null;
		try {
			list=CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).getCommoditySortAll(commodityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//为指定的商品添加类别
	public boolean doInsCommoditySort(CommoditySort commoditySort) {
		boolean falg=false;
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).doInsCommoditySort(commoditySort);
			falg=true;
		}catch (Exception e) {
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
	
	//修改指定类别
	public boolean doUpdCommoditySort(CommoditySort commoditySort) {
		boolean falg=false;
		Connection  conn=UtilConnection.getMySQLConnection();
		try {
			CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).doUpdCommoditySort(commoditySort);
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
	//通过类别Id来获取类别详细信息
	public CommoditySort getCommoditySortBySortId(int sortId) {
		CommoditySort commoditySort=null;
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			commoditySort =CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).getCommoditySortBySortId(sortId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return commoditySort;
	}
	
	//删除指定类别ID信息
	public boolean doDelCommoditySortBySortId(int sortId) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).doDelCommoditySortBysortId(sortId);
			falg=true;
		}catch (Exception e) {
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
