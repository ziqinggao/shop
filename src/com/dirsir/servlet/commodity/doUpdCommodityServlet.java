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
 * Servlet implementation class doUpdCommodityServlet
 */
@WebServlet("/commodity/doUpdCommodityServlet")
public class doUpdCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Merchant merchant=(Merchant)session.getAttribute("merchant");
		int merchantId=merchant.getMerchantId();
		
		String name=request.getParameter("commodityName");
		String describe=request.getParameter("commodityDescribe");
		double pice=Double.parseDouble(request.getParameter("commodityPice"));
		double vipPice=Double.parseDouble(request.getParameter("commodityVipPice"));
		int subtypeId=Integer.parseInt(request.getParameter("subtypeId"));
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		Commodity commodity=new Commodity(commodityId,name,describe,pice,vipPice,subtypeId,merchantId,1,1,null,0);
		CommodityService service=new CommodityService();
		boolean falg=service.doUpdCommodity(commodity);
		out.print(falg);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
