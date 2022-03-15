package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.entities.MerchantTarding;

public interface MerchantDao {
	//ͨ����ƷId��ȥ�̼���Ϣ
	public Merchant getMerchantByCommodityId(int commodityId)throws Exception;
	//�̼�ͨ���˻��������¼
	public Merchant getMerchantByAaccountAndMerchantPassword(String account, String merchantPaasword) throws Exception;
    //��ѯ�̼��˻��Ƿ��ѱ�ע��
	public  int getMerchantByAccount(String account) throws Exception;
	//ע���̼���Ϣ
	public void doInsMerchant (Merchant merchant) throws Exception;
	
	
	
	//��ѯ�̼���Ϣ
	public Merchant getMerchantInfo(String account) throws Exception;
	
	//�޸��̼ҵ����ܺ����ܵ绰��Ϣ�ͷ��˵绰
	public void upaMerchantDirectorAndDirectorPhoneAndLicensPicture(String account,String corpPhone,String director,String directorPhone) throws Exception;
	
	//�̼ҳ�ֵ
	public void merchantBalanceIn(String account,double merchantBalance) throws Exception;
	
	//�̼�����
	public void merchantBlanceOut(String account,double merchantBalance) throws Exception;
	
	//�޸�����
	public void updPassWord(String account,String oldPassWord,String newPassWord) throws Exception;
	
	//�����̼ҽ��׼�¼��
	public void doInsMerchantTarding(MerchantTarding tarding) throws Exception;
	
	//�鿴�̼ҵĽ��׼�¼��
	public List<MerchantTarding> getMerchantTarding(int merchantId) throws Exception;
}
