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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetMerchantReturnServlet
 */
@WebServlet("/storage/GetMerchantReturnServlet")
public class GetMerchantReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html,charest=utf-8");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out =response.getWriter();
    int returnid=Integer.parseInt( request.getParameter("returnId"));
    CommodityStockService service =new CommodityStockService();
    MerchantReturn merchantreturn= service.getMerchantReturn(returnid);
    JSONArray list=new JSONArray();
    list.add(merchantreturn);
    out.print(list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
