package com.dirsir.service.customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.Account;
import com.dirsir.dao.entities.AccountTarding;
import com.dirsir.dao.entities.Location;
import com.dirsir.dao.factory.AccountDaoFactory;
import com.dirsir.util.UtilConnection;

public class AccountService {
	public Account LoginAccount(String accountname, String password) {
		Connection conn = null;
		Account account = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			account = AccountDaoFactory.getAccountDaoInstance(conn).getAccountByAccountNamePassword(accountname,
					password);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}

	public boolean Register(Account account) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = UtilConnection.getMySQLConnection();
			AccountDaoFactory.getAccountDaoInstance(conn).doInsAccount(account);
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

	public Account getAccount(int accountid) {
		Connection conn = null;
		Account account = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			account = AccountDaoFactory.getAccountDaoInstance(conn).getAccountByAccountId(accountid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}

	public int getAccountName(String accountname) {
		Connection conn = null;
		int count = 0;
		try {
			conn = UtilConnection.getMySQLConnection();
			count = AccountDaoFactory.getAccountDaoInstance(conn).getAccountByAccountName(accountname);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;

	}

	public boolean updateAccount(Account account) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = UtilConnection.getMySQLConnection();
			AccountDaoFactory.getAccountDaoInstance(conn).updataAccountByAccountId(account);
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

	public boolean updateAccountBalance(int accountid, double balance) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			AccountDaoFactory.getAccountDaoInstance(conn).updataAccountByAccountId(accountid, balance);
			flag = true;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	// Ã·œ÷
	public boolean subtracrAccountBalance(int accountid, double balance) {

		Connection conn = null;
		boolean flag = false;
		try {
			conn = UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			AccountDaoFactory.getAccountDaoInstance(conn).updataAccountBanlanceByAccountID(accountid, balance);
			flag = true;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}
	public boolean  getAccountPassword(int accountid ,String password) {
		Connection conn=null;
		String string=null;
		boolean falg=false;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			string=AccountDaoFactory.getAccountDaoInstance(conn).getAccountPasswordByAccountId(accountid, password);
			if(string!=null) {
				falg=true;
			}
		    conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		return falg;
		
	}
	public boolean uptateAccountPassword(int accountid ,String password) {
		Connection conn=null;
		boolean flag=false;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			AccountDaoFactory.getAccountDaoInstance(conn).updateAccountPasswordByAccountId(accountid, password);
		    flag=true;
		    conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		return flag;
		
	}
	public boolean doInsAccountTarding(AccountTarding accountTarding) {
		Connection conn=null;
		boolean flag=false;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			AccountDaoFactory.getAccountDaoInstance(conn).doInsAccountTrading(accountTarding);
		    flag=true;
		    conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		return flag;
		
	}
	public List<Location> getLocation(int accountid){
		Connection conn=null;
		List<Location> list=null;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			list=AccountDaoFactory.getAccountDaoInstance(conn).getLocation(accountid);
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return list;
		
	}
	public boolean doInsLocation(Location location) {
		boolean flag=false;
		Connection conn=null;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			AccountDaoFactory.getAccountDaoInstance(conn).doInsLocation(location);
			flag=true;
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return flag;
		
	}
	public boolean updateLocation(Location location) {
		boolean flag=false;
		Connection conn=null;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			AccountDaoFactory.getAccountDaoInstance(conn).updateLocation(location);
			flag=true;
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return flag;
		
	}
	public Location getUpdateLocation(int locationId){
		Connection conn=null;
		Location location=null;
		try {
			conn=UtilConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			location=AccountDaoFactory.getAccountDaoInstance(conn).getUpdateLocation(locationId);
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return location;
		
	}
	

}
