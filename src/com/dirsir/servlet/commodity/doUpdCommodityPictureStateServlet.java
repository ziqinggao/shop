package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.commodity.CommodityPictureService;

/**
 * Servlet implementation class doUpdCommodityPictureStateServlet
 */
@WebServlet("/commodity/doUpdCommodityPictureStateServlet")
public class doUpdCommodityPictureStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int pictureId=Integer.parseInt(request.getParameter("pictureId"));
		int state=Integer.parseInt(request.getParameter("state"));
		CommodityPictureService service=new CommodityPictureService();
		boolean falg=service.doUpdCommodityPictureState(pictureId, state);
		out.print(falg);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
