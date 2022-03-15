package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Account;
import com.dirsir.dao.entities.AccountTarding;
import com.dirsir.dao.entities.Location;

public interface AccountDao {
	//�û���¼
	public Account getAccountByAccountNamePassword(String accountname,String password) throws Exception;
    
	//�û�ע��
	public void doInsAccount(Account account) throws Exception;
	
	//��ʾ���˻��Ƿ��ѱ�ע��
	public  int getAccountByAccountName(String accountname) throws Exception;
	
	//�����û�ID��ʾ�û�������Ϣ
	public Account getAccountByAccountId(int accountid) throws Exception;
	
	//�����û�ID�޸��û�������Ϣ
	public void updataAccountByAccountId(Account account) throws Exception;
	
	//�޸��˻����
	public void updataAccountByAccountId(int accountid,double balance) throws Exception;
	
	//ת��
	public void updataAccountBanlanceByAccountID(int accountid,double balance) throws Exception;
	
	//�鿴����
	public String getAccountPasswordByAccountId(int accountid,String password) throws Exception;
	
	//�޸�����
	public void updateAccountPasswordByAccountId(int accountid,String password) throws Exception;

	//�����û�������Ϣ
	public void doInsAccountTrading(AccountTarding accountTrading) throws Exception;
    
	//�����û�ID��ʾ��ַ    
    public List<Location> getLocation(int accountid) throws Exception;
    
    //�����ջ���ַID��ʾҪ�޸ĵ���Ϣ
    public Location getUpdateLocation(int locationId) throws Exception;
    
    //�����ջ���ַ
    public void doInsLocation(Location location) throws Exception;
    
    //�޸��ջ���ַ
    public void updateLocation(Location location) throws Exception;
    
  //�����û�ID��ʾ�û�������Ϣ
  	public Account getAccount(int accountid) throws Exception;
}
