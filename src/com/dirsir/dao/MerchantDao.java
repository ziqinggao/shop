package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.entities.MerchantTarding;

public interface MerchantDao {
	//通过商品Id过去商家信息
	public Merchant getMerchantByCommodityId(int commodityId)throws Exception;
	//商家通过账户和密码登录
	public Merchant getMerchantByAaccountAndMerchantPassword(String account, String merchantPaasword) throws Exception;
    //查询商家账户是否已被注册
	public  int getMerchantByAccount(String account) throws Exception;
	//注册商家信息
	public void doInsMerchant (Merchant merchant) throws Exception;
	
	
	
	//查询商家信息
	public Merchant getMerchantInfo(String account) throws Exception;
	
	//修改商家的主管和主管电话信息和法人电话
	public void upaMerchantDirectorAndDirectorPhoneAndLicensPicture(String account,String corpPhone,String director,String directorPhone) throws Exception;
	
	//商家充值
	public void merchantBalanceIn(String account,double merchantBalance) throws Exception;
	
	//商家提现
	public void merchantBlanceOut(String account,double merchantBalance) throws Exception;
	
	//修改密码
	public void updPassWord(String account,String oldPassWord,String newPassWord) throws Exception;
	
	//更改商家交易记录表
	public void doInsMerchantTarding(MerchantTarding tarding) throws Exception;
	
	//查看商家的交易记录表
	public List<MerchantTarding> getMerchantTarding(int merchantId) throws Exception;
}
