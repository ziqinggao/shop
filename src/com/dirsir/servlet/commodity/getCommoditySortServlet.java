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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getCommoditySortServlet
 */
@WebServlet("/commodity/getCommoditySortServlet")
public class getCommoditySortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int sortId=Integer.parseInt(request.getParameter("sortId"));
		CommoditySortService service=new CommoditySortService();
		CommoditySort commoditySort=service.getCommoditySortBySortId(sortId);
		JSONArray json=new JSONArray();
		json.add(commoditySort);
		out.print(json);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
