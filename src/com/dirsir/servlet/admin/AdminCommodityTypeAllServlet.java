package com.dirsir.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommodityType;
import com.dirsir.service.admin.AdminService;

import net.sf.json.JSONArray;


@WebServlet("/admin/AdminCommodityTypeAllsServlet")
public class AdminCommodityTypeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/**
 * 查询所有大类型和小类型
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		List<CommodityType> cType = service.getCommodityType();
		JSONArray json = new JSONArray();
		PrintWriter out = response.getWriter();
		json.addAll(cType);
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
