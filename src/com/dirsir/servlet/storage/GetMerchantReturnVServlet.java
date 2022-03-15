package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Merchant;
import com.dirsir.dao.entities.MerchantReturnV;
import com.dirsir.service.storage.CommodityStockService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetMerchantReturnVServlet
 */
@WebServlet("/storage/GetMerchantReturnVServlet")
public class GetMerchantReturnVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Merchant merchant=(Merchant) session.getAttribute("merchant");
		int merchantid=merchant.getMerchantId();
		String returndate= request.getParameter("returndate");
		CommodityStockService service= new CommodityStockService();
		List<MerchantReturnV> list=service.getMerchantReturnV(merchantid, returndate);
		JSONArray array=new JSONArray();
		array.add(list);
		out.print(array);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
