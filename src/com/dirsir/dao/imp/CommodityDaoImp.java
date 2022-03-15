package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.CommodityDao;
import com.dirsir.dao.entities.Commodity;

public class CommodityDaoImp implements CommodityDao {
	Connection conn=null;
	public CommodityDaoImp(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<Commodity> getCommodityAllByMerchantId(int merchantId) throws Exception {
		List<Commodity> list=new ArrayList<>();
		String sql="select commodity_id,commodity_name, commodity_describe, price ,vip_price, subtype_id ,sale_info ,check_info, check_date ,admin_id "
				+ " from commodity where merchant_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, merchantId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Commodity commodity=new Commodity(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),merchantId,res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10));
			list.add(commodity);
		}
		res.close();
		ps.close();
		return list;
	}

	@Override
	public List<Commodity> getCommodityAllByCommodityNameLimit(String commodityName, int merchantId, int pages)
			throws Exception {
		List<Commodity> list=new ArrayList<Commodity>();
		String sql="select commodity_id,commodity_name, commodity_describe, price ,vip_price, subtype_id ,sale_info ,check_info, check_date ,admin_id "
				+ " from commodity where merchant_id=? and commodity_name like ? limit ?,10";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, merchantId);
		ps.setString(2,"%"+ commodityName+"%");
		ps.setInt(3, (pages-1)*10);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Commodity commodity=new Commodity(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),merchantId,res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10));
			list.add(commodity);
		}
		res.close();
		ps.close();
		return list;
	}
	
	@Override
	public int getSearchNumByCommodityName(String commodityName, int merchantId) throws Exception {
		String sql="select count(*) from commodity where merchant_id=? and commodity_name like ? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, merchantId);
		ps.setString(2, "%"+commodityName+"%");
		ResultSet res=ps.executeQuery();
		int count=0;
		while(res.next()) {
			count=res.getInt(1);
		}
		res.close();
		ps.close();
		return count;
	}
	

	@Override
	public void doInsCommodity(Commodity commodity) throws Exception {
		String sql="insert into commodity(commodity_name,commodity_describe,price,vip_price,subtype_id,merchant_id)values(?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, commodity.getCommodityName());
		ps.setString(2, commodity.getCommodityDescribe());
		ps.setDouble(3, commodity.getPrice());
		ps.setDouble(4, commodity.getVipPrice());
		ps.setInt(5, commodity.getSubtypeId());
		ps.setInt(6, commodity.getMerchantId());
		ps.execute();
		ps.close();
		
	}
	@Override
	public void doUpdSaleStateByMerchantIDAndCommodityIdAndSaleState(int merchantId, int commodityId, int saleState)
			throws Exception {
		String sql="update commodity set sale_info = ? where merchant_id=? and commodity_id=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, saleState);
		ps.setInt(2, merchantId);
		ps.setInt(3, commodityId);
		ps.execute();
		ps.close();
	}
	@Override
	public void doUpdCommodityInfo(Commodity commodity) throws Exception {
		String sql="update commodity set commodity_name=?,commodity_describe=?,price=?,vip_price=?,subtype_id=?,check_info=1,check_date=null where commodity_id=? and merchant_id=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1,commodity.getCommodityName() );
		ps.setString(2, commodity.getCommodityDescribe());
		ps.setDouble(3, commodity.getPrice());
		ps.setDouble(4, commodity.getVipPrice());
		ps.setInt(5, commodity.getSubtypeId());
		ps.setInt(6, commodity.getCommodityId());
		ps.setInt(7, commodity.getMerchantId());
		ps.execute();
		ps.close();
	}
	@Override
	public List<Commodity> getNewCommodity() throws Exception {
		List<Commodity> list=new ArrayList<>();
		String sql="select commodity_id,commodity_name, commodity_describe, price ,vip_price, subtype_id ,merchant_id,sale_info ,check_info, check_date ,admin_id from commodity where check_info=3 order by check_date desc ";
		Statement sta=conn.createStatement();
		ResultSet res=sta.executeQuery(sql);
		while (res.next()) {
			Commodity commodity=new Commodity(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9),res.getString(10),res.getInt(11));
			list.add(commodity);
		}
		res.close();
		sta.close();
		return list;
	}
	@Override
	public Commodity getCommodityInfoByCommodityId(int commodityId) throws Exception {
		Commodity commodity=null;
		String sql="select commodity_name, commodity_describe, price ,vip_price, subtype_id ,merchant_id,sale_info ,check_info, check_date ,admin_id from commodity where check_info=3 and commodity_id=? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			commodity=new Commodity(commodityId,res.getString(1),res.getString(2),res.getDouble(3),res.getDouble(4),res.getInt(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getString(9),res.getInt(10));
		}
		res.close();
		ps.close();
		return commodity;
	}
	@Override
	public int getSaleNumbyCommodityId(int commodityId) throws Exception {
		String sql="select count(*) from order_list_particulars where commodity_id=? and state=4";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, commodityId);
		ResultSet res=ps.executeQuery();
		int num=0;
		while(res.next()) {
			num=res.getInt(1);
		}
		res.close();
		ps.close();
		return num;
	}
	

}
