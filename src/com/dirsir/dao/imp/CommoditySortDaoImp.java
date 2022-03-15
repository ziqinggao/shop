package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommoditySortDao;
import com.dirsir.dao.entities.CommoditySort;

public class CommoditySortDaoImp implements CommoditySortDao {

	Connection conn=null;
	public CommoditySortDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<CommoditySort> getCommoditySortAll(int commodityId) throws Exception {
		List<CommoditySort> list=new ArrayList<>();
		String sql="select sort_id,sort_name,sort_state,sort_code from commodity_sort where commodity_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommoditySort sort=new CommoditySort(res.getInt(1),commodityId,res.getString(2),res.getInt(3),res.getInt(4));
			list.add(sort);
		}
		res.close();
		ps.close();
		return list;
	}

	@Override
	public void doInsCommoditySort(CommoditySort commoditySort) throws Exception {
		String sql="insert into commodity_sort(commodity_id,sort_name,sort_state) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commoditySort.getCommodityId());
		ps.setString(2, commoditySort.getSortName());
		ps.setInt(3, commoditySort.getSortState());
		ps.execute();
		ps.close();
	}

	@Override
	public void doUpdCommoditySort(CommoditySort commoditySort) throws Exception {
		String sql="update commodity_sort set sort_name=?,sort_state=? where sort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, commoditySort.getSortName());
		ps.setInt(2, commoditySort.getSortState());
		ps.setInt(3, commoditySort.getSortId());
		ps.execute();
		ps.close();
	}
	@Override
	public CommoditySort getCommoditySortBySortId(int sortId) throws Exception {
		String sql="select commodity_id,sort_name,sort_state,sort_code from commodity_sort where sort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		CommoditySort sort=null;
		ps.setInt(1,sortId );
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			sort=new CommoditySort(sortId,res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4));
		}
		res.close();
		ps.close();
		return sort;
	}
	@Override
	public void doDelCommoditySortBysortId(int sortId) throws Exception {
		String sql="delete from commodity_sort where sort_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, sortId);
		ps.execute();
		ps.close();
		
	}
	@Override
	public List<Integer> getSortIdByCommodityIdAndMerchantId(int commodityId) throws Exception {
		List<Integer> list=new ArrayList<>();
		String sql="SELECT sort_id FROM commodity c INNER JOIN commodity_sort s ON c.`commodity_id`=s.`commodity_id` WHERE  c.`commodity_id`=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Integer sortId=res.getInt(1);
			list.add(sortId);
		}
		return list;
	}
	
	@Override
	public List<CommoditySort> getCommoditySotrByCommodityId(int commodityid) throws Exception {
		String sql="select sort_id,commdity_id,sort_name,sort_state,sort_code from commodity_sort  where commodity_id=? ";
	    PreparedStatement pstate=this.conn.prepareStatement(sql);
	    pstate.setInt(1, commodityid);
	    ResultSet res = pstate.executeQuery();
	    List<CommoditySort> list = new ArrayList<>();
	    while (res.next()) {
	    	CommoditySort commoditysort=new CommoditySort(res.getInt(1),res.getInt(2),res.getString(3),
	    			res.getInt(4),res.getInt(5));
	    	list.add(commoditysort);
	    }
	    res.close();
		pstate.close();
		return list;
	}
	@Override
	public List<String> getSortNameBySubsortId(int subsortId) throws Exception {
		List<String> sortName=new ArrayList<>();
		String sql="select sort_name from commodity_sort where commodity_id in(select commodity_id from commodity where subsort_id =?) group by sort_name";
		PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setInt(1, subsortId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			String name=res.getString(1);
			sortName.add(name);
		}
		return sortName;
	}

}
