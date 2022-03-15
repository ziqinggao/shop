package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dirsir.dao.CommodityStockDao;
import com.dirsir.dao.entities.CommodityStock;
import com.dirsir.dao.entities.MerchantRepertory;
import com.dirsir.dao.entities.MerchantReturn;
import com.dirsir.dao.entities.MerchantReturnV;
import com.dirsir.dao.entities.StockVV;

public class CommodityStockDaoImpl implements CommodityStockDao {
	public Connection conn;

	public CommodityStockDaoImpl(Connection conn) {
		this.conn = conn;
	}

	// 添加商品进货信息
	@Override
	public void doInsCommodityStock(CommodityStock commoditystock) throws Exception {
		String sql = " insert into commodity_stock(stock_id,merchant_id,commodity_id,"
				+ "subsort,stock_number,stock_price,stock_prices,procurement,"
				+ "buystock_date,supplier) values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commoditystock.getStockId());
		pstate.setInt(2, commoditystock.getMerchantId());
		pstate.setInt(3, commoditystock.getCommodityId());
		pstate.setString(4, commoditystock.getSubsort());
		pstate.setInt(5, commoditystock.getStockNumber());
		pstate.setDouble(6, commoditystock.getStockPrice());
		pstate.setDouble(7, commoditystock.getStockPrices());
		pstate.setString(8, commoditystock.getProcurement());
		pstate.setDate(9, new java.sql.Date(new Date().getTime()));
		pstate.setString(10, commoditystock.getSupplier());
		pstate.execute();
		pstate.close();

	}

	@Override
	public List<CommodityStock> getCommodityAllByMerchantId(int merchantid) throws Exception {
		String sql = "select stock_id,commodity_id,subsort,stock_number,stock_price,stock_prices,"
				+ "procurement,buystock_date,supplier from commodity_stock where merchant_id=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantid);
		ResultSet res = pstate.executeQuery();
		List<CommodityStock> list = new ArrayList<>();
		while (res.next()) {
			CommodityStock commoditystock = new CommodityStock(res.getInt(1), merchantid, res.getInt(2),
					res.getString(3), res.getInt(4), res.getDouble(5), res.getDouble(6), res.getNString(7),
					res.getString(8), res.getString(9));
			list.add(commoditystock);
		}
		pstate.close();
		res.close();
		return list;
	}

