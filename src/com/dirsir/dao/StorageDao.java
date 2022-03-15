package com.dirsir.dao;

import java.util.List;

import com.dirsir.dao.entities.OrderParticulars;
import com.dirsir.dao.entities.OrderParticularsV;
import com.dirsir.dao.entities.Repertory;
import com.dirsir.dao.entities.RepertoryV;

public interface StorageDao {
	
	//�����̼�id��ѯ������Ʒ��Id
	public List<Integer> getCommodityById(int merchantId) throws Exception;
	
	//����ͨ�����е���ƷId��ȡ�����и��̼ҵĶ��������
	/*public List<OrderParticulars> getOrderParticulars(int commodityId) throws Exception;*/
	
	//�����̼�Id��ѯ��������
	public List<OrderParticulars> getOrderparticulars(int merchantId) throws Exception;
	
	//������ͼ��ѯ��������
	public List<OrderParticularsV> getOrderParticularsV(int merchantId,int limit) throws Exception;
	
	//�޸������嵥�Ķ���״̬
	public void doUpdOrderParticulars(int particularsId,int state) throws Exception;
	
	//���ݶ���״̬��ѯ�����嵥
	public List<OrderParticularsV> getOrderParticularsVByState(int merchantId,int state,int limit) throws Exception;
	
	//���ݷ������ڲ�ѯ����
	public List<OrderParticularsV> getOrderParticularsVByDate(int merchantId,String sendDate,int limit) throws Exception;
	
	//������ͼ��ѯ��������,�����ж���������
	public int getCountOrderParticularsV(int merchantId) throws Exception;
	
	//����״̬��ѯ��������,�����ж���������
	public int getCountOrderParticularsVByState(int merchantId,int state) throws Exception;
	
	//�������ڲ�ѯ���ݣ����ع��ж���������
	public int getCountOrderParticularsVBytDate(int merchantId,String sendDate) throws Exception;
	
	//1�������̼�id��ѯ���е���ƷId
	public List<Integer> getCommodityId(int merchantId) throws Exception;
	
	//������ƷId��ѯ��Ʒ�����id
	public List<Integer> getsortId(int commodityId) throws Exception;
	
	//2��������Ʒid������е����id	
	public List<Integer> getSortId(List<Integer> commodityIdList) throws Exception;
	
	//3������sortId��ѯ�����е�ϸ��
	public List<Repertory> doCheckRepertory(List<Integer> commodityIdList) throws Exception;
	
	//�����̼�Id����ѯ�������ͨ���Ĳ�Ʒ��Id,������ƷId��ѯ����Ʒ���е����Id
	public List<Integer> getCommoditySortId(int merchantId) throws Exception;
	
	//ѭ������ sort_id ��ѯ���е�ϸ�ಢ�ҽ�������ƴ��,��sortIdѭ��������в�ѯ����̬����sortId��ѯ�Ĵ���
	public List<Repertory> checkRepertory(List<Integer> intList) throws Exception;
	
	//����ѯ����������Ϣ���뵽�̵������
	public void doInsRepertory(int merchantId) throws Exception;
	
	//�������ڽ��в�ѯ�Ƿ����̵���Ϣrepertory
	public List<Repertory> getRepertory(String checkDate,int merchantId) throws Exception;
	
	//ɾ����ѯ���ڵ�������Ϣ
	public void doDelRepertory(String checkDate,int merchantId) throws Exception;
	
	//������ͼ��ѯ���ڵ���Ϣ
	public List<RepertoryV> getRepertoryV(String checkDate,int merchantId) throws Exception;
	
	//�޸��̵���
	public void doUpdRepertory(int repertoryId,int checkRepertory) throws Exception;
	
}
