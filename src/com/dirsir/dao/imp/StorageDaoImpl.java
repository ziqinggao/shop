package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dirsir.dao.StorageDao;
import com.dirsir.dao.entities.OrderParticulars;
import com.dirsir.dao.entities.OrderParticularsV;
import com.dirsir.dao.entities.Repertory;
import com.dirsir.dao.entities.RepertoryV;


public class StorageDaoImpl implements StorageDao {
	Connection conn = null;

	public StorageDaoImpl() {
		super();
	}

	public StorageDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Integer> getCommodityById(int merchantId) throws Exception {
		List<Integer> intList = new ArrayList<>();
		String sql = "select commodity_id from Commodity where merchant_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		ResultSet res = pstate.executeQuery();
		int commodityId = 0;
		while (res.next()) {
			commodityId = res.getInt(1);
			intList.add(commodityId);
		}
		res.close();
		pstate.close();
		return intList;
	}

	/*@Override
	public List<OrderParticulars> getOrderParticulars(int commodityId) throws Exception {
		List<OrderParticulars> orderList = new ArrayList<>();
		OrderParticulars orderParticulars = null;
		String sql = "select particulars_id,order_id,commodity_id,subsort,commodity_number,"+
		"commodity_price,commodity_prices,buy_date,state from order_list_particulars where commodity_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityId);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			orderParticulars = new OrderParticulars();
			orderList.add(orderParticulars);
		}
		res.close();
		pstate.close();
		return orderList;
	}
*/
	@Override
	public void doUpdOrderParticulars(int particularsId,int state) throws Exception {
		String sql = "update order_list_particulars set state = ?,send_date = ? where particulars_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, state);
		pstate.setDate(2, new java.sql.Date(new Date().getTime()));
		pstate.setInt(3, particularsId);
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<OrderParticulars> getOrderparticulars(int merchantId) throws Exception {
		List<OrderParticulars> orderList = new ArrayList<>();
		OrderParticulars orderParticulars = null;
		String sql = "select particulars_id,order_id,commodity_id,subsort,commodity_number,commodity_price,commodity_prices,buy_date,state"+
						" from order_list_particulars where commodity_id in(select commodity_id from commodity where merchant_id = ?)"+
						" order by buy_date desc";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
//		String pattern = "yyyy年MM月dd日";
//		DateFormat df = new SimpleDateFormat(pattern);
		pstate.setInt(1, merchantId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
//			String str = df.format(res.getDate(8));
//			orderParticulars = new OrderParticulars(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getDouble(6),res.getDouble(7),str,res.getInt(9),);
			orderList.add(orderParticulars);
		}
		res.close();
		pstate.close();
		return orderList;
	}

	@Override
	public List<OrderParticularsV> getOrderParticularsV(int merchantId,int limit) throws Exception {
		List<OrderParticularsV> orderVList = new ArrayList<>();
		OrderParticularsV orderParticularsV = null;
		String sql = "select particulars_id,order_id,commodity_id,subsort,commodity_number,commodity_price,commodity_prices,buy_date,state,location,send_date"+
						" FROM order_list_v"+
						" WHERE commodity_id IN(SELECT commodity_id FROM commodity WHERE merchant_id = ?)"+
						" ORDER BY buy_date DESC limit ?,2";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy年MM月dd日";
		String str = "";
		DateFormat df = new SimpleDateFormat(pattern);
		pstate.setInt(1, merchantId);
		pstate.setInt(2, (limit-1)*1);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			str = df.format(res.getDate(8));
			orderParticularsV = new OrderParticularsV(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getDouble(6),res.getDouble(7),str,res.getInt(9),res.getString(10),res.getString(11));
			orderVList.add(orderParticularsV);
		}
		res.close();
		pstate.close();
		return orderVList;
	}

