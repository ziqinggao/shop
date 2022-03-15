package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.CommodityStock;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.storage.CommodityStockService;

/**
 * Servlet implementation class StockUpdateServlet
 */
@WebServlet("/storage/StockUpdateServlet")
public class StockUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int stockid =Integer.parseInt(request.getParameter("stockid"));
		int commodityid = Integer.parseInt(request.getParameter("commodityid"));
		String subname = request.getParameter("subname");
		int stockNumber = Integer.parseInt(request.getParameter("stockNumber"));
		double price = Double.parseDouble(request.getParameter("price"));
		String procurement = request.getParameter("procurement");
		String supplier = request.getParameter("supplier");
		CommodityStockService service=new  CommodityStockService();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		int merchantId = merchant.getMerchantId();
		double prices = stockNumber * price;
		CommodityStock commoditystock = new CommodityStock(stockid, merchantId, commodityid, subname, stockNumber, price,
				prices, procurement, null, supplier);
		boolean flag = service.commodityStockUpdate(commoditystock);
		out.print(flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
