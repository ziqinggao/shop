package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.CommodityPicture;

public interface CommodityPictureDao {
	//ͨ����ƷId�����״̬����ȡͼƬ��Ϣ
	public List<CommodityPicture> getCommodityPictureByCommodityIdAndPictureType(int commodityId, int pictureType) throws Exception;
	
	//���ͼƬ
	public void doInsCommodityPicture(CommodityPicture commodityPicture) throws Exception;
	
	//ɾ��ͼƬ
	public void doDelCommodityPicture(int commodityPictureId) throws Exception;
	
	//�޸�ͼƬ��״̬
	public void doUpdCommodityPictureByPictureIdAndState(int pictureId, int pictureState) throws Exception;
	
	//ͨ��ͼƬid��ȡͼƬ��Ϣ
	public CommodityPicture getCommodityPictureByPictureId(int pictureId) throws Exception;
	
	//ͨ����ƷId��ȡͼƬ��Ϣ
	public List<CommodityPicture> getCommodityPictureByCommodityId(int commodityId) throws Exception;
	
	
}
