package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dirsir.service.storage.CommodityStockService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class StockVVSubsortServlet
 */
@WebServlet("/storage/StockVVSubsortServlet")
public class StockVVSubsortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		CommodityStockService service = new CommodityStockService();
		int commodityid= Integer.parseInt( request.getParameter("commodityid"));
	    List<String> list = service.commoditySubsort(commodityid);
	    JSONArray subsort=new JSONArray();
	    subsort.add(list);
	    out.print(subsort);
	    out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