	@Override
	public List<OrderParticularsV> getOrderParticularsVByState(int merchantId,int state,int limit) throws Exception {
		List<OrderParticularsV> orderVList = new ArrayList<>();
		OrderParticularsV orderParticularsV = null;
		String sql = "select particulars_id,order_id,commodity_id,subsort,commodity_number,commodity_price,commodity_prices,buy_date,state,location,send_date"+
						" FROM order_list_v"+
						" WHERE commodity_id IN(SELECT commodity_id FROM commodity WHERE merchant_id = ?)and state = ?"+
						" ORDER BY buy_date DESC limit ?,2";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy年MM月dd日";
		String str = "";
		DateFormat df = new SimpleDateFormat(pattern);
		pstate.setInt(1, merchantId);
		pstate.setInt(2, state);
		pstate.setInt(3, (limit-1)*1);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			str = df.format(res.getDate(8));
			orderParticularsV = new OrderParticularsV(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getDouble(6),res.getDouble(7),str,res.getInt(9),res.getString(10),res.getString(11));
			orderVList.add(orderParticularsV);
		}
		res.close();
		pstate.close();
		return orderVList;
	}

	@Override
	public List<OrderParticularsV> getOrderParticularsVByDate(int merchantId,String sendDate,int limit) throws Exception {
		OrderParticularsV orderPV = null;
		List<OrderParticularsV> orderPVList = new ArrayList<>();
		String sql = "select particulars_id,order_id,commodity_id,subsort,commodity_number,commodity_price,commodity_prices,buy_date,state,location,send_date"+
				" FROM order_list_v"+
				" WHERE commodity_id IN(SELECT commodity_id FROM commodity WHERE merchant_id = ?)and send_date = ?"+
				" ORDER BY buy_date DESC limit ?,2";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date date = df.parse(sendDate);
		String str = "";
		pstate.setInt(1, merchantId);
		pstate.setDate(2, new java.sql.Date(date.getTime()));
		pstate.setInt(3, (limit-1)*1);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			str = df.format(res.getDate(8));
			orderPV = new OrderParticularsV(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getDouble(6),res.getDouble(7),str,res.getInt(9),res.getString(10),res.getString(11));
			orderPVList.add(orderPV);
		}
		res.close();
		pstate.close();
		return orderPVList;
	}

	@Override
	public int getCountOrderParticularsV(int merchantId) throws Exception {
		int count = 0;
		String sql = "select count(*)"+
				" FROM order_list_v"+
				" WHERE commodity_id IN(SELECT commodity_id FROM commodity WHERE merchant_id = ?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			count = res.getInt(1);
		}
		res.close();
		pstate.close();
		return count;
	}

	@Override
	public int getCountOrderParticularsVByState(int merchantId, int state) throws Exception {
		int count = 0;
		String sql = "select count(*)"+
						" FROM order_list_v"+
						" WHERE commodity_id IN(SELECT commodity_id FROM commodity WHERE merchant_id = ?)and state = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		pstate.setInt(2, state);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			count = res.getInt(1);
		}
		res.close();
		pstate.close();
		return count;
	}

	@Override
	public int getCountOrderParticularsVBytDate(int merchantId, String sendDate) throws Exception {
		int count = 0;
		String sql = "select count(*)"+
				" FROM order_list_v"+
				" WHERE commodity_id IN(SELECT commodity_id FROM commodity WHERE merchant_id = ?)and send_date = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date date = df.parse(sendDate);
		pstate.setInt(1, merchantId);
		pstate.setDate(2, new java.sql.Date(date.getTime()));
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			count = res.getInt(1);
		}
		res.close();
		pstate.close();
		return count;
	}

	@Override
	public List<Integer> getCommoditySortId(int merchantId) throws Exception {
		List<Integer> inList = new ArrayList<>();
		String sql = "SELECT sort_id FROM commodity_sort WHERE sort_state = 1 AND commodity_id IN(" + 
				"	SELECT commodity_id FROM commodity WHERE merchant_id = ? AND check_info = 3" + 
				")";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			int x = res.getInt(1);
			inList.add(x);
		}
		res.close();
		pstate.close();
		return inList;
	}
	@Override
	public List<Repertory> checkRepertory(List<Integer> intList) throws Exception {
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String str4 = ",";
		for (int i = 0; i < intList.size(); i++) {
			str2 += "a";
			str1 += " ( SELECT subsort_name FROM commodity_subsort" + 
					" WHERE subsort_state = 1 " + 
					" AND  sort_id = "+intList.get(i)+" ) "+str2;
			if(i != (intList.size()-1)) {
				str1 += str4;
			}
			str3 += str2+".subsort_name";
		}
		String sql = "SELECT commodity_id,subsort,SUM(check_repertory) check_repertory,SUM(check_repertory) count_repertory,check_date,check_name FROM(" + 
				" SELECT commodity_id,subsort,check_repertory,DATE_FORMAT(CURDATE(),'%Y-%c-%d') check_date,'当前登录人' check_name" + 
				" FROM(" + 
				" SELECT 1 commodity_id, CONCAT("+str3+") subsort,0 check_repertory  FROM " + 
				str1+
				" UNION ALL" + 
				"-- 昨天盘点的库存(以昨天的盘点库存为基础)" + 
				" SELECT commodity_id,subsort,check_repertory " + 
				" FROM merchant_repertory WHERE check_date = DATE_FORMAT(CURDATE()-1,'%Y-%c-%d') AND commodity_id = ?" + 
				" UNION ALL" + 
				"-- 今天的进货" + 
				" SELECT commodity_id,subsort,stock_number check_repertory FROM commodity_stock " + 
				" WHERE  commodity_id = ? AND buystock_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
				" UNION ALL" + 
				"-- 今天的退货" + 
				" SELECT c.commodity_id,c.subsort,b.return_number*-1 check_repertory  FROM merchant_return b,commodity_stock c" + 
				" WHERE b.stock_id = c.stock_id AND b.return_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
				" AND c.commodity_id = ?" + 
				" UNION ALL" + 
				"-- 今天的订单已发订单" + 
				" SELECT commodity_id,subsort,commodity_number*-1 check_repertory FROM order_list_particulars " + 
				" WHERE commodity_id = ? AND send_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
				" UNION ALL" + 
				"-- 今天的销售退货" + 
				" SELECT commodity_id,subsort,commodity_number check_repertory FROM order_list_particulars " + 
				" WHERE commodity_id = ? AND return_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
				" ) check_stock" + 
				" ) check_stock_sum GROUP BY commodity_id,subsort,check_date,check_name";
		this.conn.prepareCall(sql);
		return null;
	}

	@Override
	public List<Integer> getCommodityId(int merchantId) throws Exception {
		List<Integer> commodityIdList = new ArrayList<>();
		String sql = "SELECT commodity_id FROM commodity WHERE merchant_id = ? AND check_info = 3";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, merchantId);
		ResultSet res = pstate.executeQuery();
		Integer commodityId;
		while(res.next()) {
			commodityId = res.getInt(1);
			commodityIdList.add(commodityId);
		}
		res.close();
		pstate.close();
		return commodityIdList;
	}

	@Override
	public List<Integer> getSortId(List<Integer> commodityIdList) throws Exception {
		List<Integer> sortIdList = new ArrayList<>();
		String sql = "";
		String unionAll = " union all ";
		for (int i = 0; i < commodityIdList.size(); i++) {
			sql += " SELECT sort_id FROM commodity_sort WHERE commodity_id = "+commodityIdList.get(i)+" AND sort_state= 1 ";
			if(i < (commodityIdList.size()-1)) {
				sql += unionAll;
			}
		}
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		ResultSet res = pstate.executeQuery();
		Integer sortId;
		while(res.next()) {
			sortId = res.getInt(1);
			sortIdList.add(sortId);
		}
		res.close();
		pstate.close();
		return sortIdList;
	}

	@Override
	public List<Repertory> doCheckRepertory(List<Integer> commodityIdList) throws Exception {
		Repertory repertory = null;
		List<Repertory> repertoryList = new ArrayList<>();
		String sql = "";
		String unionAll = " union all ";
		for (int i = 0; i < commodityIdList.size(); i++) {
			String str1 = "";
			String str2 = "";
			String str3 = "";
			String str4 = ",";
			str2 = "a";
			List<Integer> sortIdList = getsortId(commodityIdList.get(i));
			for (int j = 0; j < sortIdList.size(); j++) {
				str1 += " ( SELECT subsort_name FROM commodity_subsort" + 
						" WHERE subsort_state = 1 " + 
						" AND  sort_id = "+sortIdList.get(j)+" ) "+str2;
				str3 += str2+".subsort_name";
				if(j < (sortIdList.size()-1)) {
					str1 += str4;
					str3 += str4;
				}
				str2 += "a";
			}
			sql += "SELECT commodity_id,subsort,SUM(check_repertory) check_repertory,SUM(check_repertory) count_repertory,check_date,check_name FROM(" + 
					" SELECT commodity_id,subsort,check_repertory,DATE_FORMAT(CURDATE(),'%Y-%c-%d') check_date,'当前登录人' check_name" + 
					" FROM(" + 
					" SELECT "+commodityIdList.get(i)+" commodity_id, CONCAT("+str3+") subsort,0 check_repertory  FROM " + 
					str1+
					" UNION ALL" + 
					//"-- 昨天盘点的库存(以昨天的盘点库存为基础)" + 
					" SELECT commodity_id,subsort,check_repertory " + 
					" FROM merchant_repertory WHERE check_date = DATE_FORMAT(CURDATE()-1,'%Y-%c-%d') AND commodity_id = "+commodityIdList.get(i)+ 
					" UNION ALL" + 
					//"-- 今天的进货" + 
					" SELECT commodity_id,subsort,stock_number check_repertory FROM commodity_stock " + 
					" WHERE  commodity_id = "+commodityIdList.get(i)+" AND buystock_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
					" UNION ALL" + 
					//"-- 今天的退货" + 
					" SELECT c.commodity_id,c.subsort,b.return_number*-1 check_repertory  FROM merchant_return b,commodity_stock c" + 
					" WHERE b.stock_id = c.stock_id AND b.return_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
					" AND c.commodity_id = "+commodityIdList.get(i)+ 
					" UNION ALL" + 
					//"-- 今天的订单已发订单" + 
					" SELECT commodity_id,subsort,commodity_number*-1 check_repertory FROM order_list_particulars " + 
					" WHERE commodity_id = "+commodityIdList.get(i)+" AND send_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
					" UNION ALL" + 
					//"-- 今天的销售退货" + 
					" SELECT commodity_id,subsort,commodity_number check_repertory FROM order_list_particulars " + 
					" WHERE commodity_id = "+commodityIdList.get(i)+" AND return_date = DATE_FORMAT(CURDATE(),'%Y-%c-%d')" + 
					" ) check_stock" + 
					" ) check_stock_sum GROUP BY commodity_id,subsort,check_date,check_name  ";
			if(i < (commodityIdList.size()-1)) {
				sql += unionAll;
			}
		}
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			repertory = new Repertory(0,res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getString(5),res.getString(6));
			repertoryList.add(repertory);
		}
		res.close();
		pstate.close();
		return repertoryList;
	}

	@Override
	public List<Integer> getsortId(int commodityId) throws Exception {
		List<Integer> sortIdList = new ArrayList<>();
		String sql = " SELECT sort_id FROM commodity_sort WHERE commodity_id = ? AND sort_state= 1 ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commodityId);
		ResultSet res = pstate.executeQuery();
		Integer sortId;
		while(res.next()) {
			sortId = res.getInt(1);
			sortIdList.add(sortId);
		}
		res.close();
		pstate.close();
		return sortIdList;
	}

	@Override
	public void doInsRepertory(int merchantId) throws Exception {
		String sql = "";
		String str = " , ";
		//在复写的方法中可，在一个方法中可以直接调用另一个方法
		List<Integer> commodityIdList = getCommodityId(merchantId);
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		List<Repertory> repertoryList = doCheckRepertory(commodityIdList);
		String s = "";
		for (int i = 0; i < repertoryList.size(); i++) {
			Date date = df.parse(repertoryList.get(i).getCheckDate());
			s += " ("+repertoryList.get(i).getCommodityId()+",'"+repertoryList.get(i).getSubsort()+"',"+repertoryList.get(i).getCheckRepertory()+","+repertoryList.get(i).getCountRepertory()+",'"+new java.sql.Date(date.getTime())+"','"+repertoryList.get(i).getCheckName()+"')";
			if(i < (repertoryList.size()-1)) {
				s += str;
			}
		}
		sql = "insert into merchant_repertory(commodity_id,subsort,check_repertory,count_repertory,check_date,check_name) values"+s+" ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<Repertory> getRepertory(String checkDate,int merchantId) throws Exception {
		List<Repertory> repertoryList = new ArrayList<>();
		Repertory repertory = null;
		String sql = "select repertory_id,commodity_id,subsort,check_repertory,count_repertory,check_date,check_name from merchant_repertory where check_date = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date date = df.parse(checkDate);
		pstate.setDate(1, new java.sql.Date(date.getTime()));
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			repertory = new Repertory(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getInt(5),res.getString(6),res.getString(7));
			repertoryList.add(repertory);
		}
		res.close();
		pstate.close();
		return repertoryList;
	}

	@Override
	public void doDelRepertory(String checkDate,int merchantId) throws Exception {
		String sql = "";
		String str = " , ";
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date date1 = df.parse(checkDate);
		List<Integer> commodityIdList = getCommodityId(merchantId);
		String s = "";
		for (int i = 0; i < commodityIdList.size(); i++) {
			s += commodityIdList.get(i)+"";
			if(i < (commodityIdList.size()-1)) {
				s += str;
			}
		}
		sql += "delete from merchant_repertory where check_date = '"+new java.sql.Date(date1.getTime())+"' and commodity_id in ("+s+")";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<RepertoryV> getRepertoryV(String checkDate, int merchantId) throws Exception {
		List<RepertoryV> repertoryListV = new ArrayList<>();
		RepertoryV repertoryV = null;
		String sql = "select repertory_id,commodity_id,merchant_id,commodity_name,subsort,check_repertory,count_repertory,check_date,check_name from repertory_v where check_date = ? and merchant_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Date date = df.parse(checkDate);
		pstate.setDate(1, new java.sql.Date(date.getTime()));
		pstate.setInt(2, merchantId);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			repertoryV = new RepertoryV(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5),res.getInt(6),res.getInt(7),res.getString(8),res.getString(9));
			repertoryListV.add(repertoryV);
		}
		res.close();
		pstate.close();
		return repertoryListV;
	}

	@Override
	public void doUpdRepertory(int repertoryId, int checkRepertory) throws Exception {
		String sql = "update merchant_repertory set check_repertory = ? where repertory_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, checkRepertory);
		pstate.setInt(2, repertoryId);
		pstate.execute();
		pstate.close();
	}

}
