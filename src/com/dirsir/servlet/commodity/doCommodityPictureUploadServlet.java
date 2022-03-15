package com.dirsir.servlet.commodity;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.lxh.smart.Files;
import org.lxh.smart.Request;
import org.lxh.smart.SmartUpload;

import com.dirsir.dao.entities.CommodityPicture;
import com.dirsir.service.commodity.CommodityPictureService;
import com.dirsir.util.GetFileName;

/**
 * Servlet implementation class doCommodityPictureUploadServlet
 */
@WebServlet("/commodity/doCommodityPictureUploadServlet")
public class doCommodityPictureUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//取得smartUpload的对象
		SmartUpload smartUpload=new SmartUpload();
		//获取pageContext对象
		JspFactory jf=JspFactory.getDefaultFactory();
		PageContext pageContext=jf.getPageContext(this, request, response, null, false, 0, false);
		smartUpload.initialize(pageContext);
		try {
			//准备上传文件
			smartUpload.upload();
			//获取参数
			Request res=smartUpload.getRequest();
			int type=Integer.parseInt(res.getParameter("type"));
			int commodityId=Integer.parseInt(res.getParameter("commodityId"));
			Files files=smartUpload.getFiles();
			for(int i=0;i<files.getCount();i++ ) {
				//取得文件的后缀名
				String ext=smartUpload.getFiles().getFile(i).getFileExt();
				//获取新的名字
				String fileName=GetFileName.getFilName(request)+"."+ext;
				//保存文件
				CommodityPicture commodityPicture=new CommodityPicture(0,commodityId,type,fileName,1,1);
				CommodityPictureService service=new CommodityPictureService();
				service.doInsCommodityPicture(commodityPicture);
				smartUpload.getFiles().getFile(i).saveAs(this.getServletContext().getRealPath("/commodityImg")+File.separator+fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
