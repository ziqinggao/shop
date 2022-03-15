package com.dirsir.service.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dirsir.dao.entities.Commodity;
import com.dirsir.dao.entities.CommodityStock;
import com.dirsir.dao.entities.MerchantRepertory;
import com.dirsir.dao.entities.MerchantReturn;
import com.dirsir.dao.entities.MerchantReturnV;
import com.dirsir.dao.entities.StockVV;
import com.dirsir.dao.factory.CommodityDaoFactory;
import com.dirsir.dao.factory.CommodityStockDaoFactory;
import com.dirsir.dao.factory.CommoditySubsortDaoFactory;
import com.dirsir.dao.factory.StockVVDaoFactory;
import com.dirsir.util.UtilConnection;

public class CommodityStockService {
	// 商品增加
	public boolean commodityAdd(CommodityStock commoditystock) {
		boolean flag = false;
		Connection conn = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			CommodityStockDaoFactory.getCommodityDaoInsater(conn).doInsCommodityStock(commoditystock);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	// 查找商品名字
	public List<Commodity> commodity(int merchantId) {
		Connection conn = null;
		List<Commodity> commodity = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			commodity = CommodityDaoFactory.getCommodityInstance(conn).getCommodityAllByMerchantId(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return commodity;

	}

	// 通过商品ID获取商品类别返回list
	public List<String> commoditySubsort(int commodityid) {
		Connection conn = null;
		List<String> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list =CommoditySubsortDaoFactory.getCommoditySubsortDaoInstance(conn).getSubsortByCommodityId(commodityid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 增加
	public boolean commodityStockUpdate(CommodityStock commoditystock) {
		boolean flag = false;
		Connection conn = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			CommodityStockDaoFactory.getCommodityDaoInsater(conn).doUpdateCommodityStock(commoditystock);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public CommodityStock stockId(int stockid) {
		Connection conn = null;
		CommodityStock commoditystock = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			commoditystock = CommodityStockDaoFactory.getCommodityDaoInsater(conn).getCommodityStockBySortid(stockid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commoditystock;

	}

	public List<MerchantReturnV> merchant(int merchantid) {
		Connection conn = null;
		List<MerchantReturnV> list = new ArrayList<>();

		try {
			conn = UtilConnection.getMySQLConnection();
			list = CommodityStockDaoFactory.getCommodityDaoInsater(conn).getMerchantReturnBymerchantid(merchantid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public List<StockVV> commodityStock(int merchantid) {
		Connection conn = null;
		List<StockVV> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list = StockVVDaoFactory.getCommodityStockDaoInstaer(conn).getStockVVAllByMerchanId(merchantid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public boolean merchantReturn(MerchantReturn merchantreturn) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = UtilConnection.getMySQLConnection();
			CommodityStockDaoFactory.getCommodityDaoInsater(conn).doInsMerchantReturn(merchantreturn);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return flag;

	}

	public MerchantReturn getMerchantReturn(int returnid) {
		Connection conn = null;
		MerchantReturn merchantreturn = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			merchantreturn = CommodityStockDaoFactory.getCommodityDaoInsater(conn)
					.getMerchantReturnByReturnId(returnid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return merchantreturn;

	}

	public boolean updataMerchantReturn(MerchantReturn merchantreturn) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = UtilConnection.getMySQLConnection();
			CommodityStockDaoFactory.getCommodityDaoInsater(conn).UpdataMerchantReturn(merchantreturn);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;

	}

	public List<MerchantRepertory> getMerchantRepertory(int repertoryid) {
		Connection conn = null;
		List<MerchantRepertory> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list = CommodityStockDaoFactory.getCommodityDaoInsater(conn).getMerchantRepertoryByRepertory(repertoryid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public List<StockVV> seeCommodityStock(String buystockdate, int merchantid) {
		Connection conn = null;
		List<StockVV> list = new ArrayList<>();
		try {
			conn = UtilConnection.getMySQLConnection();
			list = CommodityStockDaoFactory.getCommodityDaoInsater(conn).getStockVVBuystockDate(buystockdate,
					merchantid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public List<MerchantReturnV> getMerchantReturnV(int merchantid, String returndate) {
		Connection conn = null;
		List<MerchantReturnV> list = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			list = CommodityStockDaoFactory.getCommodityDaoInsater(conn).getMerchantReturnByMerchantId(merchantid,
					returndate);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
