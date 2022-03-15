package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dirsir.dao.AccountDao;
import com.dirsir.dao.entities.Account;
import com.dirsir.dao.entities.AccountTarding;
import com.dirsir.dao.entities.Location;

public class AccountDaoImpl implements AccountDao {
	private Connection conn;

	public AccountDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Account getAccountByAccountNamePassword(String accountname, String password) throws Exception {
		String sql = " select account_id,phone,name,gender,age,birthday,id_card,balance,email,picture,vip,vip_date,vip_birthday"
				+ " from account where account_name=? and account_password=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, accountname);
		pstate.setString(2, password);
		ResultSet res = pstate.executeQuery();
		Account account = null;
		while (res.next()) {
			account = new Account(res.getInt(1), accountname, res.getString(2), password, res.getString(3),
					res.getInt(4), res.getInt(5), res.getString(6), res.getString(7), res.getDouble(8),
					res.getString(9), res.getString(10), res.getInt(11), res.getString(12), res.getString(13));
		}
		pstate.close();
		res.close();
		return account;
	}

	@Override
	public void doInsAccount(Account account) throws Exception {
		String sql = "insert into account(account_name,phone,account_password,name,email,id_card,vip_birthday) values(?,?,?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, account.getAccountName());
		pstate.setString(2, account.getPhone());
		pstate.setString(3, account.getAccountPassword());
		pstate.setString(4, account.getName());
		pstate.setString(5, account.getEmail());
		pstate.setString(6, account.getPicture());
		pstate.setDate(7, new java.sql.Date(new Date().getTime()));
		pstate.execute();
		pstate.close();
	}

	@Override
	public Account getAccountByAccountId(int accountid) throws Exception {
		String sql = " select account_name, phone,account_password,name,gender,age,birthday,id_card,balance,email,vip,vip_date,vip_birthday"
				+ " from account where account_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountid);
		ResultSet res = pstate.executeQuery();
		Account account = null;
		;
		while (res.next()) {
			account = new Account(accountid, res.getString(1), res.getString(2), res.getString(3), res.getString(4),
					res.getInt(5), res.getInt(6), res.getString(7), res.getString(8), res.getDouble(9),
					res.getString(10), "", res.getInt(11), res.getString(12), res.getString(13));
		}
		pstate.close();
		res.close();
		return account;

	}

