package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySubsort;
import com.dirsir.service.commodity.CommoditySubsortService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getComoditySubsortBySortIdServlet
 */
@WebServlet("/commodity/getComoditySubsortBySortIdServlet")
public class getComoditySubsortBySortIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=UTF-8");
		PrintWriter out=response.getWriter();
		int sortId=Integer.parseInt(request.getParameter("sortId"));
		CommoditySubsortService service=new CommoditySubsortService();
		List<CommoditySubsort> list=service.getCommoditySubsortBySortId(sortId);
		JSONArray json=new JSONArray();
		json.add(list);
		out.print(json);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