	// 通过商家ID获取商品类别返回list
	@Override
	public List<String> getCommodityStockByMerchantId(int commodityid) throws Exception {
		String sql = "select concat(a.sort_name,':',b.subsort_name) FROM commodity_sort a,commodity_subsort b WHERE a.sort_id=b.sort_id AND  a.commodity_id=?;";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityid);
		ResultSet res = pstate.executeQuery();
		List<String> list = new ArrayList<>();
		while (res.next()) {

			String subsort = res.getString(1);
			list.add(subsort);
		}
		res.close();
		pstate.close();
		return list;

	}

	// 修改进货清单
	@Override
	public void doUpdateCommodityStock(CommodityStock commoditystock) throws Exception {
		String sql = "update commodity_stock set  merchant_id=?,commodity_id=?, subsort=?,stock_number=?,stock_price=?,"
				+ "stock_prices=?,procurement=?,supplier=?  where stock_id=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commoditystock.getMerchantId());
		pstate.setInt(2, commoditystock.getCommodityId());
		pstate.setString(3, commoditystock.getSubsort());
		pstate.setInt(4, commoditystock.getStockNumber());
		pstate.setDouble(5, commoditystock.getStockPrice());
		pstate.setDouble(6, commoditystock.getStockPrices());
		pstate.setString(7, commoditystock.getProcurement());
		pstate.setString(8, commoditystock.getSupplier());
		pstate.setInt(9, commoditystock.getStockId());
		pstate.execute();
		pstate.close();

	}

	// 通过进货ID获取要修改的进货信息
	@Override
	public CommodityStock getCommodityStockBySortid(int stockid) throws Exception {
		String sql = "select  merchant_id,commodity_id, subsort,stock_number,stock_price,"
				+ "stock_prices,procurement,buystock_date,supplier from commodity_stock where stock_id=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, stockid);
		ResultSet res = pstate.executeQuery();
		CommodityStock commoditystock = null;
		while (res.next()) {
			commoditystock = new CommodityStock(stockid, res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4),
					res.getDouble(5), res.getDouble(6), res.getString(7), res.getString(8), res.getString(9));

		}
		pstate.close();
		res.close();
		return commoditystock;
	}

	// 通过商家ID获取退货信息
	@Override
	public List<MerchantReturnV> getMerchantReturnBymerchantid(int merchantid) throws Exception {
		String sql = "select stock_id,return_id,commodity_name,subsort,return_number,return_price,return_prices,"
				+ "return_cause, buystock_date,return_date from merchant_return_v where merchant_id=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy年MM月dd日";
		String str = "";
		DateFormat df = new SimpleDateFormat(pattern);
		pstate.setInt(1, merchantid);
		ResultSet res = pstate.executeQuery();
		List<MerchantReturnV> list = new ArrayList<>();
		while (res.next()) {
			str = df.format(res.getDate(9));
			str = df.format(res.getDate(10));
			MerchantReturnV merchantreturn = new MerchantReturnV(merchantid, res.getInt(1), res.getInt(2),
					res.getString(3), res.getString(4), res.getInt(5), res.getDouble(6), res.getDouble(7),
					res.getString(8), str, str);
			list.add(merchantreturn);
		}
		pstate.close();
		res.close();
		return list;

	}

	@Override
	public void doInsMerchantReturn(MerchantReturn merchantreturn) throws Exception {
		String sql = "insert into merchant_return ( stock_id,return_cause,return_date,"
				+ "return_number,return_price,return_prices) values(?,?,?,?,?,?) ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantreturn.getStockId());
		pstate.setString(2, merchantreturn.getReturnCause());
		pstate.setDate(3, new java.sql.Date(new Date().getTime()));
		pstate.setInt(4, merchantreturn.getReturnNumber());
		pstate.setDouble(5, merchantreturn.getReturnPrice());
		pstate.setDouble(6, merchantreturn.getReturnPrices());
		pstate.execute();
		pstate.close();

	}

	@Override
	public MerchantReturn getMerchantReturnByReturnId(int returnid) throws Exception {
		String sql = "select stock_id,return_cause,return_date,return_number,return_price,return_prices from merchant_return where return_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, returnid);
		ResultSet res = pstate.executeQuery();
		MerchantReturn merchantreturn = null;
		while (res.next()) {

			merchantreturn = new MerchantReturn(returnid, res.getInt(1), res.getString(2), res.getString(3),
					res.getInt(4), res.getDouble(5), res.getDouble(6));

		}
		pstate.close();
		res.close();
		return merchantreturn;
	}

	@Override
	public void UpdataMerchantReturn(MerchantReturn merchantreturn) throws Exception {
		String sql = "update merchant_return set stock_id=?,return_cause=?,return_number=?,"
				+ "return_price=?,return_prices=? where return_id=?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantreturn.getStockId());
		pstate.setString(2, merchantreturn.getReturnCause());
		pstate.setInt(3, merchantreturn.getReturnNumber());
		pstate.setDouble(4, merchantreturn.getReturnPrice());
		pstate.setDouble(5, merchantreturn.getReturnPrices());
		pstate.setInt(6, merchantreturn.getReturnId());
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<MerchantRepertory> getMerchantRepertoryByRepertory(int repertoryid) throws Exception {
		String sql = "select commodity_id, subsort,check_repertory,count_repertory,check_date,check_name from merchant_repertory where repertory_id";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, repertoryid);
		ResultSet res = pstate.executeQuery();
		List<MerchantRepertory> list = new ArrayList<>();
		while (res.next()) {

			MerchantRepertory merchantrepertory = new MerchantRepertory(repertoryid, res.getInt(1), res.getString(2),
					res.getInt(3), res.getInt(4), res.getString(5), res.getString(6));
			list.add(merchantrepertory);
		}
		pstate.close();
		res.close();
		return list;
	}

	@Override
	public List<StockVV> getStockVVBuystockDate(String buystockdate, int merchantid) throws Exception {
		String sql = "select stock_id,commodity_id,subsort,stock_number,stock_price,stock_prices,procurement,"
				+ "supplier,commodity_name from commodity_stock_v where merchant_id=? and date_format( buystock_date,'%Y-%m-%d')=? ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantid);
		pstate.setString(2, buystockdate);
		ResultSet res = pstate.executeQuery();
		List<StockVV> list = new ArrayList<>();
		while (res.next()) {
			StockVV stovkvv = new StockVV(res.getInt(1), merchantid, res.getInt(2), res.getString(3), res.getInt(4),
					res.getDouble(5), res.getDouble(6), res.getString(7), buystockdate, res.getString(8),
					res.getString(9));
			list.add(stovkvv);
		}
		pstate.close();
		res.close();
		return list;
	}

	@Override
	public List<MerchantReturnV> getMerchantReturnByMerchantId(int merchantid, String returndate) throws Exception {
		String sql = "select stock_id,return_id,commodity_name,subsort,return_number,return_price,return_prices,"
				+ "return_cause, buystock_date from merchant_return_v where merchant_id=? and date_format(return_date, '%Y-%m-%d')=? ";
		;
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantid);
		pstate.setString(2, returndate);
		ResultSet res = pstate.executeQuery();
		List<MerchantReturnV> list = new ArrayList<>();
		while (res.next()) {
			MerchantReturnV merchantreturnv = new MerchantReturnV(merchantid, res.getInt(1), res.getInt(2),
					res.getString(3), res.getString(4), res.getInt(5), res.getDouble(6), res.getDouble(7),
					res.getString(8), res.getString(9), returndate);
			list.add(merchantreturnv);
		}
		pstate.close();
		res.close();
		return list ;
	}

}
