package com.dirsir.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.dirsir.dao.factory.CommoditySortDaoFactory;

public class test {
	public static void main(String[] args) {
		Connection conn=UtilConnection.getMySQLConnection();
		int commodityId=4;
		try {
			System.out.println("hello");
			List<Integer> list=CommoditySortDaoFactory.getCommoditySortDaoInstance(conn).getSortIdByCommodityIdAndMerchantId(commodityId);
			String sql=GetSubsortSQL.getsubsortSql(list, commodityId);
			System.out.println(sql);
			Statement sta=conn.createStatement();
			ResultSet res=sta.executeQuery(sql);
			while(res.next()) {
				System.out.println(res.getInt(1)+"::"+res.getString(2));
			}
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
