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
import com.dirsir.service.customer.AccountService;


@WebServlet("/customer/AccountLoginServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charest=utf-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession();
	String accountname=request.getParameter("accountName");
	String password=request.getParameter("accountPassWord");
	AccountService service=new AccountService();
	Account account=service.LoginAccount(accountname, password);
	if(null==account) {
		out.print(false);
	}else {
		session.setAttribute("account", account);
		out.print(true);
	}
	out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
