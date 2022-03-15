package com.dirsir.servlet.admin.commoditytype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommodityType;
import com.dirsir.service.admin.AdminService;


@WebServlet("/admin/commoditytype/DoInsTypeServlet")
public class DoInsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		String typeName = request.getParameter("typeName");
		String typeDescribe = request.getParameter("typeDescribe");
		int typeState = Integer.parseInt(request.getParameter("typeState"));
		int sortCode = Integer.parseInt(request.getParameter("sortCode"));
		CommodityType commodityType = new CommodityType(0,typeName,typeDescribe,typeState,sortCode);
		service.doInsCommodityType(commodityType);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
