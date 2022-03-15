package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.entities.Commodity;
import com.dirsir.dao.factory.CommodityDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommodityService {
	//ͨ���̼�Id����ʾ���е���Ʒ��Ϣ
	public List<Commodity> getCommodityByMerchantId(int merchantId){
		List<Commodity> list=new ArrayList<>();
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			list= CommodityDaoFactory.getCommodityInstance(conn).getCommodityAllByMerchantId(merchantId);
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
	//�����Ʒ
	public boolean doInsCommodity(Commodity commodity) {
		boolean falg=false;
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			CommodityDaoFactory.getCommodityInstance(conn).doInsCommodity(commodity);
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
	
	//ͨ���̼�ID����Ʒ���ַ�ҳ��ѯ������Ʒ
	public List<Commodity> getCommoditysByCommodityNameLimitAndMerchantId(String commodityName,int merchantId,int pages){
		List<Commodity> list=new ArrayList<>();
		Connection conn=UtilConnection.getMySQLConnection();
		try {
			list= CommodityDaoFactory.getCommodityInstance(conn).getCommodityAllByCommodityNameLimit(commodityName, merchantId, pages);
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
	
	//ͨ���̼�Id��ȡ��ѯ������Ʒ��ҳ��
		public int getCommodityNumByCommodityNameAndMerchantId(String commodityName,int merchantId) {
			Connection conn=UtilConnection.getMySQLConnection();
			int num=0;
			try {
				num=CommodityDaoFactory.getCommodityInstance(conn).getSearchNumByCommodityName(commodityName, merchantId);
				num=(num+10-1)/10;
				if(num==0) {
					num=1;
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
			return num;
		}
		
		//�޸�����״̬
		public boolean doUpdSaleState(int merchantId ,int commodityId, int saleState) {
			boolean falg=false;
			Connection conn=UtilConnection.getMySQLConnection();
			try {
				CommodityDaoFactory.getCommodityInstance(conn).doUpdSaleStateByMerchantIDAndCommodityIdAndSaleState(merchantId, commodityId, saleState);
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
		
		//�޸���Ʒ��Ϣ
		public boolean doUpdCommodity(Commodity commodity) {
			boolean falg=false;
			Connection conn=UtilConnection.getMySQLConnection();
			try {
				CommodityDaoFactory.getCommodityInstance(conn).doUpdCommodityInfo(commodity);
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
}
