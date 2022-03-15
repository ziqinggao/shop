package com.dirsir.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.Admin;
import com.dirsir.service.admin.AdminService;

import net.sf.json.JSONArray;


@WebServlet("/admin/AdminInfoServlet")
public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("changePage"));
		AdminService service = new AdminService();
		List<Admin> adminList = new ArrayList<>();
		adminList = service.getAdminInfo(num);
		JSONArray json = new JSONArray();
		json.addAll(adminList);
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
