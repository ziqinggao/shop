package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Admin;
import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.dao.entities.CommodityType;
import com.dirsir.dao.entities.CommodityV;
import com.dirsir.dao.entities.Merchant;

public interface AdminDao {
	//��¼
	public Admin  getAdminByAdminNameAndAdminPassword(String adminName,String adminPassword) throws Exception;
	
	//��ѯ���й���Ա��Ϣ,������ʾ�ڼ�ҳ������
	public List<Admin> getAdminInfo(int num) throws Exception;
	
	//��Ʒ��ˣ���ѯ������״̬�Ǵ���˵���Ʒ
	/*public List<Commodity> getCommodity() throws Exception;*/
	
	//��Ʒ���,�鿴����û��ͨ����˲�Ʒ����Ϣ��ͨ����ͼչʾ
	public List<CommodityV> getCommodityV(int x) throws Exception;
	
	//�޸���Ʒ״̬
	public void updCommodity(int commodityId,int checkInfo,int adminId) throws Exception;
	
	//�鿴��ע������е��̼���Ϣ
	public List<Merchant> getMerchantAll(int num) throws Exception;
	
	//�̼ҵȴ����,�޸��̼�״̬
	public void updMerchantById(int merchantId,int recordState,int adminId) throws Exception;
	
	//�鿴��Ʒ������Ϣ
	public List<CommodityType> getCommodityType() throws Exception;
	
	//�鿴��Ʒ������ϸ
	public List<CommoditySubtype> getCommoditySubtypeById(int typeId) throws Exception;
	
	//�޸���Ʒ������Ϣ״̬
	public void doUpdCommodityType(int typeId,int typeState) throws Exception;
	
	//�޸���Ʒ��ϸ״̬
	public void doUpdCommoditySubtype(int subtypeId,int subtypeState) throws Exception;
	
	//�޸ĵ�typeId����Ҫ�޸ĵ���һ����ʱ��ȫ���޸�
	public void doUpdCommoditySubtypeAll(int typeId,int subtypeState) throws Exception;
	
	//ɾ����Ʒ������Ϣ����
	public void doDelCommodityType(int typeId) throws Exception;
	
	//ɾ����Ʒ������ϸ����
	public void doDelCommoditySubtype(int subtypeId) throws Exception;
	
	//ɾ����Ʒ������ϸ��������
	public void doDelCommoditySubtypeAll(int typeId) throws Exception;
	
	//������Ʒ������Ϣ����
	public void doInsCommodityType(CommodityType commodityType) throws Exception;
	
	//������Ʒ������ϸ����
	public void doInsCommoditySubtype(CommoditySubtype commoditySubtype) throws Exception;
	
	//ģ����ѯ���ͱ����������
	public List<CommodityType> getTypeLike(String likeText,int typeState) throws Exception;
	
	//ģ����ѯ��ϸ���ͱ����������
	public List<CommoditySubtype> getSubtypeLike(String likeText,int subtypeState) throws Exception;
	
	//��ѯ��id=?����Ա��Ϣ,ʹ���˲鿴ͬ��Ԫ�أ�ûʹ�ò鿴���ݿ�
	
	//�޸ĵ�id=?����Ա��Ϣ
	public void doUpdAdmin(Admin admin) throws Exception;
	
	//ɾ��id=������Ա��Ϣ
	public void doDelAdmin(int adminId) throws Exception;
	
	//���ӹ���Ա��Ϣ
	public void doInsAdmin(Admin admin) throws Exception;
	
	//�޸Ĺ���Ա״̬
	public void doUpdAdminState(int state,int adminId) throws Exception;
	
	//�鿴�Ƿ񹤺��ظ�
	public Admin getAdminNumber(int adminNumber) throws Exception;
	
	//�鿴�˺��Ƿ��ظ�
	public Admin getAdminAccount(String adminName) throws Exception;
	
	//��ѯ���еĹ���Ա��Ϣ
	public int countAdmin() throws Exception;
}
