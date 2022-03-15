package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.commodity.CommoditySortService;

/**
 * Servlet implementation class doDelCommoditySortBySortId
 */
@WebServlet("/commodity/doDelCommoditySortBySortIdServlet")
public class doDelCommoditySortBySortIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		CommoditySortService service=new CommoditySortService();
		int sortId=Integer.parseInt(request.getParameter("sortId"));
		boolean falg=service.doDelCommoditySortBySortId(sortId);
		out.print(falg);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
