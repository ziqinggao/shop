package com.dirsir.servlet.storage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.service.storage.StorageService;


@WebServlet("/storage/DoUpdOrderParticularsServlet")
public class DoUpdOrderParticularsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int particularsId = Integer.parseInt(request.getParameter("particularsId"));
		int state = Integer.parseInt(request.getParameter("state"));
		StorageService service = new StorageService();
		service.doUpdOrderParticulars(particularsId, state);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
