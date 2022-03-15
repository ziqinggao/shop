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
		DiskFileItemFactory factory = new DiskFileItemFactory();//创建磁盘工厂
		ServletFileUpload upload = new ServletFileUpload(factory);//创建处理工具
		upload.setFileSizeMax(1024*1024*2);//设置上传文件的大小 为5M
		upload.setHeaderEncoding("UTF-8");
		try {
			
			List<FileItem> items = upload.parseRequest(request);//接收全部内容
			Iterator<FileItem> it = items.iterator();
			while(it.hasNext()) {
				FileItem item = it.next();//取得接收的每一个
				String filedName = item.getFieldName();//取得表单控件的名称
				System.out.println(filedName + "---------------" + item.isFormField());
				
				if(!item.isFormField()) {//不是普通文本
					InputStream input = null;
					OutputStream output = null;
					String ip=request.getRemoteAddr();
					input = item.getInputStream();//将上传的文件写入字节流
					String aa= FileName.getFileName(ip) +"."+ item.getName().split("\\.")[1];
					output = new FileOutputStream(new File(this.getServletContext().getRealPath("/merchantImg") 
							+ File.separator +aa));
					 fileName.add(aa);
					int temp = 0;
					while((temp = input.read() )!= -1) {//读取文件
						output.write(temp);//写入文件
					}
					output.close();
					input.close();
					
					
				}else {//是普通文本控件
					String value = item.getString("UTF-8");//取得文本控件的值
					list.add(value);
				}
				
			}
			
			Merchant merchant = new Merchant(1, list.get(2), list.get(0), list.get(1), list.get(3), list.get(4), list.get(5),Double.parseDouble( list.get(6)),
					list.get(7), list.get(8), list.get(9), list.get(10), 0, null, 1, 1, null, fileName.get(0), fileName.get(1));
			MerchantAdminService service = new MerchantAdminService();
			boolean flag = service.registered(merchant);//判断注册是否成功
			if (flag) {
				out.write("<script type='text/javascript'>alert('注册成功');window.location.href='"+request.getContextPath()+"/jsp/merchantadmin/login.jsp';</script>");
			} else {
				out.write("<script type='text/javascript'>alert('注册失败');window.location.href='"+request.getContextPath()+"/jsp/merchantadmin/login.jsp';</script>");
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}//接收全部内容
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
