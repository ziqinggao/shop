package com.dirsir.servlet.admin.commoditysubtype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.service.admin.AdminService;


@WebServlet("/admin/commoditysubtype/DoInsSubtypeServlet")
public class DoInsSubtypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		AdminService service = new AdminService();
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		String subtypeName = request.getParameter("subtypeName");
		String subtypeDescribe = request.getParameter("subtypeDescribe");
		int subtypeState = Integer.parseInt(request.getParameter("subtypeState"));
		int subsortCode = Integer.parseInt(request.getParameter("subsortCode"));
		CommoditySubtype commoditySubtype = new CommoditySubtype(0,typeId,subtypeName,subtypeDescribe,subtypeState,subsortCode);
		service.doInsCommoditySubtype(commoditySubtype);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
