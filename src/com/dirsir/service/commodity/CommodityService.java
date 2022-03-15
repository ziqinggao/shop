package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.entities.Commodity;
import com.dirsir.dao.factory.CommodityDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommodityService {
	//通过商家Id来显示所有的商品信息
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
	//添加商品
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
	
	//通过商家ID和商品名字分页查询所有商品
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
	
	//通过商家Id获取查询所有商品的页数
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
		
		//修改销售状态
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
		
		//修改商品信息
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
