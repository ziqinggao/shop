package com.dirsir.servlet.shoping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.EvaluateV;
import com.dirsir.service.shoping.ShopingService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getCommodityEvaluateByCommodityIdServlet
 */
@WebServlet("/shoping/getCommodityEvaluateByCommodityIdServlet")
public class getCommodityEvaluateByCommodityIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		int sort=Integer.parseInt(request.getParameter("sort"));
		int vaild=Integer.parseInt(request.getParameter("vaild"));
		ShopingService service=new ShopingService();
		List<EvaluateV> list=service.getEvaluateByCommodityId(commodityId, sort, vaild);
		JSONArray json=new JSONArray();
		json.add(list);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
