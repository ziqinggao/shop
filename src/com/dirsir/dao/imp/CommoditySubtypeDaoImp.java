package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommoditySubtypeDao;
import com.dirsir.dao.entities.CommoditySubtype;

public class CommoditySubtypeDaoImp implements CommoditySubtypeDao {
	Connection conn=null;
	public CommoditySubtypeDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<CommoditySubtype> getCommoditySubtypeAllByTypeId(int typeId) throws Exception {
		List<CommoditySubtype> list=new ArrayList<>();
		String sql="select subtype_id,subtype_name,subtype_describe,subtype_state,subsort_code from commodity_subtype where type_id=? and subtype_state =1";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, typeId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommoditySubtype subtype=new CommoditySubtype(res.getInt(1),typeId,res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
			list.add(subtype);
		}
		res.close();
		ps.close();
		return list;
	}
	@Override
	public List<CommoditySubtype> getCommoditySubtypeAll() throws Exception {
		List<CommoditySubtype> list=new ArrayList<>();
		String sql="select subtype_id,subtype_name,subtype_describe,subtype_state,subsort_code,type_id from commodity_subtype where type_id=? and subtype_state =1";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommoditySubtype subtype=new CommoditySubtype(res.getInt(1),res.getInt(6),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5));
			list.add(subtype);
		}
		res.close();
		ps.close();
		return list;
	}

}
