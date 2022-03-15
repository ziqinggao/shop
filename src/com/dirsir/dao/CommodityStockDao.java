package com.dirsir.dao;

import java.util.List;
import com.dirsir.dao.entities.CommodityStock;
import com.dirsir.dao.entities.MerchantRepertory;
import com.dirsir.dao.entities.MerchantReturn;
import com.dirsir.dao.entities.MerchantReturnV;
import com.dirsir.dao.entities.StockVV;

public interface CommodityStockDao {
	// ��ӽ����嵥��Ϣ
	public void doInsCommodityStock(CommodityStock commoditystock) throws Exception;

	// ͨ����ƷID��ȡ��Ʒ��𷵻�list;
	public List<String> getCommodityStockByMerchantId(int commodityid) throws Exception;

	// ͨ���̼�ID�������ӱ��ѯ ��ȡ��Ʒ���ֵļ���
	// public List<String> getCommodityNamesSortNameByMerchantId(int merchantId)
	// throws Exception;

	// ͨ���̼�ID���б��ѯ��ȡ������������Ϣ
	public List<CommodityStock> getCommodityAllByMerchantId(int merchantId) throws Exception;

	// ͨ�����ڲ�ѯ�����嵥
	public List<StockVV> getStockVVBuystockDate(String buystockdate, int merchantid) throws Exception;

	// �޸Ľ����嵥
	public void doUpdateCommodityStock(CommodityStock commoditystock) throws Exception;

	// ͨ������ID��ȡҪ�޸ĵĽ�����Ϣ
	public CommodityStock getCommodityStockBySortid(int stockid) throws Exception;

	// ͨ���̼�ID��ȡ�˻���Ϣ
	public List<MerchantReturnV> getMerchantReturnBymerchantid(int merchantid) throws Exception;

	// ͨ������ID�޸��˻��嵥
	public void doInsMerchantReturn(MerchantReturn merchantreturn) throws Exception;

	// ͨ���˻�ID��ȡ�˻���Ϣ
	public MerchantReturn getMerchantReturnByReturnId(int returnid) throws Exception;

	// �޸��˻��嵥��Ϣ
	public void UpdataMerchantReturn(MerchantReturn merchantreturn) throws Exception;

	// ��ʾ�����Ϣ
	public List<MerchantRepertory> getMerchantRepertoryByRepertory(int repertoryid) throws Exception;

	// �����̼�ID�����ڲ�ѯ�˻�����
	public List<MerchantReturnV> getMerchantReturnByMerchantId(int merchantid, String returndate) throws Exception;
}
