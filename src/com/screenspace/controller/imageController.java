package com.screenspace.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/imageController")
@MultipartConfig(
		
		fileSizeThreshold = 1024 * 10, // 10 KB
		maxFileSize = 1024*500,			// 500 KB
		maxRequestSize = 1024*1024		// 1 MB
		
		)
public class imageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		RequestDispatcher rd = request.getRequestDispatcher("imageService");
		rd.forward(request, response);
				
	}

}
