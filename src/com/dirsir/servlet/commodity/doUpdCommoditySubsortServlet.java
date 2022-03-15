package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySubsort;
import com.dirsir.service.commodity.CommoditySubsortService;

/**
 * Servlet implementation class doUpdCommoditySubsortServlet
 */
@WebServlet("/commodity/doUpdCommoditySubsortServlet")
public class doUpdCommoditySubsortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		CommoditySubsortService service=new CommoditySubsortService();
		String subsortName=request.getParameter("subsortName");
		double price=Double.parseDouble(request.getParameter("subsortPrice"));
		double vipprice=Double.parseDouble(request.getParameter("vipPrice"));
		int state=Integer.parseInt(request.getParameter("state"));
		int sortId=Integer.parseInt(request.getParameter("sortId"));
		int subsortId=Integer.parseInt(request.getParameter("subsortId"));
		CommoditySubsort commoditySubsort=new CommoditySubsort(subsortId,sortId,subsortName,price,vipprice,state,1);
		boolean falg=service.doUpdSubsort(commoditySubsort);
		out.print(falg);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
