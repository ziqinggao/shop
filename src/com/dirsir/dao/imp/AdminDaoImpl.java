package com.dirsir.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dirsir.dao.AdminDao;
import com.dirsir.dao.entities.Admin;
import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.dao.entities.CommodityType;
import com.dirsir.dao.entities.CommodityV;
import com.dirsir.dao.entities.Merchant;

public class AdminDaoImpl implements AdminDao {
	private Connection conn;

	public AdminDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Admin getAdminByAdminNameAndAdminPassword(String adminName, String adminPassword) throws Exception {
		String sql = "select admin_id, admin_number, real_name from admin where admin_name=?"
				+ " and admin_password=? and state=1";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, adminName);
		pstate.setString(2, adminPassword);
		ResultSet res = pstate.executeQuery();
		Admin admin = null;
		while (res.next()) {
			admin = new Admin(res.getInt(1), res.getInt(2), adminName, null, res.getString(3), 1);

		}
		res.close();
		pstate.close();
		return admin;
	}
	
	@Override
	public List<Admin> getAdminInfo(int num) throws Exception {
		List<Admin> adminList = new ArrayList<>();
		Admin admin = null;
		String sql = "select admin_id,admin_number,admin_name,admin_password,real_name,state from admin limit ?,1";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, (num - 1) * 1);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			admin = new Admin(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5),
					res.getInt(6));
			adminList.add(admin);
		}
		res.close();
		pstate.close();
		return adminList;
	}

