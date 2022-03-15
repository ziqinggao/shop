package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.commodity.CommoditySubsortService;

/**
 * Servlet implementation class doUpdSubsortStateServlet
 */
@WebServlet("/commodity/doUpdSubsortStateServlet")
public class doUpdSubsortStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		CommoditySubsortService service=new CommoditySubsortService();
		int state=Integer.parseInt(request.getParameter("subsortstate"));
		int subsortId=Integer.parseInt(request.getParameter("subsortId"));
		boolean falg=service.doUpdSubsortStateBySubsort(subsortId, state);
		out.print(falg);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
