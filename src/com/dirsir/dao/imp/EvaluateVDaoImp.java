package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.EvaluateVDao;
import com.dirsir.dao.entities.EvaluateV;

public class EvaluateVDaoImp implements EvaluateVDao {
	Connection conn=null;
	public EvaluateVDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<EvaluateV> getEvaluateVByMerchantId(int merchantId) throws Exception {
		return null;
	}

	@Override
	public List<EvaluateV> getEvaluateVByCommodityNameAndMerchantId(String CommodityName, int merchantId, int pages)
			throws Exception {
		List<EvaluateV> list=new ArrayList<>();
		String sql="select evaluate_id,commodity_score,logistic_score,service_score,evaluate," + 
				"evlauate_date,particulars_id,subsort,state,commodity_id,commodity_name," + 
				"order_id,order_number,account_id,account_name from eva_ord_v where commodity_name like ? and merchant_id=? limit ?,10";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "%"+CommodityName+"%");
		ps.setInt(2, merchantId);
		ps.setInt(3, (pages-1)*10);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			EvaluateV evaluateV=new EvaluateV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getInt(10),res.getString(11),merchantId,res.getInt(12),res.getString(13),res.getInt(14),res.getString(15));
			list.add(evaluateV);
		}
		res.close();
		ps.close();
		return list;
	}

	@Override
	public int getMaxPageByCommodityNameAndMerchantId(String CommodityName, int merchantId) throws Exception {
		int pages=0;
		String sql="select count(*) from eva_ord_v where commodity_name like ? and merchant_id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "%"+CommodityName+"%");
		ps.setInt(2, merchantId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			pages=(res.getInt(1)+10-1)/10;
			if(pages==0) {
				pages=1;
			}
		}
		res.close();
		ps.close();
		return pages;
	}

	@Override
	public List<EvaluateV> getEvaluateVByCommodityNameAndMerchantId(String CommodityName, int merchantId, int pages,
			int vaild) throws Exception {
		List<EvaluateV> list=new ArrayList<>();
		String sql="select evaluate_id,commodity_score,logistic_score,service_score,evaluate," + 
				"evlauate_date,particulars_id,subsort,state,commodity_id,commodity_name," + 
				"order_id,order_number,account_id,account_name from eva_ord_v where commodity_name like ? and merchant_id=? and length(evaluate)>30 limit ?,10";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "%"+CommodityName+"%");
		ps.setInt(2, merchantId);
		ps.setInt(3, (pages-1)*10);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			EvaluateV evaluateV=new EvaluateV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getInt(10),res.getString(11),merchantId,res.getInt(12),res.getString(13),res.getInt(14),res.getString(15));
			list.add(evaluateV);
		}
		res.close();
		ps.close();
		return list;
	}

	@Override
	public int getMaxPageByCommodityNameAndMerchantId(String CommodityName, int merchantId, int vaild) throws Exception {
		int pages=0;
		String sql="select count(*) from eva_ord_v where commodity_name like ? and merchant_id=? and length(evaluate)>30";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "%"+CommodityName+"%");
		ps.setInt(2, merchantId);
		ResultSet res=ps.executeQuery();
		
		while(res.next()) {
			pages=(res.getInt(1)+10-1)/10;
			if(pages==0) {
				pages=1;
			}
		}
		res.close();
		ps.close();
		return pages;
	}
	@Override
	public int getEvaluateVNumByCommodityId(int commodityId) throws Exception {
		int num=0;
		String sql="select count(*) from eva_ord_v where commodity_id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			num=res.getInt(1);
		}
		res.close();
		ps.close();
		return num;
	}
	@Override
	public List<EvaluateV> getEvaluateVByCommodityId(int commodityId) throws Exception {
		List<EvaluateV> list=new ArrayList<>();
		String sql="select evaluate_id,commodity_score,logistic_score,service_score,evaluate," + 
				"evlauate_date,particulars_id,subsort,state,commodity_id,commodity_name," + 
				"order_id,order_number,account_id,account_name,merchant_id from eva_ord_v where commodity_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			EvaluateV evaluateV=new EvaluateV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getInt(10),res.getString(11),res.getInt(16),res.getInt(12),res.getString(13),res.getInt(14),res.getString(15));
			list.add(evaluateV);
		}
		res.close();
		ps.close();
		return list;
	}
	@Override
	public List<EvaluateV> getEvaluateVByCommodityIdOrderByDate(int commodityId) throws Exception {
		List<EvaluateV> list=new ArrayList<>();
		String sql="select evaluate_id,commodity_score,logistic_score,service_score,evaluate," + 
				"evlauate_date,particulars_id,subsort,state,commodity_id,commodity_name," + 
				"order_id,order_number,account_id,account_name,merchant_id from eva_ord_v where commodity_id=? order by evlauate_date desc";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			EvaluateV evaluateV=new EvaluateV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getInt(10),res.getString(11),res.getInt(16),res.getInt(12),res.getString(13),res.getInt(14),res.getString(15));
			list.add(evaluateV);
		}
		res.close();
		ps.close();
		return list;
	}
	@Override
	public List<EvaluateV> getEvaluateVByCommodityIdAndFilter(int commodityId) throws Exception {
		List<EvaluateV> list=new ArrayList<>();
		String sql="select evaluate_id,commodity_score,logistic_score,service_score,evaluate," + 
				"evlauate_date,particulars_id,subsort,state,commodity_id,commodity_name," + 
				"order_id,order_number,account_id,account_name,merchant_id from eva_ord_v where commodity_id=? and length(evaluate)>30";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			EvaluateV evaluateV=new EvaluateV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getInt(10),res.getString(11),res.getInt(16),res.getInt(12),res.getString(13),res.getInt(14),res.getString(15));
			list.add(evaluateV);
		}
		res.close();
		ps.close();
		return list;
	}
	@Override
	public List<EvaluateV> getEvaluateVByCommodityIdAndFilterOrderByDate(int commodityId) throws Exception {
		List<EvaluateV> list=new ArrayList<>();
		String sql="select evaluate_id,commodity_score,logistic_score,service_score,evaluate," + 
				"evlauate_date,particulars_id,subsort,state,commodity_id,commodity_name," + 
				"order_id,order_number,account_id,account_name,merchant_id from eva_ord_v where commodity_id=? and length(evaluate)>30 order by evlauate_date desc";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			EvaluateV evaluateV=new EvaluateV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6),res.getInt(7),res.getString(8),res.getInt(9),res.getInt(10),res.getString(11),res.getInt(16),res.getInt(12),res.getString(13),res.getInt(14),res.getString(15));
			list.add(evaluateV);
		}
		res.close();
		ps.close();
		return list;
	}

}
