package com.dirsir.servlet.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dirsir.dao.entities.Account;
import com.dirsir.service.customer.AccountService;
import com.dirsir.util.FileName;

@WebServlet("/customer/AccountRegister")
public class AccountRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		List<String> list=new ArrayList<>();
		List<String> fileName=new ArrayList<>();
		PrintWriter out=response.getWriter();
		DiskFileItemFactory factory = new DiskFileItemFactory();//�������̹���
		ServletFileUpload upload = new ServletFileUpload(factory);//����������
		upload.setFileSizeMax(1024*1024*2);//�����ϴ��ļ��Ĵ�С Ϊ5M
		upload.setHeaderEncoding("UTF-8");
		try {
			
			List<FileItem> items = upload.parseRequest(request);//����ȫ������
			Iterator<FileItem> it = items.iterator();
			while(it.hasNext()) {
				FileItem item = it.next();//ȡ�ý��յ�ÿһ��
				if(!item.isFormField()) {//������ͨ�ı�
					InputStream input = null;
					OutputStream output = null;
					String ip=request.getRemoteAddr();
					input = item.getInputStream();//���ϴ����ļ�д���ֽ���
					String aa= FileName.getFileName(ip) +"."+ item.getName().split("\\.")[1];
					output = new FileOutputStream(new File(this.getServletContext().getRealPath("/merchantImg") 
							+ File.separator +aa));
					 fileName.add(aa);
					int temp = 0;
					while((temp = input.read() )!= -1) {//��ȡ�ļ�
						output.write(temp);//д���ļ�
					}
					output.close();
					input.close();
					
//					String fileName = item.getName();//ȡ���ļ�������
//					String fileContentType = item.getContentType();//ȡ���ļ�������
//					long sizeInBytes = item.getSize();//ȡ���ļ��Ĵ�С
//					System.out.println(fileName+ "----" + fileContentType + "---" + sizeInBytes);
					
					
					
				}else {//����ͨ�ı��ؼ�
					String value = item.getString("UTF-8");//ȡ���ı��ؼ���ֵ
					list.add(value);
				}
			
			}
			/*int accountId, String accountName, String phone, String accountPassword, String name, int gender,
			int age, String birthday, String idCard, double balance, String email, String picture, int vip,
			String vipDate, String vipBirthday*/
		Account account=new Account(1,list.get(0),list.get(3),list.get(1),list.get(4),1,1,null,
				"",0,list.get(5),"",0,null,null);
		AccountService service =new AccountService();
		boolean flag = service.Register(account);//�ж�ע���Ƿ�ɹ�
		if (flag) {
			out.write("<script type='text/javascript'>alert('ע��ɹ�');window.location.href='"+request.getContextPath()+"/jsp/customer/account.jsp';</script>");
		} else {
			out.write("<script type='text/javascript'>alert('ע��ʧ��');window.location.href='"+request.getContextPath()+"/jsp/customer/registered.jsp';</script>");
		}
		
	} catch (FileUploadException e) {
		e.printStackTrace();
	}//����ȫ������
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
