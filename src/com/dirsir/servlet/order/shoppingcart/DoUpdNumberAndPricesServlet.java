package com.dirsir.servlet.order.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.order.shoppingcart.ShoppingCartService;


@WebServlet("/order/shoppingcart/DoUpdNumberAndPricesServlet")
public class DoUpdNumberAndPricesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String subsort = request.getParameter("subsort");
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		int commodityNumber = Integer.parseInt(request.getParameter("commodityNumber"));
		ShoppingCartService service = new ShoppingCartService();
		boolean flag = service.doUpdCommodityNumberAndPrices(subsort, cartId, commodityNumber);
		PrintWriter out = response.getWriter();
		out.print(flag);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
