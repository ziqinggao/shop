package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.OrderParticularsV;
import com.dirsir.service.storage.StorageService;

import net.sf.json.JSONArray;


@WebServlet("/storage/GetOrderParticularsVServlet")
public class GetOrderParticularsVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int merchantId = Integer.parseInt(request.getParameter("merchantId"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		StorageService service = new StorageService();
		List<OrderParticularsV> orderVList = service.getOrderParticularsV(merchantId,limit);
		JSONArray json = new JSONArray();
		json.addAll(orderVList);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
