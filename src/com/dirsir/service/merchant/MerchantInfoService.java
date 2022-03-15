package com.dirsir.service.merchant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.entities.MerchantTarding;
import com.dirsir.dao.factory.MerchantDaoFcatory;
import com.dirsir.util.UtilConnection;
/**
 * 获取商家的个人信息
 * @author 时光少许
 *
 */
public class MerchantInfoService {
		
	//获取商家的所有信息
	public Merchant getMerchantInfo(String account) {
		Merchant merchant = null;
		Connection con = null;
		try {
			con = UtilConnection.getMySQLConnection();
			merchant = MerchantDaoFcatory.getMerchantDaoInstance(con).getMerchantInfo(account);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return merchant;
	}
	/**
	 * 修改商家的主管，主管电话，法人电话
	 * @return
	 */
	public boolean UpaMerchantDirectorAndDirectorPhoneAndLicensPictureService(String account,String corpPhone,String director,String directorPhone) {
		boolean flag = false;
		Connection conn = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			MerchantDaoFcatory.getMerchantDaoInstance(conn).upaMerchantDirectorAndDirectorPhoneAndLicensPicture(account, corpPhone, director, directorPhone);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * 商家充值
	 */
	public boolean merchantBalanceIn(String account,double merchantBalance) {
		boolean flag = false;
		Connection conn = null;
		conn = UtilConnection.getMySQLConnection();
		try {
			MerchantDaoFcatory.getMerchantDaoInstance(conn).merchantBalanceIn(account, merchantBalance);
			MerchantInfoService service = new MerchantInfoService();
			//查看商家的个人信息
			Merchant merchant = service.getMerchantInfo(account);
			MerchantTarding tarding = new MerchantTarding(0,merchant.getMerchantId(),"",+merchantBalance,1,"充值");
			//设置交易记录
			MerchantDaoFcatory.getMerchantDaoInstance(conn).doInsMerchantTarding(tarding);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * 商家提现
	 */
	public boolean merchantBalanceOut(String account,double merchantBalance) {
		boolean flag = false;
		Connection conn = null;
		conn = UtilConnection.getMySQLConnection();
		try {
			//取消事务的自动提交
			conn.setAutoCommit(flag);
			MerchantDaoFcatory.getMerchantDaoInstance(conn).merchantBlanceOut(account, merchantBalance);
			MerchantInfoService service = new MerchantInfoService();
			//查看商家的个人信息
			Merchant merchant = service.getMerchantInfo(account);
			MerchantTarding tarding = new MerchantTarding(0,merchant.getMerchantId(),"",-merchantBalance,3,"提现");
			//设置交易记录
			MerchantDaoFcatory.getMerchantDaoInstance(conn).doInsMerchantTarding(tarding);
			if(merchant.getMerchantBalance() >= merchantBalance) {
				conn.commit();
				flag = true;
			}else {
				int a = 1/0;
				System.out.println(a);
			}
		} catch (Exception e) {
			try {
				flag = false;
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * 修改密码
	 */
	public boolean updPassWord(String account, String oldPassWord, String newPassWord) {
		Connection conn = null;
		boolean flag = false;
		conn = UtilConnection.getMySQLConnection();
		try {
			MerchantDaoFcatory.getMerchantDaoInstance(conn).updPassWord(account, oldPassWord, newPassWord);
			Merchant merchant =MerchantDaoFcatory.getMerchantDaoInstance(conn).getMerchantByAaccountAndMerchantPassword(account, newPassWord);
			if(null!=merchant) {
				flag = true;				
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	/**
	 * 获取商家的所有交易记录
	 */
	public List<MerchantTarding> getMerchantTarding(int merchantId){
		List<MerchantTarding> tardingList = null;
		Connection conn = UtilConnection.getMySQLConnection();
		try {
			tardingList = MerchantDaoFcatory.getMerchantDaoInstance(conn).getMerchantTarding(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tardingList;
	}
}
