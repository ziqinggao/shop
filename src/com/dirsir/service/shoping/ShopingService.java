package com.dirsir.service.shoping;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.Commodity;
import com.dirsir.dao.entities.CommodityInfo;
import com.dirsir.dao.entities.CommodityPicture;
import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.CommoditySubsort;
import com.dirsir.dao.entities.EvaluateV;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.factory.CommodityDaoFactory;
import com.dirsir.dao.factory.CommodityInfoDaoFactory;
import com.dirsir.dao.factory.CommodityPictureDaoFactory;
import com.dirsir.dao.factory.CommoditySortDaoFactory;
import com.dirsir.dao.factory.CommoditySubsortDaoFactory;
import com.dirsir.dao.factory.EvaluateVDaoFactory;
import com.dirsir.dao.factory.MerchantDaoFcatory;
import com.dirsir.util.UtilConnection;

public class ShopingService {
	//获取新上架的商品
	public List<CommodityInfo> getNewCommodity(){
		Connection  conn=UtilConnection.getMySQLConnection();
		List<CommodityInfo> list=null;
		try {
			list=CommodityInfoDaoFactory.getCommodityInfoDaoInstance(conn).getNewCommodityInfo();
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
	//通过商品Id获取商品类别
	public List<CommoditySort> getSortByCommodityId(int commodityId){
		Connection conn=UtilConnection.getMySQLConnection();
		List<CommoditySort> list=null;
		try {
			list=CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).getCommoditySortAll(commodityId);
			
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
	public List<CommoditySubsort> getSubsortBySortId(int sortId){
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	//通过商品id获取商品信息
	public Commodity getCommodityByCommodityId(int commodityId) {
		Connection conn=UtilConnection.getMySQLConnection();
		Commodity commodity=null;
		try {
			commodity=CommodityDaoFactory.getCommodityInstance(conn).getCommodityInfoByCommodityId(commodityId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commodity;
		
	}
	//通过商品Id获取商家信息
	public Merchant getMerchantByCommodityId(int commodityId) {
		Connection conn=UtilConnection.getMySQLConnection();
		Merchant merchant=null;
		try {
			merchant=MerchantDaoFcatory.getMerchantDaoInstance(conn).getMerchantByCommodityId(commodityId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return merchant;
	}
	//通过商品Id获得商品详细信息
	public List<CommodityInfo> getCommodityInfoByCommodityId(int commodityId){
		Connection conn=UtilConnection.getMySQLConnection();
		List<CommodityInfo> list=null;
		try {
			list=CommodityInfoDaoFactory.getCommodityInfoDaoInstance(conn).getCommodityInfoByCommodityId(commodityId);
			
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
	
	//通过商品Id获得商品图片
		public List<CommodityPicture> getCommodityPictureByCommodityId(int commodityId){
			Connection conn=UtilConnection.getMySQLConnection();
			List<CommodityPicture> list=null;
			try {
				list=CommodityPictureDaoFactory.getCommodityPictureDaoInstance(conn).getCommodityPictureByCommodityId(commodityId);
				
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
		
		//通过商品Id获取所有的订单数
		public int getOrderNumByCommodityId(int commodityId) {
			Connection conn=UtilConnection.getMySQLConnection();
			int OrderNum=0;
			try {
				OrderNum=CommodityDaoFactory.getCommodityInstance(conn).getSaleNumbyCommodityId(commodityId);
				
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
			return OrderNum;
		}
		
		//获取所有的评价个数
		public int getEvaluateNumByCommodityId(int commodityId) {
			Connection conn=UtilConnection.getMySQLConnection();
			int EvaluateNum=0;
			try {
				EvaluateNum=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVNumByCommodityId(commodityId);
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
			return EvaluateNum;
		}
		
		//根据商品Id获取评价
		public List<EvaluateV> getEvaluateByCommodityId(int commodityId,int sort,int vaild){
			Connection conn=UtilConnection.getMySQLConnection();
			List<EvaluateV> list=null;
			try {
				if(sort==0&&vaild==0) {
					//查询所有商品不过滤评价
					//System.out.println("查询所有商品不过滤评价");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityId(commodityId);
				}else if(sort==0&&vaild==1){
					//查询所有商品过滤评价
					//System.out.println("查询所有商品过滤评价");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityIdAndFilter(commodityId);
				}else if(sort==1&&vaild==0) {
					//按照时间排序不过滤评价
					//System.out.println("按照时间排序不过滤评价");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityIdOrderByDate(commodityId);
					
				}else {
					//按照时间排序过滤评价
					//System.out.println("按照时间排序过滤评价");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityIdAndFilterOrderByDate(commodityId);
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
			return list;
		}
		
		//通过商品id获取相同类型的商品详细信息
		public List<CommodityInfo> getSimilarityCommodityByCommodityId(int commodityId) {
			Connection conn=UtilConnection.getMySQLConnection();
			List<CommodityInfo> list=null;
			try {
				list=CommodityInfoDaoFactory.getCommodityInfoDaoInstance(conn).getSimilarityCommodityInfoByCommodityId(commodityId);
				
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
		
		//通过详细类别Id获取商品信息
		public List<CommodityInfo> getCommodityInfoBySubsortId(int subSortId){
			Connection conn=UtilConnection.getMySQLConnection();
			List<CommodityInfo> list=null;
			try {
				list=CommodityInfoDaoFactory.getCommodityInfoDaoInstance(conn).getCommodityInfoBySubsortId(subSortId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
