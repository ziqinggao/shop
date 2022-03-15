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
	
	/*//�����̼�id��ѯ�����е���Ʒ��Ϣ,�����뷨
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
	//�����̼�Id��ѯ�������������Ϣ
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
	//�����̼�ID��ѯ��ͼ�е�����
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
	//�̼��޸Ķ���״̬
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
	//����״̬��ѯ�Լ��Ķ���
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
	//���ݷ������ڲ�ѯ�̼Ҷ���
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
	//������ͼ��ѯ��������,�����ж���������
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
		
	//����״̬��ѯ��������,�����ж���������
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
		
	//�������ڲ�ѯ���ݣ����ع��ж���������
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
	
	//�����̼�Id��ѯ����ѯ���е���ƷId���ڲ�ѯ�����е����id�����õ�ƴ�ճ������̵���Ϣ,����Ҫ��������в���
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
	
	//����Ϣѭ�����뵽������
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
	
	//��ѯ�̼�����һ��ʱ�������
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
	
	//ɾ���̼ҵ��������
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
	
	//��ѯ�̼�����һ��ʱ�������
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
	
	//�޸��̵���
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
