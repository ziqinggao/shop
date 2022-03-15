package com.dirsir.servlet.appraise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.appraise.EvaluateVService;

/**
 * Servlet implementation class getMaxPagesServlet
 */
@WebServlet("/appraise/getMaxPagesServlet")
public class getMaxPagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chartset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Merchant merchant=(Merchant)session.getAttribute("merchant");
		int merchantId=merchant.getMerchantId();
		int vaild=Integer.parseInt(request.getParameter("vaild"));
		String commodityName=request.getParameter("commodityName");
		EvaluateVService service=new EvaluateVService();
		int pages=service.getPages(commodityName, merchantId, vaild);
		out.print(pages);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
