package com.dirsir.servlet.order.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.ShoppingCartV;
import com.dirsir.service.order.shoppingcart.ShoppingCartService;

import net.sf.json.JSONArray;


@WebServlet("/order/shoppingcart/GetShoppingCartVListServlet")
public class GetShoppingCartVListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		ShoppingCartService service = new ShoppingCartService();
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		List<List<ShoppingCartV>> list = service.getShoppingCartVList(accountId);
		JSONArray json = new JSONArray();
		PrintWriter out = response.getWriter();
		json.addAll(list);
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
