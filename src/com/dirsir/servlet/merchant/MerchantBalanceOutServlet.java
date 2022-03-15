package com.dirsir.servlet.merchant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.merchant.MerchantInfoService;


@WebServlet("/merchant/MerchantBalanceOutServlet")
public class MerchantBalanceOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		String account = merchant.getAccount();
		double merchantBalance = Double.parseDouble(request.getParameter("merchantBalance"));
		MerchantInfoService service = new MerchantInfoService();
		boolean flag = service.merchantBalanceOut(account, merchantBalance);
		merchant = service.getMerchantInfo(account);
		PrintWriter out = response.getWriter();
		if(flag) {
			session.setAttribute("merchant", merchant);
			out.print(true);
		}else {
			out.print(false);
		}
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
