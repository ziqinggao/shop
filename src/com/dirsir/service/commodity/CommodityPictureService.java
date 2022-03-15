package com.dirsir.service.commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.CommodityPicture;
import com.dirsir.dao.factory.CommodityPictureDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommodityPictureService {
	
	//通过图片类型和商品Id来获取图片信息
	public List<CommodityPicture> getCommodityPictureByCommodityIdAndPictureType(int commodityId ,int pictureType){
		Connection conn=UtilConnection.getMySQLConnection();
		List<CommodityPicture> list=null;
		try {
			list=CommodityPictureDaoFactory.getCommodityPictureDaoInstance(conn).getCommodityPictureByCommodityIdAndPictureType(commodityId, pictureType);
		
		}catch (Exception e) {
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
	
	//添加新的图片
	public boolean doInsCommodityPicture(CommodityPicture commodityPicture) {
		Connection  conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommodityPictureDaoFactory.getCommodityPictureDaoInstance(conn).doInsCommodityPicture(commodityPicture);
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
		return  falg;
	}
	
	//删除图片
	public boolean doDelCommodityPicture(int commodityPictureId) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommodityPictureDaoFactory.getCommodityPictureDaoInstance(conn).doDelCommodityPicture(commodityPictureId);
			falg=true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return falg;
		
		
	}
	
	//修改图片状态
	public boolean doUpdCommodityPictureState(int pictureId,int state) {
		Connection conn=UtilConnection.getMySQLConnection();
		boolean falg=false;
		try {
			CommodityPictureDaoFactory.getCommodityPictureDaoInstance(conn).doUpdCommodityPictureByPictureIdAndState(pictureId, state);
			falg=true;
			
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
		return falg;
	}
	
	//通过图片Id来查询图片信息
	public CommodityPicture getCommodityPictureByPictureId(int pictureId) {
		Connection conn=UtilConnection.getMySQLConnection();
		CommodityPicture commodityPicture=null;
		try {
			commodityPicture=CommodityPictureDaoFactory.getCommodityPictureDaoInstance(conn).getCommodityPictureByPictureId(pictureId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commodityPicture;
	}

}
