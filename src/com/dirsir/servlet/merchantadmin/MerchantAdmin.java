package com.dirsir.servlet.merchantadmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Admin;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.merchantadmin.MerchantAdminService;

@WebServlet("/merchanadmin/MerchantAdmin")
public class MerchantAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int role = Integer.parseInt(request.getParameter("role"));
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		MerchantAdminService service = new MerchantAdminService();
		session.setAttribute("role", role);
		if (role == 2) {// 表示商家登录
			Merchant merchant = service.LoginMerchant(account, password);
			if (null == merchant) {
				out.print(false);
			} else {
				session.setAttribute("merchant", merchant);
				out.print(true);
			}
		} else if (role == 1) {// 表示是管理员登录
			Admin admin = service.LoginAdmin(account, password);
			if (null == admin) {
				out.print(false);
			} else {
				session.setAttribute("admin", admin);
				out.print(true);
			}

		}
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
