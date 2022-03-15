package com.dirsir.servlet.commodity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.commodity.CommodityService;

/**
 * Servlet implementation class getSerachPageServlet
 */
@WebServlet("/commodity/getSerachPageServlet")
public class getSerachPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chartset=utf-8");
		HttpSession session =request.getSession();
		PrintWriter out=response.getWriter();
		Merchant merchant=(Merchant)session.getAttribute("merchant");
		int merchantId =merchant.getMerchantId();
		CommodityService service=new CommodityService();
		String commodityName=request.getParameter("commodityName");
		int searchPages=service.getCommodityNumByCommodityNameAndMerchantId(commodityName, merchantId);
		out.print(searchPages);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
