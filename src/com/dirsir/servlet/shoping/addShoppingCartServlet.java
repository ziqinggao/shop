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
import com.dirsir.dao.entities.ShoppingCart;
import com.dirsir.service.shoping.ShoppingCartService;

/**
 * Servlet implementation class addShoppingCartServlet
 */
@WebServlet("/shoping/addShoppingCartServlet")
public class addShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		int accountId=account.getAccountId();
		int commodityId=Integer.parseInt(request.getParameter("commodityId"));
		String subsort=request.getParameter("subsort");
		double price=Double.parseDouble(request.getParameter("price"));
		int num=Integer.parseInt(request.getParameter("num"));
		double prices=price*num;
		ShoppingCart shopping=new ShoppingCart(0,accountId,commodityId,subsort,num,price,prices);
		ShoppingCartService service=new ShoppingCartService();
		boolean falg=service.doAddShoppingCart(shopping);
		out.print(falg);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
