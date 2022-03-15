package com.dirsir.servlet.order.orderlist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.AccountLocation;
import com.dirsir.service.order.orderlist.OrderListService;


@WebServlet("/order/orderlist/DoInsLocationServlet")
public class DoInsLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		String provinces = request.getParameter("provinces");
		String city = request.getParameter("city");
		String county = request.getParameter("county");
		String specificLocation = request.getParameter("specificLocation");
		String consignee = request.getParameter("consignee");
		String phone = request.getParameter("phone");
		AccountLocation accountLocation = new AccountLocation(0,accountId,provinces,city,county,specificLocation,1,consignee,phone);
		OrderListService service = new OrderListService();
		service.doInsLocation(accountLocation);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
