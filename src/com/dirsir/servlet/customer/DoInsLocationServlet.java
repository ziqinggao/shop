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
import com.dirsir.dao.entities.Location;
import com.dirsir.service.customer.AccountService;


@WebServlet("/customer/DoInsLocationServlet")
public class DoInsLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charest=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		AccountService service =new AccountService();
		String provinces=request.getParameter("provinces");
		String city=request.getParameter("city");
		String county=request.getParameter("county");
		String specificLocation=request.getParameter("specificLocation");
		String consignee=request.getParameter("consignee");
		String phone=request.getParameter("phone");
		int defaultLocation= Integer.parseInt(request.getParameter("defaultLocation"));
		Account account= (Account) session.getAttribute("account");
		int accountid=account.getAccountId();
		Location location=new Location(1,accountid,provinces,city,county,specificLocation,defaultLocation,consignee,phone);
		boolean flag= service.doInsLocation(location);
		out.print(flag);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
