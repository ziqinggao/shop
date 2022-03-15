package com.dirsir.servlet.commodity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommodityPicture;
import com.dirsir.service.commodity.CommodityPictureService;
import com.dirsir.util.DoDeletFile;

/**
 * Servlet implementation class doCommodityPictureServlet
 */
@WebServlet("/commodity/doDelCommodityPictureServlet")
public class doDelCommodityPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int pictureId=Integer.parseInt(request.getParameter("pictureId"));
		CommodityPictureService service=new CommodityPictureService();
		CommodityPicture commodityPicture=service.getCommodityPictureByPictureId(pictureId);
		String fileName=commodityPicture.getPictureUrl();
		String path=this.getServletContext().getRealPath("/commodityImg")+File.separator;
		boolean falg2=DoDeletFile.doDeletFile(path, fileName);
		boolean falg=service.doDelCommodityPicture(pictureId);
		if(falg&&falg2) {
			out.print(true);
		}else {
			out.print(false);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
