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
	//��ȡ���ϼܵ���Ʒ
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
	//ͨ����ƷId��ȡ��Ʒ���
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
	//ͨ����Ʒid��ȡ��Ʒ��Ϣ
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
	//ͨ����ƷId��ȡ�̼���Ϣ
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
	//ͨ����ƷId�����Ʒ��ϸ��Ϣ
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
	
	//ͨ����ƷId�����ƷͼƬ
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
		
		//ͨ����ƷId��ȡ���еĶ�����
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
		
		//��ȡ���е����۸���
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
		
		//������ƷId��ȡ����
		public List<EvaluateV> getEvaluateByCommodityId(int commodityId,int sort,int vaild){
			Connection conn=UtilConnection.getMySQLConnection();
			List<EvaluateV> list=null;
			try {
				if(sort==0&&vaild==0) {
					//��ѯ������Ʒ����������
					//System.out.println("��ѯ������Ʒ����������");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityId(commodityId);
				}else if(sort==0&&vaild==1){
					//��ѯ������Ʒ��������
					//System.out.println("��ѯ������Ʒ��������");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityIdAndFilter(commodityId);
				}else if(sort==1&&vaild==0) {
					//����ʱ�����򲻹�������
					//System.out.println("����ʱ�����򲻹�������");
					list=EvaluateVDaoFactory.getEvaluateVDaoInstance(conn).getEvaluateVByCommodityIdOrderByDate(commodityId);
					
				}else {
					//����ʱ�������������
					//System.out.println("����ʱ�������������");
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
		
		//ͨ����Ʒid��ȡ��ͬ���͵���Ʒ��ϸ��Ϣ
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
		
		//ͨ����ϸ���Id��ȡ��Ʒ��Ϣ
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
