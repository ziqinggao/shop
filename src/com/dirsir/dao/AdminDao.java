package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.Admin;
import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.dao.entities.CommodityType;
import com.dirsir.dao.entities.CommodityV;
import com.dirsir.dao.entities.Merchant;

public interface AdminDao {
	//登录
	public Admin  getAdminByAdminNameAndAdminPassword(String adminName,String adminPassword) throws Exception;
	
	//查询所有管理员信息,传入显示第几页的数据
	public List<Admin> getAdminInfo(int num) throws Exception;
	
	//商品审核，查询出所有状态是待审核的商品
	/*public List<Commodity> getCommodity() throws Exception;*/
	
	//商品审核,查看所有没有通过审核产品的信息，通过视图展示
	public List<CommodityV> getCommodityV(int x) throws Exception;
	
	//修改商品状态
	public void updCommodity(int commodityId,int checkInfo,int adminId) throws Exception;
	
	//查看刚注册的所有的商家信息
	public List<Merchant> getMerchantAll(int num) throws Exception;
	
	//商家等待审核,修改商家状态
	public void updMerchantById(int merchantId,int recordState,int adminId) throws Exception;
	
	//查看商品分类信息
	public List<CommodityType> getCommodityType() throws Exception;
	
	//查看商品分类明细
	public List<CommoditySubtype> getCommoditySubtypeById(int typeId) throws Exception;
	
	//修改商品分类信息状态
	public void doUpdCommodityType(int typeId,int typeState) throws Exception;
	
	//修改商品明细状态
	public void doUpdCommoditySubtype(int subtypeId,int subtypeState) throws Exception;
	
	//修改当typeId是需要修改的那一个的时候全部修改
	public void doUpdCommoditySubtypeAll(int typeId,int subtypeState) throws Exception;
	
	//删除商品分类信息数据
	public void doDelCommodityType(int typeId) throws Exception;
	
	//删除商品分类明细数据
	public void doDelCommoditySubtype(int subtypeId) throws Exception;
	
	//删除商品分类明细所有数据
	public void doDelCommoditySubtypeAll(int typeId) throws Exception;
	
	//增加商品分类信息数据
	public void doInsCommodityType(CommodityType commodityType) throws Exception;
	
	//增加商品分类明细数据
	public void doInsCommoditySubtype(CommoditySubtype commoditySubtype) throws Exception;
	
	//模糊查询类型表里面的数据
	public List<CommodityType> getTypeLike(String likeText,int typeState) throws Exception;
	
	//模糊查询详细类型表里面的数据
	public List<CommoditySubtype> getSubtypeLike(String likeText,int subtypeState) throws Exception;
	
	//查询当id=?管理员信息,使用了查看同级元素，没使用查看数据库
	
	//修改当id=?管理员信息
	public void doUpdAdmin(Admin admin) throws Exception;
	
	//删除id=？管理员信息
	public void doDelAdmin(int adminId) throws Exception;
	
	//增加管理员信息
	public void doInsAdmin(Admin admin) throws Exception;
	
	//修改管理员状态
	public void doUpdAdminState(int state,int adminId) throws Exception;
	
	//查看是否工号重复
	public Admin getAdminNumber(int adminNumber) throws Exception;
	
	//查看账号是否重复
	public Admin getAdminAccount(String adminName) throws Exception;
	
	//查询所有的管理员信息
	public int countAdmin() throws Exception;
}
