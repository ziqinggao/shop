package com.dirsir.servlet.shoping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.shoping.ShopingService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getMerchantByCommodityIdServlet
 */
@WebServlet("/shoping/getMerchantByCommodityIdServlet")
public class getMerchantByCommodityIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		ShopingService sort=new ShopingService();
		Merchant merchant=sort.getMerchantByCommodityId(commodityId);
		JSONArray json=new JSONArray();
		json.add(merchant);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
