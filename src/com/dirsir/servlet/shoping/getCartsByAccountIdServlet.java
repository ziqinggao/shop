package com.dirsir.servlet.shoping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Account;
import com.dirsir.service.shoping.ShoppingCartService;

/**
 * Servlet implementation class getCartsByAccountIdServlet
 */
@WebServlet("/shoping/getCartsByAccountIdServlet")
public class getCartsByAccountIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		int num=0;
		if(account!=null) {
			int accountId=account.getAccountId();
			ShoppingCartService service=new ShoppingCartService();
			num=service.getCartSbyAccountId(accountId);
		}
		out.print(num);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
