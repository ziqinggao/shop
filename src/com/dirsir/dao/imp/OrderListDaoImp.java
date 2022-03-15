package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.OrderListDao;
import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.dao.entities.ShoppingCartV;

public class OrderListDaoImp implements OrderListDao{

	Connection conn = null;
	
	public OrderListDaoImp(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public AccountLocation getDefaultLocation(int accountId) throws Exception {
		AccountLocation accountLocation = null;
		String sql = "select location_id,account_id,provinces,city,county,specific_location,default_location,consignee,phone"+
						" from location where account_id = ? and default_location = 1";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			accountLocation = new AccountLocation(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5)
							,res.getString(6),res.getInt(7),res.getString(8),res.getString(9));
		}
		res.close();
		pstate.close();
		return accountLocation;
	}

	@Override
	public List<AccountLocation> getLocations(int accountId) throws Exception {
		List<AccountLocation> listLocation = new ArrayList<>();
		AccountLocation accountLocation = null;
		String sql = "select location_id,account_id,provinces,city,county,specific_location,default_location,consignee,phone"+
				" from location where account_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			accountLocation = new AccountLocation(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5)
					,res.getString(6),res.getInt(7),res.getString(8),res.getString(9));
			listLocation.add(accountLocation);
		}
		res.close();
		pstate.close();
		return listLocation;
	}

	@Override
	public void doInsLocation(AccountLocation accountLocation) throws Exception {
		String sql = "insert into location(account_id,provinces,city,county,specific_location,default_location,consignee,phone)"
				+ " value(?,?,?,?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountLocation.getAccountId());
		pstate.setString(2, accountLocation.getProvinces());
		pstate.setString(3, accountLocation.getCity());
		pstate.setString(4, accountLocation.getCounty());
		pstate.setString(5, accountLocation.getSpecificLocation());
		pstate.setInt(6, accountLocation.getDefaultLocation());
		pstate.setString(7, accountLocation.getConsignee());
		pstate.setString(8, accountLocation.getPhone());
		pstate.execute();
		pstate.close();
	}

	@Override
	public ShoppingCartV getShoppingCartVInfo(int cartId) throws Exception {
		ShoppingCartV cartV = null;
		String sql = "select cart_id,account_id,commodity_id,merchant_id,subsort,commodity_number,commodity_price,"
				+"commodity_prices,merchant_name,commodity_name,price,vip_price,picture_url from shopping_cart_v where cart_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, cartId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			cartV = new ShoppingCartV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getInt(6),res.getDouble(7),res.getDouble(8),
					res.getString(9),res.getString(10),res.getDouble(11),res.getDouble(12),res.getString(13));
		}
		res.close();
		pstate.close();
		return cartV;
	}

}
