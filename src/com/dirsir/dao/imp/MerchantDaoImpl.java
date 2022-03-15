package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dirsir.dao.MerchantDao;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.entities.MerchantTarding;

public class MerchantDaoImpl implements MerchantDao {
	private Connection conn;

	public MerchantDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Merchant getMerchantByAaccountAndMerchantPassword(String account, String merchantPaasword) throws Exception {
		String sql = "select merchant_id, merchant_name, unify_code,manage,location,money,corp,corp_phone,director,director_phone,merchant_balance,record_date,record_state,admin_id,check_date,license_picture,corp_picture "
				+ "from merchant where account=? and merchant_password=? and record_state=3";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, account);
		pstate.setString(2, merchantPaasword);
		ResultSet res = pstate.executeQuery();
		Merchant merchant = null;
		while (res.next()) {
			merchant = new Merchant(res.getInt(1), res.getString(2), account, null, res.getString(3), res.getString(4),
					res.getString(5), res.getDouble(6), res.getString(7), res.getString(8), res.getString(9),
					res.getString(10), res.getDouble(11), res.getString(12), res.getInt(13), res.getInt(14),
					res.getString(15),res.getString(16),res.getString(17));
		}
		res.close();
		pstate.close();
		return merchant;

	}

	@Override
	public void doInsMerchant(Merchant merchant) throws Exception {

		String sql = " insert into merchant( merchant_name, account, merchant_password, unify_code,"
				+ "manage, location,money, corp, corp_phone, director, director_phone,record_date,license_picture,corp_picture)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, merchant.getMerchantName());
		pstate.setString(2, merchant.getAccount());
		pstate.setString(3, merchant.getMerchantPassword());
		pstate.setString(4, merchant.getUnifyCode());
		pstate.setString(5, merchant.getManage());
		pstate.setString(6, merchant.getLocation());
		pstate.setDouble(7, merchant.getMoney());
		pstate.setString(8, merchant.getCorp());
		pstate.setString(9, merchant.getCorpPhone());
		pstate.setString(10, merchant.getDirector());
		pstate.setString(11, merchant.getDirectorPhone());
		pstate.setDate(12, new java.sql.Date(new Date().getTime()));
		pstate.setString(13, merchant.getLicensPicture());
		pstate.setString(14, merchant.getCorpPicture());
		pstate.execute();
		pstate.close();

	}


	@Override
	public Merchant getMerchantByCommodityId(int commodityId) throws Exception {
		String sql = "select merchant_name,unify_code,manage,location,money,record_state "
				+ " from merchant m,commodity c where m.merchant_id=c.merchant_id and c.commodity_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityId);
		ResultSet res = pstate.executeQuery();
		Merchant merchant = null;
		while (res.next()) {
			/*int merchantId, String merchantName, String account, String merchantPassword, String unifyCode,
			String manage, String location, double money, String corp, String corpPhone, String director,
			String directorPhone, double merchantBalance, String recordDate, int recordState, int adminId,
			String checkDate, String licensPicture, String corpPicture)*/
			merchant = new Merchant(0, res.getString(1), null, null, res.getString(2), res.getString(3),res.getString(4)
									, res.getDouble(5), null, null,null,null, 0, null, res.getInt(6), 0,null,null,null);
		}
		res.close();
		pstate.close();
		return merchant;
	}

	@Override
	public int getMerchantByAccount(String account) throws Exception {
		String sql = " select count(*)  from merchant where account=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, account);
		ResultSet res = pstate.executeQuery();
		int count = 0;
		while (res.next()) {
			count = res.getInt(1);
		}
		res.close();
		pstate.close();
		return count;
	}
	
	@Override
	public Merchant getMerchantInfo(String account) throws Exception {
		String sql = "select merchant_id, merchant_name, unify_code,manage,location,money,corp,corp_phone,director,director_phone,merchant_balance,record_date,record_state,admin_id,check_date,license_picture,corp_picture "
				+ "from merchant where account=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, account);
		ResultSet res = pstate.executeQuery();
		Merchant merchant = null;
		while (res.next()) {
			merchant = new Merchant(res.getInt(1), res.getString(2), account, null, res.getString(3), res.getString(4),
					res.getString(5), res.getDouble(6), res.getString(7), res.getString(8), res.getString(9),
					res.getString(10), res.getDouble(11), res.getString(12), res.getInt(13), res.getInt(14),
					res.getString(15),res.getString(16),res.getString(17));
		}
		res.close();
		pstate.close();
		return merchant;
	}

	@Override
	public void upaMerchantDirectorAndDirectorPhoneAndLicensPicture(String account,String corpPhone,String director,String directorPhone) throws Exception {
		String sql = "update merchant set corp_phone = ?,director = ?,director_phone = ? where account = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, corpPhone);
		pstate.setString(2, director);
		pstate.setString(3, directorPhone);
		pstate.setString(4, account);
		pstate.execute();
		pstate.close();
	}

	@Override
	public void merchantBalanceIn(String account,double merchantBalance) throws Exception {
		String sql = "update merchant set merchant_balance = merchant_balance + ? where account = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setDouble(1, merchantBalance);
		pstate.setString(2, account);
		pstate.execute();
		pstate.close();
	}

	@Override
	public void merchantBlanceOut(String account, double merchantBalance) throws Exception {
		String sql = "update merchant set merchant_balance = merchant_balance - ? where account = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setDouble(1, merchantBalance);
		pstate.setString(2, account);
		pstate.execute();
		pstate.close();
	}

	@Override
	public void updPassWord(String account, String oldPassWord, String newPassWord) throws Exception {
		String sql = "update merchant set merchant_password = ? where merchant_password = ? and account = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, newPassWord);
		pstate.setString(2, oldPassWord);
		pstate.setString(3, account);
		pstate.execute();
		pstate.close();
	}

	@Override
	public void doInsMerchantTarding(MerchantTarding tarding) throws Exception {
		String sql = "insert into merchant_tarding(merchant_id,tarding_date,tarding_prices,tarding_state,tarding_note) value(?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, tarding.getMerchantID());
		pstate.setDate(2, new java.sql.Date(new Date().getTime()));
		pstate.setDouble(3, tarding.getTardingPrices());
		pstate.setInt(4, tarding.getTardingState());
		pstate.setString(5, tarding.getTardingNote());
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<MerchantTarding> getMerchantTarding(int merchantId) throws Exception {
		List<MerchantTarding> tardingList = new ArrayList<>();
		MerchantTarding tarding = null;
		String tardingDate = "";
		String pattern = "yyyy年 MM月 dd日 HH时 mm分 ss.SSS毫秒 ";
		DateFormat df = new SimpleDateFormat(pattern);
		String sql = "select tarding_id,merchant_id,tarding_date,tarding_prices,tarding_state,tarding_note from merchant_tarding where merchant_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,merchantId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			//将date类型转换成String类型使用format（）方法，将String类型转换成date类型，使用parse（）方法
			tardingDate = df.format(res.getDate(3));
			tarding = new MerchantTarding(res.getInt(1),res.getInt(2),tardingDate,res.getDouble(4),res.getInt(5),res.getString(6));
			tardingList.add(tarding);
		}
		res.close();
		pstate.close();
		return tardingList;
	}

}
