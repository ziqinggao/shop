package com.dirsir.servlet.merchant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/merchant/PassWordEqual")
public class PassWordEqual extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String oldPassWord = request.getParameter("oldPassWord");
		String newPassWord = request.getParameter("newPassWord");
		PrintWriter out = response.getWriter();
		if(oldPassWord.equals(newPassWord)) {
			out.print(false);
		}else {
			out.print(true);
		}
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
