package com.dirsir.servlet.admin.commoditysubtype;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.admin.AdminService;


@WebServlet("/admin/commoditysubtype/DoUpdSubtypeServlet")
public class DoUpdSubtypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		int subtypeId = Integer.parseInt(request.getParameter("subtypeId"));
		int subtypeState = Integer.parseInt(request.getParameter("subtypeState"));
		service.doUpdCommoditySubtype(subtypeId, subtypeState);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
