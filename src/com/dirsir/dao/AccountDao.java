package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Account;
import com.dirsir.dao.entities.AccountTarding;
import com.dirsir.dao.entities.Location;

public interface AccountDao {
	//用户登录
	public Account getAccountByAccountNamePassword(String accountname,String password) throws Exception;
    
	//用户注册
	public void doInsAccount(Account account) throws Exception;
	
	//提示该账户是否已被注册
	public  int getAccountByAccountName(String accountname) throws Exception;
	
	//根据用户ID显示用户个人信息
	public Account getAccountByAccountId(int accountid) throws Exception;
	
	//根据用户ID修改用户个人信息
	public void updataAccountByAccountId(Account account) throws Exception;
	
	//修改账户余额
	public void updataAccountByAccountId(int accountid,double balance) throws Exception;
	
	//转账
	public void updataAccountBanlanceByAccountID(int accountid,double balance) throws Exception;
	
	//查看密码
	public String getAccountPasswordByAccountId(int accountid,String password) throws Exception;
	
	//修改密码
	public void updateAccountPasswordByAccountId(int accountid,String password) throws Exception;

	//增加用户交易信息
	public void doInsAccountTrading(AccountTarding accountTrading) throws Exception;
    
	//根据用户ID显示地址    
    public List<Location> getLocation(int accountid) throws Exception;
    
    //根据收货地址ID显示要修改的信息
    public Location getUpdateLocation(int locationId) throws Exception;
    
    //增加收货地址
    public void doInsLocation(Location location) throws Exception;
    
    //修改收货地址
    public void updateLocation(Location location) throws Exception;
    
  //根据用户ID显示用户个人信息
  	public Account getAccount(int accountid) throws Exception;
}
