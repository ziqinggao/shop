package com.dirsir.servlet.order.orderlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.service.order.orderlist.OrderListService;

import net.sf.json.JSONArray;


@WebServlet("/order/orderlist/GetLocationServlet")
public class GetLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		OrderListService service = new OrderListService();
		List<AccountLocation> listLocation = service.getLocation(accountId);
		PrintWriter out = response.getWriter();
		JSONArray json = new JSONArray();
		json.add(listLocation);
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
