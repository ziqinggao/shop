package com.dirsir.servlet.order.orderlist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.service.order.orderlist.OrderListService;

import net.sf.json.JSONArray;


@WebServlet("/order/orderlist/GetDefaultLocationServlet")
public class GetDefaultLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chatset=utf-8");
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		OrderListService service = new OrderListService();
		AccountLocation accountLocation = service.getDefaultLocation(accountId);
		PrintWriter out = response.getWriter();
		JSONArray json = new JSONArray();
		json.add(accountLocation);
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
