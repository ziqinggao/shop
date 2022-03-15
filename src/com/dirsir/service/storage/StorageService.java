package com.dirsir.service.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.OrderParticulars;
import com.dirsir.dao.entities.OrderParticularsV;
import com.dirsir.dao.entities.Repertory;
import com.dirsir.dao.entities.RepertoryV;
import com.dirsir.dao.factory.StorageDaoFactory;
import com.dirsir.util.UtilConnection;

public class StorageService {
	
	/*//传入商家id查询出所有的商品信息,错误想法
	public List<OrderParticulars> getOrderParticulars(int merchantId){
		Connection conn = UtilConnection.getMySQLConnection();
		List<OrderParticulars> orderList = new ArrayList<>();
		try {
			List<Integer> intList = StorageDaoFactory.getStorageDaoIntance(conn).getCommodityById(merchantId);
			for (int i = 0; i < intList.size(); i++) {
				System.out.println(intList.get(i));
//				List<OrderParticulars> orderList1 = StorageDaoFactory.getStorageDaoIntance(conn).getOrderParticulars(intList.get(i));
			}
			for (Integer commodityId : intList) {
				System.out.println(commodityId);
				for (OrderParticulars orderParticulars : orderList1) {
					orderList.add(orderParticulars);
				}
			}
			for (OrderParticulars orderParticulars : orderList) {
				System.out.println(orderParticulars);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
 	}*/
	//传入商家Id查询出详情表所有信息
	public List<OrderParticulars> getOrderParticulars(int merchantId){
		Connection conn = UtilConnection.getMySQLConnection();
		List<OrderParticulars> orderList = null;
		try {
			orderList = StorageDaoFactory.getStorageDaoIntance(conn).getOrderparticulars(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	//传入商家ID查询视图中的数据
	public List<OrderParticularsV> getOrderParticularsV(int merchantId,int limit){
		List<OrderParticularsV> orderVList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			orderVList = StorageDaoFactory.getStorageDaoIntance(conn).getOrderParticularsV(merchantId,limit);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderVList;
	}
	//商家修改订单状态
	public void doUpdOrderParticulars(int particularsId,int state) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			StorageDaoFactory.getStorageDaoIntance(conn).doUpdOrderParticulars(particularsId, state);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	//根据状态查询自己的订单
	public List<OrderParticularsV> getOrderParticularsVByState(int merchantId,int state,int limit){
		List<OrderParticularsV> orderVList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			orderVList = StorageDaoFactory.getStorageDaoIntance(conn).getOrderParticularsVByState(merchantId, state,limit);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderVList;
	}
	//根据发货日期查询商家订单
	public List<OrderParticularsV> getOrderParticularsVBySendDate(int merchantId,String sendDate,int limit){
		List<OrderParticularsV> orderPVList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			orderPVList = StorageDaoFactory.getStorageDaoIntance(conn).getOrderParticularsVByDate(merchantId, sendDate,limit);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderPVList;
	}
	//根据视图查询订单数据,返回有多少条数据
	public int getCountOrderParticularsV(int merchantId) {
		int count = 0;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			count = StorageDaoFactory.getStorageDaoIntance(conn).getCountOrderParticularsV(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	};
		
	//订单状态查询订单数据,返回有多少条数据
	public int getCountOrderParticularsVByState(int merchantId,int state) {
		int count = 0;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			count = StorageDaoFactory.getStorageDaoIntance(conn).getCountOrderParticularsVByState(merchantId, state);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	};
		
	//发货日期查询数据，返回共有多少条数据
	public int getCountOrderParticularsVBytDate(int merchantId,String sendDate) {
		int count = 0;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			count = StorageDaoFactory.getStorageDaoIntance(conn).getCountOrderParticularsVBytDate(merchantId, sendDate);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	};
	
	//根据商家Id查询，查询所有的商品Id，在查询出所有的类别id，最后得到拼凑出当天盘点信息,不需要在这里进行操作
	public List<Repertory> getRepertoryList(int merchantId){
		Connection conn = UtilConnection.getMySQLConnection();
		List<Integer> commodityIdList = null;
		List<Repertory> repertoryList = null;
		try {
			commodityIdList = StorageDaoFactory.getStorageDaoIntance(conn).getCommodityId(merchantId);
			repertoryList = StorageDaoFactory.getStorageDaoIntance(conn).doCheckRepertory(commodityIdList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return repertoryList;
	}
	
	//将信息循环插入到库存表中
	public void doInsRepertory(int merchantId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			StorageDaoFactory.getStorageDaoIntance(conn).doInsRepertory(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//查询商家有这一天时间的数据
	public void getRepertory(String checkDate,int merchantId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			StorageDaoFactory.getStorageDaoIntance(conn).getRepertory(checkDate, merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//删除商家当天的数据
	public void doDelRepertory(String checkDate,int merchantId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			StorageDaoFactory.getStorageDaoIntance(conn).doDelRepertory(checkDate, merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//查询商家有这一天时间的数据
	public List<RepertoryV> getRepertoryV(String checkDate,int merchantId) {
		Connection conn = UtilConnection.getMySQLConnection();
		List<RepertoryV> repertoryV = null;
		try {
			repertoryV = StorageDaoFactory.getStorageDaoIntance(conn).getRepertoryV(checkDate, merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return repertoryV;
	}
	
	//修改盘点库存
	public void doUpdRepertory(int repertoryId,int checkRepertory) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			StorageDaoFactory.getStorageDaoIntance(conn).doUpdRepertory(repertoryId, checkRepertory);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
