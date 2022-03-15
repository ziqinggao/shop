package com.dirsir.servlet.appraise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.EvaluateV;
import com.dirsir.dao.entities.Merchant;
import com.dirsir.service.appraise.EvaluateVService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getEvaluateVByCommodityNameServlet
 */
@WebServlet("/appraise/getEvaluateVByCommodityNameServlet")
public class getEvaluateVByCommodityNameServlet extends HttpServlet {
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
		int pages=Integer.parseInt(request.getParameter("pages"));
		EvaluateVService service=new EvaluateVService();
		List<EvaluateV> list=service.getEvaluateV(commodityName, merchantId, pages, vaild);
		JSONArray json=new JSONArray();
		json.add(list);
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
