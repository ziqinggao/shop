package com.dirsir.servlet.baseservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.Admin;
import com.dirsir.service.admin.AdminService;


@WebServlet("/baseservice/DoInsAdminServlet")
public class DoInsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int adminNumber = Integer.parseInt(request.getParameter("adminNumber"));
		String adminName = request.getParameter("adminName");
		String adminPassword = request.getParameter("adminPassword");
		String realName = request.getParameter("realName");
		Admin admin = new Admin(0,adminNumber,adminName,adminPassword,realName,1);
		AdminService service = new AdminService();
		Admin admin1 = service.getAdminName(adminName);
		Admin admin2 = service.getAdminNumber(adminNumber);
		PrintWriter out = response.getWriter();
		if(admin1 != null ||admin2 != null) {
			out.print(false);
		}else {
			out.print(true);
			service.doInsAdmin(admin);
		}
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
