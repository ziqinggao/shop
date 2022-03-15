package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommodityInfoDao;
import com.dirsir.dao.entities.CommodityInfo;

public class CommodityInfoDaoImp implements CommodityInfoDao {
	Connection conn=null;
	public CommodityInfoDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<CommodityInfo> getNewCommodityInfo() throws Exception {
		List<CommodityInfo> list=new ArrayList<>();
		String sql="select commodity_id,commodity_name,commodity_describe,price,vip_price,subtype_id,sale_info,check_info,check_date,admin_id,merchant_id,merchant_name," + 
				"picture_id,picture_type,picture_url,picsort_code,picture_state from commodity_info_v where check_info=3 and picture_type=3 order by check_date desc ";
		Statement sta=conn.createStatement();
		ResultSet res=sta.executeQuery(sql);
		while (res.next()) {
		CommodityInfo commodityInfo=new CommodityInfo(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getInt(13),res.getInt(14),res.getString(15),res.getInt(16),res.getInt(17));
		list.add(commodityInfo);
		}
		res.close();
		sta.close();
		return list;
	}
	@Override
	public List<CommodityInfo> getCommodityInfoByCommodityId(int commodityId) throws Exception {
		List<CommodityInfo> list=new ArrayList<>();
		String sql="select commodity_id,commodity_name,commodity_describe,price,vip_price,subtype_id,sale_info,check_info,check_date,admin_id,merchant_id,merchant_name," + 
				"picture_id,picture_type,picture_url,picsort_code,picture_state from commodity_info_v where check_info=3 and picture_state=1 and commodity_id=? order by picsort_code  ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while (res.next()) {
		CommodityInfo commodityInfo=new CommodityInfo(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getInt(13),res.getInt(14),res.getString(15),res.getInt(16),res.getInt(17));
		list.add(commodityInfo);
		}
		res.close();
		ps.close();
		return list;
	}
	@Override
	public List<CommodityInfo> getSimilarityCommodityInfoByCommodityId(int commodityId) throws Exception {
		List<CommodityInfo> list=new ArrayList<>();
		String sql="select commodity_id,commodity_name,commodity_describe,price,vip_price,subtype_id,sale_info,check_info,check_date,admin_id,merchant_id,merchant_name," + 
				"picture_id,picture_type,picture_url,picsort_code,picture_state from commodity_info_v where check_info=3 and picture_type=3 and subtype_id=(select subtype_id from commodity where commodity_id=?) limit 0,5 ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while (res.next()) {
		CommodityInfo commodityInfo=new CommodityInfo(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getInt(13),res.getInt(14),res.getString(15),res.getInt(16),res.getInt(17));
		list.add(commodityInfo);
		}
		res.close();
		ps.close();
		return list;
		
	}
	@Override
	public List<CommodityInfo> getCommodityInfoBySubsortId(int subSortId) throws Exception {
		List<CommodityInfo> list=new ArrayList<>();
		String sql="select commodity_id,commodity_name,commodity_describe,price,vip_price,subtype_id,sale_info,check_info,check_date,admin_id,merchant_id,merchant_name," + 
				"picture_id,picture_type,picture_url,picsort_code,picture_state from commodity_info_v where check_info=3 and picture_type=3 and subtype_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, subSortId);
		ResultSet res=ps.executeQuery();
		while (res.next()) {
		CommodityInfo commodityInfo=new CommodityInfo(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getInt(13),res.getInt(14),res.getString(15),res.getInt(16),res.getInt(17));
		list.add(commodityInfo);
		}
		res.close();
		ps.close();
		return list;
		
	}
	@Override
	public List<String> getMerchantNameBySubsortId(int subSortId) throws Exception {
		List<String> list=new ArrayList<>();
		String sql="select merchant_name  from commodity_info_v where check_info=3 and picture_type=3 and subtype_id=? group by merchant_name";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, subSortId);
		ResultSet res=ps.executeQuery();
		while (res.next()) {
			String merchant=res.getString(1);
		list.add(merchant);
		}
		res.close();
		ps.close();
		return list;
	}

}
