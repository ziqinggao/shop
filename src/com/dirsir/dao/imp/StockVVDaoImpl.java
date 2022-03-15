package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.StockVVDao;
import com.dirsir.dao.entities.StockVV;

public class StockVVDaoImpl implements StockVVDao {
	public Connection conn;

	public StockVVDaoImpl(Connection conn) {
		this.conn = conn;
	}
//根据视图获取进货清单，分页
	@Override
	public List<StockVV> getStockVVAllByMerchanId(int merchantId , int pages) throws Exception {
		String sql = "select stock_id,merchant_id,commodity_id,subsort,stock_number,stock_price,stock_prices,procurement,buystock_date,"
				+ "supplier,commodity_name from commodity_stock_v where merchant_id=?  limit ?,10";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		pstate.setInt(2, (pages-1)*10);
		ResultSet res = pstate.executeQuery();
		List<StockVV> list = new ArrayList<>();
	/*int stockId, int merchantId, int commodityId, String subsort, int stockNumber, double stockPrice,
			double stockPrices, String procurement, String buystockDate, String supplier, String commodityName */
		while (res.next()) {
			StockVV stockvv = new StockVV(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getInt(5),
					res.getDouble(6), res.getDouble(7), res.getString(8), res.getString(9), res.getString(10),
					res.getString(11));
			list.add(stockvv);

		}
		res.close();
		pstate.close();
		return list;
	}
//获取商品类别
	@Override
	public List<StockVV> getStockVVSubsortByCommodityId(int commodityid) throws Exception {
		String sql="select stock_id,merchant_id,commodity_id,subsort,stock_number,stock_price,stock_prices,procurement,buystock_date,"
				+ "supplier,commodity_name  from commodity_stock_v where commodity_id=?";
		PreparedStatement pstate=this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityid);
		ResultSet res=pstate.executeQuery();
		List<StockVV> list = new ArrayList<>();
		while (res.next()) {
			StockVV stockvv = new StockVV(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getInt(5),
					res.getDouble(6), res.getDouble(7), res.getString(8), res.getString(9), res.getString(10),
					res.getString(11));
			list.add(stockvv);
			
		}
		res.close();
		pstate.close();
		return list;
	}
	@Override
	
		public List<StockVV> getStockVVAllByMerchanId(int merchantId ) throws Exception {
			String sql = "select stock_id,merchant_id,commodity_id,subsort,stock_number,stock_price,stock_prices,procurement,buystock_date,"
					+ "supplier,commodity_name from commodity_stock_v where merchant_id=?  ";
			PreparedStatement pstate = this.conn.prepareStatement(sql);
			pstate.setInt(1, merchantId);
			ResultSet res = pstate.executeQuery();
			List<StockVV> list = new ArrayList<>();
		/*int stockId, int merchantId, int commodityId, String subsort, int stockNumber, double stockPrice,
				double stockPrices, String procurement, String buystockDate, String supplier, String commodityName */
			while (res.next()) {
				StockVV stockvv = new StockVV(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getInt(5),
						res.getDouble(6), res.getDouble(7), res.getString(8), res.getString(9), res.getString(10),
						res.getString(11));
				list.add(stockvv);

			}
			res.close();
			pstate.close();
			return list;
		}
	}



