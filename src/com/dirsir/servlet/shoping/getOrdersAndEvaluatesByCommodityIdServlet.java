package com.dirsir.servlet.shoping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.shoping.ShopingService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getSalesAndOrdersByCommodityIdServlet
 */
@WebServlet("/shoping/getOrdersAndEvaluatesByCommodityIdServlet")
public class getOrdersAndEvaluatesByCommodityIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		ShopingService service=new ShopingService();
		int orders=service.getOrderNumByCommodityId(commodityId);
		int evaluate=service.getEvaluateNumByCommodityId(commodityId);
		JSONArray json=new JSONArray();
		json.add(orders);
		json.add(evaluate);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
