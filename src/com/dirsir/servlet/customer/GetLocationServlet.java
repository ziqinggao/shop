package com.dirsir.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Account;
import com.dirsir.dao.entities.Location;
import com.dirsir.service.customer.AccountService;

import net.sf.json.JSONArray;

@WebServlet("/customer/GetLocationServlet")
public class GetLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charest=utf-8");
	response.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	PrintWriter out =response.getWriter();
	AccountService service =new AccountService();
	Account account= (Account) session.getAttribute("account");
	int accountid=account.getAccountId();
	 List<Location> list= service.getLocation(accountid);
	 JSONArray array=new JSONArray();
	 array.add(list);
	 out.print(array);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