	@Override
	public void updataAccountByAccountId(Account account) throws Exception {
		String sql = " update account set phone=?,name=?,gender=?,age=?,birthday=?,id_card=?,email=? where account_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, account.getPhone());
		pstate.setString(2, account.getName());
		pstate.setInt(3, account.getGender());
		pstate.setInt(4, account.getAge());
		pstate.setDate(5, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(account.getBirthday()).getTime()));
		pstate.setString(6, account.getIdCard());
		pstate.setString(7, account.getEmail());
		pstate.setInt(8, account.getAccountId());
		pstate.execute();
		pstate.close();
	}

	@Override
	public int getAccountByAccountName(String accountname) throws Exception {
		String sql = "select count(*) from account where account_name=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, accountname);
		ResultSet res = pstate.executeQuery();

		int count = 0;
		while (res.next()) {
			count = res.getInt(1);
		}
		pstate.close();
		res.close();
		return count;
	}

	@Override
	public void updataAccountByAccountId(int accountid, double balance) throws Exception {
		String sql = " update account set balance=balance+? where account_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setDouble(1, balance);
		pstate.setInt(2, accountid);
		pstate.execute();
		pstate.close();

	}

	@Override
	public void updataAccountBanlanceByAccountID(int accountid, double balance) throws Exception {
		String sql = "update account set balance=balance-? where account_id=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setDouble(1, balance);
		pstate.setInt(2, accountid);
		pstate.execute();
		pstate.close();
	}

	@Override
	public String getAccountPasswordByAccountId(int accountid, String password) throws Exception {
		String sql = "select account_password from account where account_id=? and account_password=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountid);
		pstate.setString(2, password);
		ResultSet res = pstate.executeQuery();
		String string = null;
		while (res.next()) {
			string=res.getString(1);
		}
		res.close();
		pstate.close();
		return string;
	}

	@Override
	public void updateAccountPasswordByAccountId(int accountid, String password) throws Exception {
		String sql = "update account set account_password=? where account_id=?  ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, password);
		pstate.setInt(2, accountid);
		pstate.execute();
		pstate.close();

	}

	@Override
	public void doInsAccountTrading(AccountTarding accountTarding) throws Exception {
		String sql = " insert into account_tarding(account_id,trading_date, tarding_prices,tarding_type,note) values(?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountTarding.getAccountId());
		pstate.setDate(2, new java.sql.Date(new Date().getTime()));
		pstate.setDouble(3, accountTarding.getTardingPrices());
		pstate.setInt(4, accountTarding.getTardingType());
		pstate.setString(5, accountTarding.getNote());
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<Location> getLocation(int accountid) throws Exception {
		String sql = " select location_id ,provinces,city,county,specific_location,default_location,consignee,phone"
				+ " from location where account_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountid);
		ResultSet res = pstate.executeQuery();
		List<Location> list = new ArrayList<>();
		while (res.next()) {

			Location location = new Location(res.getInt(1), accountid, res.getString(2), res.getString(3),
					res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getString(8));
			list.add(location);
		}
		pstate.close();
		res.close();
		return list;
	}

	@Override
	public void doInsLocation(Location location) throws Exception {
		String sql = "insert into location(account_id,provinces,city,county,specific_location,default_location,consignee,phone) value(?,?,?,?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, location.getAccountId());
		pstate.setString(2, location.getProvinces());
		pstate.setString(3, location.getCity());
		pstate.setString(4, location.getCounty());
		pstate.setString(5, location.getSpecificLocation());
		pstate.setInt(6, location.getDefaultLocation());
		pstate.setString(7, location.getConsignee());
		pstate.setString(8, location.getPhone());
		pstate.execute();
		pstate.close();
	}

	@Override
	public void updateLocation(Location location) throws Exception {
		/*
		 * int locationId, int accountId, String provinces, String city, String county,
		 * String specificLocation, int defaultLocation, String consignee, String phone
		 */
		String sql = "update location set provinces=?,city=?,county=?,specific_location=?,default_location=?,consignee=?,phone=? where location_id=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, location.getProvinces());
		pstate.setString(2, location.getCity());
		pstate.setString(3, location.getCounty());
		pstate.setString(4, location.getSpecificLocation());
		pstate.setInt(5, location.getDefaultLocation());
		pstate.setString(6, location.getConsignee());
		pstate.setString(7, location.getPhone());
		pstate.setInt(8, location.getLocationId());
		pstate.execute();
		pstate.close();
	}

	@Override
	public Location getUpdateLocation(int locationId) throws Exception {
		String sql = " select  account_id,provinces,city,county,specific_location,default_location,consignee,phone"
				+ " from location where location_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, locationId);
		ResultSet res = pstate.executeQuery();
		Location location = null;
		while (res.next()) {
			/*int locationId, int accountId, String provinces, String city, String county,
			String specificLocation, int defaultLocation, String consignee, String phone*/

			location = new Location(locationId,res.getInt(1), res.getString(2), res.getString(3),
					res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getString(8));
			
		}
		pstate.close();
		res.close();
		return location;
	}
	@Override
	public Account getAccount(int accountid) throws Exception {
		String sql=" select account_name, phone,account_password,name,gender,age,birthday,id_card,balance,email,picture,vip,vip_date,vip_birthday"
				+" from account where account_id=?";
		PreparedStatement pstate=this.conn.prepareStatement(sql);
		pstate.setInt(1, accountid);
		ResultSet res=pstate.executeQuery();
		Account account=null;;
		while(res.next()) {
			account=new Account(accountid,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6),
					res.getString(7),res.getString(8),res.getDouble(9),res.getString(10),res.getString(11),res.getInt(12),res.getString(13),res.getString(14));
			
		}
		pstate.close();
		res.close();
		return account;
		
	}

}
