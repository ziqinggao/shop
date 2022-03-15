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

/**
 * Servlet implementation class UpaMerchantServlet
 */
@WebServlet("/merchant/UpaMerchantServlet")
public class UpaMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		String account = merchant.getAccount();
		String corpPhone = request.getParameter("corpPhone");
		String director = request.getParameter("director");
		String directorPhone = request.getParameter("directorPhone");
		MerchantInfoService service = new MerchantInfoService();
		PrintWriter out  = response.getWriter();
		boolean flag = service.UpaMerchantDirectorAndDirectorPhoneAndLicensPictureService(account, corpPhone, director, directorPhone);
		Merchant merchant1 = service.getMerchantInfo(account);
		if(flag == true) {
			session.setAttribute("merchant", merchant1);
			out.print(true);
		}else {
			out.print(false);
		}
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
