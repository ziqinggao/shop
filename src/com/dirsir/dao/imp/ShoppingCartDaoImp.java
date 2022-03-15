package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.ShoppingCartDao;
import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.ShoppingCart;
import com.dirsir.dao.entities.ShoppingCartV;
import com.dirsir.dao.entities.commodity.CommoditySubsort;

public class ShoppingCartDaoImp implements ShoppingCartDao {
	private Connection conn=null;
	public ShoppingCartDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public void doUpdShoppingCart(ShoppingCart shopping) throws Exception {
		String sql="update shopping_cart set commodity_id=? ,subsort=?,commodity_number=?,commodity_price=?,commodity_prices=? where cart_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, shopping.getCommodityId());
		ps.setString(2, shopping.getSubsort());
		ps.setInt(3, shopping.getCommodityNumber());
		ps.setDouble(4, shopping.getCommodityPrice());
		ps.setDouble(5,shopping.getCommodityPrices());
		ps.setInt(6, shopping.getCartId());
		ps.execute();
		ps.close();
	}

	@Override
	public void doInsShoppingCart(ShoppingCart shopping) throws Exception {
		String sql="insert into shopping_cart(account_id,commodity_id,subsort,commodity_number,commodity_price,commodity_prices) values(?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, shopping.getAccountId());
		ps.setInt(2, shopping.getCommodityId());
		ps.setString(3, shopping.getSubsort());
		ps.setInt(4, shopping.getCommodityNumber());
		ps.setDouble(5, shopping.getCommodityPrice());
		ps.setDouble(6, shopping.getCommodityPrices());
		ps.execute();
		ps.close();
	}

