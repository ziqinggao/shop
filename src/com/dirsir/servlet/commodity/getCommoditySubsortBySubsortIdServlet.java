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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getCommoditySubsortBySubsortIdServlet
 */
@WebServlet("/commodity/getCommoditySubsortBySubsortIdServlet")
public class getCommoditySubsortBySubsortIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		CommoditySubsortService service=new CommoditySubsortService();
		int subsortId=Integer.parseInt(request.getParameter("subsortId"));
		
		CommoditySubsort subsrot=service.getCommoditySubsortBySubsortId(subsortId);
		JSONArray json=new JSONArray();
		json.add(subsrot);
		out.print(json);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
