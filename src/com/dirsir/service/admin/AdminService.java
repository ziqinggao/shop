package com.dirsir.service.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.Admin;
import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.dao.entities.CommodityType;
import com.dirsir.dao.entities.CommodityV;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.factory.AdminDaoFcatory;
import com.dirsir.util.UtilConnection;

public class AdminService {
	// 查看所有的管理员信息
	public List<Admin> getAdminInfo(int num) {
		Connection conn = null;
		conn = UtilConnection.getMySQLConnection();
		List<Admin> adminList = null;
		try {
			adminList = AdminDaoFcatory.getAdminDaoInstance(conn).getAdminInfo(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return adminList;
	}

	// 查看视图内的所有信息
	public List<CommodityV> getCommodityVService(int x) {
		List<CommodityV> commodityVList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			commodityVList = AdminDaoFcatory.getAdminDaoInstance(conn).getCommodityV(x);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commodityVList;
	}

	// 修改商品状态，审核人，审核日期
	public void updCommodity(int commodityId, int checkInfo, int adminId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).updCommodity(commodityId, checkInfo, adminId);
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

	// 查询所有商家的信息
	public List<Merchant> getMerchantAll(int num) {
		List<Merchant> merchantAllList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			merchantAllList = AdminDaoFcatory.getAdminDaoInstance(conn).getMerchantAll(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return merchantAllList;
	}

	// 修改商家的状态
	public void updMerchantById(int merchantId, int recordState, int adminId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			System.out.println(merchantId);
			System.out.println(recordState);
			System.out.println(adminId);
			AdminDaoFcatory.getAdminDaoInstance(conn).updMerchantById(merchantId, recordState, adminId);
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

	// 查看商品分类信息
	public List<CommodityType> getCommodityType() {
		Connection conn = UtilConnection.getMySQLConnection();
		List<CommodityType> cType = null;
		try {
			cType = AdminDaoFcatory.getAdminDaoInstance(conn).getCommodityType();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cType;
	}

	// 查看商品分类明细
	public List<CommoditySubtype> getCommoditySubtype(int typeId) {
		Connection conn = UtilConnection.getMySQLConnection();
		List<CommoditySubtype> cSubtype = null;
		try {
			cSubtype = AdminDaoFcatory.getAdminDaoInstance(conn).getCommoditySubtypeById(typeId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cSubtype;
	}
	//修改商品分类信息状态
	public void doUpdCommodityType(int typeId,int typeState) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doUpdCommodityType(typeId, typeState);
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
	//修改商品明细状态
	public void doUpdCommoditySubtype(int subtypeId,int subtypeState) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doUpdCommoditySubtype(subtypeId, subtypeState);
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
	//修改当typeId是需要修改的那一个的时候全部修改
	public void doUpdCommoditySubtypeAll(int typeId,int subtypeState) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doUpdCommoditySubtypeAll(typeId, subtypeState);;
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
	//删除商品分类信息数据
	public void doDelCommodityType(int typeId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doDelCommodityType(typeId);
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
	//删除商品分类明细数据
	public void doDelCommoditySubtype(int subtypeId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doDelCommoditySubtype(subtypeId);
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
	//删除商品分类明细所有数据
	public void doDelCommoditySubtypeAll(int typeId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doDelCommoditySubtypeAll(typeId);
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
	//增加商品分类信息数据
	public void doInsCommodityType(CommodityType commodityType) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doInsCommodityType(commodityType);
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
	//增加商品分类明细数据
	public void doInsCommoditySubtype(CommoditySubtype commoditySubtype) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doInsCommoditySubtype(commoditySubtype);
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
	//查看当状态是什么的时候,根据输入的值,模糊查询类型所有的数据
	public List<CommodityType> getTypeLike(String likeText,int typeState){
		List<CommodityType> typeList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			typeList = AdminDaoFcatory.getAdminDaoInstance(conn).getTypeLike(likeText, typeState);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return typeList;
		
	}
	//查看当状态是什么的时候,根据输入的值,模糊查询详细类型所有的数据
	public List<CommoditySubtype> getSubtypeLike(String likeText,int subtypeState){
		List<CommoditySubtype> subtypeList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			subtypeList = AdminDaoFcatory.getAdminDaoInstance(conn).getSubtypeLike(likeText, subtypeState);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return subtypeList;
		
	}
	//修改管理员状态
	public void doUpdAdminState(int state,int adminId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doUpdAdminState(state, adminId);;
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
	//删除管理员信息	
	public void doDelAdmin(int adminId) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doDelAdmin(adminId);;
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
	//更改管理员信息
	public void doUpdAdmin(Admin admin) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			AdminDaoFcatory.getAdminDaoInstance(conn).doUpdAdmin(admin);
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
	//添加管理员账户
	public void doInsAdmin(Admin admin) {
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			
			AdminDaoFcatory.getAdminDaoInstance(conn).doInsAdmin(admin);
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
	//查找有没有这个工号的Admin
	public Admin getAdminNumber(int adminNumber) {
		Admin admin = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			admin = AdminDaoFcatory.getAdminDaoInstance(conn).getAdminNumber(adminNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}
	//查找有没有这个账号的Admin
	public Admin getAdminName(String adminName) {
		Admin admin = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			admin = AdminDaoFcatory.getAdminDaoInstance(conn).getAdminAccount(adminName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}
	
	//查看管理员的一个总数
	public int countAdmin() {
		int count = 0;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			count = AdminDaoFcatory.getAdminDaoInstance(conn).countAdmin();
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
	}
}
