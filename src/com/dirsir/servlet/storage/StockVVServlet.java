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
import com.dirsir.dao.entities.StockVV;
import com.dirsir.service.storage.StockVVService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class StockVV
 */
@WebServlet("/storage/StockVVServlet")
public class StockVVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		StockVVService service = new StockVVService();
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		int merchantId=  merchant.getMerchantId(); 
		int pages = Integer.parseInt(request.getParameter("pages"));
		List<StockVV>  stockvv =service.StockVV(merchantId, pages);
		JSONArray stock= new JSONArray();
		stock.add(stockvv);
		out.print(stock);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
