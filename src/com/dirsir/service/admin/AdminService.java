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
	// �鿴���еĹ���Ա��Ϣ
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

	// �鿴��ͼ�ڵ�������Ϣ
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

	// �޸���Ʒ״̬������ˣ��������
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

	// ��ѯ�����̼ҵ���Ϣ
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

	// �޸��̼ҵ�״̬
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

	// �鿴��Ʒ������Ϣ
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

	// �鿴��Ʒ������ϸ
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
	//�޸���Ʒ������Ϣ״̬
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
	//�޸���Ʒ��ϸ״̬
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
	//�޸ĵ�typeId����Ҫ�޸ĵ���һ����ʱ��ȫ���޸�
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
	//ɾ����Ʒ������Ϣ����
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
	//ɾ����Ʒ������ϸ����
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
	//ɾ����Ʒ������ϸ��������
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
	//������Ʒ������Ϣ����
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
	//������Ʒ������ϸ����
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
	//�鿴��״̬��ʲô��ʱ��,���������ֵ,ģ����ѯ�������е�����
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
	//�鿴��״̬��ʲô��ʱ��,���������ֵ,ģ����ѯ��ϸ�������е�����
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
	//�޸Ĺ���Ա״̬
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
	//ɾ������Ա��Ϣ	
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
	//���Ĺ���Ա��Ϣ
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
	//��ӹ���Ա�˻�
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
	//������û��������ŵ�Admin
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
	//������û������˺ŵ�Admin
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
	
	//�鿴����Ա��һ������
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
