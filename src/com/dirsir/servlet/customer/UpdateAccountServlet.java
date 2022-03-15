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

/**
 * Servlet implementation class UpdateAccountServlet
 */
@WebServlet("/customer/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Account account= (Account) session.getAttribute("account");
		int accountid=account.getAccountId();
		String name= request.getParameter("name");
		String phone=request.getParameter("phone");
		int gender=Integer.parseInt(request.getParameter("gender"));
		int age=Integer.parseInt(request.getParameter("age"));
		String birthday=request.getParameter("birthday");
		String idCard=request.getParameter("idCard");
		String email=request.getParameter("email");
		AccountService service=new AccountService();
		System.out.println(birthday);
		Account account1=new Account(accountid,"",phone,"",name,gender,age,birthday,idCard,0,email,"",0,"","");
		boolean flag= service.updateAccount(account1);
		out.print(flag);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
