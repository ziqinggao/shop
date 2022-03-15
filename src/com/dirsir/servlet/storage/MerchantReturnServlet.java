package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.entities.MerchantReturnV;
import com.dirsir.service.storage.CommodityStockService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class MerchantReturnServlet
 */
@WebServlet("/storage/MerchantReturnServlet")
public class MerchantReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		CommodityStockService service=new CommodityStockService();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		int merchantId=  merchant.getMerchantId(); 
		List<MerchantReturnV> merchantreturn=service.merchant(merchantId);
		 JSONArray merchant1=new JSONArray();
		 merchant1.add(merchantreturn);
		 out.print(merchant1);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
