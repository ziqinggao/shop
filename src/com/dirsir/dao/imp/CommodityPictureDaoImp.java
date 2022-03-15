package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommodityPictureDao;
import com.dirsir.dao.entities.CommodityPicture;

public class CommodityPictureDaoImp implements CommodityPictureDao {
	Connection conn=null;
	public CommodityPictureDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<CommodityPicture> getCommodityPictureByCommodityIdAndPictureType(int commodityId, int pictureType)
			throws Exception {
		List<CommodityPicture> list=new ArrayList<>();
		String sql="select picture_id,picture_url,picsort_code,picture_state from commodity_picture where commodity_id =? and picture_type=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ps.setInt(2, pictureType);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommodityPicture commodityPicture=new CommodityPicture(res.getInt(1),commodityId,pictureType,res.getString(2),res.getInt(3),res.getInt(4));
			list.add(commodityPicture);
		}
		res.close();
		ps.close();
		return list;
	}
	@Override
	public void doInsCommodityPicture(CommodityPicture commodityPicture) throws Exception {
		String sql="insert into commodity_picture(commodity_id,picture_type,picture_url)values(?,?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityPicture.getCommodityId());
		ps.setInt(2, commodityPicture.getPictureType());
		ps.setString(3, commodityPicture.getPictureUrl());
		ps.execute();
		ps.close();
		
		
	}
	@Override
	public void doDelCommodityPicture(int commodityPictureId) throws Exception {
		String sql="delete from commodity_picture where picture_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityPictureId);
		ps.execute();
		ps.close();
	}
	@Override
	public void doUpdCommodityPictureByPictureIdAndState(int pictureId, int pictureState) throws Exception {
		String sql="update commodity_picture set picture_state=? where picture_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, pictureState);
		ps.setInt(2, pictureId);
		ps.execute();
		ps.close();
	}
	@Override
	public CommodityPicture getCommodityPictureByPictureId(int pictureId) throws Exception {
		String sql="select commodity_id,picture_type,picture_url,picsort_code,picture_state from commodity_picture where picture_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, pictureId);
		ResultSet res=ps.executeQuery();
		CommodityPicture commodityPicture=null;
		while(res.next()) {
			commodityPicture=new CommodityPicture(pictureId,res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getInt(5));
		}
		return commodityPicture;
	}
	@Override
	public List<CommodityPicture> getCommodityPictureByCommodityId(int commodityId) throws Exception {
		List<CommodityPicture> list=new ArrayList<>();
		String sql="select picture_id,picture_url,picsort_code,picture_state,picture_type from commodity_picture where commodity_id =? and picture_state=1";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			CommodityPicture commodityPicture=new CommodityPicture(res.getInt(1),commodityId,res.getInt(5),res.getString(2),res.getInt(3),res.getInt(4));
			list.add(commodityPicture);
		}
		res.close();
		ps.close();
		return list;
	}

}
