package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.factory.CommoditySortDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommoditySortService {
	//ͨ����ƷID��ȡ���е���Ʒ���
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
	//Ϊָ������Ʒ������
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
	
	//�޸�ָ�����
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
	//ͨ�����Id����ȡ�����ϸ��Ϣ
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
	
	//ɾ��ָ�����ID��Ϣ
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
