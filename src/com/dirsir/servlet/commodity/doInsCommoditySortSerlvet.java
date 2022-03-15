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
 * Servlet implementation class doInsCommoditySortSerlvet
 */
@WebServlet("/commodity/doInsCommoditySortSerlvet")
public class doInsCommoditySortSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		String sortName=request.getParameter("sortName");
		int state=Integer.parseInt(request.getParameter("state"));
		CommoditySort sort=new CommoditySort(0,commodityId,sortName,state,1);
		CommoditySortService service=new CommoditySortService();
		boolean falg=service.doInsCommoditySort(sort);
		out.print(falg);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
