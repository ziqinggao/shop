package com.dirsir.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.service.admin.AdminService;

import net.sf.json.JSONArray;


@WebServlet("/admin/AdminCommoditySubtypeServlet")
public class AdminCommoditySubtypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		JSONArray json = new JSONArray();
		PrintWriter out = response.getWriter();
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		List<CommoditySubtype> cSubtype = service.getCommoditySubtype(typeId);
		json.addAll(cSubtype);
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
