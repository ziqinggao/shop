package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommodityType;
import com.dirsir.service.commodity.CommodityTypeService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ShowCommodityTypeServlet
 */
@WebServlet("/commodity/ShowCommodityTypeServlet")
public class ShowCommodityTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		CommodityTypeService service=new CommodityTypeService();
		List<CommodityType> list=service.getCommodityAll();
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(list);
		out.print(jsonArray);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
