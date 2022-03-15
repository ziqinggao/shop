package com.dirsir.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.admin.AdminService;


@WebServlet("/admin/AdminUpdMerchantServlet")
public class AdminUpdMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		int merchantId = Integer.parseInt(request.getParameter("merchantId"));
		int recordState = Integer.parseInt(request.getParameter("recordState"));
		service.updMerchantById(merchantId, recordState, adminId);
		response.sendRedirect(request.getContextPath()+"/jsp/baseService/merchantAudit/merchantAudit.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
