package com.dirsir.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Account;
import com.dirsir.dao.entities.AccountTarding;
import com.dirsir.service.customer.AccountService;

@WebServlet("/customer/WithDrawalsAccountBalanceServlet")
public class WithDrawalsAccountBalanceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		AccountService service = new AccountService();
		double balance = Double.parseDouble(request.getParameter("balance"));
		Account account = (Account) session.getAttribute("account");
		int accountid = account.getAccountId();
		boolean flag = service.subtracrAccountBalance(accountid, balance);
		double tardingPrices=balance;
		AccountTarding accountTarding=new AccountTarding(1,accountid,null,tardingPrices,4,"Ã·œ÷");
		boolean flag1=service.doInsAccountTarding(accountTarding);
		account = service.getAccount(accountid);
		session.setAttribute("account", account);
		if(flag&&flag1) {
			out.print(true);
		}else {
			out.print(false);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
