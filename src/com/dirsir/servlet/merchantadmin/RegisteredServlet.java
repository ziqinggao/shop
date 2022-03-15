package com.dirsir.servlet.merchantadmin;

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

import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.merchantadmin.MerchantAdminService;
import com.dirsir.util.FileName;


@WebServlet("/merchantadmin/RegisteredServlet")
public class RegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
				String filedName = item.getFieldName();//ȡ�ñ��ؼ�������
				System.out.println(filedName + "---------------" + item.isFormField());
				
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
					
					
				}else {//����ͨ�ı��ؼ�
					String value = item.getString("UTF-8");//ȡ���ı��ؼ���ֵ
					list.add(value);
				}
				
			}
			
			Merchant merchant = new Merchant(1, list.get(2), list.get(0), list.get(1), list.get(3), list.get(4), list.get(5),Double.parseDouble( list.get(6)),
					list.get(7), list.get(8), list.get(9), list.get(10), 0, null, 1, 1, null, fileName.get(0), fileName.get(1));
			MerchantAdminService service = new MerchantAdminService();
			boolean flag = service.registered(merchant);//�ж�ע���Ƿ�ɹ�
			if (flag) {
				out.write("<script type='text/javascript'>alert('ע��ɹ�');window.location.href='"+request.getContextPath()+"/jsp/merchantadmin/login.jsp';</script>");
			} else {
				out.write("<script type='text/javascript'>alert('ע��ʧ��');window.location.href='"+request.getContextPath()+"/jsp/merchantadmin/login.jsp';</script>");
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}//����ȫ������
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
