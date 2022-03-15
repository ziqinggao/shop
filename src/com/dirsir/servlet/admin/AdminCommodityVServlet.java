package com.dirsir.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommodityV;
import com.dirsir.service.admin.AdminService;

import net.sf.json.JSONArray;


@WebServlet("/admin/AdminCommodityVServlet")
public class AdminCommodityVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		PrintWriter out = response.getWriter();
		int x = Integer.parseInt(request.getParameter("x"));
		List<CommodityV> commodityVList = service.getCommodityVService(x);
		JSONArray json = new JSONArray();
		json.addAll(commodityVList);
		out.print(json);
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
