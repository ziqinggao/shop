package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Commodity;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.commodity.CommodityService;

/**
 * Servlet implementation class DoInsCommodityServlet
 */
@WebServlet("/commodity/DoInsCommodityServlet")
public class DoInsCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Merchant merchant=(Merchant)session.getAttribute("merchant");
		int merchantId=merchant.getMerchantId();
		//接收参数
		/*
		 *  commodityName:commodityName,
				  commodityDescribe :commodityDescribe,
				  commodityPice :commodityPice,
				  commodityVipPice:vipPice,
				  subtypeId:subtypeId
		 * */
		String name=request.getParameter("commodityName");
		String describe=request.getParameter("commodityDescribe");
		double pice=Double.parseDouble(request.getParameter("commodityPice"));
		double vipPice=Double.parseDouble(request.getParameter("commodityVipPice"));
		int subtypeId=Integer.parseInt(request.getParameter("subtypeId"));
		
		Commodity commodity=new Commodity(1,name,describe,pice,vipPice,subtypeId,merchantId,1,1,null,0);
		
		CommodityService service=new CommodityService();
		
		boolean falg=service.doInsCommodity(commodity);
		
		out.print(falg);
		
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
