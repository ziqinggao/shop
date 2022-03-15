package com.dirsir.servlet.order.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.commodity.CommoditySubsort;
import com.dirsir.service.order.shoppingcart.ShoppingCartService;

import net.sf.json.JSONArray;


@WebServlet("/order/shoppingcart/GetSortAndSubsortServlet")
public class GetSortAndSubsortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int commodityId = Integer.parseInt(request.getParameter("commodityId"));
		ShoppingCartService service = new ShoppingCartService();
		List<CommoditySort> list1 = service.getCommoditySort(commodityId);
		List<List<CommoditySort>> list2=new ArrayList<>();
		list2.add(list1);
		List<List<CommoditySubsort>> list = service.getSortAndSubsort(commodityId);
		JSONArray json = new JSONArray();
		PrintWriter out = response.getWriter();
		json.addAll(list2);
		json.addAll(list);
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
