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


@WebServlet("/Storage/GetOrderParticularsVByStateServlet")
public class GetOrderParticularsVByStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int merchantId = Integer.parseInt(request.getParameter("merchantId"));
		int state = Integer.parseInt(request.getParameter("state"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		StorageService service = new StorageService();
		List<OrderParticularsV> orderPV = service.getOrderParticularsVByState(merchantId, state,limit);
		JSONArray json = new JSONArray();
		PrintWriter out = response.getWriter();
		json.addAll(orderPV);
		out.print(json);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
