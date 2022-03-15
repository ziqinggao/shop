package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommodityPicture;

public interface CommodityPictureDao {
	//通过商品Id和类别状态来获取图片信息
	public List<CommodityPicture> getCommodityPictureByCommodityIdAndPictureType(int commodityId, int pictureType) throws Exception;
	
	//添加图片
	public void doInsCommodityPicture(CommodityPicture commodityPicture) throws Exception;
	
	//删除图片
	public void doDelCommodityPicture(int commodityPictureId) throws Exception;
	
	//修改图片的状态
	public void doUpdCommodityPictureByPictureIdAndState(int pictureId, int pictureState) throws Exception;
	
	//通过图片id获取图片信息
	public CommodityPicture getCommodityPictureByPictureId(int pictureId) throws Exception;
	
	//通过商品Id获取图片信息
	public List<CommodityPicture> getCommodityPictureByCommodityId(int commodityId) throws Exception;
	
	
}
