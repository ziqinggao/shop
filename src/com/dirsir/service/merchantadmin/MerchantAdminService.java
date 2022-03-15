package com.dirsir.service.merchantadmin;

import java.sql.Connection;
import java.sql.SQLException;

import com.dirsir.dao.entities.Admin;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.factory.AdminDaoFcatory;
import com.dirsir.dao.factory.MerchantDaoFcatory;
import com.dirsir.util.UtilConnection;

public class MerchantAdminService {
	public Merchant LoginMerchant(String account, String merchantPassword) {
		Connection conn = null;
		Merchant merchant = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			merchant = MerchantDaoFcatory.getMerchantDaoInstance(conn).getMerchantByAaccountAndMerchantPassword(account,
					merchantPassword);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return merchant;

	}

	public Admin LoginAdmin(String adminName, String adminPassword) {
		Connection conn = null;
		Admin admin = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			admin = AdminDaoFcatory.getAdminDaoInstance(conn).getAdminByAdminNameAndAdminPassword(adminName,
					adminPassword);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return admin;
	}

	// 商家账户注册
	public boolean registered(Merchant merchant) {
		boolean flag = false;
		Connection conn = null;
		try {
			conn = UtilConnection.getMySQLConnection();
			MerchantDaoFcatory.getMerchantDaoInstance(conn).doInsMerchant(merchant);
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

	// 查询商家账户是否已被注册
	public int RepeatAccount(String account) {
		Connection conn = null;
		int count = 0;
		try {
			conn = UtilConnection.getMySQLConnection();
			count = MerchantDaoFcatory.getMerchantDaoInstance(conn).getMerchantByAccount(account);

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

	
}
