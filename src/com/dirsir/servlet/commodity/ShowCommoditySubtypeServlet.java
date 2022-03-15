package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.service.commodity.CommoditySubtypeService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ShowCommoditySubtypeServlet
 */
@WebServlet("/commodity/ShowCommoditySubtypeServlet")
public class ShowCommoditySubtypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		CommoditySubtypeService service=new CommoditySubtypeService();
		List<CommoditySubtype> list=service.getSubtypeAllBy(typeId);
		JSONArray json=new JSONArray();
		json.add(list);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
