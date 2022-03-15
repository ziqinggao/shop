package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommoditySubsortDao;
import com.dirsir.dao.entities.CommoditySubsort;
import com.dirsir.dao.factory.CommoditySortDaoFactory;
import com.dirsir.util.GetSubsortSQL;

public class CommoditySubsortDaoImp implements CommoditySubsortDao {
	Connection conn=null;
	public CommoditySubsortDaoImp(Connection conn) {
		this.conn=conn;
	}
	

	@Override
	public void doInsCommoditySubsort(CommoditySubsort commoditySubsort) throws Exception {
		String sql="insert into commodity_subsort(sort_id,subsort_name,subsort_price,vip_price,subsort_state) values(?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commoditySubsort.getSortId());
		ps.setString(2, commoditySubsort.getSubsortName());
		ps.setDouble(3, commoditySubsort.getSubsortPrice());
		ps.setDouble(4, commoditySubsort.getVipPrice());
		ps.setInt(5, commoditySubsort.getSubsortState());
		ps.execute();
		ps.close();
		
	}

	@Override
	public void doUpdCommoditySunsort(CommoditySubsort commoditySubsort) throws Exception {
		String sql="update commodity_subsort set subsort_name=?,subsort_price=?,vip_price=?,subsort_state=? where subsort_id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, commoditySubsort.getSubsortName());
		ps.setDouble(2, commoditySubsort.getSubsortPrice());
		ps.setDouble(3, commoditySubsort.getVipPrice());
		ps.setInt(4, commoditySubsort.getSubsortState());
		ps.setInt(5, commoditySubsort.getSubsortId());
		ps.execute();
		ps.close();

	}

	@Override
	public List<CommoditySubsort> getCommoditySubsortBySortId(int sortId) throws Exception {
		List<CommoditySubsort> list=new ArrayList<>();
		String sql="select subsort_id,subsort_name,subsort_price,vip_price,subsort_state,subsort_code from commodity_subsort where sort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, sortId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommoditySubsort subsort=new CommoditySubsort(res.getInt(1),sortId,res.getString(2),res.getDouble(3),res.getDouble(4),res.getInt(5),res.getInt(6));
			list.add(subsort);
			
		}
		res.close();
		ps.close();
		return list;
	}


	@Override
	public void doUpdSubsortStateBySubsortId(int subsortState, int subsortId) throws Exception {
		String sql="update commodity_subsort set subsort_state=? where subsort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, subsortState);
		ps.setInt(2, subsortId);
		ps.execute();
		ps.close();
	}


	@Override
	public CommoditySubsort getCommoditySubsortBySubsortId(int subsortId) throws Exception {
		String sql="select sort_id,subsort_name,subsort_price,vip_price,subsort_state,subsort_code from commodity_subsort where subsort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, subsortId);
		ResultSet res=ps.executeQuery();
		CommoditySubsort commoditySubsort=null;
		while(res.next()) {
			commoditySubsort=new CommoditySubsort(subsortId,res.getInt(1),res.getString(2),res.getDouble(3),res.getDouble(4),res.getInt(5),res.getInt(6));
		}
		
		return commoditySubsort;
	}


	@Override
	public void doDelCommoditySubsortBySubsortId(int subsortId) throws Exception {
		String sql="delete from commodity_subsort where subsort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, subsortId);
		ps.execute();
		ps.close();
	}


	@Override
	public List<String> getSubsortByCommodityId(int commodityId) throws Exception {
		List<String> subsort=new ArrayList<>();
		List<Integer> sorts=CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).getSortIdByCommodityIdAndMerchantId(commodityId);
		String sql=GetSubsortSQL.getsubsortSql(sorts, commodityId);
		Statement sta=conn.createStatement();
		ResultSet res=sta.executeQuery(sql);
		while(res.next()) {
			subsort.add(res.getString(2));
		}
		return subsort;
	}

}
