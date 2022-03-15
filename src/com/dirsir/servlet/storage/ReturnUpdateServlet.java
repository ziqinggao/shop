package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dirsir.dao.entities.MerchantReturn;
import com.dirsir.service.storage.CommodityStockService;

/**
 * Servlet implementation class ReturnUpdateServlet
 */
@WebServlet("/storage/ReturnUpdateServlet")
public class ReturnUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html);charest=utf-8");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out =response.getWriter();
    String returncause= request.getParameter("returnCause");
    CommodityStockService service= new CommodityStockService();
    int  returnnumber=Integer.parseInt(request.getParameter("returnkNumber"));
    int stockid=Integer.parseInt(request.getParameter("stockid"));
    double price =Double.parseDouble(request.getParameter("pricea"));
    double prices=price*returnnumber;
    MerchantReturn merchantreturn=new MerchantReturn(0,stockid,returncause,null,returnnumber,price,prices);
    boolean flag=service.merchantReturn(merchantreturn);
    out.print(flag);
    
    
    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
