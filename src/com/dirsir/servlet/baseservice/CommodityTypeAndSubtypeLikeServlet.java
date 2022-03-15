package com.dirsir.servlet.baseservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommoditySubtype;
import com.dirsir.dao.entities.CommodityType;
import com.dirsir.service.admin.AdminService;

import net.sf.json.JSONArray;


@WebServlet("/baseservice/CommodityTypeAndSubtypeLikeServlet")
public class CommodityTypeAndSubtypeLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONArray json = new JSONArray();
		int likeOption = Integer.parseInt(request.getParameter("likeOption"));
		String likeText = request.getParameter("likeText");
		int state = Integer.parseInt(request.getParameter("state"));
		AdminService service = new AdminService();
		if(likeOption == 1) {
			List<CommodityType> typeList = service.getTypeLike(likeText, state);
			json.addAll(typeList);
			out.print(json);
			out.close();
		}else {
			List<CommoditySubtype> subtypeList = service.getSubtypeLike(likeText, state);
			json.addAll(subtypeList);
			out.print(json);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
