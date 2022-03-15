package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommodityTypeDao;
import com.dirsir.dao.entities.CommodityType;

public class CommodityTypeDaoImp implements CommodityTypeDao {
	Connection conn=null;
	public CommodityTypeDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<CommodityType> getCommodityTypeAll() throws Exception {
		List<CommodityType> list=new ArrayList<>();
		String sql="select type_id,type_name,type_describe,type_state,sort_code from commodity_type where type_state=1";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommodityType commodityType=new CommodityType(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
			list.add(commodityType);
		}
		res.close();
		ps.close();
		return list;
	}

}
