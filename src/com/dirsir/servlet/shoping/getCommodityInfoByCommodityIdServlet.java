package com.dirsir.servlet.shoping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.Commodity;
import com.dirsir.dao.entities.CommoditySort;
import com.dirsir.dao.entities.CommoditySubsort;
import com.dirsir.service.shoping.ShopingService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getSortAndSubsortByCommodityIdServlet
 */
@WebServlet("/shoping/getCommodityInfoByCommodityIdServlet")
public class getCommodityInfoByCommodityIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		ShopingService sort=new ShopingService();
		List<CommoditySort> list=sort.getSortByCommodityId(commodityId);
		List<CommoditySubsort> list2=new ArrayList<>();
		for (CommoditySort commoditySort : list) {
			List<CommoditySubsort> list3=sort.getSubsortBySortId(commoditySort.getSortId());
			list2.addAll(list3);
		}
		Commodity commodity=sort.getCommodityByCommodityId(commodityId);
		JSONArray json=new JSONArray();
		json.add(list);
		json.add(list2);
		json.add(commodity);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