	@Override
	public int getCartSbyAccountId(int accountId) throws Exception {
		int num=0;
		String sql="select count(*) from shopping_cart_v where account_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, accountId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			num=res.getInt(1);
		}
		return num;
	}

	@Override
	public ShoppingCart getShoppingCartByCommodityIdAndAccountIdAndSubsort(int commodityId, int accountId,
			String subSort) throws Exception {
		ShoppingCart shopping=null;
		String sql="select cart_id,commodity_number,commodity_price,commodity_prices from shopping_cart where commodity_id=? and account_id=? and subsort=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ps.setInt(2, accountId);
		ps.setString(3, subSort);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			shopping=new ShoppingCart(res.getInt(1),accountId,commodityId,subSort,res.getInt(2),res.getDouble(3),res.getDouble(4));
		}
		return shopping;
	}
	
	@Override
	public List<ShoppingCartV> getShoppingCartV(int accountId) throws Exception {
		List<ShoppingCartV> cartVList = new ArrayList<>();
		ShoppingCartV cartV = null;
		String sql = "select cart_id,account_id,commodity_id,merchant_id,subsort,commodity_number,commodity_price,"
						+"commodity_prices,merchant_name,commodity_name,price,vip_price,picture_url from shopping_cart_v where account_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			cartV = new ShoppingCartV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getInt(6),res.getDouble(7),res.getDouble(8),
									res.getString(9),res.getString(10),res.getDouble(11),res.getDouble(12),res.getString(13));
			cartVList.add(cartV);
		}
		res.close();
		pstate.close();
		return null;
	}

	@Override
	public List<ShoppingCart> getShoppingCart(int cartId) throws Exception {
		List<ShoppingCart> cartList = new ArrayList<>();
		ShoppingCart cart = null;
		String sql = "select cart_id,account_id,commodity_id,subsort,commodity_number,commodity_price,commodity_prices "+
						"from shopping_cart where = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, cartId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			cart = new ShoppingCart(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getDouble(6),res.getDouble(7));
			cartList.add(cart);
		}
		res.close();
		pstate.close();
		return cartList;
	}


	@Override
	public List<CommoditySort> getSortByCommodityId(int commodityId) throws Exception {
		List<CommoditySort> sortList = new ArrayList<>();
		CommoditySort sort = null;
		String sql = "select sort_id,commodity_id,sort_name,sort_state,sort_code from commodity_sort where commodity_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			sort = new CommoditySort(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getInt(5));
			sortList.add(sort);
		}
		res.close();
		pstate.close();
		return sortList;
	}

	@Override
	public List<CommoditySubsort> getSubsortBySortId(CommoditySort sort) throws Exception {
		List<CommoditySubsort> subsortList = new ArrayList<>();
		CommoditySubsort subsort = null;
		String sql = "select subsort_id,sort_id,subsort_name,subsort_price,vip_price,subsort_state,subsort_code"+
						" from commodity_subsort where sort_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, sort.getSortId());
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			subsort = new CommoditySubsort(res.getInt(1),res.getInt(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),res.getInt(7));
			subsortList.add(subsort);
		}
		res.close();
		pstate.close();
		return subsortList;
	}


	@Override
	public List<Integer> getMerchantId(int accountId) throws Exception {
		List<Integer> intList = new ArrayList<>();
		String sql = "SELECT DISTINCT merchant_id FROM shopping_cart_v WHERE account_id = ? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, accountId);
		Integer a = null;
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			a = res.getInt(1);
			intList.add(a);
		}
		res.close();
		pstate.close();
		return intList;
	}


	@Override
	public List<ShoppingCartV> getShoppingCartVByMerchantId(int merchantId) throws Exception {
		List<ShoppingCartV> cartVList = new ArrayList<>();
		ShoppingCartV cartV = null;
		String sql = "select cart_id,account_id,commodity_id,merchant_id,subsort,commodity_number,commodity_price,"
				+"commodity_prices,merchant_name,commodity_name,price,vip_price,picture_url from shopping_cart_v where merchant_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			cartV = new ShoppingCartV(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getInt(6),res.getDouble(7),res.getDouble(8),
					res.getString(9),res.getString(10),res.getDouble(11),res.getDouble(12),res.getString(13));
			cartVList.add(cartV);
		}
		res.close();
		pstate.close();
		return cartVList;
	}


	@Override
	public List<List<ShoppingCartV>> getShoppingCartVList(int accountId) throws Exception {
		List<Integer> intList = getMerchantId(accountId);
		List<List<ShoppingCartV>> list = new ArrayList<>();
		for (int i = 0; i < intList.size(); i++) {
			List<ShoppingCartV> cartVList = getShoppingCartVByMerchantId(intList.get(i));
			list.add(cartVList);
		}
		return list;
	}


	@Override
	public List<List<CommoditySubsort>> getSortAndSubsort(int commodityId) throws Exception {
		List<CommoditySort> sortList = getSortByCommodityId(commodityId);
		List<List<CommoditySubsort>> list = new ArrayList<>();
		for (int i = 0; i < sortList.size(); i++) {
			List<CommoditySubsort> subsortList = getSubsortBySortId(sortList.get(i));
			list.add(subsortList);
		}
		return list;
	}


	@Override
	public int getCheckRepertory(String subsort) throws Exception {
		String sql = "SELECT check_repertory FROM merchant_repertory WHERE subsort = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, subsort);
		ResultSet res = pstate.executeQuery();
		int x = 0;
		while(res.next()) {
			x = res.getInt(1);
		}
		res.close();
		pstate.close();
		return x;
	}


	@Override
	public void doUpdCommodityNumberAndPrices(int cartId, int commodityNumber) throws Exception {
		String sql = "update shopping_cart set commodity_number = ?,commodity_prices = commodity_price * ? where cart_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityNumber);
		pstate.setDouble(2, commodityNumber);
		pstate.setInt(3, cartId);
		pstate.execute();
		pstate.close();
	}


	@Override
	public void doDelCartId(int cartId) throws Exception {
		String sql = "delete from shopping_cart where cart_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, cartId);
		pstate.execute();
		pstate.close();
	}


	@Override
	public void doUpaSubsort(int cartId, String subsort) throws Exception {
		String sql = "update shopping_cart set subsort = ? where cart_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, subsort);
		pstate.setInt(2, cartId);
		pstate.execute();
		pstate.close();
	}
	

}
