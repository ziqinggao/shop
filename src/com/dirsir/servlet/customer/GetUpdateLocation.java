package com.dirsir.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dirsir.dao.entities.Location;
import com.dirsir.service.customer.AccountService;

import net.sf.json.JSONArray;

@WebServlet("/customer/GetUpdateLocation")
public class GetUpdateLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		AccountService service =new AccountService();
		int locationId= Integer.parseInt(request.getParameter("locationId"));
		/*int locationId, int accountId, String provinces, String city, String county,
			String specificLocation, int defaultLocation, String consignee, String phone*/
		 Location location= service.getUpdateLocation(locationId);
		JSONArray array=new JSONArray();
		 array.add(location);
		 out.print(array);
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
