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
import com.dirsir.service.storage.CommodityStockService;

import net.sf.json.JSONArray;

@WebServlet("/storage/SeeCommodityStockServlet")
public class SeeCommodityStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charest=utf-8");
    response.setCharacterEncoding("UTF-8");
    HttpSession session =request.getSession();
    PrintWriter out=response.getWriter();
    Merchant merchant = (Merchant) session.getAttribute("merchant");
	int merchantId=  merchant.getMerchantId(); 
    String buystockdate=request.getParameter("buystockdate");
    CommodityStockService service=new CommodityStockService();
    List<StockVV> list= service.seeCommodityStock(buystockdate, merchantId);
    JSONArray see=new JSONArray();
    see.add(list);
    out.print(see);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
