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
 * Servlet implementation class UpdataMerchantReturnServlet
 */
@WebServlet("/storage/UpdataMerchantReturnServlet")
public class UpdataMerchantReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out=response.getWriter();
    CommodityStockService service=new CommodityStockService();
    int returnid=Integer.parseInt(request.getParameter("returnId"));
    System.out.println(returnid);
    int returnnumber=Integer.parseInt(request.getParameter("returnkNumber")) ;
    int stockid=Integer.parseInt(request.getParameter("stockid"));
    double price =Double.parseDouble(request.getParameter("pricea"));
    String rerutncause=request.getParameter("returnCause");
    double prices=returnnumber*price;
    MerchantReturn merchantreturn=new MerchantReturn(returnid,stockid,rerutncause,null,returnnumber,price,prices);
    boolean flag=service.updataMerchantReturn(merchantreturn);
    out.print(flag);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
