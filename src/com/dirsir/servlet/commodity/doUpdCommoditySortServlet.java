package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.service.commodity.CommoditySortService;

/**
 * Servlet implementation class doUpdCommoditySortServlet
 */
@WebServlet("/commodity/doUpdCommoditySortServlet")
public class doUpdCommoditySortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int sortId=Integer.parseInt(request.getParameter("sortId"));
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		int sortState=Integer.parseInt(request.getParameter("state"));
		String sortName=request.getParameter("sortName");
		CommoditySort sort=new CommoditySort(sortId,commodityId,sortName,sortState,1);
		CommoditySortService service=new CommoditySortService();
		boolean falg=service.doUpdCommoditySort(sort);
		out.print(falg);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
