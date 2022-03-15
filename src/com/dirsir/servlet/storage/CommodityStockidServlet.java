package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dirsir.dao.entities.CommodityStock;
import com.dirsir.service.storage.CommodityStockService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CommodityStockidServlet
 */
@WebServlet("/storage/CommodityStockidServlet")
public class CommodityStockidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int stockid = Integer.parseInt(request.getParameter("stockid"));
		CommodityStockService service = new CommodityStockService();
		CommodityStock CommodityStock = service.stockId(stockid);
		JSONArray subsort = new JSONArray();
		subsort.add(CommodityStock);
		out.print(subsort);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