/*	@Override
	public List<Commodity> getCommodity() throws Exception {
		List<Commodity> commodityList = new ArrayList<>();
		Commodity commodity = null;
		String sql = "select ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			commodity = new Commodity();
			commodityList.add(commodity);
		}
		res.close();
		pstate.close();
		return commodityList;
	}*/

	@Override
	public List<CommodityV> getCommodityV(int x) throws Exception {
		List<CommodityV> commodityVList = new ArrayList<>();
		CommodityV commodityV = null;
		String sql = "SELECT * FROM commodity_v limit ?,3";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, (x - 1) * 5);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			commodityV = new CommodityV(res.getInt(1),res.getString(2),res.getString(3),res.getDouble(4),res.getDouble(5),res.getString(6),res.getString(7),
					res.getInt(8),res.getString(9),res.getString(10),res.getInt(11),res.getString(12),res.getInt(13));
			commodityVList.add(commodityV);
		}
		res.close();
		pstate.close();
		return commodityVList;
	}

	@Override
	public void updCommodity(int commodityId, int checkInfo, int adminId) throws Exception {
		String sql = "update commodity set check_info = ?,admin_id = ?,check_date = ? where commodity_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, checkInfo);
		pstate.setInt(2, adminId);
		pstate.setDate(3, new java.sql.Date(new Date().getTime()));
		pstate.setInt(4, commodityId);
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<Merchant> getMerchantAll(int num) throws Exception {
		List<Merchant> merchantList = new ArrayList<>();
		Merchant merchant = null;
		String sql = "select merchant_id,merchant_name,unify_code,manage,location,money,corp,corp_phone,director,director_phone,record_date,record_state,license_picture,corp_picture from merchant where record_state = 1 limit ?,5";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, (num - 1) * 5);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			merchant = new Merchant(res.getInt(1), res.getString(2), null, null, res.getString(3), res.getString(4),
					res.getString(5), res.getDouble(6), res.getString(7), res.getString(8), res.getString(9),
					res.getString(10), 0, res.getString(11), res.getInt(12), 0, null, res.getString(13),
					res.getString(14));
			merchantList.add(merchant);
		}
		res.close();
		pstate.close();
		return merchantList;
	}

	@Override
	public void updMerchantById(int merchantId, int recordState, int adminId) throws Exception {
		String sql = "update merchant set record_state = ?,admin_id = ?,record_date = ? where merchant_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, recordState);
		pstate.setInt(2, adminId);
		pstate.setDate(3, new java.sql.Date(new Date().getTime()));
		pstate.setInt(4, merchantId);
		pstate.execute();
		pstate.close();
	}

	@Override
	public List<CommodityType> getCommodityType() throws Exception {
		List<CommodityType> typeList = new ArrayList<>();
		CommodityType cType = null;
		String sql = "select type_id,type_name,type_describe,type_state,sort_code from commodity_type ";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			cType = new CommodityType(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5));
			typeList.add(cType);
		}
		res.close();
		pstate.close();
		return typeList;
	}

	@Override
	public List<CommoditySubtype> getCommoditySubtypeById(int typeId) throws Exception {
		List<CommoditySubtype> subtypeList = new ArrayList<>();
		CommoditySubtype cSubtype = null;
		String sql = "select subtype_id,type_id,subtype_name,subtype_describe,subtype_state,subsort_code from commodity_subtype where type_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, typeId);
		ResultSet res = pstate.executeQuery();
		while (res.next()) {
			cSubtype = new CommoditySubtype(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4),
					res.getInt(5), res.getInt(6));
			subtypeList.add(cSubtype);
		}
		res.close();
		pstate.close();
		return subtypeList;
	}

	@Override
	public void doUpdCommodityType(int typeId, int typeState) throws Exception {
		String sql = "update commodity_type set type_state = ? where type_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,typeState);
		pstate.setInt(2, typeId);
		pstate.execute();
		pstate.close();
	}

	@Override
	public void doUpdCommoditySubtype(int subtypeId, int subtypeState) throws Exception {
		String sql = "update commodity_subtype set subtype_state = ? where subtype_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,subtypeState);
		pstate.setInt(2, subtypeId);
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public void doUpdCommoditySubtypeAll(int typeId, int subtypeState) throws Exception {
		String sql = "update commodity_subtype set subtype_state = ? where type_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,subtypeState);
		pstate.setInt(2, typeId);
		pstate.execute();
		pstate.close();
	}

	@Override
	public void doDelCommodityType(int typeId) throws Exception {
		String sql = "delete from commodity_type where type_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,typeId);
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public void doDelCommoditySubtype(int subtypeId) throws Exception {
		String sql = "delete from commodity_subtype where subtype_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,subtypeId);
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public void doDelCommoditySubtypeAll(int typeId) throws Exception {
		String sql = "delete from commodity_subtype where type_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,typeId);
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public void doInsCommodityType(CommodityType commodityType) throws Exception {
		String sql = "insert into commodity_type(type_name,type_describe,type_state,sort_code) value(?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, commodityType.getTypeName());
		pstate.setString(2, commodityType.getTypeDescribe());
		pstate.setInt(3, commodityType.getTypeState());
		pstate.setInt(4, commodityType.getSortCode());
		pstate.execute();
		pstate.close();
	}

	@Override
	public void doInsCommoditySubtype(CommoditySubtype commoditySubtype) throws Exception {
		String sql = "insert into commodity_subtype(type_id,subtype_name,subtype_describe,subtype_state,subsort_code) value(?,?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, commoditySubtype.getTypeId());
		pstate.setString(2, commoditySubtype.getSubtypeName());
		pstate.setString(3, commoditySubtype.getSubtypeDescribe());
		pstate.setInt(4, commoditySubtype.getSubtypeState());
		pstate.setInt(5, commoditySubtype.getSubsortCode());
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public List<CommodityType> getTypeLike(String likeText, int typeState) throws Exception {
		List<CommodityType> typeList = new ArrayList<>();
		CommodityType type = null;
		String sql = "SELECT type_id,type_name,type_describe,type_state,sort_code"
				+ " FROM commodity_type WHERE type_name LIKE ? AND type_state = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, "%"+likeText+"%");
		pstate.setInt(2, typeState);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			type = new CommodityType(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5));
			typeList.add(type);
		}
		res.close();
		pstate.close();
		return typeList;
	}

	@Override
	public List<CommoditySubtype> getSubtypeLike(String likeText, int subtypeState) throws Exception {
		List<CommoditySubtype> subtypeList = new ArrayList<>();
		CommoditySubtype subtype = null;
		String sql = "SELECT subtype_id,type_id,subtype_name,subtype_describe,subtype_state,subsort_code"
				+ " FROM commodity_subtype WHERE subtype_name LIKE ? AND subtype_state = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, "%"+likeText+"%");
		pstate.setInt(2, subtypeState);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			subtype = new CommoditySubtype(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4),
					res.getInt(5), res.getInt(6));
			subtypeList.add(subtype);
		}
		res.close();
		pstate.close();
		return subtypeList;
	}

	@Override
	public void doUpdAdmin(Admin admin) throws Exception {
		String sql = "update admin set admin_number = ?,admin_name = ?,admin_password = ?,real_name = ? where admin_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, admin.getAdminNumber());
		pstate.setString(2, admin.getAdminName());
		pstate.setString(3, admin.getAdminPassword());
		pstate.setString(4, admin.getRealName());
		pstate.setInt(5, admin.getAdminId());
		pstate.execute();
		pstate.close();
	}

	@Override
	public void doDelAdmin(int adminId) throws Exception {
		String sql = "delete from admin where admin_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1,adminId);
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public void doInsAdmin(Admin admin) throws Exception {
		String sql = "insert into admin(admin_number,admin_name,admin_password,real_name) value(?,?,?,?)";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, admin.getAdminNumber());
		pstate.setString(2, admin.getAdminName());
		pstate.setString(3, admin.getAdminPassword());
		pstate.setString(4, admin.getRealName());
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public void doUpdAdminState(int state, int adminId) throws Exception {
		String sql = "update admin set state = ? where admin_id = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, state);
		pstate.setInt(2, adminId);
		pstate.execute();
		pstate.close();
		
	}

	@Override
	public Admin getAdminNumber(int adminNumber) throws Exception {
		Admin admin = null;
		String sql = "select * from admin where admin_number = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setInt(1, adminNumber);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			admin = new Admin(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6));
		}
		res.close();
		pstate.close();
		return admin;
	}

	@Override
	public Admin getAdminAccount(String adminName) throws Exception {
		Admin admin = null;
		String sql = "select * from admin where admin_account = ?";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		pstate.setString(1, adminName);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			admin = new Admin(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6));
		}
		res.close();
		pstate.close();
		return admin;
	}

	@Override
	public int countAdmin() throws Exception {
		int count = 0;
		String sql = "select count(*) from admin";
		PreparedStatement pstate = this.conn.prepareStatement(sql);
		ResultSet res = pstate.executeQuery();
		while(res.next()) {
			count = res.getInt(1);
		}
		res.close();
		pstate.close();
		return count;
	}

}
