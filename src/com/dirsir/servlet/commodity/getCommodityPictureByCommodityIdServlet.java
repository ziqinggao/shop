package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.CommodityPicture;
import com.dirsir.service.commodity.CommodityPictureService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getCommodityPictureByCommodityIdServlet
 */
@WebServlet("/commodity/getCommodityPictureByCommodityIdServlet")
public class getCommodityPictureByCommodityIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		int pictureType=Integer.parseInt(request.getParameter("type"));
		CommodityPictureService service=new CommodityPictureService();
		List<CommodityPicture> list=service.getCommodityPictureByCommodityIdAndPictureType(commodityId, pictureType);
		JSONArray json=new JSONArray();
		json.add(list);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
