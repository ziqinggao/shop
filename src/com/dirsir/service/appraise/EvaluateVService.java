package com.dirsir.service.appraise;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.EvaluateV;
import com.dirsir.dao.factory.EvaluateVDaoFactory;
import com.dirsir.util.UtilConnection;

public class EvaluateVService {
	public List<EvaluateV> getEvaluateV(String commodityName,int merchantId,int pages,int vaild){
		List<EvaluateV> list=null;
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			if(vaild==1) {
				list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityNameAndMerchantId(commodityName, merchantId, pages, vaild);
			}else {
				list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityNameAndMerchantId(commodityName, merchantId, pages);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int getPages(String commodityName,int merchantId,int vaild) {
		Connection conn =UtilConnection.getMySQLConnection();
		int pages=0;
		try {
			if(vaild==1) {
				pages=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getMaxPageByCommodityNameAndMerchantId(commodityName, merchantId, vaild);
			}else {
				pages=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getMaxPageByCommodityNameAndMerchantId(commodityName, merchantId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pages;
	}

}
